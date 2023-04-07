<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success Page</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="style.css">
	<link href="https://fonts.googleapis.com/css2?family=Lato&display=swap" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<style>
		h3{
			color: #000000;
		}
		.box-profile{
			width: 380px;
			height: 65px;
			position: relative;
			margin: 2% auto;
			background: rgba(0,0,0,0);
			padding: 5px;
		}
		form.submit-btn{
			width: 85%;
			padding: 10px 30px;
			cursor: pointer;
			display: block;
			margin: auto;
			background: linear-gradient(to right,#ff105f,#ffad06);
			border: 0;
			outline: none;
			border-radius: 30px;
		}
	</style>
</head>
<body>
	<%String name=(String)request.getAttribute("name");%>
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
	<div class="jumbotron">
		<h3>Hurray! ${name} registered successfully.</h3>
		<form class="box-profile">
			<button type="button" class="submit-btn" name="back" onclick="history.back()">Login Here!</button>
		</form>
	</div>
	
</body>
</html>