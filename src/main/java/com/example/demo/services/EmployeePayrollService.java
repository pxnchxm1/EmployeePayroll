package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.EmployeePayrollDTO;
import com.example.demo.mappers.EmployeePayrollMapper;
import com.example.demo.models.EmployeePayrollModel;

@Service
public class EmployeePayrollService {
	@Autowired
	private EmployeePayrollMapper mapper;
	
	List<EmployeePayrollModel> employeelist = new ArrayList<>(); 
	
	public List<EmployeePayrollDTO> getEmployee(){
		return employeelist.stream().map(x->mapper.dataToDto(x)).collect(Collectors.toList());
	}
	public EmployeePayrollDTO getEmployeeById(long id) {
		try {
			for(int i=0;i<employeelist.size();i++) {
				if(employeelist.get(i).getId()==id) {
					return mapper.dataToDto(employeelist.get(i));
				}
			}
		}
		catch(Exception e) {
			System.out.println("EMPLOYEE NOT FOUND");
		}
		return null;
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
