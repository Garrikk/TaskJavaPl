<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Product</title>

	<style>
		tr:first-child{
			font-weight: bold;
			background-color: #C6C9C4;
		}
	</style>

</head>


<body>
	<h2>List of Product</h2>
	<table>
		<tr>
			<td>Name</td>
			<td>datePurchase</td>
			<td>purchasePrice</td>
			<td>dateSale</td>
			<td>sellingPrice</td>
			<td>countPurchase</td>
			<td>countSelling</td>
			<td>SSN</td>
			<td></td>
		</tr>
		<c:forEach items="${product}" var="product">
			<tr>
			<td>${product.name}</td>
			<td>${product.datePurchase}</td>
			<td>${product.purchasePrice}</td>
			<td>${product.dateSale}</td>
			<td>${product.sellingPrice}</td>
			<td>${product.countPurchase}</td>
			<td>${product.countSelling}</td>
			<td><a href="<c:url value='/edit${product.ssn}' />">edit</a></td>
			<td><a href="<c:url value='/delete${product.ssn}' />">delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="<c:url value='/new' />">Add New Product</a>
</body>
</html>