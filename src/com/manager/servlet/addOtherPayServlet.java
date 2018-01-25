package com.manager.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manager.beans.OtherPay;
import com.manager.beans.User;
import com.manager.service.OtherPayService;

@WebServlet("/addOtherPayServlet")
public class addOtherPayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	OtherPayService ops = new OtherPayService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		int id = user.getId();
		
		Date date=Date.valueOf(request.getParameter("date"));
		String payfor = new String(request.getParameter("payfor").getBytes("iso8859-1"),"utf-8");
		Float money = Float.parseFloat(request.getParameter("money"));
		
		OtherPay op = new OtherPay();
		op.setDate(date);
		op.setMoney(money);
		op.setPayFor(payfor);
		op.setUser_id(id);
		
		ops.insertOtherPay(op);
		
		response.sendRedirect("ShowOtherPayServlet");
		
	}

}
