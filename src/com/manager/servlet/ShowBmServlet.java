package com.manager.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manager.beans.Bmoney;
import com.manager.beans.Staff;
import com.manager.service.BmService;
import com.manager.service.StaffService;

@WebServlet("/ShowBmServlet")
public class ShowBmServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	BmService bs = new BmService();
	StaffService ss = new StaffService();
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int sid;
		if(request.getParameter("sid")!=null){
			sid= Integer.parseInt(request.getParameter("sid"));
		}else
		{
			sid = (int) session.getAttribute("sid");
		}
		if(session.getAttribute("sid")!=null)
			session.removeAttribute("sid");
		session.setAttribute("sid", sid);
		
		List<Bmoney> bms = bs.selectBmBySid(sid);
		
		Staff s = ss.getStaffBySid(sid);
		String sname = s.getName();
		//将借支列表放入域中
		request.setAttribute("bmList", bms);
	
		//将员工名字放入域中
		request.setAttribute("staffname", sname);
		
		request.getRequestDispatcher("staff-bm.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
