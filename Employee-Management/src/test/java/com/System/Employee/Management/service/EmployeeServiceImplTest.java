package com.System.Employee.Management.service;
import com.System.Employee.Management.entity.Employee;
import com.System.Employee.Management.repositories.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class EmployeeServiceImplTest {
    @Mock
    EmployeeRepository employeeRepository;
    @InjectMocks
    EmployeeServiceImpl employeeService;

    private Employee employee;

    @BeforeEach
    void setUp() {
        employee = new Employee();
        employee.setId(1L);
        employee.setName("John Doe");
        employee.setEmail("john.doe@example.com");
    }

    @Test
    void createEmployeeTest()
    {
        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);
        Employee expectedEmployee = employeeService.createEmployee(employee);
        assertNotNull(expectedEmployee);
        assertEquals("John Doe", expectedEmployee.getName());
        verify(employeeRepository, times(1)).save(any(Employee.class));

    }
    @Test
    void getEmployeeTest()
    {
        List<Employee> employeeList =new ArrayList<Employee>();
        when(employeeRepository.findAll()).thenReturn(employeeList);
        List<Employee> result = employeeService.getAllEmployees();
        assertEquals(0, result.size());
        verify(employeeRepository, times(1)).findAll();
    }
    @Test
    void testGetEmployeeById() {
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));

        Employee foundEmployee = employeeService.getEmployeeById(1L);

        assertNotNull(foundEmployee);
        assertEquals(1L, foundEmployee.getId());
        verify(employeeRepository, times(1)).findById(1L);
    }

    @Test
    void testDeleteEmployee() {
        doNothing().when(employeeRepository).deleteById(1L);

        employeeService.deleteEmployee(1L);

        verify(employeeRepository, times(1)).deleteById(1L);
    }
}