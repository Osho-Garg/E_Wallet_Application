package com.capgemini.exception;
@SuppressWarnings("serial")
public class TransactionException extends RuntimeException {

	public TransactionException(String message)
	{
		super(message);
	}

}
