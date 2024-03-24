package com.cjc.main.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cjc.main.model.MyMail;
import com.cjc.main.repository.MailRepository;
import com.cjc.main.service.MailService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
@Service
public class MailServiceImpl implements MailService{

	@Autowired
	JavaMailSender javaMailSender;
	
	@Autowired
	MailRepository mr;
	
	@Value("${spring.mail.username}")
	private String fromMail;
	
	@Override
	public void sendMail(MyMail mail) {

		SimpleMailMessage message=new SimpleMailMessage();
		message.setFrom(fromMail);
		message.setTo(mail.getToMail());
		message.setSubject(mail.getSubject());
		message.setText(mail.getText());
		javaMailSender.send(message);
		
		mr.save(mail);
	}

	@Override
	public void sendMailWithAttachment(String mailInfo, MultipartFile file) {
		ObjectMapper mapper=new ObjectMapper();
		MyMail mail=new MyMail();
		try {
			mail=mapper.readValue(mailInfo, MyMail.class);
		} 
		
		catch (JsonMappingException mpe) {
			mpe.printStackTrace();
		}
		
		catch (JsonProcessingException jpe) {
			jpe.printStackTrace();
		}
		
		MimeMessage mime= javaMailSender.createMimeMessage();
		
		try {
			MimeMessageHelper helper=new MimeMessageHelper(mime,true);
			helper.setFrom(fromMail);
			helper.setTo(mail.getToMail());
			helper.setSubject(mail.getSubject());
			helper.setText(mail.getText());
		helper.addAttachment(file.getOriginalFilename(), file);
		javaMailSender.send(mime);
		}
	
		catch(MessagingException e){
			e.printStackTrace();
		}
	}

}
