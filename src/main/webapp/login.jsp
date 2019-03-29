<html>
<head>


</head>
<body>
<br/>
<br/>
<br/>

		<h1 align="center" style="font-family: sans-serif;">User Login</h1>
	<div class="center">
		<form action="./loginUser" method="GET">
			<table align="center">
				<tr>
					<td><font style="font-family: sans-serif;"> User ID :</font></td>
					<td><input type="text" name="userid" size="30" /></td>
				</tr>
				<tr>
					<td><font style="font-family: sans-serif;"> Password :</font></td>
					<td><input type="text" name="password" size="30" /></td>
				</tr>
				
				<tr>
					<td colspan="2"><center><input type="submit" class="button" name="loginUser" value="Login"><center></td>
				</tr>
			</table>
		</form>

	</div>

	<style><%@include file="/WEB-INF/css/style.css"%></style>
</body>
</html>
