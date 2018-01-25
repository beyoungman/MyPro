<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.manager.beans.*" import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>管理系统首页</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<!-- 检查登录 -->
	<jsp:include page="checkLogin.jsp"/>
	<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<nav class="navbar navbar-default navbar-inverse" role="navigation">
				<div class="navbar-header">
					 <a class="navbar-brand active" href="admin.jsp">管理系统</a>
				</div>
				
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li>
							 <a href="ShowStaffServlet">员工管理</a>
						</li>
						<li>
							 <a href="ShowBuyServlet">收货管理</a>
						</li>
						<li class="dropdown">
							 <a href="ShowSaleServlet" class="dropdown-toggle" data-toggle="dropdown">卖货管理</a>
						</li>
					</ul>
					<form class="navbar-form navbar-left" role="search">
						<div class="form-group">
							<input class="form-control" type="text" />
						</div> <button type="submit" class="btn btn-default">搜索</button>
					</form>
					<ul class="nav navbar-nav navbar-right">
					<li>
						<a href="ShowOtherPayServlet">其他支出</a>
					</li>
						<li>
							 <a href="UserConfServlet"><%=((User)session.getAttribute("user")).getName()%>
							 </a>
						</li>
						<li >
							 <a href="logout.jsp">退出登录</a>
			
						</li>
					</ul>
				</div>
				
			</nav>
		</div>
	</div>
</div>
</body>
</html>