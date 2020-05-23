package com.capgemini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.Transaction;
import com.capgemini.service.AccountService;
import com.capgemini.service.TransactionService;
import com.capgemini.service.WalletService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/transaction")
public class TransactionController {
	
	
	@Autowired TransactionService transaction;
	
	/*
	 This controller method is used to transfer the money
	 */
	@PostMapping(value = "/transfer", consumes = { "application/json" })
	public boolean transferMoney(@RequestBody Transaction t) {
		return transaction.TransferAmount(t);
	}
	/*
	 This controller method is used to list the 
	 transaction history
	 */
	@GetMapping(value = "/history/{senderId}")
	public List<Transaction> transactionHistory(@PathVariable int senderId) {
		// to find a account by id
		List<Transaction> history = transaction.transactionHistory(senderId);
		return history; 
	}

}
