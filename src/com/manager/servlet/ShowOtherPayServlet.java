package com.manager.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manager.beans.OtherPay;
import com.manager.beans.User;
import com.manager.service.OtherPayService;
import com.manager.tools.PageHelper;

@WebServlet("/ShowOtherPayServlet")
public class ShowOtherPayServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	OtherPayService ops = new OtherPayService();
	
	PageHelper oph = new PageHelper();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		int id = user.getId();
		
		//���õ�ǰҳ
		if(null!=request.getParameter("page")){
			int page = Integer.parseInt(request.getParameter("page"));
			oph.setPage(page);
		}else if(null!=request.getParameter("next")){
			oph.nextPage();
		}else if(null!=request.getParameter("last")){
			oph.lastPage();
		}
		
		//ʹ�÷�ҳǰ��Ҫ�õ�ȫ��buy��¼������������¼��
		oph.setMaxCout(ops.selectAllOtherPayByUid(id));
		//�õ����ҳ��
		oph.setMaxPage();
		//��ҳȡ��
		List<OtherPay> op= ops.selectOtherPayByUid(id,oph);
		
		request.setAttribute("otherPays", op);
		request.setAttribute("OtherPayPageHepler", oph);
		request.getRequestDispatcher("otherPay.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
