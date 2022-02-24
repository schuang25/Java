<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Travels</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<td>Expense</td>
				<td>Vendor</td>
				<td>Amount</td>
				<td>Actions</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="e" items="${expenses}">
				<tr>
					<td><a href="/expenses/${e.id}"><c:out value="${e.name}"/></a></td>
					<td><c:out value="${e.vendor}"/></td>
					<td>$<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${e.cost}"/></td>
					<td>
						<a href="/expenses/edit/${e.id}">Edit</a>
						<form action="/expenses/${e.id}" method="post">
						    <input type="hidden" name="_method" value="delete">
						    <input type="submit" value="Delete">
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<h1>Add an expense:</h1>
	<form:form action="/expenses/create" method="post" modelAttribute="expense">
	    <p>
	        <form:errors path="name"/><br>
	        <form:label path="name">Expense Name: </form:label>
	        <form:input path="name"/>
	    </p>
	    <p>
	        <form:errors path="vendor"/><br>
	        <form:label path="vendor">Vendor: </form:label>
	        <form:input path="vendor"/>
	    </p>
	    <p>
	        <form:errors path="cost"/><br>
	        <form:label path="cost">Amount: </form:label>
	        <form:input path="cost"/>
	    </p>
	    <p>
	        <form:errors path="description"/><br> 
	        <form:label path="description">Description: </form:label>
	        <form:textarea path="description"/>
	    </p>    
	    <input type="submit" value="Submit"/>
	</form:form>
</body>
</html>