<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃</title>
</head>
<body>
	<!-- 로그인 유저 삭제 -->
	<% session.removeAttribute("loginUser"); %>
	<!-- 세션 자체 삭제 -->
	<% session.invalidate();  // 현재 세션을 없애고 속성도 삭제함
		response.sendRedirect("index.html"); // 초기화면으로 돌아감
	
	%>
</body>
</html>