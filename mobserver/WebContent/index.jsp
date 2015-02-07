<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<style>
body,input {
	font-family: Calibri, Arial;
}

table#contact {
	border-collapse: collapse;
	width: 550px;
}

th {
	height: 40px;
	background-color: #ffee55;
}
</style>
<title>FOS Manager</title>
</head>
<body>
	<div align="center">
		<h1>FOS Manager</h1>
		<hr>
		<s:actionerror />

		<s:form action="add" method="post">
			<s:textfield name="fos.username" label="User Name" />
			<s:password name="fos.password" label="password" />
			<s:textfield name="fos.fullName" label="Full Name" />
			<s:textfield name="fos.email" label="Email" />
			<s:textfield name="fos.contact" label="Contact" />
			<s:submit value="Add FOS" align="center" />
		</s:form>


		<h2>Fos List</h2>
		<table id="contact" border="1">
			<tr>
				<th>User Name</th>
				<th>Full Name</th>
				<th>Email</th>
				<th>Contact</th>
				<th>Delete</th>
			</tr>
			<s:iterator value="fosList" var="fos">
				<tr>
					<td><s:property value="username" /></td>
					<td><s:property value="fullName" /></td>
					<td><s:property value="email" /></td>
					<td><s:property value="contact" /></td>
					<td><a href="delete?username=<s:property value="username"/>">delete</a></td>
				</tr>
			</s:iterator>
		</table>
	</div>
	<hr>
	<div align="center">
		<a href="home.action">Home</a> <a href="task_list.action">Task
			Management</a>
	</div>
</body>
</html>