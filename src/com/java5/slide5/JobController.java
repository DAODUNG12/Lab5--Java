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
@RequestMapping("/job")
public class JobController {
	@RequestMapping("form")
	public String showForm() {
		return "home/form";
	}

	@Autowired
	ServletContext context;

	@RequestMapping("load")
	public String load(ModelMap modelMap, @RequestParam("fullname") String fullname,
			@RequestParam("cv") MultipartFile cv, @RequestParam("photo") MultipartFile photo) {
		if (photo.isEmpty() || cv.isEmpty()) {
			modelMap.addAttribute("message", "Bạn Vui Lòng Chọn File!!!");

		} else {

			try {
				String photoPath = context.getRealPath("/files/" + photo.getOriginalFilename());
				photo.transferTo(new File(photoPath));
				String cvPath = context.getRealPath("/files/" + cv.getOriginalFilename());
				cv.transferTo(new File(cvPath));
				modelMap.addAttribute("photo_name", photo.getOriginalFilename());
				modelMap.addAttribute("cv_name", cv.getOriginalFilename());
				modelMap.addAttribute("cv_type", cv.getContentType());
				modelMap.addAttribute("cv_size", cv.getSize());

				return "home/ok";
			} catch (Exception e) {
				modelMap.addAttribute("message", "Bạn Lỗi Lưu File!!!");
			}
		}

		return "home/form";
	}

}
