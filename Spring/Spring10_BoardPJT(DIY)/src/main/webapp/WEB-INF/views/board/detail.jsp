<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세보기</title>
<%@ include file="../common/bootstrap.jsp"%>
</head>
<body>
	<div class="container">
		<h2>글 상세보기</h2>
		<hr>
		<%@ include file="../common/header.jsp"%>
		<!-- 회원가입,로그인,로그아웃 보이게 함 (공통영역) -->
		<div class="card">
			<div class="card-body">
				<h5 class="card-title">제목: ${board.title}</h5>

				<div class="d-flex justify-content-between align-items-center">
					<!-- 작성자는 왼쪽에 배치 -->
					<div class="card-subtitle text-muted" style="font-size: 14px;">작성자: ${board.writer}</div>
					<!-- 작성일자와 조회수는 오른쪽에 배치 -->
					<div class="d-flex">
						<div class="card-subtitle text-muted" style="font-size: 14px; margin-right: 15px;">${board.regDate}</div>
						<div class="card-subtitle text-muted" style="font-size: 14px;">조회수: ${board.viewCnt}</div>
					</div>
				</div>

				<hr>
				<%-- <pre class="card-text">${board.content}</pre> --%>
				<div class="card-text">
					<!-- 코드 하이라이팅 적용 위해 escapeXml="false" -->
					<c:out value="${parsedContent}" escapeXml="false" />
				</div>
				<div>
					<!-- GET 요청은 별로 좋지 않아... -->
					<a href="delete?id=${board.id}" class="btn btn-info">삭제</a>
					<!-- POST 요청의 삭제 -->
					<form action="/delete" method="POST">
						<input type="hidden" name="id" value="${board.id}">
						<button class="btn btn-info">삭제2</button>
					</form>

					<a href="updateform?id=${board.id}" class="btn btn-success">수정</a>
					<a href="list" class="btn btn-warning">목록</a>
				</div>
			</div>

		</div>
	</div>
</body>
</html>