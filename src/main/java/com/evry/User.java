package com.evry;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue (strategy= GenerationType.SEQUENCE, generator="userSeqGen")
	@SequenceGenerator(name = "userSeqGen", sequenceName = "USER_SEQ_GEN")
	@Column(name = "UID")
	private int id;
	
	@Column(name = "UNAME")
	private String name;
	
	@Column(name = "UAGE")
	private String age;
	
	@Column(name = "UPHONENO")
	private String phoneNo;
	
	@Column(name = "UCITY")
	private String city;
	
	@Column(name = "UCOUNTRY")
	private String country;
	
	@Column(name = "ULOGIN_ID")
	private String userid;
	
	@Column(name = "UPASSWORD")
	private String password;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="UID")
	private Set<Transaction> transactions;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean deleteTransaction(Transaction transaction) {
		transactions.remove(transaction);
		System.out.println("Removed a transaction");
		return true;
	}
	public boolean addTransaction(Transaction transaction) {
		this.transactions = new HashSet<Transaction>();
		System.out.println("Added a transaction");
		transactions.add(transaction);
		return true;
	}
	public Set<Transaction> getTransactions() {
		return transactions;
	}
}
