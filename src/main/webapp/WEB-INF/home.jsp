<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

<div class="text-bg-dark p-3">Dark with contrasting color</div>
<head>
 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<title>Film Query App</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>

<body>
	<h1 style="color: teal;">Film Query APP</h1>
	<div>
		<form action="filmDetails.do" method="get">
			<label for="searchByFilmId"> </label> <input type="text"
				name="filmId" placeholder="Search by ID"> 
				<input class="btn btn-secondary" type="submit" value="Submit"> 
				
				<!-- <input type="submit" value="Submit"> -->

		</form>
	</div>
	<br>
	<div>
		<form action="filmDetails.do" method="get">
			<label for="keyword"> </label> <input type="text"
				name="keyword" placeholder="Search by Keyword">
				<input class="btn btn-secondary" type="submit" value="Submit"> 
			<!--  	<input type="submit" value="Submit">-->

		</form>
	</div>
	<br>
	<br>
	<div>
		<form action="addFilm.do" method="post">
			
			<input type="submit" value="Create Film">
		</form>

	</div>

	<!-- <div>
		<form action="">
			<button type="button">Remove Film</button>


		</form>

	</div> -->

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>

</body>
</html>