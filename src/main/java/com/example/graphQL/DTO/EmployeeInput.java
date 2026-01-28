package com.example.graphQL.DTO;

import lombok.Data;

@Data
public class EmployeeInput {
    private Long id;
    private String name;
    private String organisation;
    private Double salary;
    private String city;
}
