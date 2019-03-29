<%@page import="com.evry.User"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page import="java.util.ArrayList" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>


</head>
<body>
	<h2 style="font-family: sans-serif;" align="center">All Patients Details</h2>
	<br>
	<%
	
		Object ob = request.getAttribute("userList");
		if(ob instanceof ArrayList){
			if(ob != null){
				ArrayList al = (ArrayList)ob;
				Iterator itr = al.iterator();
				
				while(itr.hasNext()){
					Object object = itr.next();
					if(object instanceof User){
						User user = (User)object;
						
						out.println("<div class='center'>");
						out.println("<table border='1' align='center'>");
							out.println("<tr>");
							out.println("<td>" + user.getName() + "</td>");
							out.println("<td>" + user.getAge() + "</td>");
							out.println("<td>" + user.getPhoneNo() + "</td>");
							out.println("<td>" + user.getCity() + "</td>");
							out.println("<td>" + user.getCountry() + "</td>");
							out.println("</tr>");
						out.println("</table>");
						out.println("</div>");
					}
				}
			}
		}
	
	%>
	
	
	<style><%@include file="/WEB-INF/css/styleForUserList.css"%></style>
	
</body>
