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
    <form action="productUploadResult.jsp" method="post" enctype="multipart/form-data" id="form1">
      <table width="200" border="1" align="center">
        <tr>
          <td>Category</td>
          <td><select name="catid" id="catid">
              <option value="toy">toy</option>
              <option value="book">book</option>
          </select></td>
        </tr>
        <tr>
          <td>SubCategory</td>
          <td><select name="subcatid" id="subcatid">
              <option value="novel">novel</option>
              <option value="fiction">fiction</option>
              <option value="softtoy">softtoy</option>
              <option value="puzzles">puzzles</option>
          </select></td>
        </tr>
        <tr>
          <td>Title</td>
          <td><input type="text" name="title" id="title"></td>
        </tr>
        <tr>
          <td>Description</td>
          <td><textarea name="description" id="description"></textarea></td>
        </tr>
        <tr>
          <td>Price</td>
          <td><input type="text" name="price" id="price"></td>
        </tr>
        <tr>
          <td>Picture 1</td>
          <td><input type="file" name="picture1" id="picture1"></td>
        </tr>
        <tr>
           <td>Picture 2</td>
          <td><input type="file" name="picture2" id="picture2"></td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td><input type="submit" name="submit" id="submit" value="Submit"></td>
        </tr>
      </table>
    </form>
  <!-- InstanceEndEditable --></div>
  
 
</div>
</body>
<!-- InstanceEnd --></html>
