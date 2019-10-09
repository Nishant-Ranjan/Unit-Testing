package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
public class Employee {
	
	@Id
	private Integer empId;
	
	private String empName;
	
	private Integer age;
	
	private String desgination;
	
	private Double basicSalary;
	
	private Double hra;
	
	private Double otherAllowances;
	
	@Transient
	private Double grossSalary;
	
	protected Employee() {
		
	}
	

	public Employee(Integer empId, String empName, Integer age, String desgination, Double basicSalary, Double hra,
			Double otherAllowances) {
		this.empId = empId;
		this.empName = empName;
		this.age = age;
		this.desgination = desgination;
		this.basicSalary = basicSalary;
		this.hra = hra;
		this.otherAllowances = otherAllowances;
	}
	
	public Employee(Integer empId, String empName, Integer age, String desgination, Double basicSalary, Double hra,
			Double otherAllowances, Double grossSalary) {
		this.empId = empId;
		this.empName = empName;
		this.age = age;
		this.desgination = desgination;
		this.basicSalary = basicSalary;
		this.hra = hra;
		this.otherAllowances = otherAllowances;
		this.grossSalary = grossSalary;
	}
	
	

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getDesgination() {
		return desgination;
	}

	public void setDesgination(String desgination) {
		this.desgination = desgination;
	}

	public Double getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(Double basicSalary) {
		this.basicSalary = basicSalary;
	}

	public Double getHra() {
		return hra;
	}

	public void setHra(Double hra) {
		this.hra = hra;
	}

	public Double getOtherAllowances() {
		return otherAllowances;
	}

	public void setOtherAllowances(Double otherAllowances) {
		this.otherAllowances = otherAllowances;
	}

	public Double getGrossSalary() {
		return grossSalary;
	}

	public void setGrossSalary(Double grossSalary) {
		this.grossSalary = grossSalary;
	}
	
	
	
	
}
