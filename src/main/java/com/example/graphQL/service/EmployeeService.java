package com.example.graphQL.service;

import com.example.graphQL.DTO.EmployeeInput;
import com.example.graphQL.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(EmployeeInput employeeInput);
    Employee updateEmployee(Long id);
    Employee getEmployeeById(Long id);
    List<Employee> getAll();
    EmployeeInput findById(Long id);
}
