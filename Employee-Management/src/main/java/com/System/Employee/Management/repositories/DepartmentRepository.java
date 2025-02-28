package com.System.Employee.Management.repositories;

import com.System.Employee.Management.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    // Custom query methods if needed (e.g., find by name)
    Department findByName(String dep_name);
}