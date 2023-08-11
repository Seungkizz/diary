<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>SK Dirary</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            padding: 100px;
        }

        .footer {
            text-align: center;
            margin-top: 50px;
            padding: 20px;
            background-color: #f8f9fa;
        }

        .center-image {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 400px;
        }

        .center-image img {
            max-width: 100%;
            max-height: 100%;
            object-fit: contain;
        }
        
        .custom-div {
            padding: 20px;
        }
    </style>
</head>
<body>
<div class="custom-div">
    <%@include file="/common/main_nav.jsp"%>

</div>
<hr />

<div class="center-image">
    <img src="img/main3.jpg" alt="Center Image">
</div>

<div class="footer">
    &copy;Seungki corp. All rights Reserved.</p>
</div>

<!-- Bootstrap JS -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
