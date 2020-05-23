package com.capgemini.entities;

public class User {

	private String username;
	private String pass;
	private String phoneNo;
	private String emailId;

	public User() {
		super();
	}

	public User(String username, String pass, String phoneNo,String emailId) {
		super();
		this.username = username;
		this.pass = pass;
		this.phoneNo = phoneNo;
		this.emailId = emailId;
	}

	public String getUsername() {
		return username;
	}

	public void setUserName(String userName) {
		this.username = userName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

}
