package com.dao;

import java.util.List;

import com.evry.User;

public interface UserDao {

	public boolean saveUser(User user);
	
	public List<User> getUsers();

	public User getUserByUserId(String userid);

	public boolean updateAmountByUserId(String userid, int finalAmount);
	
	public com.evry.Transaction getTransactionByUserId(String userid);

	public boolean transferAmountByUserId(String fromUserId, String toUserId, String amountToTransfer);
}
