package com.manager.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manager.beans.Bmoney;
import com.manager.beans.Ot;
import com.manager.service.BmService;
import com.manager.service.OtService;

@WebServlet("/addBmServlet")
public class addBmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BmService bs = new BmService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sid = Integer.parseInt(request.getParameter("sid"));
		Date date = Date.valueOf(request.getParameter("date"));
		int money = Integer.parseInt(request.getParameter("money"));
		
		Bmoney bm = new Bmoney();
		bm.setDate(date);
		bm.setMoney(money);
		bm.setSid(sid);
		int i = bs.addBm(bm);
		if(i==1){
			response.sendRedirect("ShowBmServlet");
		}
	}

}
