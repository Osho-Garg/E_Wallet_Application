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


@SpringBootTest
public class AccountTest 
{
	RestTemplate rst;
	
	@BeforeEach
	public void setup() { 
		rst = new RestTemplate();
	}
	
	@Test
	public void addAccount() {
		Account ac = new Account();
		
		ac.setUsername("Test_Username");
		ac.setPass("Test_Password");
		ac.setPhone("9056784322");
		ac.setEmailId("test@gmail.com");
		
		ResponseEntity<Account> account = rst.postForEntity("http://localhost:8085/accounts/new",ac, Account.class);
		Assertions.assertEquals(200, account.getStatusCodeValue());
	}

	@Test
	public void login() {
		
		
		String username="Test_Username";
		String password="Test_Password";
		
		ResponseEntity<LoginDetails> login = rst.postForEntity("http://localhost:8085/accounts/userLogin/"+username+"/"+password,null,null);
		Assertions.assertEquals(200, login.getStatusCodeValue());
	}
	

	
	
}
