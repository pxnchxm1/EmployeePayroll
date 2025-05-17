package com.example.demo.models;

import org.springframework.stereotype.Component;


@Component
public class EmployeePayrollModel {
     private long id;
     private String name;
    public EmployeePayrollModel(){}
    public long getId() {
        return id;
    }
    
    @Override
    public String toString() {
        return "EmployeePayrollModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private double salary;
     
     public EmployeePayrollModel(long id,String name,double salary) {
    	 this.id = id;
    	 this.name= name;
    	 this.salary = salary;
     }
}
