package com.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.main.model.User;
import com.main.service.UserService;
import java.util.*;
@RestController
@CrossOrigin("*")
//@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/registerUser")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User registeredUser = userService.registerUser(user);
        return ResponseEntity.ok(registeredUser);
    }

    @GetMapping("/getByName/{username}/{password}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username,@PathVariable String password) {
        User user = userService.getUserByUsername(username,password);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }
    @GetMapping("/getAllUser")
    public List<User> getAllUsers()
    {
    	return userService.getAllUsers();
    }
}