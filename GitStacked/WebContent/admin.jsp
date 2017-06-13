<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<jsp:include page="_styles.jsp"/>
		<title>Admin Portal</title>
	</head>
<body>
	<div>
		<h3>Change User Account Type</h3>

		<form action="updateUserType.do" method="post">
			<select name="username">
				<c:forEach var="u" items="${users}">
					<option>${u.username}</option>
				</c:forEach>
			</select> <select name="choice">
				<option>ADMIN</option>
				<option>USER</option>
			</select>
			<button type="submit">Make Change</button>
		</form>
	</div>

	<br>


	<div>
		<h3>Create a New Exercise</h3>
		<form action = "createExercise.do" method = "POST">
			
			<label>Name of Exercise:</label>
			<input name = "name"/>[Limited to 100 chars]<br>
			
			<label>Description/Instruction:</label>
			<input name = "desc"/>[Limited to 1000 chars]<br>
			
			<label>Image Url:</label>
			<input name = "imageUrl"/><br>
			
			<label>Calories per Movement:</label>
			<input name = "calories"/>[Integer]<br>
			
			<label>Muscle Group ENUM:</label>
			<input name = "muscleGroup"/>[ARMS,LEGS,ABS,CHEST,BACK,SHOULDERS]<br>

			<input type = "submit" value = "Create Exercise">
			
		</form>
	</div>

	<div>
		<h3>Make an Exercise Inactive/Active</h3>
		<form action="deleteExercise.do" method="post">
			<select name="name">
				<c:forEach var="e" items="${exercises}">
					<option>${e.name}</option>
				</c:forEach>
			</select> <select name="choice">
				<option>ACTIVE</option>
				<option>INACTIVE</option>
			</select>
			<button type="submit">Make Change</button>
		</form>
	</div>
	
	<div>
		<ul>
		<c:if test="${sessionScope.user.username == null }">
			<li><a href="login.do">Sign in</a></li>
		</c:if>
		
		<c:if test="${sessionScope.user.username != null }">
			<li><a href="account.jsp">Edit Account</a></li>
			<li><a href="logout.do">Logout</a></li>
		</c:if>
		</ul>
	</div>

</body>
</html>
