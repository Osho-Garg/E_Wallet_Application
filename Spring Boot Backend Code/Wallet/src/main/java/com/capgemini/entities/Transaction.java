package com.capgemini.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
@Entity
@Table(name = "wallettransaction")
public class Transaction implements Serializable  {

	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int traId;
	@Column
	private int senderAccId;
	@Column
	private int receiverAccId;
	@Column
	private double amount;
	
	@CreationTimestamp
	@Column(updatable = false)
	private  LocalDate time;
	
	
	public Transaction() {
		super();
	}


	public Transaction( int senderAccId, int receiverAccId, double amount, LocalDate time) {
		super();
		this.senderAccId = senderAccId;
		this.receiverAccId = receiverAccId;
		this.amount = amount;
		this.time = time;
	}


	public int getTraId() {
		return traId;
	}


	public void setTraId(int traId) {
		this.traId = traId;
	}


	public int getSenderAccId() {
		return senderAccId;
	}


	public void setSenderAccId(int senderAccId) {
		this.senderAccId = senderAccId;
	}


	public int getReceiverAccId() {
		return receiverAccId;
	}


	public void setReceiverAccId(int receiverAccId) {
		this.receiverAccId = receiverAccId;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public LocalDate getTime() {
		return time;
	}


	public void setTime(LocalDate time) {
		this.time = time;
	}


	@Override
	public String toString() {
		return "Transaction [traId=" + traId + ", senderAccId=" + senderAccId + ", receiverAccId=" + receiverAccId
				+ ", amount=" + amount + ", time=" + time + "]";
	}
	
	
	
}
