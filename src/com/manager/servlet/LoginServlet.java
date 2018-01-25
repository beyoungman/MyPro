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
 * 登录检验
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
			//登录成功
			HttpSession session = request.getSession();
			User user = userService.selectUserByPhone(phone);
			session.setAttribute("user", user);
			response.sendRedirect("admin.jsp");
		}else{
			//登录失败
			response.getWriter().print("验证失败，请重新输入");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			response.sendRedirect("index.html");
		}
	}

}
