package com.wilson.employee.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wilson.employee.DTO.EmployeeDTO;
import com.wilson.employee.entity.EmployeeModel;
import com.wilson.employee.services.EmployeeService;

@RestController
@RequestMapping(value = "employeers")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@GetMapping
	public ResponseEntity<List<EmployeeModel>> findAll(){
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}
	
	@PostMapping
	public ResponseEntity<Object> saveEmployee(@RequestBody EmployeeDTO employeeDTO){
		var employeeModel = new EmployeeModel();
		BeanUtils.copyProperties(employeeDTO, employeeModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeModel);
	}
}
