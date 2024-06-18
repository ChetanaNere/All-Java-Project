package com.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.main.model.Voter;
import com.main.repository.VoterRepository;

import java.time.LocalDate;
import java.time.Period;

@Service
public class VoterService {
    @Autowired
    private VoterRepository voterRepository;

    public List<Voter> getAllVoters() {
        return voterRepository.findAll();
    }

    public Voter getVoterById(Long id) {
        return voterRepository.findById(id).orElse(null);
    }

    public Voter saveVoter(Voter voter) {
        if (isEligible(voter.getDateOfBirth())) {
            voter.setIsEligible(true);
        } else {
            voter.setIsEligible(false);
        }
        return voterRepository.save(voter);
    }

    public void deleteVoter(Long id) {
        voterRepository.deleteById(id);
    }

    private boolean isEligible(LocalDate dateOfBirth) {
        if (dateOfBirth == null) {
            return false;
        }
        return Period.between(dateOfBirth, LocalDate.now()).getYears() >= 18;
    }
}
