package com.ssafy.mvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.mvc.interceptor.AdminInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	@Autowired
	AdminInterceptor adminInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {  
		// registry에 AdminInterceptor를 동록함 -> 요청이 컨트롤러에 도달하기 전에 인터셉터가 먼저 실행함
		
		registry.addInterceptor(adminInterceptor).addPathPatterns("/users");  // "/users" 경로에 대한 요창에만 인터셉터가 작동하게 함
	}
	
}
