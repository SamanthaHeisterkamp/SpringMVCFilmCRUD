<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Deleted Film</title>
</head>
<body>



	<c:choose>
		<c:when test="${deleted == true }">
			<h2>Film Deleted ${filmId}</h2>
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

</body>
</html>