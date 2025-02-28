package com.System.Employee.Management.repositories;

import com.System.Employee.Management.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    // Find all projects where a given employee is working
    List<Project> findByEmployeesId(Long employeeId);
}