package com.example.demo.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.demo.dto.EmployeePayrollDTO;
import com.example.demo.models.EmployeePayrollModel;

@Component
public class EmployeePayrollMapper {
	
	public EmployeePayrollDTO dataToDto(EmployeePayrollModel e) {
		EmployeePayrollDTO emp = new EmployeePayrollDTO();
		emp.setId(e.getId());
		emp.setName(e.getName());
		emp.setSalary(e.getSalary());
		return emp;
	}
	public EmployeePayrollModel DtoToData(EmployeePayrollDTO e) {
		EmployeePayrollModel emp = new EmployeePayrollModel();
		emp.setId(e.getId());
		emp.setName(e.getName());
		emp.setSalary(e.getSalary());
		return emp;
	}
	public List<EmployeePayrollDTO> listOfDataToDto(List<EmployeePayrollModel > e){
		return e.stream().map(x->dataToDto(x)).collect(Collectors.toList());
	}
	public List<EmployeePayrollModel> listOfDtoToData(List<EmployeePayrollDTO > e){
		return e.stream().map(y->DtoToData(y)).collect(Collectors.toList());
	}

}
