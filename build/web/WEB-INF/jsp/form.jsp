<%--
	Document   : form
	Created on :
	Author     : nice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Form Spring web</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery,min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js"></script>
</head>

<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-6">
				<h1>User Form</h1>
				<hr>
				<form:form method="post" commandName="user">

					<form:errors path="*" element="div" cssClass="alert alert-danger" />

					<p>
						<form:label path="name">Name </form:label>
						<form:input path="name" cssClass="form-control" />
					</p>

					<p>
						<form:label path="email">Email</form:label>
						<form:input path="email" cssClass="form-control" />
					</p>

					<p>
						<form:label path="age">Age </form:label>
						<form:input path="age" cssClass="form-control" />
					</p>
					<hr>
					<button class="btn btn-md btn-success">Submit</button>
				</form:form>
			</div>
		</div>
	</div>
</body>

</html>