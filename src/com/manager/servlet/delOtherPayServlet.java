package com.manager.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manager.service.OtherPayService;

@WebServlet("/delOtherPayServlet")
public class delOtherPayServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	OtherPayService ops = new OtherPayService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id= Integer.parseInt(request.getParameter("opid"));
		ops.deleteOtherPayById(id);
		response.sendRedirect("ShowOtherPayServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
