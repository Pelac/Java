<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="org.ics.ejb.Movie"%>
<html>
<head>
<link rel="icon" href="img/minilogo.jpg">
<title>24 Movieratings</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
footer {
	color: black;
	padding: 15px;
}

* {
	box-sizing: border-box;
}

.column {
	float: left;
	width: 33.33%;
	padding: 10px;
	height: 300px;
}

.row:after {
	content: "";
	display: table;
	clear: both;
} 
</style>
</head>
<body>
	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-brand" href=home.html>
			24 Movieratings</a>
		</div>
		<ul class="nav navbar-nav">
			<li><a href=home.html>Home</a></li>
			<li><a href=about.html>About</a></li>
			<li><a href=findmovies.jsp>Find movies</a></li>
			<li class="active"><a href=managemovies.jsp>Manage movies</a></li>
			<li><a href=Test.html>Test</a></li>

		</ul>
	</div>
	<div class="container">
		<div class="jumbotron">
			<h1>
				<img width="200" length="100" src="img/moviez.jpg">
			</h1>
			<p>The best place to rate movies.</p>
		</div>
	</div>
	<div class="container">
		<meta http-equiv="Content-Type"
			content="text/html; charset=ISO-8859-1">
		</head>

		<div class="container">
			<div class="column">
				<form action="/MovieReviewClientProject/MovRewServlet" method="post">
					<h3>Delete movie</h3>
					<input class="form-control" type="text" name="movieName" size="25"
						style="width: 300px" maxlength="25"
						placeholder="Enter movie title to delete..(Required)"><br>
					<input type="submit" name="submit" value="Delete" /> <input
						name="operation" value="delmovie" type="hidden">
					<h5><%=request.getAttribute("feedBackDeleteMovie") == null ? "" : request.getAttribute("feedBackDeleteMovie")%></h5>
					<h5><%=request.getAttribute("delMovieError") == null ? "" : request.getAttribute("delMovieError")%></h5>
				</form>
			</div>
			<meta http-equiv="Content-Type"
				content="text/html; charset=ISO-8859-1">

			<div class="column">
				<form action="/MovieReviewClientProject/MovRewServlet" method="post">
					<h3>Create review</h3>
					<input class="form-control" type="text" name="movieName" size="25"
						style="width: 300px" maxlength="25"
						placeholder="Enter the title of the movie..(Required)"><br>
					<select class="form-control" style="width: 300px" name="rating"
						id="buttonDis">
						<option value="0">Select your rating</option>
						<script>
							window.onload = function() {
								document.getElementById("buttonDis").onChange = function() {
									if (this.options[this.selectedIndex].value == 0) {
										document.getElementById("submitBtn").disabled = true;
									} else {
										document.getElementById("submitBtn").disabled = false;
									}
								}
							}
						</script>
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
						<option>6</option>
						<option>7</option>
						<option>8</option>
						<option>9</option>
						<option>10</option>
					</select> <br> <input type="submit" name="submit" value="Create Review"
						id="submitBtn" /> <input name="operation" value="createReview"
						type="hidden">
					<h5><%=request.getAttribute("feedBackCreateReview") == null ? "" : request.getAttribute("feedBackCreateReview")%></h5>
					<h5><%=request.getAttribute("createReviewError") == null ? "" : request.getAttribute("createReviewError")%></h5>
				</form>
			</div>
			<div class="column">
				<form action="/MovieReviewClientProject/MovRewServlet" method="post">
					<table cellspacing="0" cellpadding="0" border="0" align="left">
						<h3>Update movie</h3>
						</td>
						<input class="form-control" type="text" name="movieName" size="25"
							style="width: 300px" maxlength="25"
							placeholder="Enter the title of the movie..(Required)" required>
						<br>
						<input class="form-control" type="text" name="genre" size="25"
							style="width: 300px" maxlength="25"
							placeholder="Enter the genre of the movie..(Required)" required>
						<br>
						<input class="form-control" type="text" name="releaseYear"
							size="25" maxlength="25" style="width: 300px"
							placeholder="Enter movie release year..(Required)" required>
						<br>
						<input type="submit" name="submit" value="Update Movie" />
						<input name="operation" value="updateMovie" type="hidden">
						<h5><%=request.getAttribute("feedBackUpdateMovie") == null ? "" : request.getAttribute("feedBackUpdateMovie")%></h5>
						<h5><%=request.getAttribute("updateMovieError") == null ? "" : request.getAttribute("updateMovieError")%></h5>
						</form>
						</div>
						</div>
						</div>
						<footer class="container-fluid text-center">
						<p></p>
						<hr>
						<p>COPYRIGHT 2018, 24 consulting ab</p>
						</footer>
</body>
</html>