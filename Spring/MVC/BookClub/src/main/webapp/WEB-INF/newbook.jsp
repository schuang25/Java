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
   		<h1>Add a Book to Your Shelf!</h1>
   		<a href="/books">Back to the shelves</a>
   		<form:form action="/books/create" method="post" modelAttribute="newBook">
   			<div class="form-group">
				<label>Title:</label>
				<form:input path="title" class="form-control" />
				<form:errors path="title" class="text-danger" />
			</div>
			<div class="form-group">
				<label>Author:</label>
				<form:input path="author" class="form-control" />
				<form:errors path="author" class="text-danger" />
			</div>
			<div class="form-group">
				<label>My thoughts:</label>
				<form:input path="thoughts" class="form-control" />
				<form:errors path="thoughts" class="text-danger" />
			</div>
			<input type="submit" value="Submit" class="btn btn-primary" />
   		</form:form>
	</div>
</body>
</html>