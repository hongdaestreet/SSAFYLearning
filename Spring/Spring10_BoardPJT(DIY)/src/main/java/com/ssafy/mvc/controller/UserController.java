package com.ssafy.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.mvc.model.dto.User;
import com.ssafy.mvc.model.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	// 서비스 객체
	@Autowired
	private UserService userService;
	
	// 회원가입 페이지로 이동
	@GetMapping("/signup")
	public String signupForm() {
		return "user/signupform";
	}
	
	// 회원가입 시켜주기
	@PostMapping("/signup")
	public String signup(@ModelAttribute User user) {
		userService.signup(user);  // 사용자 등록하기 (이 signup은 UserService의 signup임)
//		return "/user/login";  // 현재는 포워딩 - 즉, user같은 파라미터들이 그대로 실려갈 수도 있다는 거임 -> redirect ㄱㄱ
		return "redirect:login";  // 로그인 페이지로 이동 (자동으로 로그인해주는 기능도 있음)
	}
	
	// 로그인 페이지로 이동
	@GetMapping("/login")
	public String loginForm() {
		return "/user/loginform";
	}
	
	// 로그인 시켜주기
	@PostMapping("/login")
	public String login(@ModelAttribute User user, HttpSession session) {
		User tmp = userService.login(user.getId(), user.getPassword());  // user의 id,pw들고와서 로그인 시도
		if(tmp == null) {  // 로그인 실패 -> 로그인 페이지로 그대로 있음
			return "redirect:login";  // /user/loginForm 아님?
		}  // 로그인 성공 -> 세션에 저장 + list 화면으로 넘어감
		session.setAttribute("loginUser",tmp.getName());
		return "redirect:list";  //
	}
	
	// 로그아웃하기
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:list";  // 목록 페이지로 이동
	}
	
	// 유저 목록
	@GetMapping("/users")
	public String userList(Model model) {
		model.addAttribute("userList", userService.getUserList());
		return "/user/adminPage";
	}
	
	
}
