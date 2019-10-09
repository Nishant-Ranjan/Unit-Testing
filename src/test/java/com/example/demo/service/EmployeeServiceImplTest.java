package com.example.demo.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.demo.exceptionHandler.RecordNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repositories.EmployeeRepository;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceImplTest {
	
	@Mock
	EmployeeRepository empRepoMock;
	
	@InjectMocks
	EmployeeServiceImpl empService;
	
	@Test
	public void testGetAllEmployees() {
		when(empRepoMock.findAll()).thenReturn(Arrays.asList((new Employee(101, "Nishant Ranjan", 26, "Software Engineer", new Double(10000),  new Double(2000),  new Double(3000)))));
		List<Employee> emp = empService.getAllEmployees();
		
		assertEquals(emp.get(0).getEmpName(), "Nishant Ranjan");
		assertEquals(emp.get(0).getGrossSalary(), new Double(15000));
	}

	@Test
	public void testGetEmployeeById() {
		when(empRepoMock.findByEmpId(101)).thenReturn(Optional.of(new Employee(101, "Nishant Ranjan", 26, "Software Engineer", new Double(10000),  new Double(2000),  new Double(3000))));
		Employee emp = empService.getEmployeeById(101);
		
		assertEquals(emp.getEmpName(), "Nishant Ranjan");
		assertEquals(emp.getGrossSalary(), new Double(15000));
	}
	
	@Test(expected = RecordNotFoundException.class)
	public void testGetEmployeeByIdForNoEmployee() {
		Employee emp = empService.getEmployeeById(102);
		
		
	}

}
