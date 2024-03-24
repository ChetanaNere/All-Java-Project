package com.cjc.main.service;

import org.springframework.web.multipart.MultipartFile;

import com.cjc.main.model.MyMail;

public interface MailService {

	public void sendMail(MyMail mail);

	public void sendMailWithAttachment(String mailInfo, MultipartFile file);

}
