package com.manager.tools;

import java.sql.*;

public class Jdbc {

	public  Connection getConnection() {
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql:///bitou-manager",
							"root", "admin");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;

	}
	public void close(Connection conn,PreparedStatement pstm, ResultSet rs) {
		if(conn !=null ){
			 try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pstm !=null ){
			try {
				pstm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(rs !=null ){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
