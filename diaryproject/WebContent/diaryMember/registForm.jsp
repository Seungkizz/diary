<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
 <style>
        body {
            padding: 100px;
        }
    </style>
<body>
<%@include file="/common/main_nav.jsp" %>
<hr />
<div class="container">
    <h2>회원 가입</h2>
    <c:if test="${errorMessage != null }">
        <p>[${errorid }] ${errorMessage }</p>
    </c:if>
    <form action="<c:url value="/regist"/>" method="post">
        <div class="form-group">
            <label for="diraryMemberId">ID:</label>
            <input type="text" id="diraryMemberId" name="diraryMemberId" class="form-control" value="${errorid }"/>
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" class="form-control" required/>
        </div>
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" class="form-control" required/>
        </div>
        <button type="submit" class="btn btn-primary">회원가입</button>
    </form>
</div>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>