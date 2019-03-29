package com.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.daoImpl.UserDaoImpl;

public class AdminController extends HttpServlet{
		
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = null;
		
		UserDao userDao = new UserDaoImpl();
		
		HttpSession session = request.getSession(); 
		
		
		if(request.getParameter("adminLogin") != null) {
			rd = request.getRequestDispatcher("adminLogin.jsp");
			rd.forward(request, response);
		} else if (request.getParameter("adminUserSubmit") != null) {
			
			String adminUserName = request.getParameter("adminUserId");
			String adminUserPassword = request.getParameter("adminPassword");
			if(adminUserName.equalsIgnoreCase("admin") && adminUserPassword.equalsIgnoreCase("admin123")) {
				rd = request.getRequestDispatcher("adminDashboard.jsp");
				rd.forward(request, response);
			}
		}
		
	}
}
