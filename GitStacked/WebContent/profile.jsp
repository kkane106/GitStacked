<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Your Profile</title>
</head>
<body>

<div id="nav">

<div>Logout</div>
<div><a href="account.jsp">Account management</a></div>
<div>Home</div>
<----- Navigation Bar ----->
</div>
<br>
<br>
<br>
Welcome, ${user.getFName()}

<br>
<br>
<br>
<div><a href="">Create new workout</a></div>
<div><a href="">Previous workouts</a></div>
<div><a href="">Planned workouts</a></div>
<----- Links for other website functionality ----->

<h2>Workouts planned for today</h2>
<----- This should show all workouts planned for today ------->


</body>
</html>