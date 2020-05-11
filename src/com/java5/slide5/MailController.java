package com.java5.slide5;

import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/mail/")
public class MailController {
	@RequestMapping("form")
	public String showForm() {
		return "mail/form";
	}

	@Autowired
	JavaMailSender mail;

	@RequestMapping("send")
	public String send(ModelMap modelMap, @RequestParam("form") String form, @RequestParam("to") String to,
			@RequestParam("subject") String subject, @RequestParam("body") String body) {

		try {
			// Tạo mail
			MimeMessage mails = mail.createMimeMessage();
			// Sử dụng lớp trợ giúp
			MimeMessageHelper helper = new MimeMessageHelper(mails);
			helper.setFrom(form, form);
			helper.setTo(to);
			helper.setReplyTo(form, form);
			helper.setSubject(subject);

			helper.setText(body, true);

			// Gửi mail
			mail.send(mails);
			modelMap.addAttribute("message", "Gửi mail thành công!!!");

		} catch (Exception e) {

			modelMap.addAttribute("message", "Lỗi Gửi Mail!!!");
		}
		return "mail/form";
	}
}
