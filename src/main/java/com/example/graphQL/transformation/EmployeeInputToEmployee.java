package com.example.graphQL.transformation;

import com.example.graphQL.DTO.EmployeeInput;
import com.example.graphQL.entity.Employee;

public class EmployeeInputToEmployee {

    public static Employee convertEmployeeInputToEmployee(EmployeeInput employeeInput){
        Employee employee=new Employee();

        if(employeeInput.getName()!=null){
            employee.setName(employeeInput.getName());
        }
        if(employeeInput.getOrganisation()!=null){
            employee.setOrganisation(employeeInput.getOrganisation());
        }
        if(employeeInput.getSalary()!=null){
            employee.setSalary(employeeInput.getSalary());
        }
        if(employeeInput.getCity()!=null){
            employee.setCity(employeeInput.getCity());
        }
        if(employeeInput.getId()!=null){
            employee.setId(employeeInput.getId());
        }
        return employee;
    }
}
