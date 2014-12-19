<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

	<center>REGISTRATION PAGE</center>


	<form action="/registerme/newuser" method="POST">
		<p>
			Username: <input type="text" name="username">
		<p>
			Email: <input type="text" name=email>
		<p>
			Nickname: <input type="text" name="nickname">
		<p>
			Password: <input type="text" name="password">
		<p>
			Confirm password: <input type="text" name="repassword">
		<p>
			<input type="submit" value="submit">
	</form>

</body>
</html>