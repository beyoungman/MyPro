<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>其他支出</title>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
$().ready(function(){
	var isHid = true;
	$(".hidden_tr").hide();
	$(".new").on("click",function (){
		if(isHid){
			$(".hidden_tr").show();
			isHid=false;
		}else{
			$(".hidden_tr").hide();
			isHid=true;
		}
	});
});
</script>
</head>
<body>
	<jsp:include page="checkLogin.jsp"></jsp:include>
	<jsp:include page="admin.jsp"></jsp:include>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<div class="row clearfix">
					<div class="col-md-2 column"></div>
					<div class="col-md-8 column">
						<h3 align="center">支出详细</h3>
						
						<form action="addOtherPayServlet" method="POST">
							<table class="table">
								<thead>
									<tr>
										<th>编号</th>
										<th>时间</th>
										<th width="30%">支出原因</th>
										<th>支出金额（元）</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${otherPays }" var="otherPay">
									<tr>
										<td>${otherPay.getId()}</td>
										<td>${otherPay.getDate()}</td>
										<td width="30%">${otherPay.getPayFor()}</td>
										<td>${otherPay.getMoney()}</td>
										<td><a href="delOtherPayServlet?opid=${otherPay.getId()}">删除</a></td>
									</tr>
									</c:forEach>
									<tr class="hidden_tr">
									<td></td><td><input value="2018-01-01" type="text" name="date"></td>
									<td width="30%"><input type="text" name="payfor"></td>
									<td><input type="text" name="money"></td><td><input type="submit" value="增加"></td>
									</tr>
								</tbody>
							</table>
						</form>
							<div align="center"><button class="new" >新增</button></div>
					</div>
					<div class="col-md-2 column"></div>
					<div class="row clearfix">
				<div class="col-md-3 column">
				</div>
				<div class="col-md-8 column">
					<ul class="pagination">
						<li>
							 <a href="ShowOtherPayServlet?page=1">首页</a>
						</li>
						<li>
							 <a href="ShowOtherPayServlet?last=yes">上一页</a>
						</li>
						<li>
							 <a>当前页：${OtherPayPageHepler.getPage()}</a>
						</li>
						<c:forEach  var="page" begin="1" end="${OtherPayPageHepler.getMaxPage()}">
						<li>
							 <a href="ShowOtherPayServlet?page=${page}">${page}</a>
						</li>
						</c:forEach>
						<li>
							 <a href="ShowOtherPayServlet?next=yes">下一页</a>
						</li>
						<li>
							 <a href="ShowOtherPayServlet?page=${OtherPayPageHepler.getMaxPage()}">最后一页</a>
						</li>
					</ul>
				</div>
				<div class="col-md-1 column">
				</div>
			</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>