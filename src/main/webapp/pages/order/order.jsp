<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>My Order</title>
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
    <span class="wel_word">My Order</span>
    <%@include file="/pages/common/login_succeed_menu.jsp" %>
</div>

<div id="main">

    <table>
        <tr>
            <td>Date</td>
            <td>Price</td>
            <td>Status</td>
            <td>Detail</td>
        </tr>
        <c:forEach items="${requestScope.orders}" var="order">
            <tr>
                <td><fmt:formatDate value="${order.createTime}" pattern="yyyy-MM-dd"/></td>
                <td>${order.price}</td>
                <td>${order.status}</td>
                <td><a href="#">Detail</a></td>
            </tr>
        </c:forEach>
    </table>


</div>

<%@include file="/pages/common/footer.jsp" %>
</body>
</html>