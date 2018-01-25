<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户资料</title>
</head>
<body>

	<!-- 检查登录 -->
	<jsp:include page="checkLogin.jsp"/>

	<jsp:include page="admin.jsp"></jsp:include>
	<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<h3 class="text-center">
				${user.getName()}的资料
			</h3>
			<div class="row clearfix">
				<div class="col-md-4 column">
				</div>
				<div class="col-md-4 column">
					<ul>
						<li>
							<b>你的员工：</b>${sts}&nbsp;人
						</li>
						<li>
							<b>你收货总次数：</b>${totolBuy}&nbsp;次
						</li>
						<li>
							<b>你卖货总次数：</b>${totolSale}&nbsp;次
						</li>
						<li>
							<b>你收货总重量：</b>${totolBuyWeight}&nbsp;公斤
						</li>
						<li>
							<b>你卖货总重量：</b>${totolSaleWeight}&nbsp;公斤
						</li>
						<li>
							<b>你收货总支出：</b>${totolBuyMoney}&nbsp;元
						</li>
						<li>
							<b>你卖货总收入：</b>${totolSaleMoney}&nbsp;元
						</li>
						<li>
							<b>你磅费总支出：</b>${totolWeigh_Money}&nbsp;元
						</li>
						<li>
							<b>你其他总支出：</b>${totolOtherPay}&nbsp;元
						</li>
					</ul>
				</div>
				<div class="col-md-4 column">
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>