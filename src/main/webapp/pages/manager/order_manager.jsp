<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order Management</title>
    <%@include file="/pages/common/head_settings.jsp" %>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/bookstore.jpg">
    <span class="wel_word">Order Management</span>
    <%@include file="/pages/common/manager_menu.jsp" %>
</div>

<div id="main">
    <table>
        <tr>
            <td>Date</td>
            <td>Price</td>
            <td>Detail</td>
            <td>Delivery</td>

        </tr>
        <tr>
            <td>2015.04.23</td>
            <td>90.00</td>
            <td><a href="#">Check</a></td>
            <td><a href="#">Ship</a></td>
        </tr>

        <tr>
            <td>2015.04.20</td>
            <td>20.00</td>
            <td><a href="#">Detail</a></td>
            <td>Sent</td>
        </tr>

        <tr>
            <td>2014.01.23</td>
            <td>190.00</td>
            <td><a href="#">Detail</a></td>
            <td>Waiting</td>
        </tr>
    </table>
</div>

<%@include file="/pages/common/footer.jsp" %>
</body>
</html>