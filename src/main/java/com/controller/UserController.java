package com.controller;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.RandomStringUtils;

import com.dao.UserDao;
import com.daoImpl.UserDaoImpl;
import com.evry.User;

/**
 * DEEPAK J A
 * 
 */
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	User user = new User();
	UserDao userDao = new UserDaoImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = null;

		
		if(request.getParameter("registerPage") != null) {
			rd = request.getRequestDispatcher("register.jsp");
			rd.forward(request, response);
		} else if(request.getParameter("loginPage") != null) {
			rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		} else if(request.getParameter("adminLogin") != null) {
			rd = request.getRequestDispatcher("adminLogin.jsp");
			rd.forward(request, response);
		} else if (request.getParameter("registerUser") != null) {

			String name = request.getParameter("name");
			String age = request.getParameter("age");
			String phoneNo = request.getParameter("phoneNo");
			String city = request.getParameter("city");
			String country = request.getParameter("country");

			user.setName(name);
			user.setAge(age);
			user.setPhoneNo(phoneNo);
			user.setCity(city);
			user.setCountry(country);
			
			Random rand = new Random();
			Integer number = rand.nextInt(9000000) + 1000000;
			
			user.setUserid(number.toString());
			user.setPassword(RandomStringUtils.randomAlphanumeric(17).toUpperCase());

			boolean isUserSaved = userDao.saveUser(user);
			if (isUserSaved) {
				System.out.println("User saved");
				request.setAttribute("user", user);
				rd = request.getRequestDispatcher("success.jsp");
				rd.forward(request, response);
			} else {
				System.out.println("User not saved");
				rd = request.getRequestDispatcher("failure.jsp");
				rd.forward(request, response);
			}

		}  
	}

}
