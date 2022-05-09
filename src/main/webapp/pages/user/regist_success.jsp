<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Succeeded</title>
    <%@include file="/pages/common/head_settings.jsp" %>
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }

        h1 a {
            color: red;
        }
    </style>
</head>
<body>
<div id="header">
    <img class="logo_img" alt="" src="static/img/bookstore.jpg">
    <span class="wel_word"></span>
    <%@include file="/pages/common/login_succeed_menu.jsp" %>
</div>

<div id="main">

    <h1>Congratulations, Registration Succeeded! <a href="index.jsp">Home</a></h1>

</div>

<%@include file="/pages/common/footer.jsp" %>
</body>
</html>