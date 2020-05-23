package com.capgemini.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.daos.AccountDAO;
import com.capgemini.daos.TransactionDAO;
import com.capgemini.daos.WalletDAO;
import com.capgemini.entities.Account;
import com.capgemini.entities.Wallet;
import com.capgemini.exception.ApplicationException;

@Service
@Transactional
public class WalletServiceImpl implements WalletService 
{
	

	@Autowired
	AccountDAO dao;
	@Autowired
	WalletDAO walletDao;
	

	@Transactional(propagation = Propagation.REQUIRED)
	public void updateBalance(int accId, double amount) 
	{
		
		Wallet w;
		Optional<Wallet> p = walletDao.findById(accId);
		if (p.isPresent())
			w = p.get();
		else
			throw new ApplicationException("Account not found!"); 

		w.setBalance(amount);

	}


	@Transactional(propagation = Propagation.REQUIRED)
	public double deposite(Wallet w, double amount) {
		// TODO Auto-generated method stub
		if (amount >= 0) {
			double new_balance = w.getBalance() + amount;			
			updateBalance(w.getAccountId(),new_balance);
			System.out.println("deposite");
			return new_balance;
		}

		return w.getBalance();
	}
	
	
	@Transactional(readOnly = true)
	public Wallet findAccount(int accId) {
		// TODO Auto-generated method stub
		Optional<Wallet> a = walletDao.findById(accId);
		
		if (a.isPresent()) 
			return a.get();
		else
			throw new ApplicationException("AccountId  not found!"); 
	}
	

	@Transactional(readOnly = true)
	public Account userProfile(int userId) {
		Account a = dao.findById(userId).orElse(new Account());
		if(a.getId() == 0) {
			throw new ApplicationException("Account not found!");	
		}
		else {
			return a;
		}
	}


}
