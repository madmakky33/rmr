<%@taglib prefix="s" uri="/struts-tags"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GCM Server Panel</title>
</head>
<body>
	<div align="center">
		<h3>GCM Server Panel</h3>
		<hr />
		<s:form action="send_gcm_message" method="post">
			Targeted Client ID : <s:property value="gcmClientKey" />
			<br>
			<br>
			<s:textarea label="GCM Message" name="gcmMessage"></s:textarea>
			<s:submit value="Send GCM Message"></s:submit>
		</s:form>
	</div>
</body>
</html>