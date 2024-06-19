package com.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.model.State;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {

	public List<State> findByNameStartingWith(String prefix);

}
