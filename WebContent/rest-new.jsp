<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<title>添加休息记录</title>
</head>
<body>

		<!-- 检查登录 -->
	<jsp:include page="checkLogin.jsp"/>

	<jsp:include page="admin.jsp"></jsp:include>
	
	
	<div class="contianer">
		<form action="addRestServlet" method="post">
			<table class="table">
				<thead>
					<tr>
						<th>编号</th>
						<th>姓名</th>
						<th>日期</th>
						<th>休息（天）</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><input type="hidden" name="rid"> 
						<input type="hidden" value="${sid}" name="sid"></td>
						<td></td>
						<td><input type="text" name="date" value="2018-01-01"></td>
						<td><input type="text" name="days"></td>
						<td><input type="submit" value="增加"></td>
					</tr>
			</table>
		</form>
			<div style="margin-left:400px"><a href="ShowRestServlet">返回</a></div>
	</div>
</body>
</html>