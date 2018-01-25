package com.manager.servlet;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manager.beans.Sale;
import com.manager.beans.User;
import com.manager.service.SaleService;

@WebServlet("/addSaleServlet")
public class addSaleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       SaleService bs = new SaleService();
       

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
		
		Sale sale = new Sale();
		sale.setCustomer(customer);
		sale.setDate(date);
		sale.setGoods(goods);
		sale.setMoney(money);
		sale.setRemarks(remarks);
		sale.setWeigh_money(weigh_money);
		sale.setWeight(weight);
		sale.setUser_id(user.getId());
		
		bs.insertSale(sale);
		
		
		response.sendRedirect("ShowSaleServlet");
	}

}
