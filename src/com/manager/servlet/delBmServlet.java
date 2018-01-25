package com.manager.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manager.service.BmService;
import com.manager.service.OtService;

@WebServlet("/delBmServlet")
public class delBmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BmService bs = new BmService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bid = Integer.parseInt(request.getParameter("bid"));
		//int sid = Integer.parseInt(request.getParameter("sid"));
		int i = bs.delBmByBid(bid);
		if(i==1){
			response.sendRedirect("ShowBmServlet");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
