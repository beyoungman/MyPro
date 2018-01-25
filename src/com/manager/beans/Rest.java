package com.manager.beans;

import java.sql.Date;
/*
 * ĞİÏ¢
 */
public class Rest {
	private int rid;
	private Date date;
	private float days;
	private int sid;
	public Rest() {
	}
	public Rest(int rid, Date date, float days ,int sid) {
		this.rid = rid;
		this.date = date;
		this.days = days;
		this.setSid(sid);
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public float getDays() {
		return days;
	}
	public void setDays(float days) {
		this.days = days;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	
}
