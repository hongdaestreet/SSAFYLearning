<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<title>과일 목록</title>
</head>
<body>
	<h2>과일 목록</h2>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>맛</th>
			<th>가격</th>
			<th>수량</th>
			<th>상세보기</th>
		</tr>
		<c:forEach var="fruit" items="${fruitList}">
			<tr>
				<td>${fruit.fruitId}</td>
				<td>${fruit.fruitName}</td>
				<td>${fruit.taste}</td>
				<td>${fruit.price}</td>
				<td>${fruit.quantity}</td>
				<td><a
					href="${pageContext.request.contextPath}/fruit/detail?fruitId=${fruit.fruitId}">
						상세 </a></td>
			</tr>
		</c:forEach>
	</table>

	<!-- 등록 페이지로 이동하는 링크 -->
	<p>
		<a href="${pageContext.request.contextPath}/fruit/registform">과일 등록</a>
	</p>
</body>
</html>
