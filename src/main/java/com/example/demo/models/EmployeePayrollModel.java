package com.example.demo.models;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class EmployeePayrollModel {
     private long id;
     private String name;
    private double salary;
     
    
}
