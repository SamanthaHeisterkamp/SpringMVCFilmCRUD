<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Add Film</title>
</head>
<body>
		<h1>Create Film</h1>
		<div>
			<form action="addFilm.do" method="POST">
				<label for="title">Title:</label> 
				  <input type="text" name="title" required="true"> S
				<br>
				<label for="description">Description:</label>
				  <textarea name="description"></textarea>
				<br> 
				<label for="releaseYear">Release Year:</label>
				  <input type="text" name="releaseYear"required>
				<br>
				  
				
				
				
				
				
				
				
				
				<form action="createdFilm.do">
					<input type="submit" value="Create Film">
				</form>

			</form>
		</div>
</body>
</html>