<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link   rel="stylesheet" href="css/staffnew.css">
<title>新增员工</title>
</head>
<script type="text/javascript">
function back(){
	window.history.back(-1);
};
</script>
<body>

	<!-- 检查登录 -->
	<jsp:include page="checkLogin.jsp"/>

	<jsp:include page="admin.jsp"/>
	<div class="centianer">
	<div class="div1"></div>
	<div class="div2">
	<div class="form-div">
	<form action="addStaffServlet" method="POST">
		<div class="confi-div">
		<div class="string">姓名</div>
		<div class="input-div"><input type="text" name="name"/></div>
		</div>
		<div class="confi-div">
		<div  class="string">身份证号码</div>
		<div class="confi-div"><input type="text" name="idNum"/></div>
		</div>
		<div class="confi-div">
		<div  class="string">电话</div>
		<div class="input-div"><input type="text" name="phone"/></div>
		</div>
		<div class="confi-div">
		<div  class="string">月薪</div>
		<div class="input-div"><input type="text" name="salary"/></div>
		</div>
		<button type="submit"> 增加</button>
		<button class="back"  type="button" onclick="back()">返回</button>
	</form></div>
	</div></div>

</body>
</html>