<%--
	Document   : success
	Created on :
	Author     : nice
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8" />
	<title>Form completed</title>
</head>

<body>
	<h1>Success !! :D</h1>
	<ul>
		<li>Nama:
			<c:out value="${name}" />
		</li>
		<li>Email:
			<c:out value="${email}" />
		</li>
		<li>Age:
			<c:out value="${age}" />
		</li>
	</ul>
	<a href="./form.htm">Back</a>
</body>

</html>