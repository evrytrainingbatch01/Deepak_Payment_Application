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
	<h1 align="center" style="font-family: sans-serif;">Check Balance</h1>
	
	<div class="center">
		<form action="./checkBalance" method="GET">
		
		
		<p>Your Balance is : </p>
		<%
			Object userInSession = session.getAttribute("user"); 
			
			
			//Object ob = request.getAttribute("user");
			if(userInSession instanceof User){
				User user = (User)userInSession;
				Integer totalAmount = 0;
				for(Transaction transaction: user.getTransactions()){
					totalAmount = Integer.sum(totalAmount, transaction.getBalanceAmount());
				}
				out.println(totalAmount);
			} 
			
		%>
		
		</form>
	</div>
	
	<style><%@include file="/WEB-INF/css/style.css"%></style>
</body>
</html>