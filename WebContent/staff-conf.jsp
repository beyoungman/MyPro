<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<title>管理系统首页</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="css/staff-conf.css">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<script src="js/jquery.min.js">
</script>
<body>

	<!-- 检查登录 -->
	<jsp:include page="checkLogin.jsp"/>

<div class="centianer">
	<div class="inc-div"><jsp:include page="staff.jsp"/></div>
	<div class="con-div">
	<div><form action="updateStaffServlet" method="POST">
		<input type="hidden" name="sid" value="${requestScope.sid}">
		<div>姓名</div><div><input type='text' name="name" value="${requestScope.name}"></div>
		<div>手机号码</div><div><input type='text' name="phone" value="${requestScope.phone}"></div>
		<div>身份证号码</div><div><input type='text' name="idNum" value="${requestScope.idNum}"></div>
		<div>月工资</div><div><input type='text' name="salary" value="${requestScope.salary}"></div>
		<div>加班钟数</div><div><input type='text' value="${allOtHours}" disabled="disabled"></div>
		<div>休息天数</div><div><input type='text' value="${allRestDays}" disabled="disabled"></div>
		<div>应发工资（年）</div><div><input type='text' disabled="disabled"></div>
		<br><div><button type="submit">提交修改</button></div>
	</form>
	</div>
	</div>
</div>
</body>
</html>