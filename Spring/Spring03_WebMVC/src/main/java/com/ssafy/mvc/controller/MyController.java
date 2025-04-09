package com.ssafy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	
	// 작성한 해당 경로로 메서드 관계없이 들어옴
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="/home", method = RequestMethod.GET)
	public ModelAndView homeHandle1() {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("msg","Welcome to Spring MVC (GET)");  // 데어터 담기
		
		mav.setViewName("home");  
		
		return mav;
	}
	
	@RequestMapping(value="/home", method = RequestMethod.POST)
	public ModelAndView homeHandle2() {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("msg","Welcome to Spring MVC (POST)");  // 데어터 담기
		
		mav.setViewName("home");  
		
		return mav;
	}
	
	
}
