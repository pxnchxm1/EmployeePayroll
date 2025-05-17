package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmployeePayrollDTO;
import com.example.demo.mappers.EmployeePayrollMapper;
import com.example.demo.models.EmployeePayrollModel;

@RestController
@RequestMapping("/employeepayservice")
public class EmployeeController {
	
	@Autowired
	private EmployeePayrollMapper epm;
	
	@GetMapping("/")
	public String getEmployee(){
		 EmployeePayrollModel e = new EmployeePayrollModel(1,"John",50000);
		 EmployeePayrollDTO emp= epm.dataToDto(e);
		 return "Name : " + emp.getName()+ " Salary : " + emp.getSalary();
	}
	@PostMapping("/create")
    public EmployeePayrollDTO createEmployee(@RequestBody EmployeePayrollDTO dto) {
        EmployeePayrollDTO response = epm.dataToDto(epm.DtoToData(dto));
        return response;
    }

}
