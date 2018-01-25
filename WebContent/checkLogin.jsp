<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    	<!-- 检查登录 -->
<%
	if(session.getAttribute("user")==null){
	response.sendRedirect("index.html");
}
%>