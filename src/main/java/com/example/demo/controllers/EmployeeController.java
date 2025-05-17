package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmployeePayrollDTO;
import com.example.demo.services.EmployeePayrollService;

@RestController
@RequestMapping("/employeepayservice")
public class EmployeeController {
	
	@Autowired
	private EmployeePayrollService eps;
	
	@GetMapping("/")
	public String getEmployeeData(){
		return eps.getEmployee();
	}
	@PostMapping("/create")
    public EmployeePayrollDTO createNewEmployee(@RequestBody EmployeePayrollDTO dto) {
        return eps.createEmployee(dto);
    }

}
