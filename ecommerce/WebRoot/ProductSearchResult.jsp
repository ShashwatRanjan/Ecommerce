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
    
    <title>My JSP 'ProductSearchResult.jsp' starting page</title>
    
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
   	<jsp:useBean id="productBOBean" class="product.ProductBO"></jsp:useBean>
     <%
     
     productBOBean.setContext(application);
     ArrayList al = productBOBean.searchProductByKey(request.getParameter("key")); 
     Iterator ir = al.iterator();
     
     %>
     <table>
     <tr><td>Picture</td><td>Title</td><td>Price</td></tr>
     <%
     while(ir.hasNext())
     {
     	ProductDTO pdto=(ProductDTO)ir.next();
      %>
      <tr><td><img src="image/product/<%=pdto.getPicture1() %>"  width="200" height="200"></td><td><a href="ProductDetail.jsp?pid=<%=pdto.getProductid()%>"><%=pdto.getTitle() %></a></td><td><%=pdto.getPrice() %></td></tr>
      
      <%} %>
     </table>
  </body>
</html>
