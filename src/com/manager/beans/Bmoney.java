package com.manager.beans;

import java.sql.Date;
/*
 * ½èÖ§
 */
public class Bmoney {
	private int bid;
	private Date date;
	private int money;
	private int sid;
	
	
	public Bmoney() {
	}
	public Bmoney(int bid, Date date, int money,int sid) {
		this.bid = bid;
		this.date = date;
		this.money = money;
		this.setSid(sid);
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	
}
