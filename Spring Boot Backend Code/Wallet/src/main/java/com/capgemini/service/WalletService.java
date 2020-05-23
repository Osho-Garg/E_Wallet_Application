package com.capgemini.service;



import com.capgemini.entities.Account;
import com.capgemini.entities.Wallet;

public interface WalletService {

	
	public void updateBalance(int accId,double amount);
	public double deposite(Wallet w, double amount);
	public Wallet findAccount(int accId) ;
	public Account userProfile(int userId);
}
