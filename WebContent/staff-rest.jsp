<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>员工休息详细页面</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="css/staff-ot.css">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<script type="text/javascript" src="js/jquery.min.js">
</script>
<script type="text/javascript">

	$().ready(function (){
		var tolM =0;
		 $(".bmoney").each(function(){
			tolM = tolM + parseInt($(this).attr("value"));
	    });
		$(".totolM").text(tolM);
	}); 

</script>
<body>

	<!-- 检查登录 -->
	<jsp:include page="checkLogin.jsp"/>

<div class="centianer">
	<div class="inc-div"><jsp:include page="admin.jsp"/></div>
	<div class="con-div">
	<div>
			<div class="col-md-8 column">
					<h3 align="center">
						员工休息详细
					</h3>
					<table class="table">
						<thead>
							<tr>
								<th>
									编号
								</th>
								<th>
									姓名
								</th>
								<th>
									日期
								</th>
								
								<th>
									休息(天)
								</th>
								<th>
									操作
								</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach var="bm" items="${requestScope.RestList}">
							<tr>
							<form action="updateRestServlet" method="POST">
								<td>
									<input type="text"  value="${bm.getRid()}" name="rid">
									<input type="hidden" value="${sid}" name="sid">
								</td>
								<td>
									<c:out value="${requestScope.staffname}"/>
								</td>
								<td>
									<input type="text"  value="${bm.getDate()}" name="date">
								</td>
								<td>
									<input type="text" class="bmoney" value="${bm.getDays()}" name="days">
								</td>
								<td >
									<input type="submit" value="修改"><a href="delRestServlet?rid=${bm.getRid()}">删除</a>
								</td>
							</form>
							</tr>
							</c:forEach>
						</tbody>
						<tfoot>
							  <tr><td>
									<b style="font-size:17px;">总计</b>
								</td>
								<td>
									
								</td>
								<td>
									
								</td>
								<td>
									<b  class="totolM" style="font-size:17px;"></b>
								</td>
								<td>
									
								</td>
								</tr>
						</tfoot>
					</table>
					<div><a href="rest-new.jsp?sid=${sid}">新增</a>&nbsp;&nbsp;&nbsp;<a href="ShowStaffServlet">返回</a></div>
				
				</div>
				<div class="col-md-4 column"></div>
	</div>
	</div>
</div>
</body>
</html>