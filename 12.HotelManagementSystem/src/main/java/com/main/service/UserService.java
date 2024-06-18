package com.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.model.User;
import com.main.repositoryy.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    public User registerUser(User user) {
       // user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User getUserByUsername(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

	public List<User> getAllUsers() {
				return userRepository.findAll();
	}
}