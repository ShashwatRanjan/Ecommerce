<!doctype html>
<%@page import="member.MemberBO"%>
<html><!-- InstanceBegin template="/Templates/Layout.dwt.jsp" codeOutsideHTMLIsLocked="false" -->
<head>
<meta charset="UTF-8">
<!-- InstanceBeginEditable name="doctitle" -->
<title>Untitled Document</title>
<!-- InstanceEndEditable -->
<link href="style.css" rel="stylesheet" type="text/css">
<!-- InstanceBeginEditable name="head" -->
<!-- InstanceEndEditable -->
</head>

<body>
<div id="mainback">Content for  id "mainback" Goes Here
  <div id="header">Visakhas Blog</div>
  <div id="menu">Content for  id "menu" Goes Here</div>
  <div id="content"><!-- InstanceBeginEditable name="contentedit" -->
  
  <!-- jsp action elements are to be used to integrate this jsp page with the java bean -->
  
  <!--  -->Important : below line-->
 <jsp:useBean id="memberFormBean" class="member.MemberForm"></jsp:useBean>
 
 <!-- the above line creates an object of the register bean which is a class and we can refer that object through the id memberBean-->
  
  <!--  * means all properties will be set and all the setter methods will be called -->
  <jsp:setProperty property="*" name="memberFormBean"/>
  
  <jsp:useBean id="memberBOBean" class="member.MemberBO"></jsp:useBean>
  <%memberBOBean.setContext(application); 
  String result = memberBOBean.insertMember(memberFormBean);
  
  %>
  
  <%=result %>
  
  
 
</div>
</body>
<!-- InstanceEnd --></html>
