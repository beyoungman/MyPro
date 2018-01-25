package com.manager.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manager.service.StaffService;

@WebServlet("/delStaffServlet")
public class delStaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	StaffService ss = new StaffService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ssid = request.getParameter("sid");
		int sid = Integer.parseInt(ssid);
		boolean b=ss.removeStaffBySid(sid);
		if(b){
			response.sendRedirect("ShowStaffServlet");
		}else{
			response.getWriter().print("<h1 color='red'>É¾³ýÊ§°Ü£¡</h1>");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			response.sendRedirect("staff.jsp");
		}
	}


}
