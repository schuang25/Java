<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Current visit count</title>
</head>
<body>
    <p>You have visited <a href="/">this server</a> <c:out value="${counter}" /> times.</p>
    <p><a href="/">Test another visit?</a></p>
</body>
</html>
