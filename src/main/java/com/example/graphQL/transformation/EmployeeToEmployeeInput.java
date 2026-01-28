package com.example.graphQL.transformation;

import com.example.graphQL.DTO.EmployeeInput;
import com.example.graphQL.entity.Employee;

public class EmployeeToEmployeeInput {
    public static EmployeeInput convertEmployeeToEmployeeInput(Employee employee){
        EmployeeInput input=new EmployeeInput();

        if(employee.getName()!=null){
            input.setName(employee.getName());
        }
        if(employee.getOrganisation()!=null){
            input.setOrganisation(employee.getOrganisation());
        }
        if(employee.getSalary()!=null){
            input.setSalary(employee.getSalary());
        }
        if(employee.getCity()!=null){
            input.setCity(employee.getCity());
        }
        if(employee.getId()!=null){
            input.setId(employee.getId());
        }
        return input;
    }
}
