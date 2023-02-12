<%@page import="com.cjc.app.model.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">

	function addProduct() {
		alert("You are adding new Product");
		document.myForm.action="reg";
		document.myForm.submit();
	}
	
	function deleteProduct() {
		alert("You are deleting Product");
		document.myForm.action="delete";
		document.myForm.submit();
	}
	
	function editProduct() {
		alert("You are Editing Product");
		document.myForm.action="edit";
		document.myForm.submit();
	}
</script>
</head>
<body>
	<h1>Welcome To The success Page..</h1>
	<%List<Product> list=(List<Product>)request.getAttribute("data");%>
	<div align="center">
		<form name="myForm">
			<table border="2px">
				<thead>
					<tr>
						<th>SELECT</th>
						<th>Product ID</th>
						<th>Product Name</th>
						<th>Product Price</th>
					</tr>
				</thead>
				<tbody>
					<%for(Product p:list) {%>
					<tr>
						<td><input type="radio" name="pid"value="<%=p.getPid()%>"></td>
						<td><%=p.getPid()%></td>
						<td><%=p.getPname()%></td>
						<td><%=p.getPrice()%></td>
					</tr>
					<%} %>
				</tbody>
			</table>
			<input type="button" value="ADD" onclick="addProduct()">
			<input type="button" value="Delete" onclick="deleteProduct()">
			<input type="button" value="EDIT" onclick="editProduct()">
		</form>
	</div>
</body>
</html>