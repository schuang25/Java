<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>New Ninja</title>
</head>
<body>
	<h1>New Ninja</h1>
	<form:form action="/ninjas/create" method="post" modelAttribute="ninja">
		<p>
			<form:label path="dojo">Dojo: </form:label>
			<form:select path="dojo">
				<c:forEach var="dojo" items="${dojos}">
					<form:option value="${dojo.id}" path="dojo">
						<c:out value="${dojo.name}"/>
					</form:option>
				</c:forEach>
			</form:select><br>
			<form:errors path="dojo"/>
		</p>
	    <p>
	        <form:label path="firstName">First Name: </form:label>
	        <form:input path="firstName"/><br>
	        <form:errors path="firstName"/>
	    </p>
	    <p>
	        <form:label path="lastName">Last Name: </form:label>
	        <form:input path="lastName"/><br>
	        <form:errors path="lastName"/>
	    </p>
	    <p>
	        <form:label path="age">Age: </form:label>
	        <form:input type="number" path="age" min="0"/><br>
	        <form:errors path="age"/>
	    </p>
	    <input type="submit" value="Submit"/>
	</form:form>
</body>