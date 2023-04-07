<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Profile</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="style.css">
	<link href="https://fonts.googleapis.com/css2?family=Lato&display=swap" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<style>
		table,th,td{
			border: 1px, solid white;
			width: 400px;
			background-color: rgba(0,0,0,0.6);
			color: #ffffff;
			position: relative;
			padding: 5px;
			text-align: center;
		}
		table.center{
			margin-left: auto;
			margin-right: auto;
			margin-top: 13%;
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
		 
		div.form-box-profile{
			width: 380px;
			height: 480px;
			position: relative;
			margin: 6% auto;
			background: rgba(0,0,0,0);
			padding: 5px;
		}
	</style>
</head>
<body>
	<%String userName = (String)request.getAttribute("username"); %>
	<%String firstName = (String)request.getAttribute("firstname"); %>
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
		<table class="center table table-bordered">
				<thead>
					<tr>
						<th>Height</th>
						<th>Weight</th>
						<th>Gender</th>
						<th>Target Weight</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="item" items="${userprofile}">

						<tr>
							<td><c:out value="${item.height}" /></td>
							<td><c:out value="${item.weight}" /></td>
							<td><c:out value="${item.gender}" /></td>
							<td><c:out value="${item.tweight}" /></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table><br>
		<div class="form-box-profile">
			<form id="login" action="updateProfile.jsp" method="post">
				<input type="hidden" name="username" value="<%=userName%>">
				<input type="hidden" name="firstname" value="<%=firstName%>">
				<input type="submit" class="submit-btn" value="Update Profile">
			</form><br>
			<form id="login" action="DeleteProfile" method="post">
				<input type="hidden" name="username" value="<%=userName%>">
				<input type="hidden" name="firstname" value="<%=firstName%>">
				<input type="submit" class="submit-btn" value="Delete Profile">
			</form><br>
			<form>
				<button class="submit-btn" type="button" name="back" onclick="history.back()">Go Back</button>
			</form>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<script type="text/javascript"></script>
</body>
</html>