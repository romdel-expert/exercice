package com.exokata.exokata.entity;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Client {
	
	@Id
	private long id;
	private String fName;
	private String lName;
	private long clientNum;
	private int secretCode;
	
	
	
	
	
	
	
	
	
	/**
	 * 
	 * @param id
	 * @param fName
	 * @param lName
	 * @param clientNum
	 * @param secretCode
	 * Constructor of the class using all the field without the id
	 */
	public Client(long id, String fName, String lName, long clientNum, int secretCode) {
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.clientNum = clientNum;
		this.secretCode = secretCode;
	}










	/**
	 * constructor of the class using super class
	 */
	public Client() {
		super();
	}










	public long getId() {
		return id;
	}










	public void setId(long id) {
		this.id = id;
	}










	public String getfName() {
		return fName;
	}










	public void setfName(String fName) {
		this.fName = fName;
	}










	public String getlName() {
		return lName;
	}










	public void setlName(String lName) {
		this.lName = lName;
	}










	public long getClientNum() {
		return clientNum;
	}










	public void setClientNum(long clientNum) {
		this.clientNum = clientNum;
	}










	public int getSecretCode() {
		return secretCode;
	}










	public void setSecretCode(int secretCode) {
		this.secretCode = secretCode;
	}










	@Override
	public String toString() {
		return "Client [id=" + id + ", fName=" + fName + ", lName=" + lName + ", clientNum=" + clientNum
				+ ", secretCode=" + secretCode + "]";
	}
}
