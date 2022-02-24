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
	<h2>Expense Details</h2>
	<p><a href="/expenses">Go back</a></p>
	<table>
		<tbody>
			<tr>
				<td>Expense Name: </td>
				<td><c:out value="${e.name}"/></td>
			</tr>
			<tr>
				<td>Expense Description: </td>
				<td><c:out value="${e.description}"/></td>
			</tr>
			<tr>
				<td>Vendor: </td>
				<td><c:out value="${e.vendor}"/></td>
			</tr>
			<tr>
				<td>Amount Spent: </td>
				<td>$<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${e.cost}"/></td>
			</tr>
		</tbody>
	</table>
</body>