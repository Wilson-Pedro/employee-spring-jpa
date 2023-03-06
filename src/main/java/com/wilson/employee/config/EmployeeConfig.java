package com.wilson.employee.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.wilson.employee.entity.EmployeeModel;
import com.wilson.employee.repositories.EmployeeRepository;

@Configuration
@Profile("test")
public class EmployeeConfig implements CommandLineRunner{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public void run(String... args) throws Exception {
		EmployeeModel emp1 = new EmployeeModel(null, "Wilson Pedro", "wilson@gmail.com", 3500.0);
		EmployeeModel emp2 = new EmployeeModel(null, "Marcos Abreu", "marcos@gmail.com", 3500.0);
		
		employeeRepository.saveAll(Arrays.asList(emp1, emp2));
		
	}

}
