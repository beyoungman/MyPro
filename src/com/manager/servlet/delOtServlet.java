package com.manager.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manager.service.OtService;

@WebServlet("/delOtServlet")
public class delOtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	OtService os = new OtService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int oid = Integer.parseInt(request.getParameter("oid"));
		//int sid = Integer.parseInt(request.getParameter("sid"));
		int i = os.delOtByOid(oid);
		if(i==1){
			response.sendRedirect("ShowOtServlet");
		}else{
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
