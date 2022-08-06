<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Film Query App</title>
</head>
<body>


<h1 style="color:teal;">Film Query APP</h1>
	<div>
		<form action="filmDetails.do" method="get">
			<label for="searchByFilmId"> </label> <input type="text"
				name="filmId" placeholder="Search by ID"> <input
				type="submit" value="Submit">

		</form>
	</div>

</body>
</html>