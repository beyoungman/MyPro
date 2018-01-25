package com.manager.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manager.service.BuyService;

@WebServlet("/delBuyServlet")
public class delBuyServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	BuyService bs = new BuyService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int buy_id = Integer.parseInt(request.getParameter("buy_id"));
		int i = bs.delBuybyBuyid(buy_id);
		response.sendRedirect("ShowBuyServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
