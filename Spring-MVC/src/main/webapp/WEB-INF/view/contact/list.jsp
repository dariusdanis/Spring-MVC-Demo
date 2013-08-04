<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>contacts</title>
</head>
<body>
	<h1>contacts</h1>
	<ul>
		<c:forEach var="contact" items="${contacts}">
			<li><a href="${contact.url}">${contact.name}</a></li>
		</c:forEach>
	</ul>
	<a href="person?add">add a new person</a> | <a href="company?add">add a new company</a>
</body>
</html>