package com.manager.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manager.beans.Rest;
import com.manager.service.RestService;

@WebServlet("/addRestServlet")
public class addRestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RestService rs = new RestService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sid = Integer.parseInt(request.getParameter("sid"));
		Date date = Date.valueOf(request.getParameter("date"));
		int days = Integer.parseInt(request.getParameter("days"));
		
		Rest re = new Rest();
		re.setDate(date);
		re.setDays(days);
		re.setSid(sid);
		int i = rs.addRest(re);
		if(i==1){
			response.sendRedirect("ShowRestServlet");
		}
	}

}
