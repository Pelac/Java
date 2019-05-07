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
label {
	color: black;
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
			<li class="active"><a href=findmovies.jsp>Find movies</a></li>
			<li><a href=managemovies.jsp>Manage movies</a></li>
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
		<h3 style="color: Black">Find out what movies we have stored in our vast database</h3>
		<h4style ="color:Black">If you find something you have seen, wish to delete a movie or just update it, proceed to "Manage movies"</h4>
	</div>
	<div class="container">
		<meta http-equiv="Content-Type"
			content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
		</head>
		<body>
			<form action="/MovieReviewClientProject/MovRewServlet" method="post">
				<table cellspacing="0" cellpadding="0" border="0" align="left">
					</td>
					<br>
					<input class="form-control" type="text" name="movieName" size="25"
						maxlength="25" style="width: 300px"
						placeholder="Enter the title of the movie.." required>
					<br>
					<input type="submit" name="submit" value="Search" />
					<input name="operation" value="showmovie" type="hidden">

					</form>
					<table class="table">
						<thead style="color: black">
							<tr>
								<th>Movie Title</th>
								<th>Genre</th>
								<th>Release Year</th>
								<th>Rating</th>
							</tr>
						</thead>
						<tbody id="movieTable" style="color: black">
							<tr>
								<td><%=request.getAttribute("movieName") == null ? "" : request.getAttribute("movieName")%></td>
								<td><%=request.getAttribute("genre") == null ? "" : request.getAttribute("genre")%></td>
								<td><%=request.getAttribute("releaseYear") == null ? "" : request.getAttribute("releaseYear")%></td>
								<td><%=request.getAttribute("rating") == null ? "" : request.getAttribute("rating")%></td>
							</tr>
						</tbody>
					</table>
					<h5><%=request.getAttribute("searchMovieError") == null ? "" : request.getAttribute("searchMovieError")%></h5>
					<footer class="container-fluid text-center">
					<p></p>
					<hr>
					<p>COPYRIGHT 2018, 24 consulting ab</p>
					</footer>
		</body>
</html>
