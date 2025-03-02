package com.System.Employee.Management.service;

import com.System.Employee.Management.entity.Department;
import com.System.Employee.Management.repositories.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class DepartmentServiceImplTest {
    @Mock
    DepartmentRepository departmentRepository;
    @InjectMocks
    DepartmentServiceImpl departmentService;
    @Mock
    Department department;
    @BeforeEach
    void Setup()
    {
        department = new Department();
        department.setDep_name("Software");
        department.setId(1L);
    }

    @Test
    void createdepTest()
    {
        when(departmentRepository.save(any(Department.class))).thenReturn(department);
        Department expectedDept = departmentService.createDepartment(department);
        assertNotNull(expectedDept);
        assertEquals("Software",expectedDept.getDep_name());
        verify(departmentRepository,times(1)).save(any(Department.class));
    }
    @Test
     void getDeptById()
    {
        when(departmentRepository.findById(1L)).thenReturn(Optional.ofNullable(department));
        Department getDept = departmentService.getDepartmentById(1L);
        assertNotNull(getDept);
        assertEquals(1L,getDept.getId());
        verify(departmentRepository,times(1)).findById(1L);
    }

    @Test
    void getAllDept()
    {
        List<Department> departmentList = new ArrayList<Department>();
        when(departmentRepository.findAll()).thenReturn(departmentList);
        List<Department> result = departmentService.getAllDepartments();
        assertNotNull(result);
        assertEquals(0,result.size());
        verify(departmentRepository,times(1)).findAll();
    }
        @Test
        void testUpdateDepartment() {
            Department updatedDepartment = new Department();
            updatedDepartment.setId(2L);
            updatedDepartment.setDep_name("Finance");

            when(departmentRepository.findById(1L)).thenReturn(Optional.of(department));
            when(departmentRepository.save(any(Department.class))).thenReturn(updatedDepartment);

            Department result = departmentService.updateDepartment(1L, updatedDepartment);

            assertNotNull(result);
            assertEquals("Finance", result.getDep_name());
            verify(departmentRepository, times(1)).save(any(Department.class));
        }


    @Test
    void testDeleteDepartment() {
        when(departmentRepository.findById(1L)).thenReturn(Optional.of(department));
        doNothing().when(departmentRepository).deleteById(1L);

        departmentService.deleteDepartment(1L);

        verify(departmentRepository, times(1)).deleteById(1L);
    }

}
