package com.cjc.main.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.main.exception.EmployeeNotFoundException;
import com.cjc.main.exception.InvalidDetailsException;
import com.cjc.main.model.Employee;
import com.cjc.main.repository.EmployeeRespository;
import com.cjc.main.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRespository er;
	
	@Override
	public Employee saveEmployee(Employee emp) {
	String number=String.valueOf(emp.getMobNo());
	if(number.length()!=10)
		throw new InvalidDetailsException("MobNo Must be 10 digit");
	if(!emp.getEmail().endsWith("@gmail.com"))
		throw new InvalidDetailsException("Email id is wrong");
	System.out.println(number.length());
		return er.save(emp);
	}

	@Override
	public Employee getEmployeeById(int id) {
		Optional<Employee> opEmployee=er.findById(id);
		if(opEmployee.isPresent())
		{
			return opEmployee.get();
			
		}
		else {
			throw new EmployeeNotFoundException("Employee with id:"+id + " is not Fond");
		}
	}

	/*if employee is present on given ID then update or
	* thorw EmployeeNotFoundException
	 */
	@Override
	public Employee updateEmployeeInfo(int id, Employee employee) {
		Optional<Employee>opEmployee= er.findById(id);
		if(opEmployee.isPresent())
		{
			er.save(employee); 
		}
		else {
			throw new EmployeeNotFoundException("Employee with id:"+id + " is not Fond");
		}
		return null;
	}

	@Override
	public void deleteEmployeeById(int id) {
		Optional<Employee>opEmployee=er.findById(id);
		if(opEmployee.isPresent())
		{
			er.deleteById(id);
		}
		else {
			throw new EmployeeNotFoundException("Employee with id: "+id + " Fail to delete");
			
		}
	}

}
