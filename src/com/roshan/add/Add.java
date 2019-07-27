package com.roshan.add;

import java.util.Date;

public class Add {
	
	private int txn;
	private int userId;
	private String date;
	private String purpose;
	private int amount;
	private String mode;
	private int total;
	public Add() {
		// TODO Auto-generated constructor stub
	}
	public int getTxn() {
		return txn;
	}
	public void setTxn(int txn) {
		this.txn = txn;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	public Add(int userId, String date, String purpose, int amount, String mode) {
		super();
		this.userId = userId;
		this.date = date;
		this.purpose = purpose;
		this.amount = amount;
		this.mode = mode;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	

}
