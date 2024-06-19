package com.main.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.main.model.State;
import com.main.serviceimpl.StateService;

@RestController
@CrossOrigin("*")
public class StateController {

	@Autowired
	StateService stateService;
	
	@PostMapping("/createState")
	public ResponseEntity<State> createState(@RequestBody State state)
	{
		State s=stateService.createState(state);
		return new ResponseEntity<State>(s,HttpStatus.CREATED);
	}
	@GetMapping("/getAllState")
	public List<State> getAllState()
	{
		return stateService.getAllState();
	}
	 @GetMapping("/getStatesByPrefix")
	    public List<State> getStatesByPrefix(@RequestParam String prefix) {
	        return stateService.getStatesByPrefix(prefix);
	    }

	    @GetMapping("getById/{id}")
	    public ResponseEntity<State> getStateDetails(@PathVariable Long id) {
	        Optional<State> state = stateService.getStateDetails(id);
	        return state.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }
}
