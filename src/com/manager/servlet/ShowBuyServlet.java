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
		
		//设置当前页
		if(null!=request.getParameter("page")){
			int page = Integer.parseInt(request.getParameter("page"));
			bph.setPage(page);
		}else if(null!=request.getParameter("next")){
			bph.nextPage();
		}else if(null!=request.getParameter("last")){
			bph.lastPage();
		}
		
		//得到全部buy记录数，设置最大记录数
		bph.setMaxCout(bs.selectBuyByUid(userid).size());
		//得到最大页数
		bph.setMaxPage();
		//分页取出
		List<Buy> buys = bs.selectBuyByUidLimit(userid,bph);
		
		request.setAttribute("buys", buys);
		request.setAttribute("BuyPageHepler", bph);
		request.getRequestDispatcher("buy.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
