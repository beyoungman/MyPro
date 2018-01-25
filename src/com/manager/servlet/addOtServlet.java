package com.manager.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manager.beans.Ot;
import com.manager.service.OtService;

@WebServlet("/addOtServlet")
public class addOtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	OtService os = new OtService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sid = Integer.parseInt(request.getParameter("sid"));
		Date date = Date.valueOf(request.getParameter("date"));
		Float hours =Float.parseFloat(request.getParameter("hours"));
		int money = Integer.parseInt(request.getParameter("money"));
		
		Ot ot = new Ot();
		ot.setDate(date);
		ot.setHours(hours);
		ot.setMoney(money);
		ot.setSid(sid);
		int i = os.addOt(ot);
		if(i==1){
			response.sendRedirect("ShowOtServlet");
		}
	}

}
