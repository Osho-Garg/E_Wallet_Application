package com.capgemini.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.Account;
import com.capgemini.entities.Wallet;
import com.capgemini.service.AccountService;
import com.capgemini.service.TransactionService;
import com.capgemini.service.WalletService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/wallet")
public class WalletController 
{
	@Autowired AccountService account;
	@Autowired TransactionService transaction;
	@Autowired WalletService wallet;
	
	
	
	/*
	 This controller method is used for adding money in
	 the wallet
	 */
	@PostMapping(value = "/deposit", consumes = { "application/json" })
	public double deposit(@RequestBody Wallet input) {
		Wallet w = wallet.findAccount(input.getAccountId());
		double amount = input.getBalance();
		
		return wallet.deposite(w, amount);
	}

	
	/*
	 This controller method is used for viewing the
	 user profile
	 */
	@GetMapping(value = "/profile/{id}")
	public Account userProfile(@PathVariable int id) {

		Account a = wallet.userProfile(id);
		return a; 
	}
}
