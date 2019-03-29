<%@page import="com.evry.User"%>
<html>
<head>


</head>
<body>
	<br />
	<br />
	<br />

	<h1 align="center" style="font-family: sans-serif;">Payment Application</h1>
	<div class="center">
		<form action="./loginSuccess" method="GET">
			<p>You are now Logged in as</p>
			<%
				Object loginSuccessUser = request.getAttribute("user");
				if (loginSuccessUser instanceof User) {
					User user = (User) loginSuccessUser;
					out.println("<b>");
					out.println("User id : " + user.getUserid());
					out.println("&nbsp;&nbsp;");
					out.println("User name : " + user.getName());
					out.println("</b>");
					
					session.setAttribute("user", user);
				}
			%>
		</form>
		<form action="./addMoney" method="GET">
			<input type="submit" class="button" name="addMoney" value="Add Money">
		</form>
		<form action="./transferMoney" method="GET">
			<input type="submit" class="button" name="transferMoney"
				value="Transfer Money">
		</form>
		<form action="./checkBalance" method="GET">
			<input type="submit" class="button" name="checkBalance" value="Check Balance">
		</form>
		<form action="./logOut" method="GET">
			<input type="submit" class="button" name="logOut" value="Log Out">
		</form>
	</div>

	<style>
	<%@include file="/WEB-INF/css/style.css"%>
</style>
</body>
</html>
