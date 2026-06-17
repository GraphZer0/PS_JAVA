package ru.productstar.mockito.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.productstar.mockito.ProductNotFoundException;
import ru.productstar.mockito.model.*;
import ru.productstar.mockito.repository.OrderRepository;
import ru.productstar.mockito.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @Mock
    private CustomerService customerService;

    @Mock
    private WarehouseService warehouseService;

    @Spy
    private OrderRepository orderRepository = new OrderRepository();

    @Mock
    private ProductRepository productRepository;

    private OrderService orderService;

    @BeforeEach
    void setUp() {
        orderService = new OrderService(customerService, warehouseService, orderRepository, productRepository);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Ivan", "Oleg"})
    void createShouldCreateOrderForExistingAndNewCustomer(String customerName) {
        // Цель: проверить создание заказа для разных имен клиентов, включая существующего и нового.
        Customer customer = new Customer(customerName);
        when(customerService.getOrCreate(customerName)).thenReturn(customer);

        Order result = orderService.create(customerName);

        assertNotNull(result);
        assertEquals(customerName, result.getCustomer().getName());
        verify(customerService, times(1)).getOrCreate(customerName);
        verify(orderRepository, times(1)).create(customer);
    }

    @Test
    void addProductShouldAddExistingProductWhenCountIsEnough() throws ProductNotFoundException {
        // Цель: проверить успешное добавление товара в заказ и расчет общей суммы.
        Order order = new Order(new Customer("Ivan"));
        order.setId(0);
        orderRepository.create(order.getCustomer());

        Product phone = new Product("phone");
        Warehouse warehouse = new Warehouse("Warehouse0", 30);
        Stock stock = new Stock(phone, 400, 5);

        when(warehouseService.findWarehouse("phone", 3)).thenReturn(warehouse);
        when(warehouseService.getStock(warehouse, "phone")).thenReturn(stock);
        when(productRepository.getByName("phone")).thenReturn(phone);

        Order result = orderService.addProduct(order, "phone", 3, false);

        assertEquals(1200, result.getTotal());
        assertEquals(1, result.getDeliveries().size());
        assertEquals("phone", result.getDeliveries().get(0).getProduct().getName());

        InOrder inOrder = inOrder(warehouseService, productRepository, orderRepository);
        inOrder.verify(warehouseService).findWarehouse("phone", 3);
        inOrder.verify(productRepository).getByName("phone");
        inOrder.verify(warehouseService).getStock(warehouse, "phone");
        inOrder.verify(orderRepository).addDelivery(eq(0), any(Delivery.class));
    }

    @Test
    void addProductShouldUseClosestWarehouseForFastestDelivery() throws ProductNotFoundException {
        // Цель: проверить сценарий быстрой доставки — должен использоваться findClosestWarehouse.
        Order order = new Order(new Customer("Ivan"));
        order.setId(0);
        orderRepository.create(order.getCustomer());

        Product phone = new Product("phone");
        Warehouse closestWarehouse = new Warehouse("Warehouse2", 5);
        Stock stock = new Stock(phone, 450, 3);

        when(warehouseService.findClosestWarehouse("phone", 2)).thenReturn(closestWarehouse);
        when(warehouseService.getStock(closestWarehouse, "phone")).thenReturn(stock);
        when(productRepository.getByName("phone")).thenReturn(phone);

        Order result = orderService.addProduct(order, "phone", 2, true);

        assertEquals(900, result.getTotal());
        assertEquals("Warehouse2", result.getDeliveries().get(0).getWarehouse().getName());
        verify(warehouseService, times(1)).findClosestWarehouse("phone", 2);
        verify(warehouseService, never()).findWarehouse(anyString(), anyInt());
    }

    @Test
    void addProductShouldThrowExceptionWhenProductNotFoundOrCountIsNotEnough() {
        // Цель: проверить обработку ошибки — подходящий склад не найден.
        Order order = new Order(new Customer("Ivan"));
        order.setId(0);

        when(warehouseService.findWarehouse("printer", 10)).thenReturn(null);

        assertThrows(ProductNotFoundException.class,
                () -> orderService.addProduct(order, "printer", 10, false));

        verify(warehouseService, times(1)).findWarehouse("printer", 10);
        verify(productRepository, never()).getByName(anyString());
        verify(orderRepository, never()).addDelivery(anyInt(), any(Delivery.class));
    }
}
