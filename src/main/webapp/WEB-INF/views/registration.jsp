<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Product Registration Form</title>

<style>

	.error {
		color: #ff0000;
	}
</style>

</head>

<body>

	<h2>Registration Form</h2>
 
	<form:form method="POST" modelAttribute="product">
		<form:input type="hidden" path="id" id="id"/>
		<table>
			<tr>
				<td><label for="name">Name: </label> </td>
				<td><form:input path="name" id="name"/></td>
				<td><form:errors path="name" cssClass="error"/></td>
		    </tr>
	    
			<tr>
				<td><label for="datePurchase">datePurchase: </label> </td>
				<td><form:input path="datePurchase" id="datePurchase"/></td>
				<td><form:errors path="datePurchase" cssClass="error"/></td>
		    </tr>
	
			<tr>
				<td><label for="purchasePrice">purchasePrice: </label> </td>
				<td><form:input path="purchasePrice" id="purchasePrice"/></td>
				<td><form:errors path="purchasePrice" cssClass="error"/></td>
		    </tr>

			<tr>
				<td><label for="datePurchase">Date Sale: </label> </td>
				<td><form:input path="dateSale" id="dateSale"/></td>
				<td><form:errors path="dateSale" cssClass="error"/></td>
			</tr>

			<tr>
				<td><label for="purchasePrice">sellingPrice: </label> </td>
				<td><form:input path="sellingPrice" id="sellingPrice"/></td>
				<td><form:errors path="sellingPrice" cssClass="error"/></td>
			</tr>

			<tr>
				<td><label for="purchasePrice">countPurchase: </label> </td>
				<td><form:input path="countPurchase" id="countPurchase"/></td>
				<td><form:errors path="countPurchase" cssClass="error"/></td>
			</tr>

			<tr>
				<td><label for="purchasePrice">sellingPrice: </label> </td>
				<td><form:input path="countSelling" id="countSelling"/></td>
				<td><form:errors path="countSelling" cssClass="error"/></td>
			</tr>
	
			<tr>
				<td><label for="ssn">SSN: </label> </td>
				<td><form:input path="ssn" id="ssn"/></td>
				<td><form:errors path="ssn" cssClass="error"/></td>
		    </tr>
	
			<tr>
				<td colspan="3">
					<c:choose>
						<c:when test="${edit}">
							<input type="submit" value="Update"/>
						</c:when>
						<c:otherwise>
							<input type="submit" value="Register"/>
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</table>
	</form:form>
	<br/>
	<br/>
	Go back to <a href="<c:url value='/list' />">List of All Product</a>
</body>
</html>