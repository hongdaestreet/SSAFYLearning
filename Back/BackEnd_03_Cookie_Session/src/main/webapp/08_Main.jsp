<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인화면</title>

</head>
<body>
<h1>메인화면</h1>
	<%
		if (session.getAttribute("loginUser") == null){
			response.sendRedirect("07_LoginForm.jsp");
		}else{
			%>
			<%=session.getAttribute("loginUser")%>님 ㅎ2ㅎ2
			<%
		}
	%>
	<!-- 로그아웃 (POST 요청) -->
	<form action = "07_Logout.jsp" method = "POST">
		<button>로그아웃</button>
	</form>
	<a href="07_Logout.jsp">로그아웃 링크</a>

</body>
</html>