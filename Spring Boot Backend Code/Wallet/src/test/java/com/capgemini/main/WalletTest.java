package com.capgemini.main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.capgemini.entities.Account;

import com.capgemini.entities.Wallet;

@SpringBootTest
public class WalletTest {
	
RestTemplate rst;
	
	@BeforeEach
	public void setup() { 
		rst = new RestTemplate();
	}
	
	@Test
	public void deposit() {
		Wallet w=new Wallet();
		w.setAccountId(33);
		w.setBalance(100);
		
		ResponseEntity<Wallet> wallet = rst.postForEntity("http://localhost:8085/wallet/deposit",w, Wallet.class);
		
	
		Assertions.assertEquals(200, wallet.getStatusCodeValue());
	}

	@Test
	public void userProfile() {
		int accountId=32;
		
		ResponseEntity<Account> account = rst.getForEntity("http://localhost:8085/wallet/profile/"+accountId,Account.class);
		
		
		Assertions.assertEquals(200, account.getStatusCodeValue());
	}
	
	

}
