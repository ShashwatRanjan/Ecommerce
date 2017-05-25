<%@page import="product.ProductDTO"%>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ProductDetail.jsp' starting page</title>
    
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
    <jsp:useBean id="ProductBoBean" class="product.ProductBO"> </jsp:useBean>
    <%ProductBoBean.setContext(application);
    String pid = request.getParameter("pid");
    
   ProductDTO pdto = ProductBoBean.searchProductById(pid);
   
    %>
    <table border="1" align="center">
    <tr><td><img src="image/product/<%=pdto.getPicture1() %>"  width="200" height="200"></td></tr>
      <tr><td><a href="ProdutDetails.jsp?pid=<%=pdto.getProductid()%>"><%=pdto.getTitle() %></a></td></tr>
      <tr><td><%=pdto.getPrice() %></td></tr>
     <tr><td><textarea ><%=pdto.getDescription() %></textarea></td></tr>
     <tr><td><a href="member/addtoCart.jsp?pid=<%=pdto.getProductid()%>"><input type="button" value="Add to Cart"/></</a></td></tr>
     
     </table>
  </body>
</html>
