<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Edit Film Details</title>
</head>
<body>
<h1>Update Film</h1>
	<div>
		<form action="filmIsEdited.do" method="post">
			<input type="hidden" name="filmId" value="${film.filmId}">
			<label for="title">Title:</label> 
			<input type="text" name="title" value="${film.title}" required> 
				<br>
				 <label for="description">Description:</label>
			<input name="description" maxlength=250 value="${film.description}"></input>
			<br>
			 <label for="releaseYear">Release Year:</label> 
			 <input type="text" name="releaseYear" value="${film.releaseYear}" required> 
				<br>
				 <label
				for="languageId">Language:</label> 
				<select name="languageId" value="${film.languageId}">
				<option value=1>English</option>
				<option value=2>Italian</option>
				<option value=3>Japanese</option>
				<option value=4>Mandarin</option>
				<option value=5>French</option>
				<option value=6>German</option>
				
				</select><br>
				
				<label for="rentDuration">Rent Duration:</label> 
				<input type="text" name="rentDuration" value="${film.rentDuration}" required> 
				<br>
			<label for="rentalRate">Rental Rate:</label> 
			<input type="text" name="rentalRate" value="${film.rentalRate}" required> 
			<br> 
			<label for="length">Length:</label>
			<input type="text" name="length" value="${film.length}" required > 
			<br> 
			<label for="replacementCost">ReplacementCost:</label> 
			<input type="text"
				name="replacementCost" value="${film.replacementCost}" required> 
				<br> 
				<label
				for="rating">Rating:</label> <input type="text" name="rating"
				value="${film.rating}"> 
				<br>
				<label for="specialFeatures">Special Features:</label> 
				<select name="specialFeatures" value="${film.specialFeatures}">
				<option >Trailers</option>
				<option >Commentaries</option>
				<option >Deleted Scenes</option>
				<option >Behind the Scenes</option>
				
				</select>
				<br>


			<input type="submit" value="Update Film">


		</form>
	</div>

</body>
</html>