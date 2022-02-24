<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body>
   	<div class="container mt-5">
   		<h1>Welcome ${user.userName}!</h1>
		<a href="/logout"> Logout</a>
   		<a href="/books/new">Add a book to my shelf</a>
   		<h3>Books from everyone's shelves</h3>
   		<table>
   			<thead>
   				<tr>
   					<td>ID</td>
   					<td>Title</td>
   					<td>Author Name</td>
   					<td>Posted By</td>
   				</tr>
   			</thead>
   			<tbody>
   				<c:forEach var="book" items="${books}">
   					<tr>
   						<td>${book.id}</td>
   						<td><a href="/books/${book.id}">${book.title}</a></td>
   						<td>${book.author}</td>
   						<td>${book.user.userName}</td>
   					</tr>
   				</c:forEach>
   			</tbody>
   		</table>
	</div>
</body>
</html>