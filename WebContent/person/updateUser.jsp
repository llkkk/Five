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
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=Edge" charset="UTF-8">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/update.css" rel="stylesheet">
<script src="js/jquery-3.2.1.js"></script>
<script src="js/bootstrap.min.js"></script>
<title>修改信息</title>
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
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="SelectAllUserServlet">Weblog</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="IndexInitServlet">首页</a></li>
					<li><a
						href="SelectBlogByUserIdServlet?pid=${user_cur.userId}&pName=${user_cur.userName}">我的主页</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<c:if test="${user_cur.limits gt 0}">
						<li><a href="ManageServlet">管理模式</a></li>
					</c:if>
					<li class="active">
						<a class="dropdown-toggle userName" data-toggle="dropdown">${user_cur.userName}</a>
       					<ul class="dropdown-menu userName">
       						<li><a href="UserManageServlet?pid=${user_cur.userId}">用户信息</a></li>
							<li><a href="SelectAllUserServlet?from=userManage">修改信息</a></li>
							<li><a href="IndexInitServlet?from=updatePWD">修改密码</a></li>
							<li><a href="LogOffServlet">退出账号</a></li>
						</ul>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container">
		<div class="row main">
			<div class="col-md-2">
				<div class="blog">
					<span class="heading">用户列表</span>
					<c:forEach items="${lst_user}" var="p">
						<div class="content">
							<c:if test="${p.limits eq 2}">
								<a class="limits2"
									href="SelectBlogByUserIdServlet?pid=${p.userId}
										&pName=${p.userName}">${p.userName}</a>
							</c:if>
							<c:if test="${p.limits eq 1}">
								<a class="limits1"
									href="SelectBlogByUserIdServlet?pid=${p.userId}
										&pName=${p.userName}">${p.userName}</a>
							</c:if>
							<c:if test="${p.limits eq 0}">
								<a class="limits0"
									href="SelectBlogByUserIdServlet?pid=${p.userId}
										&pName=${p.userName}">${p.userName}</a>
							</c:if>
						</div>
					</c:forEach>
				</div>
			</div>
			<div class="col-md-10">
				<div class="blog">
					<form class="form-horizontal" action="UpdateUserServlet" method="post">
						<span class="heading">修改信息</span>
						<div class="form-group">
							<span class="text-muted">用户名：</span>
							<input type="text" class="form-control1" name="userName" autofocus="autofocus" 
								required="required" value="${user_cur.userName}" onblur="nameCheck();"> <span
								class="text-muted" id="nameCheck"></span>
						</div>
						<div class="form-group">
							<span class="text-muted">性　别：</span>
							<select class="form-control1" name="sex">
								<c:if test="${user_cur.sex eq '男'}">
									<option selected="selected">男</option>
									<option>女</option>
								</c:if>
								<c:if test="${user_cur.sex eq '女'}">
									<option>男</option>
									<option selected="selected">女</option>
								</c:if>
							</select>
						</div>
						<div class="form-group">
							<span class="text-muted">生　日：</span>
							<input type="date" class="form-control1" name="dayOfBirth"
								value="${user_cur.dayOfBirth}">
						</div>
						<div class="form-group">
							<span class="text-muted">邮　箱：</span>
							<input type="email" class="form-control1" name="email"
								value="${user_cur.email}">
						</div>
						<div class="form-group">
							<span class="text-muted">号　码：</span>
							<input type="text" class="form-control1" name="phone"
								value="${user_cur.phone}">
						</div>
						<div class="form-group">
							<span class="text-muted">地　址：</span>
							<input type=text class="form-control1" name="address"
								value="${user_cur.address}">
						</div>
						<div class="form-group">
							<button type="submit" class="btn btn-default">修改</button>
						</div>
						<div class="form-group"></div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<footer class="footer footer-inverse footer-fixed-buttom">
		<div class="container">
			<p class="text-muted">Copyright © 2017 Weblog All Rights
				Reserved. 备案号：渝ICP备17072707号-1</p>
		</div>
	</footer>
</body>
</html>
