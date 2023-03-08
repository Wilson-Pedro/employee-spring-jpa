package com.wilson.employee.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wilson.employee.DTO.EmployeeDTO;
import com.wilson.employee.entity.EmployeeModel;
import com.wilson.employee.services.EmployeeService;

@RestController
@CrossOrigin(origins="*", maxAge=3600)
@RequestMapping(value = "/employeers")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@GetMapping
	public ResponseEntity<List<EmployeeModel>> findAll(){
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Object> findById(@PathVariable Long id){
		Optional<EmployeeModel> obj = service.findById(id);
		if(!obj.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found!");
		}
		return ResponseEntity.status(HttpStatus.OK).body(obj.get());
	}
	
	@PostMapping
	public ResponseEntity<Object> saveEmployee(@RequestBody EmployeeDTO employeeDTO){
		if(service.existsByEmail(employeeDTO.getEmail())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Email is already in use!");
		}
		var employeeModel = new EmployeeModel();
		BeanUtils.copyProperties(employeeDTO, employeeModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(employeeModel));
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<EmployeeModel> updateEmployee(@PathVariable Long id, 
			@RequestBody EmployeeModel obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
