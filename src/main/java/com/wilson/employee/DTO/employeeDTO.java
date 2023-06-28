package com.wilson.employee.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EmployeeDTO {

	@NotBlank(message = "name is mandatory")
	private String name;
	
	@NotBlank(message = "email is mandatory")
	private String email;
	
	@NotNull(message = "salary cannot be null")
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
