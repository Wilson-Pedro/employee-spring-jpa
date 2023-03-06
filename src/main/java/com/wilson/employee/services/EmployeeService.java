package com.wilson.employee.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wilson.employee.entity.EmployeeModel;
import com.wilson.employee.repositories.EmployeeRepository;

import jakarta.transaction.Transactional;

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

	@Transactional
	public EmployeeModel update(Long id, EmployeeModel obj) {
		EmployeeModel entity = repository.getReferenceById(id);
		updtaeData(entity, obj);
		return repository.save(entity);
	}

	private void updtaeData(EmployeeModel entity, EmployeeModel obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setSalary(obj.getSalary());
	}
}
