package com.cjc.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.main.service.EmployeeService;

@RestController
public class AdminController {

	@Autowired 
	EmployeeService es;
	
	/*
	 * id employee present then delete 
	 * or throw employee not found exception
	 */
	@DeleteMapping("/employee/{id}")
	public String deleteEmployeeId(@PathVariable int id)
	{
		
		es.deleteEmployeeById(id);
		
		return "Employee Remove";
	}
}
