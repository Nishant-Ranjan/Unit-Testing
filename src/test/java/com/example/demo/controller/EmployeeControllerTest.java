package com.example.demo.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;


@WebMvcTest(EmployeeController.class)
@RunWith(SpringRunner.class)
public class EmployeeControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	EmployeeService employeeServiceMock;
	
	@InjectMocks
	EmployeeController empController;
	
	

	@Test
	public void testGetAllEmployees() throws Exception {
		List<Employee> employee = new ArrayList<Employee>();
		employee.add(new Employee(101, "Nishant Ranjan", 26, "Software Engineer", new Double(10000),  new Double(2000),  new Double(3000), new Double(15000)));
		when(employeeServiceMock.getAllEmployees()).thenReturn(employee);
		
		RequestBuilder request = MockMvcRequestBuilders.get("/employee").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(request)
							.andExpect(status().isOk())
							.andReturn();
		JSONAssert.assertEquals("[{empId:101,empName:'Nishant Ranjan'}]", result.getResponse().getContentAsString(), false);
	}
	
	

}
