<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up</title>
</head>
<body>
	<h3>Please fill the form New Reg.</h3>
	<div align="center"></div>
	<s:form>
		<s:textfield name="username" label="username"></s:textfield>
		<s:textfield name="email" label="email"></s:textfield>
		<s:textfield name="contact" label="contact"></s:textfield>
		<s:submit value="Sign Up"></s:submit>
	</s:form>
</body>
</html>