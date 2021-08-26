package com.exokata.exokata.param;

public class Login {

	private long clientNum;
	private int secretCode;
	
	
	public Login(long clientNum, int secretCode) {
		super();
		this.clientNum = clientNum;
		this.secretCode = secretCode;
	}
	
	
	public Login() {
		super();
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
}
