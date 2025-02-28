package com.System.Employee.Management.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long department_id;

    private String dep_name;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;
}
