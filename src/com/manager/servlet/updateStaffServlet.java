package com.manager.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manager.beans.Staff;
import com.manager.service.StaffService;

@WebServlet("/updateStaffServlet")
public class updateStaffServlet extends HttpServlet {
	StaffService ss = new StaffService();
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sid = Integer.parseInt(request.getParameter("sid"));
		String sname = request.getParameter("name");
		String name = new String(sname.getBytes("iso8859-1"),"utf-8");
		String idNum = request.getParameter("idNum");
		String phone = request.getParameter("phone");
		int salary = Integer.parseInt(request.getParameter("salary"));
		Staff s = new Staff(sid,name,idNum,phone,salary);
		int upd = ss.updateStaff(s);
		if(upd==1){
			 response.getWriter().print("<script>alert('更新成功！')</script>");
			 response.sendRedirect("staff-conf.jsp");
		}else{
			response.getWriter().print("<script>alert('更新失败！')</script>");
			response.sendRedirect("staff-conf.jsp");
		}
	}

}
