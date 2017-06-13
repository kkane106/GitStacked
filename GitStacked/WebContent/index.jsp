<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <jsp:include page="_styles.jsp"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Git Stacked - Homepage</title>
  </head>
<body>
  <div id="parent">
    <div id="opacity">
      <div id="child">
        <!-- why is this not a div or header? -->
        Click below to start your workout plan!
        
        <br> <!-- Why do you have errant breaks? why not use css? -->
        
        <form action = "createUser.do" method = "GET">
          <input type="image" src="pics/logo.png" id ="logo"/>
        </form>
        <!-- why is this not a div or header? -->
        Already have an account?

        <form action = "login.do" method = "POST">
          <input type="text" name="username" placeholder="Username"><br>
          <input type="password" name="password" placeholder="Password"><br>
          <input type= "submit" value= "Log In">
        </form>
        </div>
      </div>
    <br>
    </div>
  </div>

</body>
</html>