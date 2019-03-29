<%@page import="com.evry.User"%>
<html>
<head>


</head>
<body>
<br/>
<br/>
<br/>

		<h1 align="center" style="font-family: sans-serif;">Payment Application</h1>
	<div class="center">
		<form action="./success" method="GET">
		<p> You are now a Registered User </p>
		<%
			Object ob = request.getAttribute("user");
			if(ob instanceof User){
				User user = (User)ob;
				out.println("Your Generated User id is : " + user.getUserid());
				out.println("Your Generated Password is : " + user.getPassword());
			}
		
		%>
		</form>
		<form action="./login" method="GET">
						<input type="submit" class="button" name="loginPage" value="Login">
				</form>
		<form action="./logOut" method="GET">
				<input type="submit" class="button" name="logOut" value="Log Out">
		</form>
	</div>

	<style><%@include file="/WEB-INF/css/style.css"%></style>
</body>
</html>
