<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL</title>
</head>
<body>
	<%
		pageContext.setAttribute("name", "page hongdae");
		request.setAttribute("name", "request hongdae");
		session.setAttribute("name", "session hongdae");
		application.setAttribute("name", "application hongdae");
		
	%>
	<%=pageContext.getAttribute("name") %>
	${pageScope.name} <br>
	${requestScope.name} <br>
	${sessionScope.name} <br>
	${applicationScope.name} <br>
	${cookie.JESSIONID.value} <br>
	
	<h3>나는 누구일까?</h3>
	${name}
	
</body>
</html>