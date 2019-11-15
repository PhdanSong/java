package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
	
	public Connection getConnection(){
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/bishesystem_db?useUnicode=true&characterEncoding=utf-8","root","");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return connection;
	}
	public static void closeCon(ResultSet rs,PreparedStatement pstm,Connection con){
		try{
			if(rs!=null)
				rs.close();
			if(pstm!=null)
				pstm.close();
			if(con!=null)
				con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
