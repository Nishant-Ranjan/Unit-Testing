package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptionHandler.DuplicateRecordsException;
import com.example.demo.exceptionHandler.RecordNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repositories.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository empRepo; 
	
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employeeList = empRepo.findAll();
		for(Employee emp: employeeList){
			calculateGrossSalary(emp);
		}
		return employeeList;
	}

	@Override
	public void saveEmployee(Employee emp) {
		if(checkEmployeeExists(emp.getEmpId())) {
			throw new DuplicateRecordsException("Employee Already Exists.");
		}
		empRepo.save(emp);
		
	}
	
	private boolean checkEmployeeExists(Integer employeeId) {
		return empRepo.findById(employeeId).isPresent();
	}
	
	private Employee calculateGrossSalary(Employee emp) {
		if(emp != null) {
			emp.setGrossSalary(emp.getBasicSalary() + emp.getHra()+emp.getOtherAllowances());
		}
		return emp;
	}

	@Override
	public Employee getEmployeeById(Integer employeeId) {
		Optional<Employee> opt = empRepo.findByEmpId(employeeId);
		if(opt.isPresent()) {
			return calculateGrossSalary(opt.get());
		}
		else {
			throw new RecordNotFoundException("Employee Does Not Exist.");
		}
	}

}
