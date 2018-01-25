package com.manager.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*
 * Ô±¹¤
 */
public class Staff implements Serializable {
	private int sid;
	private String name;
	private String idNum;
	private String phone;
	private int salary;
	private int yearSalary;
	private List<Ot> ots = new ArrayList<>();
	private List<Bmoney> bms= new ArrayList<>();
	private List<Rest> rests= new ArrayList<>();
	
	
	public Staff() {
	}
	
	public Staff(int sid, String name, String idNum, String phone,
			int salary) {
		this.sid = sid;
		this.name = name;
		this.idNum = idNum;
		this.phone = phone;
		this.salary = salary;
	
	}


	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdNum() {
		return idNum;
	}
	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public List<Ot> getOts() {
		return ots;
	}
	public void setOts(List<Ot> ots) {
		this.ots = ots;
	}
	public List<Bmoney> getBms() {
		return bms;
	}
	public void setBms(List<Bmoney> bms) {
		this.bms = bms;
	}
	public List<Rest> getRests() {
		return rests;
	}
	public void setRests(List<Rest> rests) {
		this.rests = rests;
	}

	public double getYearSalary() {
		return yearSalary;
	}

	public void setYearSalary(int yearSalary) {
		this.yearSalary = yearSalary;
	}

	@Override
	public String toString() {
		return "Staff [sid=" + sid + ", name=" + name + ", idNum=" + idNum
				+ ", phone=" + phone + ", salary=" + salary + ", ots=" + ots
				+ ", bms=" + bms + ", rests=" + rests + "]";
	}
	
	
}
