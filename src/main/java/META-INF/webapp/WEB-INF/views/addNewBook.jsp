<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>


  <center>ADD NEW BOOK PAGE</center>


  <form action="/book/add" method="POST">
  <p>  BookName: <input type="text" name="bookname">
  <p>  Author: <input type="text" name=author>
  <p>  Publish Year: <input type="text" name="publishYear">
  <p>  <input type="submit" value="submit">
  </form>

</body>
</html>