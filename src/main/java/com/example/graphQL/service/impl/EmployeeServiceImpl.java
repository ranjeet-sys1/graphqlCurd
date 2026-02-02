package com.example.graphQL.service.impl;

import com.example.graphQL.DTO.EmployeeInput;
import com.example.graphQL.entity.Employee;
import com.example.graphQL.repo.EmployeeRepository;
import com.example.graphQL.service.EmployeeService;
import com.example.graphQL.specification.EmployeeSpecification;
import com.example.graphQL.transformation.EmployeeInputToEmployee;
import com.example.graphQL.transformation.EmployeeToEmployeeInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl  implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Employee saveEmployee(EmployeeInput employeeInput) {
        Employee employee = EmployeeInputToEmployee.convertEmployeeInputToEmployee(employeeInput);
        return employeeRepository.save(employee);
        //return EmployeeToEmployeeInput.convertEmployeeToEmployeeInput(saved);
    }

    @Override
    public Employee updateEmployee(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("employee id doesn't exist"));

        return null;
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("employee id doesn't exist"));
        //return  EmployeeToEmployeeInput.convertEmployeeToEmployeeInput(employee);

    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
        //return all.stream().map(EmployeeToEmployeeInput::convertEmployeeToEmployeeInput).toList();
    }

    @Override
    public EmployeeInput findById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("employee id doesn't exist"));
        return  EmployeeToEmployeeInput.convertEmployeeToEmployeeInput(employee);
    }

    @Override
    public List<Employee> getEmployeeBasedOnFilter(EmployeeInput employeeInput) {
        return employeeRepository.findAll(EmployeeSpecification.getEmployeeBasedOnFilter(employeeInput));
    }
}
