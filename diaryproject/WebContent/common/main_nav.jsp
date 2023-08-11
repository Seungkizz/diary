<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<!-- Bootstrap CSS CDN link -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
body {
	padding-top: 60px;
}

.navbar {
	background-color: #f8f9fa;
}

.navbar-brand {
	font-weight: bold;
}

.navbar-nav .nav-link {
	color: #333;
}

.navbar-nav .nav-link:hover {
	color: #007bff;
}

.navbar-nav .active .nav-link {
	color: #007bff;
}
</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light fixed-top">
		<div class="container">
			<a class="navbar-brand" href="${contextPath }/index.jsp">
			<c:if test="${auth != null }">
				<span> ${auth.name } 님의</span>
			</c:if> 다이어리</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNav" aria-controls="navbarNav"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav ml-auto">
					<c:choose>
						<c:when test="${auth == null }">
							<li class="nav-item"><a class="nav-link"
								href="<c:url value="/diaryMember/registForm.jsp"/>">회원 가입</a></li>
							<li class="nav-item"><a class="nav-link"
								href="<c:url value="/diaryMember/loginForm.jsp"/>">로그인</a></li>
						</c:when>
						<c:otherwise>
							<li class="nav-item"><a class="nav-link"
								href="<c:url value="/logout"/>">로그아웃</a></li>
							<li class="nav-item"><a class="nav-link"
								href="<c:url value="/memberInfo"/>">내 정보</a></li>
						</c:otherwise>
					</c:choose>
					<li class="nav-item"><a class="nav-link"
						href="<c:url value="/diary/writediary.jsp"/>">일기 쓰기</a></li>
					<li class="nav-item"><a class="nav-link"
						href="<c:url value="/view"/>">일기장 보기</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<!-- Bootstrap JS and jQuery CDN links -->
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
