package com.System.Employee.Management.repositories;

import com.System.Employee.Management.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    @Query("SELECT d FROM Department d WHERE d.dep_name = :name")
    Department findByDepName(String dep_name);
}