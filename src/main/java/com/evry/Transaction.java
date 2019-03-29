package com.evry;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="transaction")
public class Transaction {
	
	@Id
	@GeneratedValue (strategy= GenerationType.SEQUENCE, generator="transSeqGen")
	@SequenceGenerator(name = "transSeqGen", sequenceName = "TRANS_SEQ_GEN",initialValue=1)
	@Column(name = "TID")
	private int id;
	
	@Column(name = "TBALAMOUNT")
	private int balanceAmount;
	
	@Column(name = "TTYPE")
	private String transactionType;
	
	@Column(name = "TSTATUS")
	private String transactionStatus;

	@ManyToOne
	@JoinColumn(name="UID")
	private User user;
	
	public Transaction() {

	}

	public Transaction(int balanceAmount, String transactionType, String transactionStatus) {
		super();
		this.balanceAmount = balanceAmount;
		this.transactionType = transactionType;
		this.transactionStatus = transactionStatus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBalanceAmount() {
		return balanceAmount;
	}

	public void setBalanceAmount(int balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}
	
}
