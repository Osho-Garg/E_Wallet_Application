package com.capgemini.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "wallet")
public class Wallet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int accountId;

	@Column
	private double balance;

	public Wallet() {
		super();
	}

	public Wallet(double balance) {
		super();
		this.balance = balance;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

//	public Account getAccount() {
//		return account;
//	}

//	public void setAccount(Account account) {
//		this.account = account;
//	}

	@Override
	public String toString() {
		return "Wallet [accountId=" + accountId + ", balance=" + balance + "]";
	}
	
	

}
