package com.cjc.main.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.main.exception.EmployeeNotFoundException;
import com.cjc.main.model.Employee;
import com.cjc.main.model.EroorResponce;
import com.cjc.main.service.EmployeeService;
@CrossOrigin("*")
@RestController
public class EmployeeController {

	@Autowired
	EmployeeService es;
	
	@PostMapping("/employee")
	public Employee createEmployee(@RequestBody Employee employee)
	{
		Employee emp=es.saveEmployee(employee);
		return emp;
	}
	@GetMapping("employee/{id}")
	public ResponseEntity<Employee> exposeEmployee(@PathVariable int id) {
		Employee employee= es.getEmployeeById(id);
		return new ResponseEntity<Employee>(employee,HttpStatus.OK);
	}
	
	@PutMapping("/employee/{id}")
	public Employee updateEmployee(@PathVariable int id,@RequestBody Employee employee)
	{
		Employee emp=es.updateEmployeeInfo(id,employee);
		return emp;
	}
	
//	@ExceptionHandler(EmployeeNotFoundExceptio n.class)
//	public String handleEmployeeNotFound() {
//		return "Employee Not Available in database";
//	}
	
}
