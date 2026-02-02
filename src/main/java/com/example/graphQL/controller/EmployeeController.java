package com.example.graphQL.controller;

import com.example.graphQL.DTO.EmployeeInput;
import com.example.graphQL.entity.Employee;
import com.example.graphQL.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/graphql")
public class EmployeeController {
    @Autowired
    private EmployeeService service;
    @MutationMapping
    public Employee saveEmployee(@Argument EmployeeInput employeeInput){
        return service.saveEmployee(employeeInput);
    }
    @MutationMapping
    public Employee updateEmployee(@Argument Long id,@Argument EmployeeInput employeeInput){
        EmployeeInput employee = service.findById(id);
        employee.setCity(employeeInput.getCity());
        employee.setOrganisation(employeeInput.getOrganisation());
        employee.setSalary(employeeInput.getSalary());
        employee.setName(employeeInput.getName());
        return service.saveEmployee(employee);


    }
    @QueryMapping
    public Employee getEmployeeById(@Argument Long id){
           return service.getEmployeeById(id);
    }
    @QueryMapping
    public List<Employee> getAll(){
        return service.getAll();

    }
    @QueryMapping
    public List<Employee> getEmployeesBasedOnFilter(@Argument EmployeeInput employeeInput){
        return service.getEmployeeBasedOnFilter(employeeInput);
    }
}
