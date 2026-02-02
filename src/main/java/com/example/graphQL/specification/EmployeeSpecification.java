package com.example.graphQL.specification;

import com.example.graphQL.DTO.EmployeeInput;
import com.example.graphQL.entity.Employee;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.query.JpqlQueryBuilder;

import java.util.ArrayList;
import java.util.List;

public class EmployeeSpecification {
    public static Specification<Employee> getEmployeeBasedOnFilter(EmployeeInput filter){
         return (root,query,cb)->{
            List<Predicate> predicates=new ArrayList<>();
            if(filter!=null){
                if(filter.getCity()!=null){
                    predicates.add(cb.like(
                            cb.lower(root.get("city")),
                            "%"+filter.getCity()+"%"
                                    ));

                }
                if(filter.getOrganisation()!=null){
                    predicates.add(cb.like(cb.lower(root.get("organisation")),"%"+filter.getOrganisation()+"%"));
                }
                if(filter.getSalary()!=null){
                    predicates.add(cb.lessThan(root.get("salary"),filter.getSalary()));
                }
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
