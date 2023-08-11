<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>다이어리 작성</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            padding: 100px;
        }
    </style>
</head>
<body>
<%@include file="/common/main_nav.jsp" %>
<c:choose>
<c:when test="${auth == null }">
<div class="container">
    <p>로그인 후 이용해주세요.</p>
    <a class="btn btn-primary" href="${pageContext.request.contextPath }/diaryMember/loginForm.jsp">로그인하러 가기</a>
</div>
</c:when>
<c:otherwise>
<div class="container"> 
    <h3>다이어리 작성</h3>
    <form action="<c:url value="/write"/>" method="post">
        <div class="form-group">
            <label for="dirarymemberId">작성자 ID:</label>
            <input type="text" id="dirarymemberId" name="dirarymemberId" class="form-control" readonly value="${auth.diraryMemberId }"/>
        </div>
        <div class="form-group">
            <label for="title">제목:</label>
            <input type="text" id="title" name="title" class="form-control" required/>
        </div>
        <div class="form-group">
            <label for="content">내용:</label>
            <textarea id="content" name="content" rows="10" class="form-control" required></textarea>
        </div>
        <button type="submit" class="btn btn-primary">올리기</button>
        <button type="button" class="btn btn-primary" onclick="goBack()">취소</button>
    </form>
</div>
</c:otherwise>
</c:choose>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script>
    function goBack() {
        window.history.back();
    }
</script>
</body>
</html>