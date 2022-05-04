<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login Page</title>
	<%@include file="/pages/common/head_settings.jsp"%>
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
				};

				// Verify Password
				var password_regex = /^\w{5,12}$/;
				var passwdField = $("#passwd"); // Get the username input field
				var pwd = passwdField.val(); // Get the value
				if (!password_regex.test(pwd)){
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
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎登录</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>尚硅谷会员</h1>
								<a href="pages/user/regist.jsp">立即注册</a>
							</div>
							<div class="msg_cont">
								<b></b>
								<span class="errorMsg">Enter Username and Password</span>
							</div>
							<div class="form">
								<form action="loginServlet" method="post">
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username"/>
									<br />
									<br />
									<label>用户密码：</label>
									<input id="passwd" class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" />
									<br />
									<br />
									<input type="submit" value="登录" id="sub_btn" />
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<%@include file="/pages/common/footer.jsp" %>
</body>
</html>