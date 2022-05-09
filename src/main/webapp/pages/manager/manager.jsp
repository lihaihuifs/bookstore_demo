<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Management System</title>
    <%@include file="/pages/common/head_settings.jsp" %>
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }
    </style>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/bookstore.jpg">
    <span class="wel_word">Management System</span>
    <%@include file="/pages/common/manager_menu.jsp"%>
</div>

<div id="main">
    <h1>Welcome to Book Store Management System</h1>
</div>

<%@include file="/pages/common/footer.jsp" %>
</body>
</html>