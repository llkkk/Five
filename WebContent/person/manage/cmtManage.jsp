<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + 
					  request.getServerPort() + path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
  <head>
    <base href="<%=basePath%>">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge" charset="UTF-8">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/index.css" rel="stylesheet">
    <script src="js/jquery-3.2.1.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <title>管理评论</title>
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
					<li><a href="SelectBlogByUserIdServlet?pid=${user_cur.userId}&pName=${user_cur.userName}">我的主页</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<c:if test="${user_cur.limits gt 0}">
						<li class="active"><a href="ManageServlet">管理模式</a></li>
					</c:if>
					<li>
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
			<div class="col-md-3">
				<div class="blog">
					<span class="heading">用户列表</span>
					<c:forEach items="${lst_user}" var="p">
						<div class="content1">
						<c:if test="${p.limits eq 2}">
							<span class="limits2">${p.userName}</span>
						</c:if>
						<c:if test="${p.limits eq 1}">
							<span class="limits1">${p.userName}</span>
						</c:if>
						<c:if test="${p.limits eq 0}">
							<span class="limits0">${p.userName}</span>
						</c:if>
						<c:if test="${user_cur.limits eq 1}">
							<c:if test="${p.limits eq 0}">
								<a class="btn btn-danger btn-xs btn3" href="DeleteUserServlet?pid=${p.userId}"
								 onclick="if(confirm('确认删除？')==false)return false;">删除</a>
							</c:if>
						</c:if>
						<c:if test="${user_cur.limits eq 2}">
							<c:if test="${p.limits ne 2}">
								<a class="btn btn-danger btn-xs btn3" href="DeleteUserServlet?pid=${p.userId}"
								 onclick="if(confirm('确认删除？')==false)return false;">删除</a>
							</c:if>
							<c:if test="${p.limits eq 0}">
								<a class="btn btn-warning btn-xs btn3" href="UpdateLimits?pid=${p.userId}&plmt=${p.limits}">设为管理员</a>
							</c:if>
							<c:if test="${p.limits eq 1}">
								<a class="btn btn-warning btn-xs btn3" href="UpdateLimits?pid=${p.userId}&plmt=${p.limits}">移除管理员</a>
							</c:if>
						</c:if>
					</div>
					</c:forEach>
				</div>
			</div>
			<div class="col-md-9">
				<div class="blog">
					<span class="heading">博文详情</span>
					<div class="content">
						<a href="SelectBlogByUserIdServlet?pid=${blog.userId}&pName=${blog.userName}">
						${blog.userName}</a> <span class="text-muted">　${blog.blogDate}</span>
						<p>　　${blog.blogContent}</p>
						<a href="DeleteBlogServlet?bid=${blog.blogId}&from=manageDelete"
						 onclick="if(confirm('确认删除？')==false)return false;">删除</a>
					</div>
				</div>
				<div class="blog">
					<span class="heading">评论</span>
					<c:forEach items="${lst_cmt}" var="cmt">
						<div class="content">
						  <a href="SelectBlogByUserIdServlet?pid=${cmt.userId}&pName=${cmt.userName}">
						  ${cmt.userName}</a> <span class="text-muted">　${cmt.dayOfCmt}</span>
						  <p>　　${cmt.cmtContent}</p>
							<a href="DeleteCmtServlet?cid=${cmt.cmtId}&cmtNum=${blog.cmtNum}
							&bid=${blog.blogId}&from=deleteCmtManage"
							 onclick="if(confirm('确认删除？')==false)return false;">删除</a>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	<footer class="footer footer-inverse footer-fixed-buttom">
	  <div class="container">
	    <p class="text-muted">Copyright © 2017 Weblog All Rights Reserved. 备案号：渝ICP备17072707号-1</p>
	  </div>
	</footer>
  </body>
</html>
