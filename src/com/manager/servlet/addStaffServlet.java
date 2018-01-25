package com.manager.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manager.beans.Staff;
import com.manager.beans.User;
import com.manager.service.StaffService;

@WebServlet("/addStaffServlet")
public class addStaffServlet extends HttpServlet {
	
	StaffService ss = new StaffService();
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sname = request.getParameter("name");
		String name = new String(sname.getBytes("ISO8859-1"),"utf-8");
		String phone = request.getParameter("phone");
		String idNum = request.getParameter("idNum");
		String ssalary = request.getParameter("salary");
		int salary=Integer.parseInt(ssalary);
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		Staff s = new Staff();
		s.setName(name);
		s.setPhone(phone);
		s.setIdNum(idNum);
		s.setSalary(salary);
		boolean b= ss.addStaff(s,user.getId());
		if(b){
			response.sendRedirect("ShowStaffServlet");
		}else{
			PrintWriter out = response.getWriter();
			out.print("<h1>Ôö¼ÓÊ§°Ü£¡</h1>");
		}
	}

}
