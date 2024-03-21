package com.cjc.main.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.cjc.main.model.User;

public interface UserService {

	public User saveUserDetails(String userJson, MultipartFile profImage, MultipartFile adharCard, MultipartFile pancard);

	public List<User> getAllUsers();

	public void deleteData(int userID);

}
