package com.manager.beans;

import java.util.List;

import com.manager.service.StaffService;
/*
 * 用户，老板
 */

public class User {
	private int id;
	private String phone;
	private String password;
	private String name;
	private List<Staff> staffs;
	
	public User() {

	}
	
	public User(int id,String phone,String password, String name) {
		this.id = id;
		this.phone = phone;
		this.password = password;
		this.name = name;

	}
	//新增员工
	

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public List<Staff> getStaffs() {
		return staffs;
	}

	public void setStaffs(List<Staff> staffs) {
		this.staffs = staffs;
	}

	@Override
	public String toString() {
		return "User [id="+ id +", password=" + password
				+ ", name=" + name + ", phone=" + phone + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
