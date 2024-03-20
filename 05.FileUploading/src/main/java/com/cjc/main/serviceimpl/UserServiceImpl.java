package com.cjc.main.serviceimpl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cjc.main.model.User;
import com.cjc.main.repository.UserRepository;
import com.cjc.main.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository ur;
	@Override
	public User saveUserDetails(String userJson, MultipartFile profImage, MultipartFile adharCard,
			MultipartFile pancard) {
		ObjectMapper mapper=new ObjectMapper();
		try {
			User user=mapper.readValue(userJson, User.class);
			if(profImage!=null) user.setProfileImage(profImage.getBytes());
			if(adharCard!=null) user.setAdharCard(adharCard.getBytes());
			if(pancard!=null) user.setPanCard(pancard.getBytes());
			System.err.println(user);
			ur.save(user);
			}
		catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(IOException e)
		{
			
		}
	
		return null;
	}

}
