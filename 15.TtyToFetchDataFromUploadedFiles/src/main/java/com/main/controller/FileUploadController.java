package com.main.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.main.model.UploadFile;
import com.main.serviceimpl.FileProcessingService;

@RestController
@RequestMapping("/api/files")
@CrossOrigin("*")
public class FileUploadController {

    @Autowired
    private FileProcessingService fileProcessingService;

//    @PostMapping("/upload")
//    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile  file) {
//        try {
//            String content = fileProcessingService.processFile(file);
//            return new ResponseEntity<>(content, HttpStatus.OK);
//        } catch (IOException e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//	@Autowired
//	UserService us;
//	
	@PostMapping("/upload")
	public ResponseEntity<String> uploadFile(@RequestPart("text") String userJson,
			@RequestPart("prof") MultipartFile profImage)
	{
 	System.out.println(userJson);
		System.out.println(profImage.getName());
		System.out.println(profImage.getOriginalFilename());
		
		UploadFile user=fileProcessingService.saveUserDetails(userJson,profImage);
		return new ResponseEntity<String> ("save....",HttpStatus.CREATED);
	}
	 @GetMapping("/getAllFiles")
	    public ResponseEntity<List<UploadFile>> getAllFiles() {
	        return ResponseEntity.ok(fileProcessingService.getAllFiles());
	    }


	    @GetMapping("getFileById/{id}")
	    public ResponseEntity<UploadFile> getFile(@PathVariable int id) 
	    {
	        UploadFile file = fileProcessingService.getFile(id);
	        if (file != null)
	        {
	            return ResponseEntity.ok(file);
	        } else 
	        {
	            return ResponseEntity.notFound().build();
	        }
	    }
	    
	    @DeleteMapping("/deleteData/{id}")
	    public ResponseEntity<String> deleteData(@PathVariable int id)
	    {
	    	fileProcessingService.deleteData(id);
	    	return new ResponseEntity<String>("Delete Successfuly",HttpStatus.OK);
	    }
}