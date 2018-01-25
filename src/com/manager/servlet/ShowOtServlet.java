package com.manager.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manager.beans.Ot;
import com.manager.beans.Staff;
import com.manager.service.OtService;
import com.manager.service.StaffService;

@WebServlet("/ShowOtServlet")
public class ShowOtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	OtService os = new OtService();
	StaffService ss = new StaffService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�õ�Ա��id����session��
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
		
		//����Ա��id�õ��Ӱ��б�
		List<Ot> ots = os.getOtsBySid(sid);
		//����Ա��id�õ�Ա������
		Staff s = ss.getStaffBySid(sid);
		String sname = s.getName();
		//���Ӱ��б��������
		request.setAttribute("otList", ots);
	
		//��Ա�����ַ�������
		request.setAttribute("staffname", sname);
		
		request.getRequestDispatcher("staff-ot.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
