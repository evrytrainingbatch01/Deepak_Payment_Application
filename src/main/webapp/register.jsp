<html>
<head>


</head>
<body>
<br/>
<br/>
<br/>

		<h1 align="center" style="font-family: sans-serif;">User Registration</h1>
	<div class="center">
		<form action="./register" method="GET">
			<table align="center">
				<tr>
					<td><font style="font-family: sans-serif;"> Name :</font></td>
					<td><input type="text" name="name" size="30" /></td>
				</tr>
				<tr>
					<td><font style="font-family: sans-serif;"> Age :</font></td>
					<td><input type="text" name="age" size="30" /></td>
				</tr>
				
				<tr>
					<td><font style="font-family: sans-serif;"> Phone No :</font></td>
					<td><input type="text" name="phoneNo" size="30" /></td>
				</tr>

				<tr>
					<td><font style="font-family: sans-serif;"> City :</font></td>
					<td><select name="city">
							<option value="Bangalore">Bangalore</option>
							<option value="Mysore">Mysore</option>
							<option value="Hyderabad">Hyderabad</option>
							<option value="Chennai">Chennai</option>
							<option value="Hubli">Hubli</option>
					</select></td>
				</tr>
				
				<tr>
					<td><font style="font-family: sans-serif;"> Country :</font></td>
					<td><select name="country">
							<option value="India">India</option>
							<option value="Usa">Usa</option>
							<option value="China">China</option>
							<option value="Srilanka">Srilanka</option>
							<option value="Portugal">Portugal</option>
					</select></td>
				</tr>
				
				<tr>
					<td colspan="2"><center><input type="submit" class="button" name="registerUser" value="Register"><center></td>

				</tr>
			</table>
		</form>

		<!-- <form action="./showAll" method="GET">
			<center><input type="submit" class="button" name="showUsers" value="Show User List"></center>
		</form> -->

	</div>

	<style><%@include file="/WEB-INF/css/style.css"%></style>
</body>
</html>
