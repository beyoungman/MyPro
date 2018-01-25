package com.manager.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manager.beans.Ot;
import com.manager.service.OtService;

@WebServlet("/updateOtServlet")
public class updateOtServlet extends HttpServlet {
	
	OtService os = new OtService();
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strdate = request.getParameter("date");
		Date date = Date.valueOf(strdate);
		int money = Integer.parseInt(request.getParameter("money"));
		int oid = Integer.parseInt(request.getParameter("oid"));
		
		float hours = Float.parseFloat(request.getParameter("hours"));
		
		Ot ot = new Ot();
		ot.setDate(date);
		ot.setHours(hours);ot.setMoney(money);ot.setOid(oid);
		int i =os.updateOt(ot);
		if(i==1){
			response.getWriter().print("<script>window.history.back(-1);</script>");
		}
		
		
	}

}
