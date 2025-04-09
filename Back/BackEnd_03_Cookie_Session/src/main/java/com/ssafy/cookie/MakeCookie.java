package com.ssafy.cookie;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/make")
public class MakeCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String key =request.getParameter("key");
		String value =request.getParameter("value");
		
		// 쿠키 생성
		Cookie cookie = new Cookie(key,value);
		
		// 쿠키의 만료기간 (초단위)
		cookie.setMaxAge(60);  // 1분
		
//		// 쿠키를 뒤져보니 삭제가 보이지 않음
//		cookie.setMaxAge(0); // 0으로 재설정
		
		response.addCookie(cookie);
		
		response.sendRedirect("02_CookieResult.jsp");
		
		
	}

}
