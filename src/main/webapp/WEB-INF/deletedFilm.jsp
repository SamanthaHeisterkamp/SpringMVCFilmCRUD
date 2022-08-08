<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<div id=missionstatement class="text-bg-dark p-3">People | Person's | Video | People</div>

<head>
<meta charset="UTF-8">
<title>Deleted Film</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
<link rel="stylesheet" href="CSS/style.css">
</head>
<body>



	<c:choose>
		<c:when test="${deleted}">
			<h1>Film Deleted ${filmId}</h1>
			<form action="home.do">
				<input type="submit" value="Home">
			</form>
		</c:when>

		<c:otherwise>
			<h3>Unable to Delete Film</h3>
			<form action="home.do">
				<input type="submit" value="Home">
			</form>
		</c:otherwise>

	</c:choose>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
		crossorigin="anonymous"></script>
</body>
</html>