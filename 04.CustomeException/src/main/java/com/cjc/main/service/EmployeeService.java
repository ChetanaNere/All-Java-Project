package com.cjc.main.service;

import com.cjc.main.model.Employee;

public interface EmployeeService {

	public Employee saveEmployee(Employee emp);

	public Employee getEmployeeById(int id);

	public Employee updateEmployeeInfo(int id, Employee employee);

	public void deleteEmployeeById(int id);

}
