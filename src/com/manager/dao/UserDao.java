package com.manager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.manager.beans.Staff;
import com.manager.beans.User;
import com.manager.tools.Jdbc;

public class UserDao{
	
	Jdbc db = new Jdbc();
	PreparedStatement pstm =null;
	Connection con = null;
	ResultSet rs =null;
	
	
	public boolean selectUser(String phone, String password) {
		con=db.getConnection();
		String sql="select * from user where phone= ? and password=?";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, phone);
			pstm.setString(2, password);
			rs = pstm.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {db.close(con, pstm, null);}
	}


	public User selectUserByPhone(String phone) {
		con= db.getConnection();
		String sql="select * from user where phone=?;";
		try{
			pstm =con.prepareStatement(sql);
			pstm.setString(1, phone);
			rs = pstm.executeQuery();
			if(rs.next()){
				int id=rs.getInt("id");
				String password=rs.getString("password");
				String name = rs.getString("name");
				return new User(id,phone,password,name);
			}else return null;
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}finally{
			db.close(con, pstm, null);
		}
	}
	
}
