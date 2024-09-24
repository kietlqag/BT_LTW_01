<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/BT_LTW_01/register" method="post">
		<c:if test="${alert !=null}">
			<h3 class="alert alert-danger">${alert}</h3>
		</c:if>
		<div class="container">
			<h1>Register</h1>
			<p>Please fill in this form to create an account.</p>
			<hr>

			<label for="username"><b>Username</b></label> <input type="text"
				placeholder="Enter Username" name="username" id="username" required>

			<label for="psw"><b>Password</b></label> <input type="password"
				placeholder="Enter Password" name="password" id="password" required>
			<hr>

			<button type="submit" class="registerbtn">Register</button>
		</div>
	</form>
</body>
</html>