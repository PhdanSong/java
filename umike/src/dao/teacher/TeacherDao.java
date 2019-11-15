package dao.teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import entity.ketixinxi;
import entity.lunwenxinxi;
import entity.teacher;
import entity.teacher;

public class TeacherDao {

	public int saveTeacherDao(teacher tea){
		Connection con=null;
		PreparedStatement pstm=null;
		BaseDao dao = new BaseDao();
		try{			
			con=dao.getConnection();
			if(con==null)
				System.out.println("连接失败");
			else
				System.out.println("连接成功");
			pstm=con.prepareStatement("insert into teacher values(?,?,?,?,?,?,?)");
			pstm.setString(1, tea.getTeacher_ID());
			pstm.setString(2, tea.getXingming());
			pstm.setString(3, tea.getXingbie());
			pstm.setString(4, tea.getBeizhu());
			pstm.setString(5, tea.getZhujiaokecheng());
			pstm.setString(6, tea.getDianhua());
			pstm.setString(7, tea.getMima());
			return pstm.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}finally{
			dao.closeCon(null,pstm,con);
		}
	}
	
	public teacher selectAll(String teacher_ID){
		Connection con=null;
		PreparedStatement pstm=null;
		BaseDao dao = new BaseDao();
		teacher tea = new teacher();
		ResultSet resultSet=null;
		try {
			con=dao.getConnection();
			if(con==null)
				System.out.println("连接失败");
			else
				System.out.println("连接成功");
			pstm=con.prepareStatement("select * from teacher where teacher_ID=?");
			pstm.setString(1, teacher_ID);
			resultSet=pstm.executeQuery();
			while(resultSet.next()){
				tea.setTeacher_ID(resultSet.getString("teacher_ID"));
				tea.setXingming(resultSet.getString("xingming"));
				tea.setXingbie(resultSet.getString("xingbie"));
				tea.setBeizhu(resultSet.getString("beizhu"));
				tea.setZhujiaokecheng(resultSet.getString("zhujiaokecheng"));
				tea.setDianhua(resultSet.getString("dianhua"));
				tea.setMima(resultSet.getString("mima"));
				System.out.println(tea.getTeacher_ID()+","+tea.getXingming()+","+tea.getXingbie()+","+tea.getBeizhu()+","+tea.getZhujiaokecheng()+","+tea.getDianhua()+","+tea.getMima());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dao.closeCon(null,pstm,con);
		}
		return tea;
	}
	
	public int updateteacher(teacher tea,String techID){
		Connection con=null;
		PreparedStatement pstm=null;
		BaseDao dao = new BaseDao();
		try{
			
			con=dao.getConnection();
			if(con==null)
				System.out.println("连接失败");
			else
				System.out.println("连接成功");
			pstm=con.prepareStatement("update teacher set teacher_ID=?,xingming=?,xingbie=?,beizhu=?,zhujiaokecheng=?,dianhua=?,mima=? where teacher_ID=?");
			pstm.setString(1, tea.getTeacher_ID());
			pstm.setString(2, tea.getXingming());
			pstm.setString(3, tea.getXingbie());
			pstm.setString(4, tea.getBeizhu());
			pstm.setString(5, tea.getZhujiaokecheng());
			pstm.setString(6, tea.getDianhua());
			pstm.setString(7, tea.getMima());
			pstm.setString(8, techID);
			return pstm.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}finally{
			dao.closeCon(null,pstm,con);
		}
	}
	
	public boolean checkLogin(String username,String password){
		boolean b=false;
		PreparedStatement ps=null;
		BaseDao dao = new BaseDao();
		ResultSet rs = null;
		Connection connection = dao.getConnection();
		try {
			ps=connection.prepareStatement("select teacher_ID,mima from teacher where teacher_ID=? and mima=?");
			ps.setString(1,username);
			ps.setString(2,password);
			rs=ps.executeQuery();
			if (rs.next())
			{
				b=true;
			}
			else
			{
				b=false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return b;
	}
}
