package com.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.model.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
	
}