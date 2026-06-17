package ru.productstar.mockito.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.productstar.mockito.model.Customer;
import ru.productstar.mockito.repository.CustomerRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    private CustomerService customerService;

    @BeforeEach
    void setUp() {
        customerService = new CustomerService(customerRepository);
    }

    @Test
    void getOrCreateShouldReturnExistingCustomer() {
        // Цель: проверить обычный сценарий, когда клиент уже есть в репозитории.
        Customer ivan = new Customer("Ivan");
        when(customerRepository.getByName("Ivan")).thenReturn(ivan);

        Customer result = customerService.getOrCreate("Ivan");

        assertSame(ivan, result);
        verify(customerRepository, times(1)).getByName("Ivan");
        verify(customerRepository, never()).add(any(Customer.class));
        verifyNoMoreInteractions(customerRepository);
    }

    @Test
    void getOrCreateShouldCreateNewCustomerWhenCustomerNotFound() {
        // Цель: проверить сценарий создания нового клиента, если его нет в репозитории.
        when(customerRepository.getByName("Oleg")).thenReturn(null);
        when(customerRepository.add(any(Customer.class))).thenAnswer(invocation -> {
            Customer customer = invocation.getArgument(0);
            customer.setId(10);
            return customer;
        });

        Customer result = customerService.getOrCreate("Oleg");

        assertEquals(10, result.getId());
        assertEquals("Oleg", result.getName());

        ArgumentCaptor<Customer> captor = ArgumentCaptor.forClass(Customer.class);
        verify(customerRepository, times(1)).getByName("Oleg");
        verify(customerRepository, times(1)).add(captor.capture());
        assertEquals("Oleg", captor.getValue().getName());
        verifyNoMoreInteractions(customerRepository);
    }

    @Test
    void getOrCreateShouldCreateCustomerWithNullName() {
        // Цель: проверить граничный случай — в сервис передали null вместо имени.
        when(customerRepository.getByName(null)).thenReturn(null);
        when(customerRepository.add(any(Customer.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Customer result = customerService.getOrCreate(null);

        assertNotNull(result);
        assertNull(result.getName());
        verify(customerRepository, times(1)).getByName(null);
        verify(customerRepository, times(1)).add(any(Customer.class));
        verifyNoMoreInteractions(customerRepository);
    }
}
