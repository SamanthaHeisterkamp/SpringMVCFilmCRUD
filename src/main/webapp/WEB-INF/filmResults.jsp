<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Results</title>
</head>
<body>

	<h1 style="color:maroon;">Results</h1>
	<div>
		<c:choose>
		<c:when test="${! empty film}">

					<ul>
						<h3>Film</h3>
						<li>ID: ${film.filmId}</li>
						<li>Title: ${film.title}</li>
						<li>Description: ${film.description}</li>
						<li>Release Year: ${film.releaseYear}</li>
						<li>Language: ${film.language}</li>
						<li>Rental Duration: ${film.rentDuration}</li>
						<li>Rental Rate: ${film.rentalRate}</li>
						<li>Film Length: ${film.length}</li>
						<li>Replacement Cost: ${film.replacementCost}</li>
						<li>Rating: ${film.rating}</li>
						<li>Special Features: ${film.specialFeatures}</li>
						

					</ul>
						<form action="home.do">
							<input type="submit" value="Back">
						</form>

			</c:when>
			<c:when test="${! empty films[0]}">
				<c:forEach var="film" items="${films}">

					<ul>
						<h3>Film</h3>
						<li>ID: ${film.filmId}</li>
						<li>Title: ${film.title}</li>
						<li>Description: ${film.description}</li>
						<li>Release Year: ${film.releaseYear}</li>
						<li>Language: ${film.language}</li>
						<li>Rental Duration: ${film.rentDuration}</li>
						<li>Rental Rate: ${film.rentalRate}</li>
						<li>Film Length: ${film.length}</li>
						<li>Replacement Cost: ${film.replacementCost}</li>
						<li>Rating: ${film.rating}</li>
						<li>Special Features: ${film.specialFeatures}</li>
						<h3>Cast</h3>
						<c:forEach var="actor" items="${film.actorList}">
							<li>${actor.toString()}</li>

						</c:forEach>

					</ul>
				</c:forEach>
						<form action="home.do">
							<input type="submit" value="Back">
						</form>

		<form action="deleteFilm.do" method="GET">
			<label for="deleteFilm"> </label> <input type="text"
				name="filmId" value="${film.filmId}" placeholder="Delete by ID"> <input
				type="submit" value="Submit">
		</form>
			</c:when>

			<c:otherwise>
				<p>Film NOT Found!!!!!!</p>
				<form action="home.do">
					<input type="submit" value="Back">
				</form>

			</c:otherwise>
		</c:choose>
	</div>
<div>

	</div>
</body>
</html>