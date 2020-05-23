package com.capgemini.entities;

public class LoginDetails {
	
	private boolean status;
	private long userId;
	private String name;
	private int accountId;
	
	public boolean isStatus() {
		return this.status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
}
