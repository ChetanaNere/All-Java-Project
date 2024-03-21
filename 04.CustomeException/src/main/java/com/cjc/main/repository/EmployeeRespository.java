package com.cjc.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjc.main.model.Employee;
@Repository
public interface EmployeeRespository extends JpaRepository<Employee, Integer>{

}
