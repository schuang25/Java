<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Omikuji</title>
</head>
<body>
    <h2>Send an Omikuji!</h2>
    <form action="omikuji/submit" method="post">
    	<label for='number'>Pick any number from 5 to 25</label><br>
    	<input type='number' name='number' min='5' max='25'></input><br>
    	<label for='city'>Enter the name of any city:</label><br>
    	<input type='text' name='city'><br>
    	<label for='name'>Enter the name of any real person:</label><br>
    	<input type='text' name='name'><br>
    	<label for='job'>Enter professional endeavor or hobby:</label><br>
    	<input type='text' name='job'><br>
    	<label for='thing'>Enter any type of living thing:</label><br>
    	<input type='text' name='thing'><br>
    	<label for='nice'>Say something nice to someone:</label><br>
    	<textarea name='nice'></textarea>
    	<p>Send and show a friend</p>
    	<input type='submit' value="Send">
    </form>
</body>
</html>
