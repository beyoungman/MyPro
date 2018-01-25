package com.manager.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manager.beans.Buy;
import com.manager.beans.Sale;
import com.manager.service.BuyService;
import com.manager.service.SaleService;

@WebServlet("/updateSaleServlet")
public class updateSaleServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	SaleService ss = new SaleService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sale_id = Integer.parseInt(request.getParameter("sale_id"));
		Date date =Date.valueOf(request.getParameter("date"));
		String customer = new String(request.getParameter("customer").getBytes("iso8859-1"),"utf-8");
		String goods =new String(request.getParameter("goods").getBytes("iso8859-1"),"utf-8");
		int weight = Integer.parseInt(request.getParameter("weight"));
		int weigh_money = Integer.parseInt(request.getParameter("weigh_money"));
		int money= Integer.parseInt(request.getParameter("money"));
		String remarks = new String(request.getParameter("remarks").getBytes("iso8859-1"),"utf-8");
		
		Sale sale = new Sale();
		sale.setSale_id(sale_id);
		sale.setCustomer(customer);
		sale.setDate(date);
		sale.setGoods(goods);
		sale.setMoney(money);
		sale.setRemarks(remarks);
		sale.setWeigh_money(weigh_money);
		sale.setWeight(weight);
		
		ss.updateSale(sale);
		response.sendRedirect("ShowSaleServlet");
	}

}
