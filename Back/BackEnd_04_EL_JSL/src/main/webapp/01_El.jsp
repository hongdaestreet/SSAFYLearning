<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL</title>
</head>
<body>
	<!-- 스크립트릿 -->
	<% out.print("Hello"); %>
	<!-- 표현식 -->
	<%= "Hello" %>
	<!-- EL ${변수/함수호출/계산식} -->
	${"Hello" }
</body>
</html>