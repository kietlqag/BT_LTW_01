<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reset Password</title>
</head>
<body>
	<form action="reset-password" method="post">
		<c:if test="${alert !=null}">
			<h3 class="alert alert-danger">${alert}</h3>
		</c:if>
		<label for="username">Username</label>
		<input type="text" id="username" name="username" required />

		<label for="password">Password</label>
		<input type="password" id="password" name="password" required />
		
		<label for="password-verify">Re-type password</label>
		<input type="password" id="password-verify" name="password-verify" required />

		<button type="submit">Reset password</button>
	</form>
</body>
</html>
