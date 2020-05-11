package com.java5.slide5;

import javax.mail.internet.MimeMessage;
import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service("mail2")
public class Xmail {
	@Autowired
	JavaMailSender mail2;

	public void send(String from, String to, String subject, String body,String path, String filename) {
		try {
			// Tạo Mail
			MimeMessage mail = mail2.createMimeMessage();
			// Dùng lớp hỗ trợ
			MimeMessageHelper helper = new MimeMessageHelper(mail, true, "utf-8");
			helper.setFrom(from, from);
			helper.setTo(to);
			helper.setReplyTo(from, from);
			helper.setSubject(subject);
			
			helper.setText(body, true);

			mail2.send(mail);
		} catch (Exception e) {
			throw new RuntimeException(e);

		}
	}

	
}
