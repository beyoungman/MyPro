package com.manager.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Test;

import com.manager.beans.Buy;
import com.manager.beans.User;
import com.manager.service.BuyService;
import com.manager.tools.PageHelper;

@WebServlet("/ShowBuyServlet")
public class ShowBuyServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	BuyService bs = new BuyService();
	PageHelper bph = new PageHelper();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		int userid = user.getId();
		
		//���õ�ǰҳ
		if(null!=request.getParameter("page")){
			int page = Integer.parseInt(request.getParameter("page"));
			bph.setPage(page);
		}else if(null!=request.getParameter("next")){
			bph.nextPage();
		}else if(null!=request.getParameter("last")){
			bph.lastPage();
		}
		
		//�õ�ȫ��buy��¼������������¼��
		bph.setMaxCout(bs.selectBuyByUid(userid).size());
		//�õ����ҳ��
		bph.setMaxPage();
		//��ҳȡ��
		List<Buy> buys = bs.selectBuyByUidLimit(userid,bph);
		
		request.setAttribute("buys", buys);
		request.setAttribute("BuyPageHepler", bph);
		request.getRequestDispatcher("buy.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
