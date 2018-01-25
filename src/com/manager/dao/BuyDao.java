package com.manager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.manager.beans.Buy;
import com.manager.tools.Jdbc;
import com.manager.tools.PageHelper;

public class BuyDao {
	Jdbc db = new Jdbc();
	PreparedStatement pstm =null;
	Connection con = null;
	ResultSet rs =null;
	
	//分页查找
	public List<Buy> selectBuyUidLimit(int id,PageHelper bph) {
		con = db.getConnection();
		List<Buy> buys= new ArrayList<>();
		
		String sql = "select * from buy where user_id=? limit ?,?;";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.setInt(2, bph.getPageStart());
			pstm.setInt(3, bph.getCout());
			rs = pstm.executeQuery();
			while(rs.next()){
				Buy b = new Buy(rs.getInt("buy_id"),rs.getDate("date"),rs.getString("customer"),
						rs.getString("goods"),rs.getInt("weight"),rs.getInt("weigh_money"),
						rs.getInt("money"),rs.getString("remarks"),id);
				buys.add(b);
			}
			return buys;
		} catch (SQLException e) {
			e.printStackTrace();
			return buys;
		}finally{
			db.close(con, pstm, rs);
		}
		
	}
	//根据用户id全部查找
	public List<Buy> selectBuyUid(int id) {
		con = db.getConnection();
		List<Buy> buys= new ArrayList<>();
		String sql = "select * from buy where user_id="+id;
		try {
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()){
				Buy b = new Buy(rs.getInt("buy_id"),rs.getDate("date"),rs.getString("customer"),
						rs.getString("goods"),rs.getInt("weight"),rs.getInt("weigh_money"),
						rs.getInt("money"),rs.getString("remarks"),id);
				buys.add(b);
			}
			return buys;
		} catch (SQLException e) {
			e.printStackTrace();
			return buys;
		}finally{
			db.close(con, pstm, rs);
		}
		
	}
	//插入购买记录
	public int insertBuy(Buy buy) {
		con = db.getConnection();
		String sql = "insert into buy (date,customer,goods,weight,weigh_money,money,remarks,user_id) values(?,?,?,?,?,?,?,?);";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setDate(1, buy.getDate());
			pstm.setString(2, buy.getCustomer());
			pstm.setString(3, buy.getGoods());
			pstm.setInt(4, buy.getWeight());
			pstm.setInt(5, buy.getWeigh_money());
			pstm.setInt(6, buy.getMoney());
			pstm.setString(7, buy.getRemarks());
			pstm.setInt(8, buy.getUser_id());
			return pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}finally{
			db.close(con, pstm, rs);
		}
	}
	//更新记录
	public int updateBuy(Buy buy) {
		con = db.getConnection();
		String sql="update buy set date=?, customer=?,goods=?,weight=?,weigh_money=?,money=?,remarks=? where buy_id=?";
		try {
			pstm =con.prepareStatement(sql);
			pstm.setDate(1, buy.getDate());
			pstm.setString(2, buy.getCustomer());
			pstm.setString(3, buy.getGoods());
			pstm.setInt(4, buy.getWeight());
			pstm.setInt(5, buy.getWeigh_money());
			pstm.setInt(6, buy.getMoney());
			pstm.setString(7, buy.getRemarks());
			pstm.setInt(8, buy.getBuy_id());
			return pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}finally{
			db.close(con, pstm, rs);
		}
		
	}
	//删除
	public int deleteBuy(int buy_id) {
		con = db.getConnection();
		String sql="delete from buy where buy_id="+buy_id;
		try {
			pstm = con.prepareStatement(sql);
			return pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}finally{
			db.close(con, pstm, rs);
		}
	}
	public int selectTotolWeight(int id) {
		con = db.getConnection();
		String sql="select sum(weight) from buy where user_id="+id;
		try {
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			int keyValue= -1;
			if(rs.next()){
				keyValue=rs.getInt("sum(weight)");
			}
			return keyValue;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}finally{
			db.close(con, pstm, rs);
		}
	}
	
	public int selectTotolMoney(int id) {
		con = db.getConnection();
		String sql="select sum(money) from buy where user_id="+id;
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
	public int selectTotolWeigh_Money(int id) {
		con = db.getConnection();
		String sql="select sum(weigh_money) from buy where user_id="+id;
		try {
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			int keyValue= -1;
			if(rs.next()){
				keyValue=rs.getInt("sum(weigh_money)");
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
