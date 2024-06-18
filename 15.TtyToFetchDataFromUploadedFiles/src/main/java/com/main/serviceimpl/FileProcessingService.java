package com.main.serviceimpl;

import java.io.IOException;
import java.util.List;

import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.main.model.UploadFile;
import com.main.repository.FileProcessingRepository;

@Service
public class FileProcessingService 
{

    @Autowired
    FileProcessingRepository fileRepo;
    
	public UploadFile saveUserDetails(String userJson,MultipartFile profImage) {
		ObjectMapper mapper=new ObjectMapper();
		try {
			UploadFile user=mapper.readValue(userJson,UploadFile.class);
			if(profImage!=null) user.setProfileImage(profImage.getBytes());
			System.err.println(user);
			fileRepo.save(user);
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

	public List<UploadFile> getAllFiles() {
        return fileRepo.findAll();
    }
	
	public UploadFile getFile(int id) {
        return fileRepo.findById(id).orElse(null);
    }

	public void deleteData(int id) {
		
		fileRepo.deleteById(id);
	}
	
}
	
	
	
	