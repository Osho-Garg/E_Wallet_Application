package com.capgemini.main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.capgemini.entities.Account;
import com.capgemini.entities.LoginDetails;
import com.capgemini.entities.Transaction;

@SpringBootTest
public class TransactionTest 
{
	RestTemplate rst;
	
	@BeforeEach
	public void setup() { 
		rst = new RestTemplate();
	}
	
	@Test
	public void transferMoney() {
		Transaction t=new Transaction();
		
		t.setSenderAccId(33);
		t.setReceiverAccId(35);
		t.setAmount(100);
		
		
		
		ResponseEntity<Transaction> transaction = rst.postForEntity("http://localhost:8085/transaction/transfer",t, Transaction.class);

		Assertions.assertEquals(200, transaction.getStatusCodeValue());
	}

	
	

}
