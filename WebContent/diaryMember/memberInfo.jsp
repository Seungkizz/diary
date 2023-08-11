<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
    body {
        padding: 100px;
    }
    .info-label {
        font-size: 14px;
    }
    .info-value {
        font-size: 16px;
    }
    .table {
        max-width: 500px;
    }
</style>
</head>
<body>
<%@include file="/common/main_nav.jsp" %>
<hr />
<div class="container">
    <table class="table table-bordered">
        <c:forEach var="diaryMember" items="${diaryMember}">
            <tr>
                <th class="info-label">내 아이디:</th>
                <td class="info-value">${diaryMember.diraryMemberId}</td>
            </tr>
            <tr>
                <th class="info-label">이름:</th>
                <td class="info-value">${diaryMember.name}</td>
            </tr>
            <tr>
                <th class="info-label">비밀번호:</th>
                <td class="info-value">${diaryMember.password}</td>
            </tr>
        </c:forEach>
    </table>
</div>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
