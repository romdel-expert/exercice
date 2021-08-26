package com.exokata.exokata.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Acount {
	@Id
	private long id;
	private String accountNum;
	private float balance;
	private String dateCreatedAcc;
	private String AcTitle;
	private long clientId;
	
	
	
	
	
	
	/**
	 * 
	 * @param id
	 * @param accountNum
	 * @param balance
	 * @param dateCreatedAcc
	 * @param clientId
	 * Constructor of the class using all the field
	 * 
	 */
		public Acount(long id, String accountNum, float balance, String dateCreatedAcc, String AcTitle, long clientId) {
		super();
		this.id = id;
		this.accountNum = accountNum;
		this.balance = balance;
		this.dateCreatedAcc = dateCreatedAcc;
		this.AcTitle=AcTitle;
		this.clientId = clientId;
	}




	/**
	 * constructor of the class using super class
	 */
	public Acount() {
		super();
	}





	public long getId() {
		return id;
	}





	public void setId(long id) {
		this.id = id;
	}





	public String getAccountNum() {
		return accountNum;
	}





	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}





	public double getBalance() {
		return balance;
	}





	public void setBalance(float balance) {
		this.balance = balance;
	}





	public String getDateCreatedAcc() {
		return dateCreatedAcc;
	}





	public void setDateCreatedAcc(String dateCreatedAcc) {
		this.dateCreatedAcc = dateCreatedAcc;
	}
	
	





	public String getAcTitle() {
		return AcTitle;
	}



	public void setAcTitle(String acTitle) {
		AcTitle = acTitle;
	}



	public long getClientId() {
		return clientId;
	}





	public void setClientId(long clientId) {
		this.clientId = clientId;
	}





	@Override
	public String toString() {
		return "Acount [id=" + id + ", accountNum=" + accountNum + ", balance=" + balance + ", dateCreatedAcc="
				+ dateCreatedAcc + "]";
	}
	
}
