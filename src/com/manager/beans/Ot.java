package com.manager.beans;

import java.sql.Date;
/*
 * ¼Ó°à
 */
public class Ot {
	private int oid;
	private Date date;
	private float hours;
	private int money;
	private int sid;
	
	public Ot() {
	}
	public Ot(int oid, Date date, float hours, int money) {
		this.oid = oid;
		this.date = date;
		this.hours = hours;
		this.money = money;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public float getHours() {
		return hours;
	}
	public void setHours(float hours) {
		this.hours = hours;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return "Ot [oid=" + oid + ", date=" + date + ", hours=" + hours
				+ ", money=" + money + "]";
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	
	
}
