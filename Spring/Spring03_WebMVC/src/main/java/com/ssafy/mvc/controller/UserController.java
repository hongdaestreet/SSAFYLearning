package com.ssafy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.model.dto.User;

@Controller
public class UserController {
	@GetMapping("/regist")
	public String registForm() {
		return "regist";
	}
	
	@PostMapping("/regist")
	public String regist(@ModelAttribute User user) {
		System.out.println(user);
		
		return "result";  // result.jsp로 이동시켜줌
	}
	
}
