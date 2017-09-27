<html>
<body>
	<a href="logOutServlet">LogOut</a>
	<h2>Add New Employee</h2>
	<form action="SaveServlet">
		<table>
			<tbody>
				<tr>
					<td>Name:</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><input type="email" name="email"></td>
				</tr>
				<tr>
					<td>Country:</td>
					<td><select name="country">
							<option>India</option>
							<option>USA</option>
							<option>UK</option>
							<option>Japan</option>
					</select></td>
				</tr>
				<tr>
					<td><input type="submit" value="Add"></td>
					<td><a href="ViewServlet">View Employees</a></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>
