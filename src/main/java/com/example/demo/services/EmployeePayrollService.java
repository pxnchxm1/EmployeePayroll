package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.EmployeePayrollDTO;
import com.example.demo.mappers.EmployeePayrollMapper;
import com.example.demo.models.EmployeePayrollModel;

@Service
public class EmployeePayrollService {
	@Autowired
	private EmployeePayrollMapper mapper;
	public String getEmployee() {
		EmployeePayrollDTO dtomodel = mapper.dataToDto(new EmployeePayrollModel(1,"John",35000));
		return "Name : " +dtomodel.getName() + " Salary : "+dtomodel.getSalary();
	}
    public EmployeePayrollDTO createEmployee(EmployeePayrollDTO dto) {
        EmployeePayrollDTO response = mapper.dataToDto(new EmployeePayrollModel(dto.getId(),dto.getName(),dto.getSalary()));
        return response;
    }


}
