package com.example.demo.mappers;

import org.springframework.stereotype.Component;

import com.example.demo.dto.EmployeePayrollDTO;
import com.example.demo.models.EmployeePayrollModel;

@Component
public class EmployeePayrollMapper {
	
	public EmployeePayrollDTO dataToDto(EmployeePayrollModel e) {
		EmployeePayrollDTO emp = new EmployeePayrollDTO(e.getId(),e.getSalary(),e.getName());
		return emp;
	}
	public EmployeePayrollModel DtoToData(EmployeePayrollDTO e) {
		EmployeePayrollModel emp = new EmployeePayrollModel();
		emp.setId(e.getId());
		emp.setName(e.getName());
		emp.setSalary(e.getSalary());
		return emp;
	}

}
