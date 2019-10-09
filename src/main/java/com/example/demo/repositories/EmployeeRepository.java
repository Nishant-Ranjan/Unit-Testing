package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	
	public List<Employee> findAll();
	public Optional<Employee> findByEmpId(Integer empId);

}
