<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <%@include file="/pages/common/head_settings.jsp" %>
    <script type="text/javascript">
        $(function () {
            // Onload
            $("#sub_btn").click(function () {

                // Verify username
                var account_regex = /^\w{5,12}$/; // Translate: start 5-12 words or nums end
                var userNameField = $(":text[name=username]"); // Get the username input field
                var userName = userNameField.val(); // Get the value
                if (!account_regex.test(userName)) {
                    // If userName doesn't follow pattern, add some red text
                    $("span.errorMsg").text("Illegal Username");
                    return false; // Stop forwarding
                }
                ;

                // Verify Password
                var password_regex = /^\w{5,12}$/;
                var passwdField = $("#passwd"); // Get the username input field
                var pwd = passwdField.val(); // Get the value
                if (!password_regex.test(pwd)) {
                    // If userName doesn't follow pattern, add some red text
                    $("span.errorMsg").text("Illegal Password");
                    return false; // Stop forwarding
                }
            });
        });
    </script>
</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="static/img/bookstore.jpg">
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">Welcome</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>Member</h1>
                    <a href="pages/user/regist.jsp">Register</a>
                </div>
                <div class="msg_cont">
                    <b></b>
                    <span class="errorMsg"><%=request.getAttribute("msg") == null ? "Enter username and password" : request.getAttribute("msg")%></span>
                </div>
                <div class="form">
                    <form action="userServlet" method="post">
                        <input type="hidden" name="action" value="login"/>
                        <label>Username: </label>
                        <input class="itxt" type="text" placeholder="Username"
                               autocomplete="off" tabindex="1" name="username"
                               value="${requestScope.username}"
                        />
                        <br/>
                        <br/>
                        <label>Password: </label>
                        <input id="passwd" class="itxt" type="password" placeholder="Password" autocomplete="off"
                               tabindex="1" name="password"/>
                        <br/>
                        <br/>
                        <input type="submit" value="Log in" id="sub_btn"/>
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<%@include file="/pages/common/footer.jsp" %>
</body>
</html>