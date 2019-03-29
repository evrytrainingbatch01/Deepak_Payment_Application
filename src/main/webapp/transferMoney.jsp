<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.evry.User"%>
<%@page import="com.evry.Transaction"%>
<%@page import="java.lang.Integer"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Money</title>
</head>
<body>
	<h1 align="center" style="font-family: sans-serif;">Transfer Money</h1>
	
	<div class="center">
		<form action="./transferMoney" method="GET">
		
			<table align="center">
				<!-- <tr>
					<td><font style="font-family: sans-serif;"> From user ID :</font></td>
					<td><input type="text" name="fromuserid" size="30" /></td>
				</tr> -->
				<tr>
					<td><font style="font-family: sans-serif;"> To user ID :</font></td>
					<td><input type="text" name="touserid" size="30" /></td>
				</tr>
				
				<tr>
					<td><font style="font-family: sans-serif;"> Amount To Transfer :</font></td>
					<td><input type="text" name="amountToTransfer" size="30" /></td>
				</tr>
				
				<tr>
					<td colspan="2"><center><input type="submit" class="button" name="transfer" value="Transfer"><center></td>
				</tr>
			</table>
		</form>
		
		<style><%@include file="/WEB-INF/css/style.css"%></style>
</body>
</html>