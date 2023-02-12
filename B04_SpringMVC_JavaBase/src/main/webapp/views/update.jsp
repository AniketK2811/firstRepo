<%@page import="com.cjc.app.model.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome To The Update page</h1>

 <% Product p=(Product)	request.getAttribute("data");%> 
 <div align="center">
 <form action="update">
 <label>Product ID :</label><%=p.getPid()%>
 
 <input type="hidden" name="pid" value="<%=p.getPid()%>"><br>
 <label>Product Name :</label>
 <input type="text" name="pname"  value="<%=p.getPname()%>"><br>
 <label>Product price :</label>
 <input type="text" name="price" value="<%=p.getPrice()%>"><br>
 <input type="submit" value="SUBMIT">
 </form>
 </div>
</body>
</html>