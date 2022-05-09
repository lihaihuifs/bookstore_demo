<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book List</title>
    <%@include file="/pages/common/head_settings.jsp" %>
    <script type="text/javascript">
        $(function () {
            $("a.deleteClass").click(function () {
                return confirm("Confirm to delete: " + "【" +
                    $(this).parent().parent().find("td:first").text()
                    + "】?");
            });

            $("#searchPageBtn").click(function () {
                var pageNo = $("#pn_input").val();
                location.href = "${pageScope.basePath}manager/bookServlet?action=page&pageNo=" + pageNo;
            });

        })
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/bookstore.jpg">
    <span class="wel_word">Book Management System</span>
    <%@include file="/pages/common/manager_menu.jsp" %>
</div>

<div id="main">
    <table>
        <tr>
            <td>Title</td>
            <td>Price</td>
            <td>Author</td>
            <td>Sales</td>
            <td>Stock</td>
            <td colspan="2">Operation</td>
        </tr>

        <c:forEach items="${requestScope.page.items}" var="book">
            <tr>
                <td>${book.name}</td>
                <td>${book.price}</td>
                <td>${book.author}</td>
                <td>${book.sales}</td>
                <td>${book.stock}</td>
                <td><a class="updateClass" href="manager/bookServlet?action=getBook&id=${book.id}&pageNo=${requestScope.page.pageNo}">Edit</a></td>
                <td><a class="deleteClass" href="manager/bookServlet?action=delete&id=${book.id}&pageNo=${requestScope.page.pageNo}">Delete</a></td>
            </tr>
        </c:forEach>

        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td><a href="pages/manager/book_edit.jsp?pageNo=${requestScope.page.pageTotal + 1}">Add Book</a></td>
        </tr>
    </table>

    <div id="page_nav">
        <c:if test="${requestScope.page.pageNo > 1}">
            <a href="manager/bookServlet?action=page&pageNo=1">First</a>
            <a href="manager/bookServlet?action=page&pageNo=${requestScope.page.pageNo - 1}">Last</a>
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
        <c:forEach begin="${begin}" end="${end}" var="i">
            <c:if test="${i == requestScope.page.pageNo}">
                【${i}】
            </c:if>
            <c:if test="${i != requestScope.page.pageNo}">
                <a href="manager/bookServlet?action=page&pageNo=${i}">${i}</a>
            </c:if>
        </c:forEach>

        <c:if test="${requestScope.page.pageNo < requestScope.page.pageTotal}">
            <a href="manager/bookServlet?action=page&pageNo=${requestScope.page.pageNo+1}">Next</a>
            <a href="manager/bookServlet?action=page&pageNo=${requestScope.page.pageTotal}">End</a>
        </c:if>
        , Total: ${requestScope.page.pageTotal} page，${requestScope.page.pageTotalCount} records
        , to <input value="${param.pageNo}" name="pn" id="pn_input"/> page
        <input id="searchPageBtn" type="button" value="Confirm">
    </div>

</div>

<%@include file="/pages/common/footer.jsp" %>
</body>
</html>