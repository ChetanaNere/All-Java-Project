package com.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import com.main.model.Voter;
import com.main.service.VoterService;

@RestController
//@RequestMapping("/api/voters")
@CrossOrigin("*")
public class VoterController {
    @Autowired
    private VoterService voterService;

    @GetMapping("/getAllData")
    public List<Voter> getAllVoters() {
        return voterService.getAllVoters();
    }

    @GetMapping("getById/{id}")
    public Voter getVoterById(@PathVariable Long id) {
        return voterService.getVoterById(id);
    }

    @PostMapping("/saveVoter")
    public Voter createVoter(@RequestBody Voter voter) {
        return voterService.saveVoter(voter);
    }

    @PutMapping("updateVoter/{id}")
    public Voter
    updateVoter(@PathVariable Long id, @RequestBody Voter voter) {
        voter.setId(id);
        return voterService.saveVoter(voter);
    }

    @DeleteMapping("deleteById/{id}")
    public void deleteVoter(@PathVariable Long id) {
        voterService.deleteVoter(id);
    }
}


