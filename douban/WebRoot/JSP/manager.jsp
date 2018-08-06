<%@ page language="java" import="java.util.*,com.neu.cxl.Entity.User" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'manager.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  
 	<%
		User user=(User)session.getAttribute("user");
		if(!("管理员".equals((String)user.getRole())))
		{
			out.println("您还没有登录，请先登录！<br>");
			out.println("3秒后跳转到登录页面...<br>");
			response.setHeader("Refresh","3;URL=../login.html"); 

			out.println("如果没有跳转，请点击<a href='login.html'>这里</a>跳转！");
			
		}
		else {
		%>
		 <br>
		 <center>
		 	<h3>欢迎管理员${sessionScope.user.getUserName()}登录！</h3>
			  <a href="UserManageServlet" >用户管理</a><br>
			   <a href="JSP/movieManage.jsp">电影管理</a><br>
			   <a href="RemoveServlet">退出</a>
			 <center>	
		<%}%>
 

   
  </body>
</html>
