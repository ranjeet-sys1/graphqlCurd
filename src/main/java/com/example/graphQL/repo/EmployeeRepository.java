package com.example.graphQL.repo;

import com.example.graphQL.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EmployeeRepository extends JpaRepository<Employee,Long> , JpaSpecificationExecutor<Employee> {
}
