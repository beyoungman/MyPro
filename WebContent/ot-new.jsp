<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<title>添加加班记录</title>
</head>
<body>

	<!-- 检查登录 -->
	<jsp:include page="checkLogin.jsp"/>

	<jsp:include page="admin.jsp"></jsp:include>
	
	
	<div class="contianer">
		<form action="addOtServlet" method="post">
			<table class="table">
				<thead>
					<tr>
						<th>编号</th>
						<th>姓名</th>
						<th>日期</th>
						<th>加班时间(小时)</th>
						<th>加班费</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><input type="hidden" name="oid"> 
						<input type="hidden" value="${sid}" name="sid"></td>
						<td></td>
						<td><input type="text" name="date" value="2018-01-01"></td>
						<td><input type="text" name="hours"></td>
						<td><input type="text" name="money"></td>
						<td><input type="submit" value="增加"></td>
					</tr>
			</table>
		</form>
			<div style="margin-left:400px"><a href="ShowOtServlet">返回</a></div>
	</div>
</body>
</html>