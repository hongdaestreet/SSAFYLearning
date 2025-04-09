<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL</title>
</head>
<body>
	<!-- request 영역에서 id 꺼내기 -->
	<%= request.getParameter("id") == "ssafy" %> <br/>
	<%= request.getParameter("id").equals("ssafy")%> <br/> 
	
	== (EL) : ${param.id == "ssafy"}
	
	eq (EL) : ${param.id eq "ssafy"}
	
	
</body>
</html>