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
 * ��ѯ�û���Ϣ
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
		//��ȡԱ���б�
		if(session.getAttribute("staffs")!=null)
			staffs = (List<Staff>) session.getAttribute("staffs");
		else {
			staffs = sts.getStaffsByUid(user.getId());
			session.setAttribute("staffs", staffs);
		}	
		//Ա������
		int sts=staffs.size();
		//�ջ���¼����
		List<Buy> buys = bs.selectBuyByUid(id);
		int totolBuy =buys.size();
		
		//������¼����
		List<Sale> sales = ss.selectSaleBySid(id);
		int totolSale =sales.size();
		//�ջ�������
		int totolBuyWeight = bs.selectTotolWeight(id);
		//����������
		int totolSaleWeight = ss.selectTotolWeight(id);
		//�ջ���֧��
		int totolBuyMoney = bs.selectTotolMoney(id);
		//����������
		int totolSaleMoney = ss.selectTotolMoney(id);
		//������֧��
		int totolWeigh_Money = bs.selectTotolWeigh_Money(id);
		//����֧����֧��
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
		//����ת��
		request.getRequestDispatcher("user-conf.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
