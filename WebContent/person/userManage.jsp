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
<link href="css/index.css" rel="stylesheet">
<script src="js/jquery-3.2.1.js"></script>
<script src="js/bootstrap.min.js"></script>
<title>${user_other.userName}的个人信息</title>
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
					<li
						<c:if test="${param.pid eq user_cur.userId}">class="active"</c:if>>
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
									href="UserManageServlet?pid=${p.userId}
										&pName=${p.userName}">${p.userName}</a>
							</c:if>
							<c:if test="${p.limits eq 1}">
								<a class="limits1"
									href="UserManageServlet?pid=${p.userId}
										&pName=${p.userName}">${p.userName}</a>
							</c:if>
							<c:if test="${p.limits eq 0}">
								<a class="limits0"
									href="UserManageServlet?pid=${p.userId}
										&pName=${p.userName}">${p.userName}</a>
							</c:if>
						</div>
					</c:forEach>
				</div>
			</div>
			<div class="col-md-10">
				<div class="blog">
					<span class="heading">用户信息</span> 
					<%-- <span class="info">用户名：${user_other.userName}</span>
					<span class="info">年龄：${user_other.age}</span> <span class="info">性别：${user_other.sex}</span>
					<span class="info">出生日期：${user_other.dayOfBirth}</span> 
					<span class="info">注册时间：${user_other.registrationdate}</span> 
					<span class="info">电子邮箱：${user_other.email}</span> 
					<span class="info">电话号码：${user_other.phone}</span>
					<span class="info">权限级别：${user_other.limits}</span>
					<span class="info">地址：${user_other.address}</span> --%>
					<table border="0" class="table table-striped">
						<tr>
							<td id="td">用户名：${user_other.userName}</td>
							<td id="td">注册时间：${user_other.registrationdate}</td>
						</tr>
						<tr>
							<td id="td">年　龄：${user_other.age}</td>
							<td id="td">出生日期：${user_other.dayOfBirth}</td>
						</tr>
						<tr>
							<td id="td">性　别：${user_other.sex}</td>
							<td id="td">邮　　箱：${user_other.email}</td>
						</tr>
						<tr>
							<td id="td">权　限：${user_other.limits}</td>
							<td id="td">号　　码：${user_other.phone}</td>
						</tr>
						<tr>
							<td colspan="2"  id="td">地　址：${user_other.address}</td>
						</tr>
					</table>
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
