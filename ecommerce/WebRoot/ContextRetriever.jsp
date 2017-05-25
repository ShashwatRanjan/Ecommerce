<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ContextRetrieverJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<!-- html style Comment (view html comments only in view source because server sends response only in html format-->
<%--jsp style comment(cant view source wont be visible --%>
<%--In jsp we have some implicit objects example
request,response,config,application,out(directly used) --%>
<%String dburl = (String)application.getAttribute("dburl"); %>
  </head>
  
  <body>
    This is my JSP page. <br>
  </body>
</html>
