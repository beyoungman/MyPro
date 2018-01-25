package com.manager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.manager.beans.Buy;
import com.manager.beans.OtherPay;
import com.manager.tools.Jdbc;
import com.manager.tools.PageHelper;

public class OtherPayDao {
	Jdbc db = new Jdbc();
	PreparedStatement pstm =null;
	Connection con = null;
	ResultSet rs =null;
	
	//∑÷“≥≤È’“
		public List<OtherPay> selectByUidLimit(int id,PageHelper ph) {
			con = db.getConnection();
			List<OtherPay> op = new ArrayList<>();
			String sql="select * from otherpay where user_id=? limit ?,?;";
			try {
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, id);
				pstm.setInt(2, ph.getPageStart());
				pstm.setInt(3, ph.getCout());
				rs =pstm.executeQuery();
				while(rs.next()){
					OtherPay o = new OtherPay();
					o.setId(rs.getInt("id"));
					o.setDate(rs.getDate("date"));
					o.setPayFor(rs.getString("payfor"));
					o.setMoney(rs.getFloat("money"));
					o.setUser_id(id);
					op.add(o);
				}
				return op;
			} catch (SQLException e) {
				e.printStackTrace();
				return op;
			}finally{
				db.close(con, pstm, rs);
			}
		}

		public int selectAllByUid(int id) {
			con = db.getConnection();
			String sql="select * from otherpay WHERE user_id="+id;
			int allrows=0;
			try {
				pstm=con.prepareStatement(sql);
				rs = pstm.executeQuery();
				while(rs.next()){
					allrows++;
				}
				return allrows;
			} catch (SQLException e) {
				e.printStackTrace();
				return 0;
			}finally{
				db.close(con, pstm, rs);
			}
		}

		public void insertOtherPay(OtherPay op) {
			con = db.getConnection();
			String sql="insert into otherpay (date,payfor,money,user_id) values(?,?,?,?)";
			try {
				pstm=con.prepareStatement(sql);
				pstm.setDate(1, op.getDate());
				pstm.setString(2, op.getPayFor());
				pstm.setFloat(3, op.getMoney());
				pstm.setInt(4, op.getUser_id());
				pstm.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				db.close(con, pstm, rs);
			}
		}

		public void deleteById(int id) {
			con = db.getConnection();
			String sql= "delete from otherpay where id="+id;
			try {
				con.prepareStatement(sql).executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				db.close(con, pstm, rs);
			}
		}

		public int selectAllMoneyByUid(int id) {
			con = db.getConnection();
			String sql="select sum(money) from otherpay where user_id="+id;
			try {
				pstm = con.prepareStatement(sql);
				rs = pstm.executeQuery();
				int keyValue= -1;
				if(rs.next()){
					keyValue=rs.getInt("sum(money)");
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
