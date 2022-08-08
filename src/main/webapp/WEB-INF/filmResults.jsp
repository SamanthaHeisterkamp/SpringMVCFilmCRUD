<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<div id=missionstatement class="text-bg-dark p-3">People | Person's | Video | People</div>

<head>
<meta charset="UTF-8">
<title>Search Results</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
<link rel="stylesheet" href="CSS/style.css">
</head>
<body>

	<h1>Results</h1>
	<div>
		<c:choose>
		<c:when test="${! empty film}">

					<ul>
						<h3>Film</h3>
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
						<c:if test="${! empty film.category}">
						<li>Category: ${film.category} </li>
						</c:if>
						<c:if test="${! empty film.actorList[0]}">
						<h3>Cast</h3>
						<c:forEach var="actor" items="${film.actorList}">
							<li>${actor.toString()}</li>

						</c:forEach>
						</c:if>
					</ul>
				</c:forEach>
						
						<form action="deleteFilm.do" method="GET">
							<label for="deleteFilm"> </label> <input type="text"
									name="filmId" value="${film.filmId}" placeholder="Delete by ID"> 
								<input class="btn btn-secondary" type="submit" value="Submit">
								
						</form> <br>
		
						<form action="editFilmForm.do" method="GET">
							<label for="editFilm"> </label> <input type="text"
									name="filmId" value="${film.filmId}" placeholder="Update by ID">
									<input class="btn btn-secondary" type="submit" value="Submit">
									
						</form><br>
						
						<form action="home.do">
						<input class="btn btn-secondary" type="submit" value="Back">
						
							<input type="submit" value="Back">
						</form>


	
		
		
			</c:when>

			<c:otherwise>
				<p>Film NOT Found!!!!!!</p>
				<form action="home.do">
				<input class="btn btn-secondary" type="submit" value="Back">
				
				</form>

			</c:otherwise>
		</c:choose>
	</div>
<div>

	</div>
		<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
		crossorigin="anonymous"></script>
</body>
</html>