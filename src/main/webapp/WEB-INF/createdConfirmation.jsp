<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<div id=missionstatement class="text-bg-dark p-3">People | Person's | Video | People</div>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
<link rel="stylesheet" href="CSS/style.css">
</head>
<body>

<c:choose>
		<c:when test="${createdFilm}">
			<h1>Created Film!</h1>
			<li>ID: ${film.filmId}</li>
						<li>Title: ${film.title}</li>
						<li>Description: ${film.description}</li>
						<li>Release Year: ${film.releaseYear}</li>
						<li>Language: ${language}</li>
						<li>Rental Duration: ${film.rentDuration}</li>
						<li>Rental Rate: ${film.rentalRate}</li>
						<li>Film Length: ${film.length}</li>
						<li>Replacement Cost: ${film.replacementCost}</li>
						<li>Rating: ${film.rating}</li>
						<li>Special Features: ${film.specialFeatures}</li>
		<form action="deleteFilm.do" method="GET">
			<label for="deleteFilm"> </label> <input type="text"
				name="filmId" value="${film.filmId}" placeholder="Delete by ID"> 
				<input class="btn btn-secondary" type="submit" value="Delete Film">
				
		</form><br>
		
		<form action="editFilmForm.do" method="GET">
			<label for="editFilm"> </label> <input type="text"
				name="filmId" value="${film.filmId}" placeholder="Update by ID"> 
				<input class="btn btn-secondary" type="submit" value="Update Film">
				
		</form>
			<form action="home.do">
			<input class="btn btn-secondary" type="submit" value="Home">
			
			</form>
		</c:when>
		<c:otherwise>
			<h3>Unable to Create Film Loser</h3>
			<form action="home.do">
			<input class="btn btn-secondary" type="submit" value="Home">
			
			</form>
		</c:otherwise>


	</c:choose>




	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
		crossorigin="anonymous"></script>


</body>
</html>