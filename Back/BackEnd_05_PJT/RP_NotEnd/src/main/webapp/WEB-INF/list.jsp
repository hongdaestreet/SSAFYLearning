<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>RoutePick</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" />
    <!-- Bootstrap Icons -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.0/font/bootstrap-icons.css">
    <!-- 커스텀 CSS (내부 스타일시트로 통합) -->
    <style>
      /* 전체 배경색 및 기본 폰트 설정 */
      body {
        background-color: #f8f9fa;
        font-family: Pretendard, "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
      }
      /* Header 스타일 */
      .custom-header {
        background-color: #27ae60; /* 예쁜 초록색 배경 */
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
      }
      .custom-header span {
        align-items: center;
        margin-left: auto;
        display: flex;
      }
      .custom-header span a {
        align-items: center;
        text-decoration: none;
        color: white;
        font-size: large;
      }
      /* Header 텍스트 스타일 */
      .custom-header h1 {
        margin: 0;
        font-size: 2rem;
      }
      /* Footer 스타일 */
      .custom-footer {
        background-color: #27ae60; /* 조금 더 진한 초록색 */
        bottom: 0;
        width: 100%;
      }
      /* Footer 텍스트 스타일 */
      .custom-footer p {
        margin: 0;
        font-size: 0.9rem;
      }
      /* 카드 이미지 고정 높이 및 오브젝트 피팅 */
      .card-img-top {
        height: 200px;
        object-fit: cover;
      }
      /* 카드 호버 효과 */
      .card {
        transition: transform 0.2s ease;
      }
      .card:hover {
        transform: translateY(-5px);
      }
      /* 카드 제목 스타일 */
      .card-title {
        font-size: 1.25rem;
        font-weight: bold;
      }
      /* 카드 텍스트 간격 조정 */
      .card-text {
        margin-bottom: 0.5rem;
      }
      /* 카드 하단 버튼 간격 및 스타일 개선 */
      .card-footer a {
        font-weight: 500;
        text-decoration: none;
      }
      .card-footer a:hover {
        opacity: 0.8;
      }
      /* 로그인 모달 스타일 */
      .login-form {
        max-width: 400px;
        margin: 0 auto;
      }
      .login-buttons {
        display: flex;
        align-items: center;
        gap: 10px;
      }
      .login-error {
        color: #dc3545;
        font-size: 0.85rem;
        margin-top: 5px;
      }
      .login-success {
        color: #198754;
        font-size: 0.85rem;
        margin-top: 5px;
      }
      /* 계정 버튼 스타일 */
      .account-buttons {
        display: flex;
        gap: 8px;
      }
      /* 좋아요 버튼 스타일 */
      .like-btn {
        position: absolute;
        top: 10px;
        right: 10px;
        background-color: rgba(255, 255, 255, 0.8);
        border-radius: 50%;
        width: 40px;
        height: 40px;
        display: flex;
        align-items: center;
        justify-content: center;
        cursor: pointer;
        border: none;
        transition: all 0.2s;
      }
      .like-btn:hover {
        background-color: rgba(255, 255, 255, 1);
      }
      .like-btn i {
        font-size: 1.25rem;
      }
      .liked {
        color: #e74c3c;
      }
      /* 좋아요 목록 버튼 */
      .liked-list-btn {
        background-color: #f8f9fa;
        border: 1px solid #dee2e6;
        border-radius: 4px;
        transition: all 0.2s;
      }
      .liked-list-btn:hover {
        background-color: #e9ecef;
      }
      /* 타이틀 섹션 스타일 */
      .title-section {
        display: flex;
        justify-content: space-between;
        align-items: center;
        margin-bottom: 1rem;
      }
    </style>
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard/dist/web/static/pretendard.css" />
  </head>
  <body>
    <!-- Header -->
    <header class="custom-header">
      <div class="container d-flex">
        <h1 class="text-white py-3">RoutePick</h1>
        <div class="ms-auto d-flex align-items-center">
          <span class="me-3"><a href="https://weather.naver.com/">오늘의 날씨</a></span>
          <c:choose>
            <c:when test="${not empty sessionScope.username}">
              <div class="d-flex align-items-center">
                <span class="text-white me-3">반갑습니다, ${sessionScope.username} 님!</span>
                <a href="${pageContext.request.contextPath}/board/logout" class="btn btn-outline-light btn-sm">로그아웃</a>
              </div>
            </c:when>
            <c:otherwise>
              <div class="account-buttons">
                <button class="btn btn-outline-light btn-sm" data-bs-toggle="modal" data-bs-target="#loginModal">로그인</button>
                <button class="btn btn-light btn-sm" data-bs-toggle="modal" data-bs-target="#registerModal">회원가입</button>
              </div>
            </c:otherwise>
          </c:choose>
        </div>
      </div>
    </header>

    <!-- 로그인 모달 -->
    <div class="modal fade" id="loginModal" tabindex="-1" aria-labelledby="loginModalLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="loginModalLabel">로그인</h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            <form method="post" action="${pageContext.request.contextPath}/board/login" class="login-form">
              <div class="mb-3">
                <label for="username" class="form-label">아이디</label>
                <input type="text" class="form-control" id="username" name="username" required>
              </div>
              <div class="mb-3">
                <label for="password" class="form-label">비밀번호</label>
                <input type="password" class="form-control" id="password" name="password" required>
              </div>
              <c:if test="${not empty loginErrorMessage}">
                <div class="login-error">${loginErrorMessage}</div>
              </c:if>
              <div class="mb-3 form-check">
                <input type="checkbox" class="form-check-input" id="rememberMe" name="rememberMe">
                <label class="form-check-label" for="rememberMe">로그인 상태 유지</label>
              </div>
              <div class="d-grid">
                <button type="submit" class="btn btn-primary">로그인</button>
              </div>
              <div class="mt-3 text-center">
                <p class="mb-0">계정이 없으신가요? <a href="#" data-bs-toggle="modal" data-bs-target="#registerModal" data-bs-dismiss="modal">회원가입</a></p>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>

    <!-- 회원가입 모달 -->
    <div class="modal fade" id="registerModal" tabindex="-1" aria-labelledby="registerModalLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="registerModalLabel">회원가입</h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            <form method="post" action="${pageContext.request.contextPath}/board/register" class="login-form">
              <div class="mb-3">
                <label for="newUsername" class="form-label">아이디</label>
                <input type="text" class="form-control" id="newUsername" name="newUsername" required>
              </div>
              <div class="mb-3">
                <label for="newPassword" class="form-label">비밀번호</label>
                <input type="password" class="form-control" id="newPassword" name="newPassword" required>
              </div>
              <div class="mb-3">
                <label for="confirmPassword" class="form-label">비밀번호 확인</label>
                <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" required>
              </div>
              <c:if test="${not empty registerErrorMessage}">
                <div class="login-error">${registerErrorMessage}</div>
              </c:if>
              <c:if test="${not empty registerSuccessMessage}">
                <div class="login-success">${registerSuccessMessage}</div>
              </c:if>
              <div class="d-grid">
                <button type="submit" class="btn btn-success">회원가입</button>
              </div>
              <div class="mt-3 text-center">
                <p class="mb-0">이미 계정이 있으신가요? <a href="#" data-bs-toggle="modal" data-bs-target="#loginModal" data-bs-dismiss="modal">로그인</a></p>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>

    <!-- Main Content -->
    <div class="container my-5">
      <div class="title-section">
        <h2 class="text-black"><strong>서울 산책 명소</strong></h2>
        <a href="${pageContext.request.contextPath}/board/likedList" class="btn liked-list-btn">
          <i class="bi bi-heart-fill text-danger"></i> 찜한 목록 보기
        </a>
      </div>
      
      <div class="row g-4">
        <c:forEach var="place" items="${places}">
          <div class="col-lg-4 col-md-6 col-sm-12">
            <div class="card h-100 shadow-sm">
              <img src="${place.image}" class="card-img-top" alt="${place.name} 이미지" />
              <c:if test="${not empty sessionScope.username}">
                <a href="${pageContext.request.contextPath}/board/like?placeId=${place.id}" class="like-btn">
                  <i class="bi ${userLikes.contains(place.id) ? 'bi-heart-fill liked' : 'bi-heart'}"></i>
                </a>
              </c:if>
              <div class="card-body">
                <h5 class="card-title">${place.name}</h5>
                <p class="card-text">
                  <strong>주소:</strong>
                  ${place.address}
                </p>
                <p class="card-text">
                  <strong>코스:</strong>
                  ${place.course}
                </p>
                <p class="card-text">
                  <strong>길이:</strong>
                  ${place.length}
                </p>
                <p class="card-text">
                  <strong>소요시간:</strong>
                  ${place.duration}
                </p>
              </div>
              <div class="card-footer bg-transparent border-top-0 d-flex justify-content-around">
                <a href="${place.mapLink}" class="btn btn-outline-primary btn-sm" target="_blank">길찾기</a>
                <a href="#" class="btn btn-outline-success btn-sm">근처 카페</a>
                <a href="#" class="btn btn-outline-warning btn-sm">근처 맛집</a>
              </div>
            </div>
          </div>
        </c:forEach>
      </div>
    </div>

    <!-- Footer -->
    <footer class="custom-footer text-center py-3">
      <div class="container">
        <p class="mb-0 text-white">© <%=java.time.Year.now().getValue()%> 산책/러닝 장소 추천. All rights reserved.</p>
      </div>
    </footer>

    <!-- Bootstrap JS Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    
    <c:if test="${not empty loginErrorMessage}">
      <script>
        // 로그인 오류 시 모달 표시
        document.addEventListener('DOMContentLoaded', function() {
          var loginModal = new bootstrap.Modal(document.getElementById('loginModal'));
          loginModal.show();
        });
      </script>
    </c:if>
    
    <c:if test="${not empty registerErrorMessage || not empty registerSuccessMessage}">
      <script>
        // 회원가입 관련 메시지가 있을 때 모달 표시
        document.addEventListener('DOMContentLoaded', function() {
          var registerModal = new bootstrap.Modal(document.getElementById('registerModal'));
          registerModal.show();
        });
      </script>
    </c:if>
  </body>
</html>