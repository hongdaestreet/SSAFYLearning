<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>과일 정보 수정</title>
</head>
<body>
	<h2>과일 정보 수정</h2>
	<!-- <input> -->
	<form action="${pageContext.request.contextPath}/fruit/update?fruitId=${fruit.fruitId}"
		method="post">
		이름: <input type="text" name="fruitName" value = "${fruit.fruitName}"><br>
		맛: <input type="text" name="taste"><br>
		가격: <input type="number" name="price"><br>
		수량: <input type="number" name="quantity"><br>
		<input type="submit" value="수정 완료">
	</form>
</body>
</html>
