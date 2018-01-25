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
import com.manager.beans.Sale;
import com.manager.beans.Staff;
import com.manager.beans.User;
import com.manager.service.BuyService;
import com.manager.service.OtherPayService;
import com.manager.service.SaleService;
import com.manager.service.StaffService;

/*
 * 查询用户信息
 */
@WebServlet("/UserConfServlet")
public class UserConfServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	BuyService bs = new BuyService();
	SaleService ss = new SaleService();
	OtherPayService ops = new OtherPayService();
	StaffService sts = new StaffService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		int id = user.getId();
		List<Staff> staffs=null;
		//获取员工列表
		if(session.getAttribute("staffs")!=null)
			staffs = (List<Staff>) session.getAttribute("staffs");
		else {
			staffs = sts.getStaffsByUid(user.getId());
			session.setAttribute("staffs", staffs);
		}	
		//员工人数
		int sts=staffs.size();
		//收货记录总数
		List<Buy> buys = bs.selectBuyByUid(id);
		int totolBuy =buys.size();
		
		//卖货记录总数
		List<Sale> sales = ss.selectSaleBySid(id);
		int totolSale =sales.size();
		//收货总重量
		int totolBuyWeight = bs.selectTotolWeight(id);
		//卖货总重量
		int totolSaleWeight = ss.selectTotolWeight(id);
		//收货总支出
		int totolBuyMoney = bs.selectTotolMoney(id);
		//卖货货收入
		int totolSaleMoney = ss.selectTotolMoney(id);
		//磅费总支出
		int totolWeigh_Money = bs.selectTotolWeigh_Money(id);
		//其他支出总支出
		int totolOtherPay = ops.selectTotolMoney(id);
		
		request.setAttribute("sts",sts );
		request.setAttribute("totolBuy",totolBuy );
		request.setAttribute("totolSale", totolSale);
		request.setAttribute("totolBuyWeight",totolBuyWeight );
		request.setAttribute("totolSaleWeight",totolSaleWeight );
		request.setAttribute("totolBuyMoney",totolBuyMoney );
		request.setAttribute("totolSaleMoney", totolSaleMoney);
		request.setAttribute("totolWeigh_Money",totolWeigh_Money );
		request.setAttribute("totolOtherPay",totolOtherPay );
		//请求转发
		request.getRequestDispatcher("user-conf.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
