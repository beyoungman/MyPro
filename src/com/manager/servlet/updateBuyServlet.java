package com.manager.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manager.beans.Buy;
import com.manager.service.BuyService;

@WebServlet("/updateBuyServlet")
public class updateBuyServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	BuyService bs = new BuyService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int buy_id = Integer.parseInt(request.getParameter("buy_id"));
		Date date =Date.valueOf(request.getParameter("date"));
		String customer = new String(request.getParameter("customer").getBytes("iso8859-1"),"utf-8");
		String goods =new String(request.getParameter("goods").getBytes("iso8859-1"),"utf-8");
		int weight = Integer.parseInt(request.getParameter("weight"));
		int weigh_money = Integer.parseInt(request.getParameter("weigh_money"));
		int money= Integer.parseInt(request.getParameter("money"));
		String remarks = new String(request.getParameter("remarks").getBytes("iso8859-1"),"utf-8");
		
		Buy buy = new Buy();
		buy.setBuy_id(buy_id);
		buy.setCustomer(customer);
		buy.setDate(date);
		buy.setGoods(goods);
		buy.setMoney(money);
		buy.setRemarks(remarks);
		buy.setWeigh_money(weigh_money);
		buy.setWeight(weight);
		
		int i = bs.updateBuy(buy);
		if(i==1){
			response.sendRedirect("ShowBuyServlet");
		}else{
			response.sendRedirect("ShowBuyServlet");
			response.getWriter().print("<script charset='utf-8'>alert('ÐÞ¸ÄÊ§°Ü£¡');</script>");
		}
	}

}
