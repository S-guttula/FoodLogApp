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
		button{
			padding: 0.8px 15px;
			margin-left: 95px;
		}
	</style>
</head>
<body>
	<%String userName=(String)request.getParameter("username");%>
	<%String firstName=(String)request.getParameter("firstname");%>
	<%String lastName=(String)request.getParameter("lastname");%>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  		<a class="navbar-brand" href="Login1.jsp">Digital Health Inc.</a>
  		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    	<span class="navbar-toggler-icon"></span>
  		</button>

  	<div class="collapse navbar-collapse" id="navbarSupportedContent">
    	<ul class="navbar-nav ml-auto">
    		<li class="nav-item"><a class="nav-link" href="http://localhost:8085/Personal_Food_Log_App/">Log Out</a></li>
    	</ul>
  	</div>
	</nav>
	<div class="container">
		<div class="form-box-profile">
		<h3>Let's create your profile</h3>
		<form id="login" class="input-group-profile" action="CreateProfile" method="post">
			<label>Height: <input type="text" class="input-field" placeholder="Enter your height here(in cms)" name="height" required></label>
			<label>Weight: <input type="text" class="input-field" placeholder="Enter your weight here(in kgs)" name="weight" required></label>
			<p>Gender:</p>
			<label>
				<input name="gender" type="radio" value="male">
				Male
			</label>
			<label>
				<input name="gender" type="radio" value="female">
				Female
			</label>
			<label>
				<input name="gender" type="radio" value="other">
				Other
			</label>
			<label>Target Weight: <input type="text" class="input-field" placeholder="Enter your target weight(in kgs)" name="tweight" required></label>
			<input type="hidden" name="username" value="<%=userName%>">
			<input type="hidden" name="firstname" value="<%=firstName%>">
			<input type="submit" class="submit-btn" value="Create Profile"><br>
			<button type="button" name="back" onclick="history.back()">Go Back</button>
		</form>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<script type="text/javascript"></script>
</body>
</html>