<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<script src="/js/jquery-1.10.2.min.js" type="text/javascript"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$("#validateUser").click(function() {
			$.get("/authorizeme/validateUser", {
				email : document.getElementById("inputEmail").value,
				password : document.getElementById("inputPassword").value
			}, function(data) {
				if (data == "success") {
					document.authorize.submit();
				} else {
					$('h2').text('Invalid username or password');
				}
			});
		});
	});
</script>


<body>

	<center>AUTHORIZATION PAGE</center>

	<h2 style="color: red"></h2>

	<form action="/authorizeme/user" method="POST" name="authorize">
		<p>
			Email: <input type="text" name=email id="inputEmail">
		<p>
			Password: <input type="text" name="password" id="inputPassword">
	</form>
	<button id="validateUser">Submit</button>

</body>
</html>