<html>
<head>


</head>
<body>
<br/>
<br/>
<br/>

		<h1 align="center" style="font-family: sans-serif;">Admin User Login</h1>
	<div class="center">
		<form action="./adminLogin" method="GET">
			<table align="center">
				<tr>
					<td><font style="font-family: sans-serif;"> Admin User ID :</font></td>
					<td><input type="text" name="adminUserId" size="30" /></td>
				</tr>
				<tr>
					<td><font style="font-family: sans-serif;"> Admin Password :</font></td>
					<td><input type="text" name="adminPassword" size="30" /></td>
				</tr>
				
				<tr>
					<td colspan="2"><center><input type="submit" class="button" name="adminUserSubmit" value="Submit"><center></td>
				</tr>
			</table>
		</form>

	</div>

	<style><%@include file="/WEB-INF/css/style.css"%></style>
</body>
</html>
