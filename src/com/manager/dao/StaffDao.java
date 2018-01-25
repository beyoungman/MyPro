package com.manager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.manager.beans.Staff;
import com.manager.tools.Jdbc;

public class StaffDao{
	
	Jdbc db = new Jdbc();
	PreparedStatement pstm =null;
	Connection con = null;
	ResultSet rs =null;
	
	public ArrayList<Staff> selectByUid(int id) {
		con = db.getConnection();
		ArrayList<Staff> staffs = new ArrayList<>();
		String sql = "select * from staff where uid="+id;
		try {
			rs = con.prepareStatement(sql).executeQuery();
			while(rs.next()){
				int sid = rs.getInt("sid");
				String name = rs.getString("name");
				String idNum = rs.getString("idNum");
				String phone = rs.getString("phone");
				int salary = rs.getInt("salary");
				Staff staff =new Staff(sid,name,idNum,phone,salary);
				staffs.add(staff);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally{
			db.close(con, pstm, rs);
		}
		return staffs;
	}


	public boolean insertStaff(Staff s,int uid) {
		String sql="insert into staff (name,phone,idNum,salary,uid)values(?,?,?,?,?);";
		con= db.getConnection();
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, s.getName());
			pstm.setString(2, s.getPhone());
			pstm.setString(3, s.getIdNum());
			pstm.setInt(4, s.getSalary());
			pstm.setInt(5, uid);
			int ud = pstm.executeUpdate();
			if(ud==1){
				return true;
			}else return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally{
			db.close(con, pstm, rs);
		}
	}


	public boolean deleteStaff(int sid) {
		con = db.getConnection();
		String sql="delete from staff where sid="+sid;
		try {
			pstm=con.prepareStatement(sql);
			int ud = pstm.executeUpdate();
			if(ud==1)
				return true;
			else 
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}


	public Staff selectStaffBySid(int sid) {
		con = db.getConnection();
		String sql="select * from staff where sid="+sid;
		try {
			pstm=con.prepareStatement(sql);
			rs = pstm.executeQuery();
			if(rs.next()){
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String idNum = rs.getString("idNum");
				 String sal =rs.getString("salary");
				if(sal!=null){
					int salary = Integer.parseInt(sal);
				Staff s= new Staff(sid,name,idNum,phone,salary);
				return s;
				}else{
					Staff s= new Staff(sid,name,idNum,phone,0);
					return s;
				}
			}else
				return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally{
			db.close(con, pstm, rs);
		}
	}


	public int update(Staff s) {
		con = db.getConnection();
		String sql="update staff set name=?,idNum=?,phone=?,salary=? where sid=?";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, s.getName());
			pstm.setString(2, s.getIdNum());
			pstm.setString(3, s.getPhone());
			pstm.setInt(4, s.getSalary());
			pstm.setInt(5, s.getSid());
			int upd = pstm.executeUpdate();
			return upd;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}finally{
			db.close(con, pstm, rs);
		}
	}


	public float selectAllOtHours(int sid) {
		con = db.getConnection();
		String sql = "select sum(hours) from ot where sid="+sid;
		try {
			int keyValue=-1;
			rs = con.prepareStatement(sql).executeQuery();
			if(rs.next()){
				keyValue = rs.getInt("sum(hours)");
			}
			return keyValue;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}finally{
			db.close(con, pstm, rs);
		}
	}


	public float selectAllRestDays(int sid) {
		con = db.getConnection();
		String sql = "select sum(days) from rest where sid="+sid;
		try {
			int keyValue=-1;
			rs = con.prepareStatement(sql).executeQuery();
			if(rs.next()){
				keyValue = rs.getInt("sum(days)");
			}
			return keyValue;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}finally{
			db.close(con, pstm, rs);
		}
	}

}
