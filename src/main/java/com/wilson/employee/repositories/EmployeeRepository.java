package com.wilson.employee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wilson.employee.entity.EmployeeModel;

public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long>{

}
