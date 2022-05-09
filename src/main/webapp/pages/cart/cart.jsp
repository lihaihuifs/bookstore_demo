<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cart</title>
    <%@include file="/pages/common/head_settings.jsp" %>
    <script type="text/javascript">
        $(function () {
            $("a.deleteItem").click(function () {
                return confirm("Delete【" + $(this).parent().parent().find("td:first").text() +"】?")
            });
            $("#clearCart").click(function () {
                return confirm("Clear cart?");
            })
        });
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">Cart</span>
    <%@include file="/pages/common/login_succeed_menu.jsp" %>
    <script type="text/javascript">
        $(function () {
            $(".update_count").change(function () {
                var name = $(this).parent().parent().find("td:first").text();
                var id = $(this).attr('bookId');
                var count = this.value;
                if ( confirm("Change【" + name + "】 quantity to:" + count + " ?") ) {
                    location.href =
                        "http://localhost:8080/book/cartServlet?action=updateCount&count="+count+"&id="+id;
                } else {
                    this.value = this.defaultValue;
                }
            });
        })
    </script>
</div>

<div id="main">

    <table>
        <tr>
            <td>Item</td>
            <td>Quantity</td>
            <td>Price</td>
            <td>Total</td>
            <td>Option</td>
        </tr>
        <c:if test="${empty sessionScope.cart.items}">
            <tr>
                <td colspan="5"><a href="index.jsp">Cart is empty, go to store</a>
                </td>
            </tr>
        </c:if>
        <c:if test="${not empty sessionScope.cart.items}">
            <c:forEach items="${sessionScope.cart.items}" var="entry">
                <tr>
                    <td>${entry.value.name}</td>
                    <td>
                        <input type="text" class="update_count" style="width: 80px"
                            bookId="${entry.value.id}" value="${entry.value.count}"
                        >
                    </td>
                    <td>${entry.value.price}</td>
                    <td>${entry.value.totalPrice}</td>
                    <td><a class="deleteItem" href="cartServlet?action=deleteItem&id=${entry.value.id}">delete</a></td>
                </tr>
            </c:forEach>
        </c:if>

    </table>

    <c:if test="${not empty sessionScope.cart.items}">
        <div class="cart_info">
            <span class="cart_span">There are <span class="b_count">${sessionScope.cart.totalCount}</span> items</span>
            <div>
                Add <span style="color: red">${sessionScope.lastAddedItem}</span> to cart
            </div>
            <span class="cart_span">Total: <span class="b_price">${sessionScope.cart.totalPrice}</span> dollar</span>
            <span class="cart_span"><a id="clearCart" href="cartServlet?action=clear">Clear cart</a></span>
            <span class="cart_span"><a href="orderServlet?action=createOrder">Check out</a></span>
        </div>
    </c:if>
</div>
<%@include file="/pages/common/footer.jsp" %>
</body>
</html>