package com.qfedu.util;

import java.sql.*;

public class BaseDao {
	public static Connection getConn() {
		Connection conn=null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore?useSSL=false", "root", "123456");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
}
	//增删改
	public int  setUpdate(String sql,Object[] obj)  {
		int result=0;
		PreparedStatement ps;
		try {
			ps = getConn().prepareStatement(sql);
			for (int i = 0; i < obj.length; i++) {
				ps.setObject(i+1, obj[i]);
				
			}
			result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return result;
	}
	
	//查询
		public ResultSet select(String sql,Object[] obj) throws Exception {
			ResultSet result=null;
			Connection  conn=getConn();
			 PreparedStatement ps = conn.prepareStatement(sql);
			 
			 
			for (int i = 0; i < obj.length; i++) {
				ps.setObject(i+1, obj[i]);
				
			}
			 //result=ps.executeQuery();
			result=ps.executeQuery();
			return result;
		}
	
	
	

}
