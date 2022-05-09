<%--
  Created by IntelliJ IDEA.
  User: lihai
  Date: 2022/5/4
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>

<div>
    <span>Welcome, <span class="um_span">${sessionScope.user.username}</span></span>
    <a href="orderServlet?action=showOrder">Order | </a>
    <a href="userServlet?action=logout">Logout | </a>
    <a href="index.jsp">Home</a>
</div>