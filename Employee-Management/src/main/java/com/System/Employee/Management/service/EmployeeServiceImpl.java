package com.System.Employee.Management.service;

import com.System.Employee.Management.entity.Employee;
import com.System.Employee.Management.entity.Project;
import com.System.Employee.Management.repositories.EmployeeRepository;
import com.System.Employee.Management.repositories.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ProjectRepository projectRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ProjectRepository projectRepository) {
        this.employeeRepository = employeeRepository;
        this.projectRepository = projectRepository;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        Employee existingEmployee = getEmployeeById(id);
        existingEmployee.setName(employee.getName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setDepartment(employee.getDepartment());
        return employeeRepository.save(existingEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> getEmployeesByDepartment(Long deptId) {
        return employeeRepository.findByDepartmentId(deptId);
    }

    @Override
    public List<Employee> getEmployeesByProject(Long projId) {
        return employeeRepository.findByProjectsId(projId);
    }

    @Override
    public Employee assignProjectToEmployee(Long empId, Long projId) {
        Employee employee = getEmployeeById(empId);
        Project project = projectRepository.findById(projId)
                .orElseThrow(() -> new RuntimeException("Project not found"));

        employee.getProjects().add(project);
        return employeeRepository.save(employee);
    }
}
