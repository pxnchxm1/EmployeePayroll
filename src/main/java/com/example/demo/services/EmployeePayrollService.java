package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.EmployeePayrollDTO;
import com.example.demo.exceptions.EmployeeNotFoundException;
import com.example.demo.mappers.EmployeePayrollMapper;
import com.example.demo.models.EmployeePayrollModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmployeePayrollService {
	@Autowired
	private EmployeePayrollMapper mapper;
	
	List<EmployeePayrollModel> employeelist = new ArrayList<>(); 
	
	public List<EmployeePayrollDTO> getEmployee(){
		log.info("Getting all employee details here...");
		log.debug("This is a debug message");
        log.error("This is an error message for demonstration");
		return employeelist.stream().map(x->mapper.dataToDto(x)).collect(Collectors.toList());
	}
	public EmployeePayrollModel getEmployeeById(long id) {
		   return employeelist.stream()
	                .filter(emp -> emp.getId() == id)
	                .findFirst()
	                .orElseThrow(() -> new EmployeeNotFoundException("Employee with ID " + id + " not found"));
	}
	
	public String createEmployee(EmployeePayrollDTO d) {
		employeelist.add(mapper.DtoToData(d));
		return "Successfully added " + d.getName() + "to the list";
	}
	public EmployeePayrollDTO updateEmployee(long id,EmployeePayrollDTO emp) {
		for (EmployeePayrollModel e : employeelist) {
	        if (e.getId() == id) {
	            e.setName(emp.getName());
	            e.setSalary(emp.getSalary());
	            return mapper.dataToDto(e); 
	        }
	    }
	    return null; 
	}
    public void deleteEmployee(long id) {
    	try {
    		for (EmployeePayrollModel e : employeelist) {
    	        if (e.getId() == id) {
    	            employeelist.remove(e);
    	            return ;
    	        }
    	    }
    	}
    	catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
    }

}
