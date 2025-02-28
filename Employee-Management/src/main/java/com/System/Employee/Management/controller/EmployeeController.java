package com.System.Employee.Management.controller;

import com.System.Employee.Management.entity.Employee;
import com.System.Employee.Management.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }

    @GetMapping("/department/{deptId}")
    public List<Employee> getEmployeesByDepartment(@PathVariable Long deptId) {
        return employeeService.getEmployeesByDepartment(deptId);
    }

    @GetMapping("/project/{projId}")
    public List<Employee> getEmployeesByProject(@PathVariable Long projId) {
        return employeeService.getEmployeesByProject(projId);
    }

    @PostMapping("/{empId}/assign-project/{projId}")
    public Employee assignProject(@PathVariable Long empId, @PathVariable Long projId) {
        return employeeService.assignProjectToEmployee(empId, projId);
    }
}