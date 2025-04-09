<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>내가 찜한 장소 - RoutePick</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" />
    <!-- Bootstrap Icons -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.0/font/bootstrap-icons.css">
    <!-- 커스텀 CSS -->
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
      /* 카드 스타일 */
      .card {
        transition: transform 0.2s ease;
      }
      .card:hover {
        transform: translateY(-5px);
      }
      /* 타이틀 섹션 스타일 */
      .title-section {
        display: flex;
        justify-content: space-between;
        align-items: center;
        margin-bottom: 1rem;
      }
      /* 뒤로가기 버튼 */
      .back-btn {
        color: #27ae60;
        text-decoration: none;
        font-weight: 500;
      }
      .back-btn:hover {
        text-decoration: underline;
      }
      /* 카드 이미지 고정 높이 및 오브젝트 피팅 */
      .card-img-top {
        height: 200px;
        object-fit: cover;
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
                <a href="${pageContext.request.contextPath}/board/list" class="btn btn-outline-light btn-sm">로그인</a>
              </div>
            </c:otherwise>
          </c:choose>
        </div>
      </div>
    </header>

    <!-- Main Content -->
    <div class="container my-5">
      <div class="title-section">
        <h2 class="text-black"><strong>내가 찜한 장소</strong></h2>
        <a href="${pageContext.request.contextPath}/board/list" class="back-btn">
          <i class="bi bi-arrow-left"></i> 메인으로 돌아가기
        </a>
      </div>
      
      <c:choose>
        <c:when test="${empty sessionScope.username}">
          <div class="alert alert-warning" role="alert">
            <h4 class="alert-heading">로그인이 필요합니다!</h4>
            <p>찜한 장소를 보려면 로그인이 필요합니다.</p>
            <hr>
            <p class="mb-0">
              <a href="${pageContext.request.contextPath}/board/list" class="btn btn-primary">로그인 페이지로 이동</a>
            </p>
          </div>
        </c:when>
        <c:when test="${empty likedPlaces}">
          <div class="alert alert-info" role="alert">
            <h4 class="alert-heading">찜한 장소가 없습니다!</h4>
            <p>아직 찜한 장소가 없습니다. 메인 페이지에서 마음에 드는 장소를 찜해보세요!</p>
            <hr>
            <p class="mb-0">
              <a href="${pageContext.request.contextPath}/board/list" class="btn btn-success">산책 명소 둘러보기</a>
            </p>
          </div>
        </c:when>
        <c:otherwise>
          <div class="row g-4">
            <c:forEach var="place" items="${likedPlaces}">
              <div class="col-lg-4 col-md-6 col-sm-12">
                <div class="card h-100 shadow-sm">
                  <img src="${place.image}" class="card-img-top" alt="${place.name} 이미지" />
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
                    <a href="${pageContext.request.contextPath}/board/like?placeId=${place.id}" class="btn btn-outline-danger btn-sm">찜 해제</a>
                  </div>
                </div>
              </div>
            </c:forEach>
          </div>
        </c:otherwise>
      </c:choose>
    </div>

    <!-- Footer -->
    <footer class="custom-footer text-center py-3">
      <div class="container">
        <p class="mb-0 text-white">© <%=java.time.Year.now().getValue()%> 산책/러닝 장소 추천. All rights reserved.</p>
      </div>
    </footer>

    <!-- Bootstrap JS Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
  </body>
</html>