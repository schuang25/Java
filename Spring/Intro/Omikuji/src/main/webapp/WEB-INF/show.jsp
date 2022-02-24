<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Omikuji</title>
</head>
<body>
	<h2>Here's your Omikuji!</h2>
    <p>In <c:out value="${number}"/> years, you will live in <c:out value="${city}"/> with <c:out value="${name}"/>, 
    <c:out value="${job}"/> for a living. The next time you see a <c:out value="${thing}"/>, you will have good luck.
    Also, <c:out value="${nice}"/></p>
</body>
</html>
