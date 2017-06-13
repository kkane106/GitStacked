<nav class="navbar">
	
	<ul>
		<li><img class="logo" src="pics/logo.png"/></li>

		<c:if test="${sessionScope.user.username != null }">

			<li><a href="home.do">Home</a></li>
			<li><a href="account.jsp">Edit Account</a></label></li>
			<li><a href="createWorkout.do">Create Workout</a></label></li>
		</c:if>

		<c:if test="${sessionScope.user.username == null }">
			<li><a href="login.do">Sign in</a></label></li>
		</c:if>

		<c:if test="${sessionScope.user.username != null }">
			<li><a href="logout.do">Logout</a></label></li>
		</c:if>

	</ul>
</nav>

<script src="test.js"></script>