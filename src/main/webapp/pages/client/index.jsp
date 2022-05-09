<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <%@include file="/pages/common/head_settings.jsp" %>
    <link type="text/css" rel="stylesheet" href="static/css/style.css">
    <script type="text/javascript">
        $(function () {
            $("button.add_to_cart").click(function () {
                var bookId = $(this).attr("bookId");
                location.href = "${basePath}cartServlet?action=addItem&id=" + bookId;
            });
        })
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="bookstore logo" src="static/img/bookstore.jpg">
    <span class="wel_word" style="margin:0 auto; text-align: center;">Book Store</span>
    <div>
        <c:if test="${empty sessionScope.user}">
            <a href="pages/user/login.jsp">Login | </a>
            <a href="pages/user/regist.jsp">Register | </a>
        </c:if>
        <c:if test="${not empty sessionScope.user}">
            <span>Welcome, <span class="um_span">${sessionScope.user.username}</span>|</span>
            <a href="userServlet?action=logout">Logout | </a>
        </c:if>
        <a href="pages/cart/cart.jsp">Cart | </a>
        <a href="pages/manager/manager.jsp">Management</a>
    </div>
</div>
<div id="main">
    <div id="book">
        <div class="book_cond">
            <form action="client/bookServlet?action=pageByPrice&pageNo=${requestScope.page.pageNo}" method="post">
                Price： <input id="min" type="text" name="min" value=""> $ -
                <input id="max" type="text" name="max" value=""> $
                <input type="submit" style="width: auto" value="Search"/>
            </form>
        </div>

        <div style="text-align: center">
            <span>Cart has: ${not empty sessionScope.cart.items ? sessionScope.cart.totalCount : 0} item(s)</span>
            <c:if test="${not empty sessionScope.cart.items}">
                <div>
                    Add <span style="color: red">${sessionScope.lastAddedItem}</span> to Cart
                </div>
            </c:if>
        </div>

        <c:forEach items="${requestScope.page.items}" var="book">
            <div class="b_list">
                <div class="img_div">
<%--                    <img class="book_img" alt="" src="${book.imgPath}"/>--%>
                    <img class="book_img" alt="" src="static/img/hp.jpg"/>
                </div>
                <div class="book_info">
                    <div class="book_name">
                        <span class="sp1">Book:</span>
                        <span class="sp2">${book.name}</span>
                    </div>
                    <div class="book_author">
                        <span class="sp1">Author:</span>
                        <span class="sp2">${book.author}</span>
                    </div>
                    <div class="book_price">
                        <span class="sp1">Price:</span>
                        <span class="sp2">$${book.price}</span>
                    </div>
                    <div class="book_sales">
                        <span class="sp1">Sales:</span>
                        <span class="sp2">${book.sales}</span>
                    </div>
                    <div class="book_amount">
                        <span class="sp1">Stock:</span>
                        <span class="sp2">${book.stock}</span>
                    </div>
                    <div class="book_add">
                        <button class="add_to_cart" bookId="${book.id}">Add to cart</button>
                    </div>
                </div>
            </div>
        </c:forEach>

    </div>

    <div id="page_nav">
        <c:if test="${requestScope.page.pageNo > 1}">
            <a href="${requestScope.page.url}&pageNo=1">Home</a>
            <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo - 1}">Last</a>
        </c:if>

        <c:choose>
            <c:when test="${requestScope.page.pageTotal <= 5}">
                <c:set var="begin" value="1"></c:set>
                <c:set var="end" value="${requestScope.page.pageTotal}"></c:set>
            </c:when>
            <c:when test="${requestScope.page.pageTotal > 5}">
                <c:choose>
                    <c:when test="${requestScope.page.pageNo <= 3}">
                        <c:set var="begin" value="1"></c:set>
                        <c:set var="end" value="5"></c:set>
                    </c:when>
                    <c:when test="${requestScope.page.pageNo > requestScope.page.pageTotal-3}">
                        <c:set var="begin" value="${requestScope.page.pageTotal-4}"/>
                        <c:set var="end" value="${requestScope.page.pageTotal}"/>
                    </c:when>
                    <c:otherwise>
                        <c:set var="begin" value="${requestScope.page.pageNo-2}"/>
                        <c:set var="end" value="${requestScope.page.pageNo+2}"/>
                    </c:otherwise>
                </c:choose>

            </c:when>
        </c:choose>
        <c:forEach begin="${begin}" end="${end}" var="i"> <%-- Include【Start,End】--%>
            <c:if test="${i == requestScope.page.pageNo}">
                【${i}】
            </c:if>
            <c:if test="${i != requestScope.page.pageNo}">
                <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
            </c:if>
        </c:forEach>

        <c:if test="${requestScope.page.pageNo < requestScope.page.pageTotal}">
            <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo+1}">Next</a>
            <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageTotal}">End</a>
        </c:if>
         ,Total ${requestScope.page.pageTotal} pages, ${requestScope.page.pageTotalCount} records
        to <input value="${param.pageNo}" name="pn" id="pn_input"/> page
        <input id="searchPageBtn" type="button" value="go">
    </div>
</div>

<%@include file="/pages/common/footer.jsp" %>
</body>
</html>