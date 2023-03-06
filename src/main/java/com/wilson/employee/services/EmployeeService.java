package com.wilson.employee.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wilson.employee.entity.EmployeeModel;
import com.wilson.employee.repositories.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	public List<EmployeeModel> findAll() {
		return repository.findAll();
	}

	public EmployeeModel findById(Long id) {
		Optional<EmployeeModel> obj = repository.findById(id);
		return obj.orElseThrow(() -> new RuntimeException());
	}


}
