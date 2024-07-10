package com.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.model.Leave;

@Repository
public interface LeaveRepository extends JpaRepository<Leave, Long> 
{
	
	
}