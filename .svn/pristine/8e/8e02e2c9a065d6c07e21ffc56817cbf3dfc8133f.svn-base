<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
<base href="<%=basePath%>">
<meta http-equiv="X-UA-Compatible" content="IE=Edge" charset="UTF-8">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/signin.css" rel="stylesheet">
<script src="js/jquery-3.2.1.js"></script>
<script src="js/bootstrap.min.js"></script>
<title>用户登录</title>
</head>
<body>
	<%
		if (request.getAttribute("msg") != null) {
	%>
	<script>
		alert('${msg}');
	</script>
	<%
		}
	%>
	<script>
		function nameCheck() {
			var xmlhttp;
			if (window.XMLHttpRequest) {
				//  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
				xmlhttp = new XMLHttpRequest();
			} else {
				// IE6, IE5 浏览器执行代码
				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			}
			xmlhttp.onreadystatechange = function() {
				if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
					document.getElementById("nameCheck").innerHTML = xmlhttp.responseText;
					if (xmlhttp.responseText == ''){
						$("button").removeAttr("disabled");
					} else {
						 $("button").attr("disabled","disabled");
					}
				}
			}
			xmlhttp.open("GET", "NameCheckServlet?name="
					+ document.getElementById("inputName").value, true);
			xmlhttp.send();
		} 

		function myfun() {
			$(".d2").hide();
			$("#register").click(function() {
				document.title = '用户注册';
				//$(".d1").hide();
				$(".d1").hide();
				//$("#headtitle").html("用户注册");
				//$("#headtitle").fadeIn(1000);
				$(".d2").slideDown(600);
				//$(".form-horizontal").attr('action', 'InsertServlet'); //通过jquery为action属性赋值

			});
			 $("#login").click(function() {
				 document.title = '用户登录';
				$(".d2").slideUp(200);
				//$("#headtitle").html("用户登录");
				//$("#headtitle").fadeIn(1000);
				$(".d1").show(500);
				//$(".form-horizontal").attr('action', 'LoginServlet'); //通过jquery为action属性赋值

			}); 
		}
		window.onload = myfun;
		function validate() {
		    var pwd = $("#pwd").val();
		    var pwd1 = $("#pwd1").val();
		    if(pwd == pwd1)
		     {
		        $("#pwdCheck").html("");
		         $("#pwdCheck").css("color","green");
		    $("button").removeAttr("disabled");
		     }
		else {
		        $("#pwdCheck").html("两次密码不相同");
		         $("#pwdCheck").css("color","red")
		          $("button").attr("disabled","disabled");   
		      }
		}
	</script>
	<div class="container">
		<div class="row">
			<div class="col-md-offset-3 col-md-5">
				<form class="form-horizontal d1" action="LoginServlet" method="post">
					<span class="heading" id="headtitle">用户登录</span>
					<div class="form-group">
						<input type="text" class="form-control" id="inputEmail3"
							name="userName" autofocus="autofocus" 
							placeholder="用户名" required="required">
					</div>
					<div class="form-group">
						<input type="password" class="form-control" id="inputPassword3"
							name="userPass"  placeholder="密　码" required="required">
					</div>
					<div class="form-group">
						<span class="text-muted">还没有账号？立即<a id="register" style="cursor: pointer;">注册</a></span>
						<button type="submit" class="btn btn-default">登录</button>
					</div>
					</form>
					<form class="form-horizontal d2" action="InsertServlet" method="post">
						<span class="heading" id="headtitle">用户注册</span>
                    <div class="form-group regis">
						<input type="text" class="form-control" id="inputName"
							name="userName1" autofocus="autofocus" 
							placeholder="用户名" onblur="nameCheck();" required="required"> 
							<span class="text-muted" id="nameCheck"></span>
					</div>
					<div class="form-group regis">
						<input type="password" class="form-control" id="pwd"
							name="userPass1"  placeholder="密　码"required="required">
					</div>
					<div class="form-group regis">
						<input type="password" class="form-control" id="pwd1"
							 onkeyup="validate()" name="pass"  placeholder="确认密码"required="required">
						<span class="text-muted" id="pwdCheck"></span>
					</div>
					<div class="form-group regis">

						<select class="form-control" name="sex">
							<option>男</option>
							<option>女</option>
						</select>
					</div>
					<div class="form-group regis">
						<input type="date" class="form-control" id="inputPassword3"
							name="dayOfBirth" placeholder="出生日期" required="required">
					</div>
					<div class="form-group regis">
						<input type="email" class="form-control" id="inputPassword3"
							name="email" placeholder="电子邮箱"required="required">
					</div>
					<div class="form-group regis">
						<input type="text" class="form-control" id="inputPassword3"
							name="phone" placeholder="电话号码"required="required">
					</div>
					<div class="form-group regis">
						<input type=text class="form-control" id="inputPassword3"
							name="address" placeholder="家庭住址"required="required">

					</div>

					<div class="form-group regis">
						<span class="text-muted">已有账号？直接<a id="login" style="cursor: hand;cursor: pointer;">登录</a></span>
						<button type="submit" class="btn btn-default">注册</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>