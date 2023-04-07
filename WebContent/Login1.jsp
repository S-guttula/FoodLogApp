<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Success!</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="style.css">
	<link href="https://fonts.googleapis.com/css2?family=Lato&display=swap" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<style>
		.jumbotron{
					background-image:url("https://images.unsplash.com/photo-1519751138087-5bf79df62d5b?ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80");
					background-size:cover;
		}
		h6{
			color: #000000;
			text-align:center;
		}
	</style>
</head>
<body>
	<% String userName=(String)request.getAttribute("userName"); %>
	<% String firstName=(String)request.getAttribute("firstName"); %>
	<% String lastName=(String)request.getAttribute("lastName"); %>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  		<a class="navbar-brand" href="#">Digital Health Inc.</a>
  		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    	<span class="navbar-toggler-icon"></span>
  		</button>

  	<div class="collapse navbar-collapse" id="navbarSupportedContent">
    	<ul class="navbar-nav ml-auto">
    		<li class="nav-item"><a class="nav-link" href="http://localhost:8085/Personal_Food_Log_App/">Log Out</a></li>
    	</ul>
  	</div>
	</nav>
	<div class="jumbotron">
		<h6>Successfully logged in!</h6>
		<h2 style="text-align:center">Welcome ${firstName}  ${lastName}!</h2>
	</div>
	<div class="container">
		<div class="form-box-profile">
		<h3>Tools</h3>
		<form id="login" action="createProfile.jsp" method="post">
			<input type="hidden" name="username" value="<%=userName%>">
			<input type="hidden" name="firstname" value="<%=firstName%>">
			<input type="submit" class="submit-btn" value="Create Profile">
		</form><br>
		<form id="login" action="ViewProfile" method="post">
			<input type="hidden" name="username" value="<%=userName%>">
			<input type="hidden" name="firstname" value="<%=firstName%>">
			<input type="submit" class="submit-btn" value="View Profile">
		</form><br>
		<form id="login" action="CalorieCounterBasic" method="post">
			<input type="hidden" name="username" value="<%=userName%>">
			<input type="hidden" name="firstname" value="<%=firstName%>">
			<input type="submit" class="submit-btn" value="Calorie Counter">
		</form><br>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<script type="text/javascript"></script>
</body>
</html>