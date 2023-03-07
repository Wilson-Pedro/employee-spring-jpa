package com.wilson.employee.DTO;

import jakarta.validation.constraints.NotBlank;

public class EmployeeDTO {

	@NotBlank
	private String name;
	@NotBlank
	private String email;
	@NotBlank
	private Double salary;
	
	public EmployeeDTO() {
	}

	public EmployeeDTO(String name, String email, Double salary) {
		this.name = name;
		this.email = email;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
}
