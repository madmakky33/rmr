<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<center>
		<h2>LOGIN TO MOB SERVER</h2>
		<br />
		<s:form action="login.action">
			<table>
				<tr>
					<s:textfield name="userName" label="User Name"></s:textfield>
				</tr>
				<tr>
					<s:password name="password" label="Password"></s:password>
				</tr>
				<tr>
					<s:submit value="submit"></s:submit>
				</tr>
			</table>
		</s:form>
		<s:a href="signup.jsp" label="Sign Up">Sign Up</s:a>
	</center>
</body>
</html>