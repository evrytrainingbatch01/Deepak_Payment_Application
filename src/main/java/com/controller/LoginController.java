package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.dao.UserDao;
import com.daoImpl.UserDaoImpl;
import com.evry.Transaction;
import com.evry.User;

public class LoginController extends HttpServlet{
	
	/**
	 * DEEPAK J A
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
		
		UserDao userDao = new UserDaoImpl();
		HttpSession session = request.getSession(); 
		
		
		
		if (request.getParameter("loginUser") != null) {
					
					String userid = request.getParameter("userid");
					String password = request.getParameter("password");
					
					
					List<User> listOfUsers = userDao.getUsers();
					if(userid !=null && password != null) {
						for(User user : listOfUsers) {
							if(user.getUserid().equalsIgnoreCase(userid) && user.getPassword().equalsIgnoreCase(password)) {
								request.setAttribute("user", user);
								rd = request.getRequestDispatcher("loginSuccess.jsp");
								rd.forward(request, response);
							}
						}
					}
			} else if(request.getParameter("loginSuccess") != null) {
				rd = request.getRequestDispatcher("loginSuccess.jsp");
				rd.forward(request, response);
			} else if (request.getParameter("addMoney") != null) {
				rd = request.getRequestDispatcher("addMoney.jsp");
				rd.forward(request, response);
			}else if (request.getParameter("add") != null) {
				
				String amoutToBeAdded = request.getParameter("amount");
				
				if(amoutToBeAdded != null && session.getAttribute("user") != null) {
					User sessionUser = (User) session.getAttribute("user");
					User retrievedUser = userDao.getUserByUserId(sessionUser.getUserid());
					/*Integer totalAmount = new Integer(0);
					
					System.out.println(retrievedUser);
					for(Transaction transaction : retrievedUser.getTransactions()) {
						totalAmount = Integer.sum(totalAmount, transaction.getBalanceAmount());
					}
					Integer finalAmount = Integer.sum(totalAmount, Integer.parseInt(amoutToBeAdded));
					int amountToUpdate = finalAmount.intValue();*/
					boolean isAmountUpdated = userDao.updateAmountByUserId(retrievedUser.getUserid(), Integer.parseInt(amoutToBeAdded));
					if(isAmountUpdated) {
						System.out.println("Amount Updated");
						rd = request.getRequestDispatcher("addMoneySuccessfully.jsp");
						rd.forward(request, response);
					}
				}
				
			} else if (request.getParameter("transferMoney") != null) {
				rd = request.getRequestDispatcher("transferMoney.jsp");
				rd.forward(request, response);
			} else if(request.getParameter("transfer") != null) {
				
				User sessionUser = (User) session.getAttribute("user");
				User retrievedUser = userDao.getUserByUserId(sessionUser.getUserid());
				
				String fromUserId = sessionUser.getUserid();
				String toUserId = request.getParameter("touserid");
				String amountToTransfer =  request.getParameter("amountToTransfer");
				
				if(fromUserId != null && toUserId != null && amountToTransfer != null) {
					
					boolean isTransfered = userDao.transferAmountByUserId(fromUserId, toUserId, amountToTransfer);
					if(isTransfered) {
						rd = request.getRequestDispatcher("moneyTransferedSuccessfully.jsp");
						rd.forward(request, response);
					}
					
				}
				
				
			}else if (request.getParameter("checkBalance") != null) {
			
				User sessionUser = (User) session.getAttribute("user");
				User retrievedUser = userDao.getUserByUserId(sessionUser.getUserid());
				
				
				rd = request.getRequestDispatcher("checkBalance.jsp");
				rd.forward(request, response);
			} else if(request.getParameter("logOut") != null) {
				rd = request.getRequestDispatcher("logOut.jsp");
				response.sendRedirect("http://localhost:8292/HospitalForm/paymentApp.jsp");
				session.invalidate();
			} else {
				System.out.println("Do nothing");
			}
	}

}
