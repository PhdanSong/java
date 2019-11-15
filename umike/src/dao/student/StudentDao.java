package dao.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import entity.lunwenxinxi;
import entity.student;

public class StudentDao {

	public int saveStudentDao(student stu){
		Connection con=null;
		PreparedStatement pstm=null;
		BaseDao dao = new BaseDao();
		try{			
			con=dao.getConnection();
			if(con==null)
				System.out.println("连接失败");
			else
				System.out.println("连接成功");
			pstm=con.prepareStatement("insert into studnet values(?,?,?,?,?,?,?,?,?,?)");
			pstm.setString(1, stu.getXuehao());
			pstm.setString(2, stu.getXingming());
			pstm.setString(3, stu.getXingbie());
			pstm.setString(4, stu.getDianhua());
			pstm.setString(5, stu.getMima());
			pstm.setString(6, stu.getJiguan());
			pstm.setString(7, stu.getXueyuan());
			pstm.setString(8, stu.getZhuanye());
			pstm.setString(9, stu.getBanji());
			pstm.setString(10, stu.getBeizhu());
			return pstm.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}finally{
			dao.closeCon(null,pstm,con);
		}
	}
	
	public List<student> selectAll(){
		PreparedStatement pstm=null;
		BaseDao dao = new BaseDao();
		Connection connection = dao.getConnection();
		List<student> list=new ArrayList<student>();
		String sql="select * from student";
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {
			preparedStatement=connection.prepareStatement(sql);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				student stu = new student();
				stu.setXuehao(resultSet.getString("xuehao"));
				stu.setXingming(resultSet.getString("xingming"));
				stu.setXingbie(resultSet.getString("xinbie"));
				stu.setDianhua(resultSet.getString("dianhua"));
				stu.setMima(resultSet.getString("mima"));
				stu.setJiguan(resultSet.getString("jiguan"));
				stu.setXueyuan(resultSet.getString("xueyuan"));
				stu.setZhuanye(resultSet.getString("zhuanye"));
				stu.setBanji(resultSet.getString("banji"));
				stu.setBeizhu(resultSet.getString("beizhu"));
				list.add(stu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dao.closeCon(null,pstm,connection);
		}
		return list;
	}
	
	public boolean checkLogin(String username,String password){
		boolean b=false;
		PreparedStatement ps=null;
		BaseDao dao = new BaseDao();
		ResultSet rs = null;
		Connection connection = dao.getConnection();
		try {
			ps=connection.prepareStatement("select xuehao,mima from student where xuehao=? and mima=?");
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

	//学生
	public student selectAll(String xuehao){
		Connection con=null;
		PreparedStatement pstm=null;
		BaseDao dao = new BaseDao();
		List<student> list=new ArrayList<student>();
		String sql="select * from student where xuehao=?";
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		student stu = new student();
		try {
			con=dao.getConnection();
			preparedStatement=con.prepareStatement(sql);
			preparedStatement.setString(1, xuehao);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				stu.setXuehao(resultSet.getString("xuehao"));
				stu.setXingming(resultSet.getString("xingming"));
				stu.setXingbie(resultSet.getString("xingbie"));
				stu.setDianhua(resultSet.getString("dianhua"));
				stu.setMima(resultSet.getString("mima"));
				stu.setJiguan(resultSet.getString("jiguan"));
				stu.setXueyuan(resultSet.getString("xueyuan"));
				stu.setZhuanye(resultSet.getString("zhuanye"));
				stu.setBanji(resultSet.getString("banji"));
				stu.setBeizhu(resultSet.getString("beizhu"));
			}
			System.out.println(stu.getXuehao());
			System.out.println(stu.getXingming());
			System.out.println(stu.getXingbie());
			System.out.println(stu.getDianhua());
			System.out.println(stu.getMima());
			System.out.println(stu.getJiguan());
			System.out.println(stu.getXueyuan());
			System.out.println(stu.getZhuanye());
			System.out.println(stu.getBanji());
			System.out.println(stu.getBeizhu());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dao.closeCon(null,pstm,con);
		}
		return stu;
	}
	//学生
	public int stuUpdate(String xuehao,student stu){
		Connection con=null;
		PreparedStatement pstm=null;
		BaseDao dao = new BaseDao();
		List<student> list=new ArrayList<student>();
		String sql="update student set xuehao=?,xingming=?,xingbie=?,dianhua=?,jiguan=?,xueyuan=?,zhuanye=?,banji=?,beizhu=? where xuehao=?";
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {
			con=dao.getConnection();
			preparedStatement=con.prepareStatement(sql);
			preparedStatement.setString(1, stu.getXuehao());
			preparedStatement.setString(2, stu.getXingming());
			preparedStatement.setString(3, stu.getXingbie());
			preparedStatement.setString(4, stu.getDianhua());
			preparedStatement.setString(5, stu.getJiguan());
			preparedStatement.setString(6, stu.getXueyuan());
			preparedStatement.setString(7, stu.getZhuanye());
			preparedStatement.setString(8, stu.getBanji());
			preparedStatement.setString(9, stu.getBeizhu());
			preparedStatement.setString(10, xuehao);
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}finally{
			dao.closeCon(null,pstm,con);
		}
	}

}
