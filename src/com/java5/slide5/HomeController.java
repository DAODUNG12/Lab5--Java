package com.java5.slide5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {
	@Autowired
	User user;

	@RequestMapping("index")
	public String index(ModelMap modelMap) {
		return "home/index";
	}

	@ModelAttribute("user")
	public User getUser() {
		return user;
	}
	
}
