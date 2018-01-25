package com.manager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.manager.beans.Rest;
import com.manager.tools.Jdbc;

public class RestDao{
	Jdbc db = new Jdbc();
	PreparedStatement pstm =null;
	Connection con = null;
	ResultSet rs =null;

	public List<Rest> selectRest(int sid) {
		con = db.getConnection();
		List<Rest> res = new ArrayList<>();
		String sql="select *from rest where sid="+sid;
		try {
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()){
				Rest re= 
						new Rest(rs.getInt("rid"),rs.getDate("date"),rs.getFloat("days"),rs.getInt("sid"));
				res.add(re);
			}
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
			return res;
		}finally{
			db.close(con, pstm, rs);
		}
		
	}

	public int updateRest(Rest rs) {
		con = db.getConnection();
		String sql="update rest set date=?,days=? where rid=?";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setDate(1, rs.getDate());
			pstm.setFloat(2, rs.getDays());
			pstm.setInt(3, rs.getRid());
			int i = pstm.executeUpdate();
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}finally{
			db.close(con, pstm, null);
		}
	}

	public int deleteRest(int rid) {
		con =db.getConnection();
		String sql="delete from rest where rid="+rid;
		try {
			int i=con.createStatement().executeUpdate(sql);
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}finally{
			db.close(con, pstm, rs);
		}
		
	}

	public int insertRest(Rest re) {
		con =db.getConnection();
		String sql="insert into rest (sid,date,days)values(?,?,?);";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, re.getSid());
			pstm.setDate(2, re.getDate());
			pstm.setFloat(3, re.getDays());
			int i = pstm.executeUpdate();
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}finally{
			db.close(con, pstm, rs);
		}
		
	}
}
