<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:choose>
		<c:when test="${createdFilm}">
			<h2>Created Film!</h2>
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
				name="filmId" value="${film.filmId}" placeholder="Delete by ID"> <input
				type="submit" value="Delete Film">
		</form><br>
		
		<form action="editFilmForm.do" method="GET">
			<label for="editFilm"> </label> <input type="text"
				name="filmId" value="${film.filmId}" placeholder="Update by ID"> <input
				type="submit" value="Update Film">
		</form>
			<form action="home.do">
				<input type="submit" value="Home">
			</form>
		</c:when>

		<c:otherwise>
			<h3>Unable to Create Film Loser</h3>
			<form action="home.do">
				<input type="submit" value="Home">
			</form>
		</c:otherwise>

	</c:choose>







</body>
</html>