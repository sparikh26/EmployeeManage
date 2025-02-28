package com.System.Employee.Management.repositories;

import com.System.Employee.Management.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Find employees by department ID
    List<Employee> findByDepartmentId(Long departmentId);

    // Find employees working on a specific project
    List<Employee> findByProjectsId(Long projectId);

}
