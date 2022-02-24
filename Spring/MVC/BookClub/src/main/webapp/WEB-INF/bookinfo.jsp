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
		<h1>${book.title}</h1>
		<h3>${book.user.userName} read ${book.title} by ${book.author}.</h3>
		<h3>Here are ${book.user.userName}'s thoughts:</h3>
		<p>${book.thoughts}</p>
		<a href="/books">Back to the shelves</a>
	</div>
</body>
</html>