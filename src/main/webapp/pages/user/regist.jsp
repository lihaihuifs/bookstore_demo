<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Registration</title>
		<%@include file="/pages/common/head_settings.jsp"%>
		<script type="text/javascript">
			$(function () {
				$("#sub_btn").click(function () {
					var usernameText = $("#username").val();
					var usernamePatt = /^\w{5,12}$/;
					if (!usernamePatt.test(usernameText)) {
						$("span.errorMsg").text("Illegal Username");
						return false;
					}

					var passwordText = $("#password").val();
					var passwordPatt = /^\w{5,12}$/;
					if (!passwordPatt.test(passwordText)) {
						$("span.errorMsg").text("Illegal Password！");

						return false;
					}

					var repwdText = $("#repwd").val();
					if (repwdText != passwordText) {
						$("span.errorMsg").text("Different Passwords");
						return false;
					}

					var emailText = $("#email").val();
					var emailPatt = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
					if (!emailPatt.test(emailText)) {
						$("span.errorMsg").text("Illegal Email");
						return false;
					}

					var codeText = $("#code").val();
					codeText = $.trim(codeText);

					if (codeText == null || codeText == "") {
						$("span.errorMsg").text("Can't be empty");
						return false;
					}

					$("span.errorMsg").text("");

				});

				$("code_img").click(function () {
					this.src = "${basePath}kaptcha.jpg?d=" + new Date(); // Keep URL Different with Date
				});
			});

		</script>
	<style type="text/css">
		.login_form{
			height:420px;
			margin-top: 25px;
		}

	</style>
	</head>
	<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/bookstore.jpg" >
		</div>

			<div class="login_banner">

				<div id="l_content">
					<span class="login_word">Registration</span>
				</div>

				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>Registration</h1>
								<span class="errorMsg">${requestScope.msg}</span>
							</div>
							<div class="form">
								<form action="userServlet" method="post">
									<input type="hidden" name="action" value="register"/>
									<label>Username: </label>
									<input class="itxt" type="text" placeholder="Username"
										   autocomplete="off" tabindex="1" name="username" id="username"
										   value="${requestScope.username}"
									/>
									<br />
									<br />
									<label>Password: </label>
									<input class="itxt" type="password" placeholder="Password"
										   autocomplete="off" tabindex="1" name="password" id="password" />
									<br />
									<br />
									<label>Repeat：</label>
									<input class="itxt" type="password" placeholder="Password"
										   autocomplete="off" tabindex="1" name="repwd" id="repwd" />
									<br />
									<br />
									<label>Email：</label>
									<input class="itxt" type="text" placeholder="Email@email.com"
										   autocomplete="off" tabindex="1" name="email" id="email" />
									<br />
									<br />
									<div id="verification_div">
										<label>Verification：</label>
										<input class="itxt" type="text" style="width: 80px;" name="code" id="code"/><img id="code_img" alt="code" src="kaptcha.jpg" style="float: right; width: 120px; margin-right: 0px">
									</div>
									<input type="submit" value="Register" id="sub_btn" />
								</form>
							</div>

						</div>
					</div>
				</div>
			</div>
		<%@include file="/pages/common/footer.jsp" %>
	</body>
</html>