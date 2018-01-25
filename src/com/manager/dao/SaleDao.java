package com.manager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.manager.beans.Buy;
import com.manager.beans.Sale;
import com.manager.tools.Jdbc;
import com.manager.tools.PageHelper;

public class SaleDao {
	Jdbc db = new Jdbc();
	PreparedStatement pstm =null;
	Connection con = null;
	ResultSet rs =null;
	
	//根据用户id分页查找
	public List<Sale> selectSaleSidLimit(int userid, PageHelper sph) {
		con = db.getConnection();
		List<Sale> sales= new ArrayList<>();
		String sql = "select * from sale where user_id=? limit ?,?;";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, userid);
			pstm.setInt(2, sph.getPageStart());
			pstm.setInt(3, sph.getCout());
			rs = pstm.executeQuery();
			while(rs.next()){
				Sale b = new Sale(rs.getInt("sale_id"),rs.getDate("date"),rs.getString("customer"),
						rs.getString("goods"),rs.getInt("weight"),rs.getInt("weigh_money"),
						rs.getInt("money"),rs.getString("remarks"),userid);
				sales.add(b);
			}
			return sales;
		} catch (SQLException e) {
			e.printStackTrace();
			return sales;
		}finally{
			db.close(con, pstm, rs);
		}
	}
	//根据用户id查找所以
	public List<Sale> selectSaleSid(int id) {
		con = db.getConnection();
		List<Sale> sales= new ArrayList<>();
		String sql = "select * from sale where user_id="+id;
		try {
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()){
				Sale s = new Sale(rs.getInt("sale_id"),rs.getDate("date"),rs.getString("customer"),
						rs.getString("goods"),rs.getInt("weight"),rs.getInt("weigh_money"),
						rs.getInt("money"),rs.getString("remarks"),id);
				sales.add(s);
			}
			return sales;
		} catch (SQLException e) {
			e.printStackTrace();
			return sales;
		}finally{
			db.close(con, pstm, rs);
		}
		
	}

	public int insertSale(Sale sale) {
		con = db.getConnection();
		String sql = "insert into sale (date,customer,goods,weight,weigh_money,money,remarks,user_id) values(?,?,?,?,?,?,?,?);";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setDate(1, sale.getDate());
			pstm.setString(2, sale.getCustomer());
			pstm.setString(3, sale.getGoods());
			pstm.setInt(4, sale.getWeight());
			pstm.setInt(5, sale.getWeigh_money());
			pstm.setInt(6, sale.getMoney());
			pstm.setString(7, sale.getRemarks());
			pstm.setInt(8, sale.getUser_id());
			return pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}finally{
			db.close(con, pstm, rs);
		}
	}

	public int updateSale(Sale sale) {
		con = db.getConnection();
		String sql="update sale set date=?, customer=?,goods=?,weight=?,weigh_money=?,money=?,remarks=? where sale_id=?";
		try {
			pstm =con.prepareStatement(sql);
			pstm.setDate(1, sale.getDate());
			pstm.setString(2, sale.getCustomer());
			pstm.setString(3, sale.getGoods());
			pstm.setInt(4, sale.getWeight());
			pstm.setInt(5, sale.getWeigh_money());
			pstm.setInt(6, sale.getMoney());
			pstm.setString(7, sale.getRemarks());
			pstm.setInt(8, sale.getSale_id());
			return pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}finally{
			db.close(con, pstm, rs);
		}
		
	}

	public int deleteSale(int sale_id) {
		con = db.getConnection();
		String sql="delete from sale where sale_id="+sale_id;
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
		String sql="select sum(weight) from sale where user_id="+id;
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
		String sql="select sum(money) from sale where user_id="+id;
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
