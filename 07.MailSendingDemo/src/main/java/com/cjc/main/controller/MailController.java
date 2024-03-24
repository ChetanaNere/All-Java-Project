package com.cjc.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cjc.main.model.MyMail;
import com.cjc.main.service.MailService;

@RestController
public class MailController {

	@Autowired 
	MailService ms;
	
	@PostMapping("/simpleMail")
	public ResponseEntity<String> sendMail(@RequestBody MyMail mail){
		ms.sendMail(mail);
		return new  ResponseEntity<String>("Send Mail....", HttpStatus.OK);
	}
	@PostMapping("/attachmentfile")
	public ResponseEntity<String> sendAttachmentFile
	        (@RequestPart("mailInfo") String mailInfo,
			@RequestPart("attachment") MultipartFile file)
	{
		ms.sendMailWithAttachment(mailInfo,file);
		
		return new ResponseEntity<String>("AttachFile Send..", HttpStatus.OK);
	}
}
