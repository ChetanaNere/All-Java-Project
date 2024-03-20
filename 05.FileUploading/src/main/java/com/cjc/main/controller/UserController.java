package com.cjc.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cjc.main.model.User;
import com.cjc.main.service.UserService;
@CrossOrigin("*")
@RestController
public class UserController 
{
	@Autowired
	UserService us;
	
	@PostMapping("/user")
	public ResponseEntity<String> createUser(@RequestPart("text") String userJson,
			@RequestPart("prof") MultipartFile profImage,
			@RequestPart("adhar") MultipartFile adharCard,
			@RequestPart("pan") MultipartFile pancard)
	{
		System.out.println(userJson);
		System.out.println(profImage.getName());
		System.out.println(profImage.getOriginalFilename());
		
		User user=us.saveUserDetails(userJson,profImage,adharCard,pancard);
		return new ResponseEntity<String> ("save....",HttpStatus.CREATED);
	}
}
