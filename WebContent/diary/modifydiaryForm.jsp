<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dirary Modify</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%@include file="/common/main_nav.jsp" %>
<div class="container mt-4">
    <h3>다이어리 수정</h3>
    <form action="<c:url value="/modify"/>" method="post">
        <c:forEach var="command" items="${modify}">
            <p>${command.name}</p>
            <div class="form-group d-none">
                <label>글 넘버:</label>
                <input type="text" class="form-control" name="diaryId" readonly value="${command.diary.diaryId}"/>
            </div>
            <div class="form-group">
                <label>작성날짜:</label>
                <input type="text" class="form-control" name="date" readonly value="${command.diary.date}"/>
            </div>
            <div class="form-group">
                <label>작성자 ID:</label>
                <input type="text" class="form-control" name="dirarymemberId" readonly value="${command.diary.dirarymemberId}"/>
            </div>
            <div class="form-group">
                <label>이름:</label>
                <input type="text" class="form-control" name="name" readonly value="${command.name}"/>
            </div>
            <div class="form-group">
                <label>제목:</label>
                <input type="text" class="form-control" name="title" value="${command.diary.title}"/>
            </div>
            <div class="form-group">
                <label>내용:</label>
                <textarea class="form-control" rows="10" cols="30" name="content">${command.diary.content}</textarea>
            </div>
            
            <button type="submit" class="btn btn-primary">수정</button>
            <button type="button" class="btn btn-primary" onclick="goBack()">취소</button>
        </c:forEach>
    </form>
</div>
<script>
    function goBack() {
        window.history.back();
    }
</script>
</body>
</html>
