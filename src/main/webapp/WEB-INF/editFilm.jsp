<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<div id=missionstatement class="text-bg-dark p-3">People | Person's | Video | People</div>

<head>
<meta charset="UTF-8">
<title>Edit Film Details</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
<link rel="stylesheet" href="CSS/style.css">
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
			 <input type="number" onkeypress="return /[0-9]/i.test(event.key)" name="releaseYear" value="${film.releaseYear}" required> 
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
				<input type="number" onkeypress="return /[0-9]/i.test(event.key)" name="rentDuration" value="${film.rentDuration}" required> 
				<br>
			<label for="rentalRate">Rental Rate:</label> 
			<input type="text" onkeypress="return (event.charCode !=8 && event.charCode ==0 || ( event.charCode == 46 || (event.charCode >= 48 && event.charCode <= 57)))" name="rentalRate"  value="${film.rentalRate}" required> 
			<br> 
			<label for="length">Length:</label>
			<input type="text" onkeypress="return /[0-9]/i.test(event.key)" name="length" value="${film.length}" required > 
			<br> 
			<label for="replacementCost">ReplacementCost:</label> 
			<input type="text" onkeypress="return (event.charCode !=8 && event.charCode ==0 || ( event.charCode == 46 || (event.charCode >= 48 && event.charCode <= 57)))" name="replacementCost" value="${film.replacementCost}" required> 
				<br> 
				<label for="rating">Rating:</label>
				 <select  name="rating" value="${film.rating}"> 
				<option >G</option>
				<option >PG</option>
				<option >PG13</option>
				<option >R</option>
				<option >NC17</option>
				
				</select>
				
				<br>
				<label for="specialFeatures">Special Features:</label> 
				<select name="specialFeatures" value="${film.specialFeatures}">
				<option >Trailers</option>
				<option >Commentaries</option>
				<option >Deleted Scenes</option>
				<option >Behind the Scenes</option>
				
				</select>
				<br>

<input class="btn btn-secondary" type="submit" value="Home">



		</form>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
		crossorigin="anonymous"></script>
</body>
</html>