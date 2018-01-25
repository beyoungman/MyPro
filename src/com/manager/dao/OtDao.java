package com.manager.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.manager.beans.Ot;
import com.manager.tools.Jdbc;

public class OtDao {
	Jdbc db = new Jdbc();
	PreparedStatement pstm =null;
	Connection con = null;
	ResultSet rs =null;

	public List<Ot> select(int sid) {
		con =db.getConnection();
		String sql="select * from ot where sid="+sid;
		List<Ot> ots = new ArrayList<>();
		try {
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()){
				Ot ot = new Ot(rs.getInt("oid"),rs.getDate("date"),rs.getFloat("hours"),rs.getInt("money"));
				ot.setSid(sid);
				ots.add(ot);
			}
			return ots;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally{
			db.close(con, pstm, rs);
		}
	}

	public int update(Ot ot) {
		con =db.getConnection();
		String sql="update ot set date=?,hours=?,money=? where oid=? ;";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setDate(1, (Date) ot.getDate());
			pstm.setFloat(2, ot.getHours());
			pstm.setInt(3, ot.getMoney());
			pstm.setInt(4, ot.getOid());
			return pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}finally{
			db.close(con, pstm, rs);
		}
	}

	public int deleteOt(int oid) {
		con =db.getConnection();
		String sql="delete from ot where oid="+oid;
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

	public int insertOt(Ot ot) {
		con =db.getConnection();
		String sql="insert into ot (sid,date,hours,money)values(?,?,?,?);";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, ot.getSid());
			pstm.setDate(2, ot.getDate());
			pstm.setFloat(3, ot.getHours());
			pstm.setInt(4, ot.getMoney());
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
