package com.System.Employee.Management.service;

import com.System.Employee.Management.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);
    Employee getEmployeeById(Long id);
    List<Employee> getAllEmployees();
    Employee updateEmployee(Long id, Employee employee);
    void deleteEmployee(Long id);
    List<Employee> getEmployeesByDepartment(Long deptId);
    List<Employee> getEmployeesByProject(Long projId);
    Employee assignProjectToEmployee(Long empId, Long projId);
}

