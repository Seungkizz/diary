<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dirary View</title>
<!-- 부트스트랩 CSS -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<style>
body {
	padding: 100px;
}

h2 {
	margin-top: 20px;
	margin-bottom: 20px;
}

table {
	margin-top: 20px;
}

table th, table td {
	vertical-align: middle !important;
	padding: 40px important;
	 width: 100px; 
}
  table td:nth-child(4) {
    width: 300px; 
  }

.btn-primary {
	background-color: #007bff;
	border-color: #007bff;
}

.btn-primary:hover {
	background-color: #0069d9;
	border-color: #0062cc;
}

.btn-light {
	background-color: #f8f9fa;
	border-color: #f8f9fa;
}

.btn-light:hover {
	background-color: #e2e6ea;
	border-color: #dae0e5;
}

.btn-primary.active, .btn-primary:active {
	background-color: #0062cc;
	border-color: #005cbf;
}
</style>
</head>
<body>
	<%@ include file="/common/main_nav.jsp"%>
	<hr />
	<div class="container">
		<h2>${auth.name}님의하루 일기장</h2>
		<c:choose>
			<c:when test="${empty list}">
				<p>등록된 글이 없습니다.</p>
			</c:when>
			<c:otherwise>
				<div class="table-responsive">
					<table class="table table-bordered">
						<tr>
							<th>글쓴이</th>
							<th>이름</th>
							<th>제목</th>
							<th>내용</th>
							<th>작성날짜</th>
							<th>수정날짜</th>
							<th>수정</th>
							<th>삭제</th>
						</tr>
						<c:forEach var="command" items="${list}">
							<tr>
								<td>${command.diary.dirarymemberId}</td>
								<td>${command.name}</td>
								<td>${command.diary.title}</td>
								<td>${command.diary.content}</td>
								<td>${command.diary.date}</td>
								<td>${command.diary.moddate}</td>
								<td><a class="btn btn-primary"
									href="<c:url value='/selectmodify?diaryId=${command.diary.diaryId}'/>"
									onclick="return confirmModfiy();">수정</a></td>
								<td><a class="btn btn-danger"
									href="<c:url value='/delete?diaryId=${command.diary.diaryId}'/>"
									onclick="return confirmDelete();">삭제</a></td>
							</tr>
						</c:forEach>
					</table>
				</div>

				<!-- 페이징 -->
				<div class="text-center">
					<c:choose>
						<c:when test="${currentPage > 1}">
							<a class="btn btn-primary"
								href="<c:url value='/view?page=${currentPage - 1}'/>">이전</a>
						</c:when>
						<c:otherwise>
							<button class="btn btn-primary" disabled>이전</button>
						</c:otherwise>
					</c:choose>

					<c:choose>
						<c:when test="${totalPages <= 10}">
							<c:forEach begin="1" end="${totalPages}" var="pageNumber">
								<c:choose>
									<c:when test="${pageNumber eq currentPage}">
										<a class="btn btn-primary active"
											href="<c:url value='/view?page=${pageNumber}'/>">${pageNumber}</a>
									</c:when>
									<c:otherwise>
										<a class="btn btn-light"
											href="<c:url value='/view?page=${pageNumber}'/>">${pageNumber}</a>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<c:choose>
								<c:when test="${currentPage <= 5}">
									<c:forEach begin="1" end="10" var="pageNumber">
										<c:choose>
											<c:when test="${pageNumber eq currentPage}">
												<a class="btn btn-primary active"
													href="<c:url value='/view?page=${pageNumber}'/>">${pageNumber}</a>
											</c:when>
											<c:otherwise>
												<a class="btn btn-light"
													href="<c:url value='/view?page=${pageNumber}'/>">${pageNumber}</a>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</c:when>
								<c:when test="${currentPage > 5}">
									<c:forEach begin="${currentPage - 4}" end="${currentPage + 5}"
										var="pageNumber">
										<c:choose>
											<c:when test="${pageNumber eq currentPage}">
												<a class="btn btn-primary active"
													href="<c:url value='/view?page=${pageNumber}'/>">${pageNumber}</a>
											</c:when>
											<c:otherwise>
												<a class="btn btn-light"
													href="<c:url value='/view?page=${pageNumber}'/>">${pageNumber}</a>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</c:when>
							</c:choose>
						</c:otherwise>
					</c:choose>

					<c:choose>
						<c:when test="${currentPage < totalPages}">
							<a class="btn btn-primary"
								href="<c:url value='/view?page=${currentPage + 1}'/>">다음</a>
						</c:when>
						<c:otherwise>
						</c:otherwise>
					</c:choose>
				</div>
			</c:otherwise>
		</c:choose>

	</div>


	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script
src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script>
    function confirmDelete() {
        return confirm("정말로 삭제하시겠습니까?");
    }
    
    function confirmModfiy() {
        return confirm("수정하시겠습니까?");
    }
</script>
</body>
</html>
