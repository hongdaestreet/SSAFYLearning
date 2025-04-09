<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String id = request.getParameter("id");
	String pw = request.getParameter("password");
	
	// ID,PW를 이용해 DB에서 해당 유저가 있는지 검사해야 함
	// 매니저로 관리하지도 않음
	if(id.equals("ssafy") && pw.equals("1234")){  // null 처리해줘야 함
		//로그인 성공
		out.print("로그인 성공");
	// request라는 객체를 통해 세션을 가져올 수 있음
		//HttpSession session1 = request.getSession();
		session.setAttribute("loginUser","홍대");  // ID or 닉네임
		// 페이지(Main.jsp) 이동
		// 1. 포워딩 (가능하나 적절하지 않음. 해당 계정 정보를 그대로 들고 감)
		request.getRequestDispatcher("08_Main.jsp").forward(request,response);
		// 2. 리다이렉트
		//response.sendRedirect("08_Main.jsp");
	}else{
		//로그인 실패
		out.print("로그인 실패");
		response.sendRedirect("07_LoginForm.jsp");
	}
%>