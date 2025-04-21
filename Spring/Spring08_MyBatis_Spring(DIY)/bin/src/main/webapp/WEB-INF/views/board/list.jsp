<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 목록</title>
<%@ include file="../common/bootstrap.jsp" %>
</head>
<body>
	<div class="container">
		<h2>게시물 목록</h2>
		<hr>
		<table class="table">
			<tr>
			<th>글순서</th>
			<th>글번호</th>
			<th>글제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>작성일</th>
			</tr>
			
			<c:forEach items="${boardList}" var="board" varStatus="vs">
			<tr>
			<td>${vs.count}</td> 
			<td>${board.id }</td>
			<td><a href="/detail?id=${board.id }">${board.title }</a></td>
			<td>${board.writer }</td>
			<td>${board.viewCnt }</td>
			<td>${board.regDate }</td>
			</tr>
			</c:forEach>
		</table>
		<a href="/writeform">글등록</a>
	</div>
	
</body>
</html>