<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import = "com.ssafy.dto.Person" %>
<%
	Person p =new Person();
	p.setName("홍대");
	p.setAge(26);
	p.setHobbies(new String[]{"공부","밥"});
	out.print(p);
	pageContext.setAttribute("p",p);
	
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JavaBean</title>
</head>
<body>
	<h1>JavaBeans</h1>
	<div>전체 정보 : ${p}</div>
	<div>이름 : ${p.name}</div>
	<div>나이 : ${p["age"]}</div>
	<div>취미 : ${p["hobbies"][0]}</div>
</body>
</html>
