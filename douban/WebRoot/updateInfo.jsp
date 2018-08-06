<%@ page language="java" import="java.util.*,com.neu.cxl.Entity.User" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
  <head>
    <title>publishreview.html</title>
	<meta charset="utf-8">
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=UTF-8">
    
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->

  </head>
  <style>
  #div1{backgroung:url("images/img01.jpg");width:60px;height:60px;border-radius:100px; overflow:hidden}
  #div1 img{width:100%;height:100%}
  </style>
  <body>

   <div class=“div1‘”>
 	用户资料修改
  </div>
  <form action="UpdateUserInfoServlet" enctype="multipart/form-data" method="post">
  用户头像：
  <div id="div1" >
	<img src="${sessionScope.user.getIcon()}"  />
	</div>
  
  <input type="file" name="icon" value="更改"><br>
  <input type="hidden" name="username" value="${sessionScope.user.getUserName()}"><br>
     用户名：<input type="text" name="username" disabled="disabled" value="${sessionScope.user.getUserName()}"><br>
  	密码：<input type="text" name="password" value="${sessionScope.user.getPassword()}"><br>
  	性别：<input type="text" name="sex" value="${sessionScope.user.getSex()}"><br>
  	年龄：<input type="text" name="age" value="${sessionScope.user.getAge()}"><br>
  	手机：<input type="text" name="phone" value="${sessionScope.user.getPhone()}"><br>
  	邮箱：<input type="email" name="email" value="${sessionScope.user.getEmail()}"><br>
  	个人简介：<textarea name="introduction" >${sessionScope.user.getIntroduction()}</textarea>
   <input type="submit" value="提交" align="left">
</form>

  </body>
</html>
