package com.ssafy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller  // component-scan해야 될텐데?

public class HelloController {
	
//	// (정석코딩) 의존성 주입 -> 필드/설정자/생성자 주입
//	@Autowired
//	private UserService userService;
	
	@GetMapping("/hello")
	public String getMethodName(Model model) {
		// 반환타입 String -> View 이름
		model.addAttribute("msg","Hello Boot");
		return "hello";  // prefix,suffix 설정 안해도 됨???
	}
	
}
