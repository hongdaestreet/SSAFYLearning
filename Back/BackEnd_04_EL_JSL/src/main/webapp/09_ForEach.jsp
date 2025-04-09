<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>드라마 반복</title>
</head>
<body>
	<%
		String[] dramaList = {"치인트","별그대","라이브"};
		pageContext.setAttribute("dramaList",dramaList);
	%>
	
	<c:forEach var = "drama" items="${dramaList}"  > <!-- 반복할 애-->
		${drama } <br>
		
	</c:forEach>
	
	<hr>
	<!-- begin/end : 시작/종료index번호 지정 -->
	<c:forEach var = "drama" items="${dramaList}" varStatus = "status" begin="1" end="4" step="2">
		${status.index} : ${drama}
		${status.count} : ${drama}
		
		${drama } <br>
		
	</c:forEach>
	
</body>
</html>