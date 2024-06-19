package com.main.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.main.exception.UsernameNotFoundException;
import com.main.model.User;
import com.main.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    
    // Registration logic
    public User registerUser(User user) {
           return userRepository.save(user);
     }


    // Login logic
    public User loginUser(String username, String password) {
    	 return userRepository.findByUsernameAndPassword(username, password);
    
    }

    public List<User> getAllUsers()
    {
		return userRepository.findAll();
    }
   
    
    public void updatePassword(String email, String newPassword) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            // Now you have the User object, so you can set the password
            user.setPassword(newPassword); // Make sure to encode the password
            userRepository.save(user);
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }


    public Optional<User> findByToken(String token) {
        return userRepository.findByResetToken(token);
    }


	public Optional<User> findUserById(Long id) {
		return userRepository.findById(id);
		 
	}

	
   
}
