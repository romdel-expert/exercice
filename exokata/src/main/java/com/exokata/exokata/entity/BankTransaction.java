package com.exokata.exokata.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BankTransaction {
	
	@Id
	private long id;
	private String dateTransaction;
	private String typeTransaction;
	private float amountTransaction;
	private float balance;
	private String transacTitle;
	private long acountId;









	/**
	 * 
	 * @param id
	 * @param dateTransaction
	 * @param typeTransaction
	 * @param amountTransaction
	 * @param balance
	 * constructor of the class with all the fields
	 */
	public BankTransaction(long id, String dateTransaction, String typeTransaction, float amountTransaction,
			float balance, String transacTitle, long acountId) {
		super();
		this.id = id;
		this.dateTransaction = dateTransaction;
		this.typeTransaction = typeTransaction;
		this.amountTransaction = amountTransaction;
		this.balance = balance;
		this.transacTitle=transacTitle;
		this.acountId=acountId;
	}









	/**
	 * constructor of the the class form the super class
	 */
	public BankTransaction() {
		super();
	}










	public long getId() {
		return id;
	}










	public void setId(long id) {
		this.id = id;
	}










	public String getDateTransaction() {
		return dateTransaction;
	}










	public void setDateTransaction(String dateTransaction) {
		this.dateTransaction = dateTransaction;
	}










	public String getTypeTransaction() {
		return typeTransaction;
	}










	public void setTypeTransaction(String typeTransaction) {
		this.typeTransaction = typeTransaction;
	}










	public float getAmountTransaction() {
		return amountTransaction;
	}










	public void setAmountTransaction(float amountTransaction) {
		this.amountTransaction = amountTransaction;
	}










	public float getBalance() {
		return balance;
	}










	public void setBalance(float balance) {
		this.balance = balance;
	}



	






	public long getAcountId() {
		return acountId;
	}









	public void setAcountId(long acountId) {
		this.acountId = acountId;
	}


	






	public String getTransacTitle() {
		return transacTitle;
	}









	public void setTransacTitle(String transacTitle) {
		this.transacTitle = transacTitle;
	}









	@Override
	public String toString() {
		return "BankTransaction [id=" + id + ", dateTransaction=" + dateTransaction + ", typeTransaction="
				+ typeTransaction + ", amountTransaction=" + amountTransaction + ", balance=" + balance + "]";
	}
}
