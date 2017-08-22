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
<title>Weblog</title>
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
					<li class="active"><a href="IndexInitServlet">首页</a></li>
					<li><a href="SelectBlogByUserIdServlet?pid=${user_cur.userId}
					&pName=${user_cur.userName}">我的主页</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a data-toggle="modal" data-target="#myModal">发表动态</a></li>
					<c:if test="${user_cur.limits gt 0}">
						<li><a href="ManageServlet">管理模式</a></li>
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
			<div class="col-md-2">
				<div class="blog">
				<span class="heading">用户列表</span>
				<c:forEach items="${lst_user}" var="p">
				 	<div class="content">
						<c:if test="${p.limits eq 2}">
							<a class="limits2" href="SelectBlogByUserIdServlet?pid=${p.userId}
										&pName=${p.userName}">${p.userName}</a>
							</c:if>
						<c:if test="${p.limits eq 1}">
							<a class="limits1" href="SelectBlogByUserIdServlet?pid=${p.userId}
										&pName=${p.userName}">${p.userName}</a>
						</c:if>
						<c:if test="${p.limits eq 0}">
							<a class="limits0" href="SelectBlogByUserIdServlet?pid=${p.userId}
										&pName=${p.userName}">${p.userName}</a>
						</c:if>
				 	</div>
				</c:forEach>
				</div>
			</div>
			<div class="col-md-10">
				<div class="blog">
					<span class="heading">全部动态</span>
				</div>
					<c:forEach items="${lst_blog}" var="blog">
						<div class="content">
							<a href="SelectBlogByUserIdServlet?pid=${blog.userId}&pName=${blog.userName}">
							${blog.userName}</a> <span class="text-muted">　${blog.blogDate}</span>
							<p>　　${blog.blogContent}</p>
							<c:if test="${blog.userName eq user_cur.userName}">
								<a href="DeleteBlogServlet?bid=${blog.blogId}&pid=${user_cur.userId}&pName=${user_cur.userName}"
								 onclick="if(confirm('确认删除？')==false)return false;">删除</a>
							</c:if>
							<a href="SelectBlogDetailsServlet?bid=${blog.blogId}">评论(${blog.cmtNum})</a>
						</div>
					</c:forEach>
			</div>
		</div>
	</div>
	<footer class="footer footer-inverse footer-fixed-buttom">
	  <div class="container">
	    <p class="text-muted">Copyright © 2017 Weblog All Rights Reserved. 备案号：渝ICP备17072707号-1</p>
	  </div>
	</footer>
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
						<h4 class="modal-title">发表动态</h4>
					</div>
					<div class="modal-body">
						<form action="InsertBlogServlet?pid=${user_cur.userId}&pName=${user_cur.userName}" method="post">
							<textarea class="form-control" name="blogContent" required="required" 
											placeholder="在此输入您要发表的内容..."></textarea>
							<button data-dismiss="modal" class="btn btn-default btn1" type="button">关闭</button>
							<button class="btn btn-info btn1" type="submit">发布</button>
						</form>
					</div>
				</div><!-- /.modal-content -->
			</div><!-- /.modal-dialog -->
		</div>
	</body>
</html>
