<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/KTQuaTrinh/register"  method="post">
		<div class="container">
			<h1>Register</h1>
			<hr>

			<label for="username"><b>Username</b></label> <input type="text"
				placeholder="Enter Username" name="username" id="username" required>

			<label for="psw"><b>Password</b></label> <input type="password"
				placeholder="Enter Password" name="psw" id="psw" required> <label
				for="psw-repeat"><b>Repeat Password</b></label> <input
				type="password" placeholder="Repeat Password" name="psw-repeat"
				id="psw-repeat" required>
			<hr>
			<button type="submit" class="registerbtn">Register</button>
		</div>
	</form>
</body>
</html>