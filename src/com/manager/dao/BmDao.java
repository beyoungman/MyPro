package com.manager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.manager.beans.Bmoney;
import com.manager.beans.Ot;
import com.manager.tools.Jdbc;

public class BmDao{
	Jdbc db = new Jdbc();
	PreparedStatement pstm =null;
	Connection con = null;
	ResultSet rs =null;

	public List<Bmoney> selectBm(int sid) {
		con = db.getConnection();
		List<Bmoney> bms = new ArrayList<>();
		String sql="select *from bmoney where sid="+sid;
		try {
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()){
				Bmoney bm = 
						new Bmoney(rs.getInt("bid"),rs.getDate("date"),rs.getInt("money"),rs.getInt("sid"));
				bms.add(bm);
			}
			return bms;
		} catch (SQLException e) {
			e.printStackTrace();
			return bms;
		}finally{
			db.close(con, pstm, rs);
		}
		
	}

	public int updateBm(Bmoney bm) {
		con = db.getConnection();
		String sql="update bmoney set date=?,money=? where bid=?";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setDate(1, bm.getDate());
			pstm.setInt(2, bm.getMoney());
			pstm.setInt(3, bm.getBid());
			int i = pstm.executeUpdate();
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}finally{
			db.close(con, pstm, rs);
		}
	}

	public int deleteBm(int bid) {
		con =db.getConnection();
		String sql="delete from bmoney where bid="+bid;
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

	public int insertBm(Bmoney bm) {
		con =db.getConnection();
		String sql="insert into bmoney (sid,date,money)values(?,?,?);";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, bm.getSid());
			pstm.setDate(2, bm.getDate());
			pstm.setInt(3, bm.getMoney());
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
