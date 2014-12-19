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
<body>

	<center>PRIVATE LIBRARY</center>

	<p>username: ${currentUser.username}
	<p>email: ${currentUser.email}
	<p>
		nickname: ${currentUser.nickname}

		<c:if test="${pageOwner}">
			<input type=button
				onClick="location.href='${currentUser.username}/quit'" value='QUIT'>

			<input type=button onClick="location.href='book'"
				value='Add new book'>
		</c:if>
	<table>
		<h4>BOOK SHELF</h4>
		<tr>
			<th>idBook</th>
			<th>Book name</th>
			<th>Author</th>
			<th>Publish date</th>
		</tr>
		<c:forEach items="${userBooksList}" var="book" varStatus="loop"
			step="1">
			<tr>
				<td><c:out value="${book.idBook}" /></td>
				<td><c:out value="${book.bookname}" /></td>
				<td><c:out value="${book.author}" /></td>
				<td><c:out value="${book.publishYear}" /></td>
				<td><input type="button"
					onClick="location.href='book/${book.idBook}'" value="VIEW BOOK">
				</td>
			</tr>
		</c:forEach>
	</table>




</body>
</html>