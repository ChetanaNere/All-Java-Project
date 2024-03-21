package com.cjc.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public ResponseEntity<User> createUser(@RequestPart("text") String userJson,
			@RequestPart("prof") MultipartFile profImage,
			@RequestPart("adhar") MultipartFile adharCard,
			@RequestPart("pan") MultipartFile pancard)
	{
		System.out.println(userJson);
		System.out.println(profImage.getName());
		System.out.println(profImage.getOriginalFilename());
		
		User user=us.saveUserDetails(userJson,profImage,adharCard,pancard);
		return new ResponseEntity<User> (user,HttpStatus.CREATED);
	}
	@GetMapping("/user")
	public ResponseEntity<List<User>> exposeUser()
	{
		List<User> users=us.getAllUsers();
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteData/{userID}")
	public String deleteData(@PathVariable int userID )
	{
		us.deleteData(userID);
		return "delete Successfully";
	}
}
