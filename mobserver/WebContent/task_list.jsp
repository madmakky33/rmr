<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<style>
body,input {
	font-family: Calibri, Arial;
}

table#task {
	border-collapse: collapse;
	width: 90%;
}

th {
	height: 40px;
	background-color: #ffee55;
}
</style>
<title>Task List Manager</title>
</head>
<body>
	<div align="center">
		<h1>Task List Manager</h1>
		<hr>
		<s:actionerror />

		<s:form action="add_task" method="post">
			<%-- <s:textfield name="task.taskId" label="Task Id" /> --%>
			<s:textfield name="task.taskName" label="Dealer Name" />
			<s:textfield name="task.taskContact" label="Contact" />
			<s:select list="usernames" name="task.username" label="FOS"></s:select>
			<%-- <s:textfield name="task.username" label="Fos" /> --%>
			<s:textfield name="task.definedLat" label="Lat" />
			<s:textfield name="task.definedLang" label="Long" />
			<s:textfield name="task.targetAmount" label="Targeted Amount" />
			<s:textfield name="task.collectedAmt" label="Collected Amount" />
			<s:submit value="Add Task" align="center" />
		</s:form>


		<h2>Tasks List</h2>
		<table id="task" border="1">
			<tr>
				<th>Task Id</th>
				<th>Dealer Name</th>
				<th>Contact</th>
				<th>Fos</th>
				<th>Lat</th>
				<th>Lang</th>
				<th>Targeted Amount</th>
				<th>Collected Amount</th>
				<th>Task Date</th>
				<th>Closed Date</th>
				<th>Delete</th>
			</tr>
			<s:iterator value="taskList" var="task">
				<tr>
					<td><s:property value="taskId" /></td>
					<td><s:property value="taskName" /></td>
					<td><s:property value="taskContact" /></td>
					<td><s:property value="username" /></td>
					<td><s:property value="definedLat" /></td>
					<td><s:property value="definedLang" /></td>
					<td><s:property value="targetAmount" /></td>
					<td><s:property value="collectedAmt" /></td>
					<td><s:property value="assignedDate" /></td>
					<td><s:property value="closedDate" /></td>
					<td><a href="delete_task?taskId=<s:property value="taskId"/>">delete</a></td>
				</tr>
			</s:iterator>
		</table>
	</div>

	<hr>
	<div align="center">
		<a href="home.action">Home</a> <a href="index.action">FOS
			Management</a>
	</div>
</body>
</html>