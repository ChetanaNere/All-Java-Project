package com.main.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.model.State;
import com.main.repository.StateRepository;

@Service
public class StateService {

	@Autowired
	StateRepository stateRepo;
	
	public State createState(State state) {
		
		return stateRepo.save(state);
	}

	public List<State> getAllState() {
		
		return stateRepo.findAll();
	}

	 public List<State> getStatesByPrefix(String prefix) {
	        return stateRepo.findByNameStartingWith(prefix);
	    }

	    public Optional<State> getStateDetails(Long id) {
	        return stateRepo.findById(id);
	    }

}
