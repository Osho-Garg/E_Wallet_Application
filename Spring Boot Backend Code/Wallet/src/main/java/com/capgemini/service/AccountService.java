package com.capgemini.service;

import java.util.List;

import com.capgemini.entities.Account;
import com.capgemini.entities.LoginDetails;
import com.capgemini.entities.Transaction;
import com.capgemini.entities.Wallet;

public  interface AccountService {
		public Account addAccount(Account a);
		public LoginDetails userLogin(String userName,String password);
}
