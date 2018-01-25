package com.manager.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manager.beans.Staff;
import com.manager.service.StaffService;
/*
 * 查询员工信息
 */
@WebServlet("/StaffConfServlet")
public class StaffConfServlet extends HttpServlet {
	StaffService ss = new StaffService();
	
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sid = Integer.parseInt(request.getParameter("sid"));
		Staff staff=ss.getStaffBySid(sid);
		float allOtHours = ss.getAllOtHours(sid);
		float allRestDays = ss.getAllRestDays(sid);
		
		request.setAttribute("allOtHours", allOtHours);
		request.setAttribute("allRestDays", allRestDays);
		request.setAttribute("sid", sid);
		request.setAttribute("name", staff.getName());
		request.setAttribute("idNum", staff.getIdNum());
		request.setAttribute("phone", staff.getPhone());
		request.setAttribute("salary", staff.getSalary());
		request.getRequestDispatcher("staff-conf.jsp").forward(request, response);
	}

}
