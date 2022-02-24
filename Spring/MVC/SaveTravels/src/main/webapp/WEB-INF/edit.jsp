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
	<h2>Edit Expense</h2>
	<p><a href="/expenses">Go back</a></p>
	<form:form action="/expenses/update/${id}" method="post" modelAttribute="expense">
		<input type="hidden" name="_method" value="put">
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