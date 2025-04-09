<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예외처리</title>
</head>
<body>
	<c:catch var ="errmsg">
		<div>예외 발생 전</div>
		<div><%=2 / 0 %></div>
		<div>예외 발생 후</div>
	</c:catch>
	${errmsg }
</body>
</html>