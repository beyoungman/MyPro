package com.manager.beans;

import java.io.Serializable;
import java.sql.Date;
/*
 * 
 * Âô»õ
 *
 */
public class Sale implements Serializable {
	
	private int sale_id;
	private Date date;
	private String customer;
	private String goods;
	private int weight;
	private int weigh_money;
	private int money;
	private String remarks;
	private int user_id;
	
	public Sale() {
		
	}

	public Sale(int sale_id, Date date, String customer, String goods,
			int weight, int weigh_money, int money, String remarks, int user_id) {
		this.sale_id = sale_id;
		this.date = date;
		this.customer = customer;
		this.goods = goods;
		this.weight = weight;
		this.weigh_money = weigh_money;
		this.money = money;
		this.remarks = remarks;
		this.user_id = user_id;
	}

	public int getSale_id() {
		return sale_id;
	}

	public void setSale_id(int sale_id) {
		this.sale_id = sale_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getGoods() {
		return goods;
	}

	public void setGoods(String goods) {
		this.goods = goods;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getWeigh_money() {
		return weigh_money;
	}

	public void setWeigh_money(int weigh_money) {
		this.weigh_money = weigh_money;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	
	
}
