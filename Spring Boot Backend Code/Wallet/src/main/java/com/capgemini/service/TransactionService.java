package com.capgemini.service;

import java.util.List;

import com.capgemini.entities.Transaction;
import com.capgemini.entities.Wallet;

public interface TransactionService {
	
	public Boolean TransferAmount(Transaction t);
	public List<Transaction> transactionHistory(int id);
	public void updateBalance(int accId, double amount);
	public Wallet findAccount(int accId);

}
