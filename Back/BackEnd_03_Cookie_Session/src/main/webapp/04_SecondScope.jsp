<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 기본객체</title>
</head>
<body>
	<p>페이지 속성 : <%= pageContext.getAttribute("name") %></p>
	<p>요청 속성 : <%= request.getAttribute("name") %></p>
	<p>세션 속성 : <%= session.getAttribute("name") %></p>
	<p>애플리케이션속성 속성 : <%= application.getAttribute("name") %></p>
	
	
	<a href="05_ThirdScope.jsp">세번째 페이지</a>
	<!-- 누르면 세션,어플리케이션만 살아남음 -->
</body>
</html>