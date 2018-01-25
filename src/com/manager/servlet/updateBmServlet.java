package com.manager.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manager.beans.Bmoney;
import com.manager.service.BmService;

@WebServlet("/updateBmServlet")
public class updateBmServlet extends HttpServlet {
	
	BmService os = new BmService();
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strdate = request.getParameter("date");
		Date date = Date.valueOf(strdate);
		int money = Integer.parseInt(request.getParameter("money"));
		int bid = Integer.parseInt(request.getParameter("bid"));
		int sid =(int)request.getSession().getAttribute("sid");
		Bmoney bm = new Bmoney(bid,date,money,sid);
		int i =os.updateBm(bm);
		if(i==1){
			response.getWriter().print("<script>window.history.back(-1);</script>");
		}
		
		
		
	}

}
