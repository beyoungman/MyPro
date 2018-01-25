package com.manager.service;

import java.util.ArrayList;

import com.manager.beans.Staff;
import com.manager.dao.StaffDao;

public class StaffService{
	
	StaffDao sdao = new StaffDao();
	
	
	public ArrayList<Staff> getStaffsByUid(int id){
		ArrayList<Staff> staffs = sdao.selectByUid(id);
		return staffs;
	}

	public boolean addStaff(Staff s,int uid) {
		return sdao.insertStaff(s,uid);
	}

	public boolean removeStaffBySid(int sid) {
		boolean b= sdao.deleteStaff(sid);
		return b;
	}

	public Staff getStaffBySid(int sid) {
		return sdao.selectStaffBySid(sid);
		
	}

	public int updateStaff(Staff s) {
		return sdao.update(s);
	}

	public float getAllOtHours(int sid) {
		return sdao.selectAllOtHours(sid);
	}

	public float getAllRestDays(int sid) {
		return sdao.selectAllRestDays(sid);
	}
}
