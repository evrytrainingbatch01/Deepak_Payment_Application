package com.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dao.UserDao;
import com.evry.TransactionStatus;
import com.evry.TransactionType;
import com.evry.User;
import com.uitl.HibernateUtil;

public class UserDaoImpl implements UserDao {
	
	Session ses = HibernateUtil.getSessionFactory().openSession();

	
	//SAVE
	public boolean saveUser(User user) {
          Transaction tx=ses.beginTransaction();
         
          com.evry.Transaction transaction = new com.evry.Transaction(new Integer(100), TransactionType.DEFAULT.toString(), TransactionStatus.DEFAULT.toString());
          
          user.addTransaction(transaction);
          
          ses.save(user);
          ses.save(transaction);
          tx.commit();
          return true;
	}

	//SHOW USERS
	public List<User> getUsers() {
		List<User> userList = new ArrayList();
        Query query = ses.createQuery("from User");
        userList = query.list();
        return userList;
	}

	public User getUserByUserId(String userid) {
		String hqlQuery = "from User u " + 
				"where u.userid = :userid";
		Query query = ses.createQuery(hqlQuery.toString());
		query.setParameter("userid", userid);
		User user = (User)query.uniqueResult();
		return user;
	}
	
	public com.evry.Transaction getTransactionByUserId(String userid) {
		String hqlQuery = "from Transaction t " + 
				"where t.user.userid = :userid";
		Query query = ses.createQuery(hqlQuery.toString());
		query.setParameter("userid", userid);
		com.evry.Transaction transaction = (com.evry.Transaction)query.uniqueResult();
		return transaction;
	}

	public boolean updateAmountByUserId(String userid, int finalAmount) {
		String hqlQuery = "update Transaction t set t.balanceAmount = :finalAmount " +
				"where t.user.userid = :userid";
		Query query = ses.createQuery(hqlQuery.toString());
		query.setParameter("finalAmount", finalAmount);
		User user = getUserByUserId(userid);
		query.setParameter("userid", user.getUserid());
		
		com.evry.Transaction transaction = getTransactionByUserId(userid);
		if(transaction.getBalanceAmount() != 0) {
			Integer sumValue = Integer.sum(transaction.getBalanceAmount(), finalAmount);
			transaction.setBalanceAmount(sumValue.intValue());
			
			Transaction tx=ses.beginTransaction();
			ses.saveOrUpdate(transaction);
			tx.commit();
		}
		
		return true;
	}

	public boolean transferAmountByUserId(String fromUserId, String toUserId, String amountToTransfer) {
		//get first user transaction
		com.evry.Transaction userTransaction1 = getTransactionByUserId(fromUserId);
		//get second user transaction
		com.evry.Transaction userTransaction2 = getTransactionByUserId(toUserId);
		
		
		int newBalAmountOfUser1 = Math.subtractExact(userTransaction1.getBalanceAmount(), Integer.parseInt(amountToTransfer));
		int newBalAmountOfUser2 = Math.addExact(userTransaction2.getBalanceAmount(), Integer.parseInt(amountToTransfer));
		
		userTransaction1.setBalanceAmount(newBalAmountOfUser1);
		userTransaction2.setBalanceAmount(newBalAmountOfUser2);
		
		Transaction tx=ses.beginTransaction();
		ses.saveOrUpdate(userTransaction1);
		ses.saveOrUpdate(userTransaction2);
		tx.commit();
		
		return true;
	}

}
