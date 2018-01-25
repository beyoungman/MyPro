<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.manager.beans.*" import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>员工管理页面</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="css/staff.css">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
</head>
<script src="js/jquery.min.js"></script>
<script charset="UTF-8" language="javascript" type="text/javascript"  src="js/staff.js" >
</script>
<body>

	<!-- 检查登录 -->
	<jsp:include page="checkLogin.jsp"/>

<jsp:include page="admin.jsp"/>

<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="row clearfix">
				<div id="staff-div"class="col-md-3 column">
					<h3 style="color:white;">
						员工列表
					</h3>
					<ul id='accordion' class='accordion'>
					<%
					List <Staff> staffs = (List<Staff>)session.getAttribute("staffs");
					for(int i=0; i<staffs.size();i++){
						Staff staff = staffs.get(i);
						out.print("<ul>");
						out.print("<div class='link'><a>"+staff.getName()+"</a></div>");
						out.print("<ul class='submenu'>");
						out.print("<a href='StaffConfServlet?sid="+staff.getSid()+"'>员工资料</a>");
						out.print("<a href='ShowOtServlet?sid="+staff.getSid()+"'>加班</a>");
						out.print("<a href='ShowBmServlet?sid="+staff.getSid()+"'>借支</a>");
						out.print("<a href='ShowRestServlet?sid="+staff.getSid()+"'>休息</a>");
						out.print("<a class='delstaff' href='delStaffServlet?sid="+staff.getSid()+"' onclick='return delstaff()'> 删除员工</a>");
						out.print("</ul></ul>");
							}%>
					</ul>
					<div><a class="newstaff" href="staff-new.jsp">新增员工 </a></div>
				</div>
				<div id="content" class="col-md-7 column">
					
				</div>
				<div class="col-md-2 column">
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>