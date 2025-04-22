package com.ssafy.mvc.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component // Bean으로 등록
public class AdminInterceptor implements HandlerInterceptor {
	
	@Override  // 클라이언트가 컨트롤러에 접근하기 직전에 실행됨
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 로그인한 유저가 관리자인지 확인해야 함
		HttpSession session = request.getSession();  // UserController의 login에서 getName으로 이름 가져옴
		if (!"admin".equals(session.getAttribute("loginUser"))) {  // 관리자가 아니면  // ** session.getAttribute("loginUser").equals("admin")하면 NullException 생길 수 있음
			response.sendRedirect("list");  // 일반 목록 페이지로 향하게 함
			return false;
		}
		return true;
	}
}
