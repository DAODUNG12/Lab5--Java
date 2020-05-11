package com.java5.slide5;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/ok")
public class Mail2Controller {
	@RequestMapping("form")
	public String showForm2() {
		return "mail/showform2";
	}

	@Autowired
	Xmail mail2;
	@Autowired
	ServletContext context;

	@RequestMapping("send")
	public String send(ModelMap modelMap, @RequestParam("form") String form, @RequestParam("to") String to,
			@RequestParam("subject") String subject, @RequestParam("body") String body,
			@RequestParam("attach") MultipartFile attach) {

		try {
			// Gửi mail
			String fileName = attach.getOriginalFilename();
			String path = context.getRealPath("/images/" + fileName);
			attach.transferTo(new File(path));
			mail2.send(form, to, subject, body, path, fileName);
			modelMap.addAttribute("message", "Bạn Đã gửi mail thành công!!!");

		} catch (Exception e) {
			modelMap.addAttribute("message", "Gửi mail thất bại!!!");
		}
		return "mail/showform2";
	}

}
