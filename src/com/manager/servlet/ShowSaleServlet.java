package com.manager.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manager.beans.Buy;
import com.manager.beans.Sale;
import com.manager.beans.User;
import com.manager.service.SaleService;
import com.manager.tools.PageHelper;

@WebServlet("/ShowSaleServlet")
public class ShowSaleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PageHelper sph = new PageHelper();
	SaleService ss = new SaleService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		int userid = user.getId();

		//设置当前页
		if(null!=request.getParameter("page")){
			int page = Integer.parseInt(request.getParameter("page"));
			sph.setPage(page);
		}else if(null!=request.getParameter("next")){
			sph.nextPage();
		}else if(null!=request.getParameter("last")){
			sph.lastPage();
		}
		
		//得到全部sale记录数，设置最大记录数
		sph.setMaxCout(ss.selectSaleBySid(userid).size());
		//得到最大页数
		sph.setMaxPage();
		
		List<Sale> sales = ss.selectSaleBySidLimit(userid,sph);
		
		request.setAttribute("sales", sales);
		request.setAttribute("SalePageHelper", sph);
		request.getRequestDispatcher("sale.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
