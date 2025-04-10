package com.ssafy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.mvc.model.dto.User;

import jakarta.servlet.http.HttpSession;

@Controller  // 이거없으면 말짱도루묵
public class UserController {
	
	@GetMapping("/login")
	public String loginForm() {
		return "user/loginForm";
	}
	
//	@PostMapping("/login")
//	public String login(@RequestParam("id") String id,@RequestParam("pw") String pw) {
//		
//	}
	
	
	// 로그인 정보는 세션에 저장하자
	@PostMapping("/login")
	public String login(@ModelAttribute User user,HttpSession session) {
		System.out.println(user);
//		session.setAttribute("loginUser",user);  // 이건 내용너무많음(개인정보,나이 등등)
		session.setAttribute("loginUser",user.getId());  // id만 받기
		return "redirect:hello";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		// 로그아웃 방법
		// 1. 세션에서 해당 로그인 정보만 삭제
		session.removeAttribute("loginUser");
		// 2. 세션 자체를 초기화
		session.invalidate();
		return "redirect:/";  // 메인화면으로 보내기
		
	}
	
}
