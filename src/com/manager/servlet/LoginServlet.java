package com.manager.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manager.beans.User;
import com.manager.service.UserService;
/*
 * ��¼����
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	UserService userService = new UserService();
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		boolean b = userService.checkLogin(phone,password);
		
		
		if(b){
			//��¼�ɹ�
			HttpSession session = request.getSession();
			User user = userService.selectUserByPhone(phone);
			session.setAttribute("user", user);
			response.sendRedirect("admin.jsp");
		}else{
			//��¼ʧ��
			response.getWriter().print("��֤ʧ�ܣ�����������");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			response.sendRedirect("index.html");
		}
	}

}
