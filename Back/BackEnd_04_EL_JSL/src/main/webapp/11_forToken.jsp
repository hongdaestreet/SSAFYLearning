<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>캠퍼스</title>
</head>
<body>
	<h2>캠퍼스</h2>
	<c:forTokens var="place" items="남산,성수,한남.연남" delims=",">
		${place} <br>
	</c:forTokens>
	<hr>
	<c:forTokens var="place" items="남산,성수,한남.연남" delims=",.">
		${place} <br>
	</c:forTokens>
</body>
</html>