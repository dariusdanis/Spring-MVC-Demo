<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>${office.name}</title>
</head>
<body>
	<h1>${office.name}</h1>
	<ul>
		<c:set var="address" value="${office.address}" />
		<li>${address.street}</li>
		<li>${address.city}, ${address.state} ${address.zip}</li>
	</ul>
	<a href="${office.url}&edit">edit office</a> |
	<a href="${office.company.url}">back to ${office.company.name}</a>
</body>
</html>