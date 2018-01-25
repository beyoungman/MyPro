package com.manager.beans;

import java.sql.Date;
/*
 * 临时加上，其他方面的支出。
 */
public class OtherPay {
	
	private int id;
	private Date date;
	private String payFor;
	private float money;
	private int user_id;
	
	public OtherPay(){
		
	}
	
	public OtherPay(int id, Date date, String payFor, float money, int user_id) {
		this.id = id;
		this.date = date;
		this.payFor = payFor;
		this.money = money;
		this.user_id = user_id;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getPayFor() {
		return payFor;
	}


	public void setPayFor(String payFor) {
		this.payFor = payFor;
	}


	public float getMoney() {
		return money;
	}


	public void setMoney(float money) {
		this.money = money;
	}


	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	
}
