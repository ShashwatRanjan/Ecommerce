<!doctype html>
<html><!-- InstanceBegin template="/Templates/Layout.dwt.jsp" codeOutsideHTMLIsLocked="false" -->
<head>
<meta charset="UTF-8">
<!-- InstanceBeginEditable name="doctitle" -->
<title>Untitled Document</title>
<!-- InstanceEndEditable -->
<link href="../style.css" rel="stylesheet" type="text/css">
<!-- InstanceBeginEditable name="head" -->
<!-- InstanceEndEditable -->
</head>

<body>
<div id="mainback">Content for  id "mainback" Goes Here
  <div id="header">Visakhas Blog</div>
  <div id="menu">Content for  id "menu" Goes Here</div>
  <div id="content"><!-- InstanceBeginEditable name="contentedit" -->
  
  <jsp:useBean id="ProductBOBean" class="product.ProductBO"></jsp:useBean>
  
  <%
  ProductBOBean.setContext(application);//we are sending the ServletContext obj from jsp to bean
  //becaus ethe ServletContext has attributes that holds dburl,dbuname,dbpassword that we need to
  //get database connection
  ProductBOBean.insertProduct(request);//we are sending the entire request object..  this is good bcos
  //the request obj holds all the parameters and the files....
  %>
  
  
  
  
  <!-- InstanceEndEditable --></div>
  
 
</div>
</body>
<!-- InstanceEnd --></html>
