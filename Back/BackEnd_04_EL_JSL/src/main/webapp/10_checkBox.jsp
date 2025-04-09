<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>반찬고르기</title>
</head>
<body>
	<h2>반찬을 골라보자</h2>
	<form action="10_checkBoxResult.jsp">
		<input type ="checkbox" name="dish" value ="계란말이">계란말이
		<input type ="checkbox" name="dish" value ="김치">김치 <br>
		<input type ="checkbox" name="dish" value ="양꼬치">양꼬치
		<input type ="checkbox" name="dish" value ="상추무침">상추무침
		<button>구매</button>
	</form>
</body>
</html>