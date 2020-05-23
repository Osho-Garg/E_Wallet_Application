package com.capgemini.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.entities.Account;
import com.capgemini.entities.LoginDetails;

import com.capgemini.service.AccountService;

import com.capgemini.daos.AccountDAO;
import com.capgemini.daos.TransactionDAO;
import com.capgemini.daos.WalletDAO;
import com.capgemini.exception.ApplicationException;


@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountDAO dao;
	
	public Account addAccount(Account a) {
		
		if (dao.findByUsername(a.getUsername())!=null)
			throw new ApplicationException("Account already exists!!"); 
		
		dao.save(a); 
		System.out.println("Account added to the database");
		return a;
	}

	public LoginDetails userLogin(String username, String pass) {

		if (dao.findByUsernameAndPass(username, pass) != null) {
			Account userdata = dao.findByUsernameAndPass(username, pass);
			LoginDetails details = new LoginDetails();
			details.setStatus(true);
			details.setUserId(userdata.getId());
			details.setName(userdata.getUsername());
			details.setAccountId(userdata.getWallet().getAccountId());
			return details;
		} else {
			LoginDetails details = new LoginDetails();
			details.setStatus(false);
			details.setUserId(0);
			details.setName("");
			details.setAccountId(0);
			return details;
		}

	}

}
