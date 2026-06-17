package ru.productstar.mockito.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.productstar.mockito.model.Product;
import ru.productstar.mockito.model.Stock;
import ru.productstar.mockito.model.Warehouse;
import ru.productstar.mockito.repository.WarehouseRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class WarehouseServiceTest {

    @Mock
    private WarehouseRepository warehouseRepository;

    private WarehouseService warehouseService;

    private Product phone;
    private Product laptop;
    private Product mouse;
    private Warehouse warehouse0;
    private Warehouse warehouse1;
    private Warehouse warehouse2;

    @BeforeEach
    void setUp() {
        warehouseService = new WarehouseService(warehouseRepository);

        phone = new Product("phone");
        laptop = new Product("laptop");
        mouse = new Product("mouse");

        warehouse0 = new Warehouse("Warehouse0", 30);
        warehouse0.addStock(new Stock(phone, 400, 5));

        warehouse1 = new Warehouse("Warehouse1", 20);
        warehouse1.addStock(new Stock(phone, 380, 2));
        warehouse1.addStock(new Stock(laptop, 850, 1));

        warehouse2 = new Warehouse("Warehouse2", 5);
        warehouse2.addStock(new Stock(phone, 450, 3));
    }

    @Test
    void addStockShouldAddProductToWarehouse() {
        // Цель: проверить добавление товара на склад и последующее получение этого товара через WarehouseService.
        Stock mouseStock = new Stock(mouse, 100, 7);

        boolean added = warehouse0.addStock(mouseStock);
        Stock result = warehouseService.getStock(warehouse0, "mouse");

        assertTrue(added);
        assertNotNull(result);
        assertEquals("mouse", result.getProduct().getName());
        assertEquals(100, result.getPrice());
        assertEquals(7, result.getCount());
    }

    @Test
    void findWarehouseShouldReturnWarehouseWhenProductIsAvailable() {
        // Цель: проверить доступность товара — сервис должен найти склад с достаточным количеством товара.
        when(warehouseRepository.all()).thenReturn(Arrays.asList(warehouse0, warehouse1, warehouse2));

        Warehouse result = warehouseService.findWarehouse("phone", 4);

        assertNotNull(result);
        assertEquals("Warehouse0", result.getName());
        verify(warehouseRepository, times(1)).all();
        verifyNoMoreInteractions(warehouseRepository);
    }

    @Test
    void findClosestWarehouseShouldReturnNearestWarehouseWithEnoughProduct() {
        // Цель: проверить, что при выборе ближайшего склада учитывается расстояние и доступное количество товара.
        when(warehouseRepository.all()).thenReturn(Arrays.asList(warehouse0, warehouse1, warehouse2));

        Warehouse result = warehouseService.findClosestWarehouse("phone", 2);

        assertNotNull(result);
        assertEquals("Warehouse2", result.getName());
        assertEquals(5, result.getDistance());
        verify(warehouseRepository, times(1)).all();
        verifyNoMoreInteractions(warehouseRepository);
    }

    @Test
    void findWarehouseShouldWorkWithZeroStockBoundaryCase() {
        // Цель: проверить граничный случай — нулевой запас товара и запрос количества 0.
        Warehouse emptyWarehouse = new Warehouse("EmptyWarehouse", 10);
        emptyWarehouse.addStock(new Stock(mouse, 50, 0));
        when(warehouseRepository.all()).thenReturn(Arrays.asList(emptyWarehouse));

        Warehouse result = warehouseService.findWarehouse("mouse", 0);

        assertNotNull(result);
        assertEquals("EmptyWarehouse", result.getName());
        verify(warehouseRepository, times(1)).all();
        verifyNoMoreInteractions(warehouseRepository);
    }

    @Test
    void findWarehouseShouldReturnNullWhenProductCountIsNotEnough() {
        // Цель: проверить ситуацию, когда товар есть на складе, но его количества недостаточно.
        when(warehouseRepository.all()).thenReturn(Arrays.asList(warehouse0, warehouse1, warehouse2));

        Warehouse result = warehouseService.findWarehouse("laptop", 2);

        assertNull(result);
        verify(warehouseRepository, times(1)).all();
        verifyNoMoreInteractions(warehouseRepository);
    }

    @Test
    void findWarehouseShouldThrowExceptionForNegativeCount() {
        // Цель: проверить обработку ошибки — отрицательное количество товара считается некорректным входным значением.
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> warehouseService.findWarehouse("phone", -1));

        assertEquals("Количество товара не может быть отрицательным", exception.getMessage());
        verifyNoInteractions(warehouseRepository);
    }
}
