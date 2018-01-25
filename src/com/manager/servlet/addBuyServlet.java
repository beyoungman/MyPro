package com.manager.servlet;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manager.beans.Buy;
import com.manager.beans.User;
import com.manager.service.BuyService;

@WebServlet("/addBuyServlet")
public class addBuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       BuyService bs = new BuyService();
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strdate =request.getParameter("date");
		Date date= Date.valueOf(strdate);
		
		String customer= new String(request.getParameter("customer").getBytes("iso8859-1"),"utf-8");
		String goods = new String(request.getParameter("goods").getBytes("iso8859-1"),"utf-8");
		int weight= Integer.parseInt(request.getParameter("weight"));
		int weigh_money=Integer.parseInt(request.getParameter("weigh_money"));
		int money= Integer.parseInt(request.getParameter("money"));
		String remarks= new String(request.getParameter("remarks").getBytes("iso8859-1"),"utf-8");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		Buy buy = new Buy();
		buy.setCustomer(customer);
		buy.setDate(date);
		buy.setGoods(goods);
		buy.setMoney(money);
		buy.setRemarks(remarks);
		buy.setWeigh_money(weigh_money);
		buy.setWeight(weight);
		buy.setUser_id(user.getId());
		
		int i = bs.insertBuy(buy);
		if(i==1){
			response.getWriter().print("<script charset='utf-8'>alert('增加成功！');</script>");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			response.sendRedirect("ShowBuyServlet");
		}else{
			response.getWriter().print("<script charset='utf-8'>alert('增加失败！');</script>");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			response.sendRedirect("ShowBuyServlet");
		}
	}

}
