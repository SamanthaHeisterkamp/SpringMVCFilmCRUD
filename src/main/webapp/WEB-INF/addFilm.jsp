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
		<form action="createdFilm.do" method="post">
			<label for="title">Title:</label> 
			<input type="text" name="title"required="true"> 
				<br>
				 <label for="description">Description:</label>
			<textarea name="description"></textarea>
			<br>
			 <label for="releaseYear">Release Year:</label> 
			 <input type="text" name="releaseYear" required> 
				<br>
				 <label
				for="language">Language:</label> 
				<select name="languageId">
				<option value=1>English</option>
				<option value=2>Italian</option>
				<option value=3>Japanese</option>
				<option value=4>Mandarin</option>
				<option value=5>French</option>
				<option value=6>German</option>
				
				</select><br>
				
				<label for="rentDuration">Rent Duration:</label> 
				<input type="text" name="rentDuration" required> 
				<br>
			<label for="rentalRate">Rental Rate:</label> 
			<input type="text" name="rentalRate" required> 
			<br> 
			<label for="length">Length:</label>
			<input type="text" name="length" required > 
			<br> 
			<label for="replacementCost">ReplacementCost:</label> 
			<input type="text"
				name="replacementCost" required> 
				<br> 
				<label
				for="rating">Rating:</label> <input type="text" name="rating"
				> 
				<br>
				<label for="specialFeatures">Special Features:</label> 
				<select name="specialFeatures">
				<option >Trailers</option>
				<option >Commentaries</option>
				<option >Deleted Scenes</option>
				<option >Behind the Scenes</option>
				
				</select>
				<br>


			<input type="submit" value="Create Film">


		</form>
	</div>
</body>
</html>