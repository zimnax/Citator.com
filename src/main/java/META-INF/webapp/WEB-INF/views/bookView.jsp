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
			$("#addQuoteByAjax").click(function() {
				$.get("/quote/add", {
					quote : document.getElementById("currentQuote").value,
					currentBookId : ${currentBook.idBook}
				}, function(data) {
					$("#quoteTable tbody").append(data);
				});
			});
		});
	</script>

<body>

	<center>BOOK VIEW</center>

	<p>BookName: ${currentBook.bookname}
	<p>Author: ${currentBook.author}
	<p>Publish Year: ${currentBook.publishYear}
	<p>
		Input your quote: <input type="text" name="quote" width="200px"
			height="100px" id="currentQuote">
	<p>
		<input type="submit" name="submit" value="Add new quote"
			id="addQuoteByAjax">
	<table id="quoteTable">
		<tr>
			<th>Quote</th>
		</tr>
		<c:forEach items="${bookQuotesList}" var="Quote" varStatus="loop"
			step="1">
			<tr>
				<td><c:out value="${Quote.quote}" /></td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>