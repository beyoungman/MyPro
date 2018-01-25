package com.manager.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manager.beans.Staff;
import com.manager.beans.User;
import com.manager.service.StaffService;

@WebServlet("/ShowStaffServlet")
public class ShowStaffServlet extends HttpServlet {
	
	StaffService ss = new StaffService();
	
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		//根据ID查找员工列表
		List<Staff> staffs=null;
		
		if(session.getAttribute("staffs")!=null)
			staffs = (List<Staff>) session.getAttribute("staffs");
		else {
			staffs = ss.getStaffsByUid(user.getId());
			session.setAttribute("staffs", staffs);
		}	
		user.setStaffs(staffs);
		
		//List放入session之中传递
		session.setAttribute("staffs", staffs);
		session.setAttribute("user", user);
		
		request.getRequestDispatcher("staff.jsp").forward(request,response);
	}

}
