<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>과일 등록</title>
</head>
<body>
    <h2>과일 등록</h2>
    <form action="${pageContext.request.contextPath}/fruit/regist" method="POST">
        과일 이름: <input type="text" name="fruitName"><br>
        맛: <input type="text" name="taste"><br>
        가격: <input type="number" name="price"><br>
        수량: <input type="number" name="quantity"><br>
        <input type="submit" value="등록">
    </form>
    <form action="${pageContext.request.contextPath }/fruit/list">
    <input type="submit" value="취소">
    </form>
    
</body>
</html>
