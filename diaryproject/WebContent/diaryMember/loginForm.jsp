<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
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
    <h2>로그인</h2>
    <c:if test="${msg ne null}">
        <script type="text/javascript">
            alert("${msg}");
        </script>
    </c:if>
    <c:if test="${fail != null }">
        <p>아이디 혹은 비밀번호가 맞지 않습니다.</p>
    </c:if>
    <form action="<c:url value="/login"/>" method="post">
        <div class="form-group">
            <label for="diraryMemberId">ID:</label>
            <input type="text" id="diraryMemberId" name="diraryMemberId" class="form-control" value="${fail.diraryMemberId }"/>
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" class="form-control" required/>
        </div>
        <button type="submit" class="btn btn-primary">로그인</button>
    </form>
</div>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>