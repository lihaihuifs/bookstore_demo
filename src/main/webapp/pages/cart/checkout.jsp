<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Check out</title>
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
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">Check out</span>
    <%@include file="/pages/common/login_succeed_menu.jsp"%>
</div>

<div id="main">

    <h1>Order is created: Order Id ${sessionScope.orderId}</h1>


</div>

<%@include file="/pages/common/footer.jsp" %>
</body>
</html>