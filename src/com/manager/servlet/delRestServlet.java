package com.manager.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manager.service.RestService;

@WebServlet("/delRestServlet")
public class delRestServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	RestService rs = new RestService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rid = Integer.parseInt(request.getParameter("rid"));
		//int sid = Integer.parseInt(request.getParameter("sid"));
		int i = rs.delRestByRid(rid);
		if(i==1){
			response.sendRedirect("ShowRestServlet");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
