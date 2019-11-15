package dao.tongzhi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import entity.ketilunwen;
import entity.ketixinxi;
import entity.student;
import entity.stutag;
import entity.teacher;
import entity.tongzhi;
import entity.xuantixinxi;

public class TongzhiDao {

	public int saveTongzhiDao(tongzhi ton){
		Connection con=null;
		PreparedStatement pstm=null;
		BaseDao dao = new BaseDao();
		try{			
			con=dao.getConnection();
			if(con==null)
				System.out.println("连接失败");
			else
				System.out.println("连接成功");
			pstm=con.prepareStatement("insert into tongzhi(teacher_ID,tongzhibiaoti,fabushijian,tixingshijian,tongzhineirong,beizhu,tag) values(?,?,?,?,?,?,?)");
			pstm.setString(1, ton.getTeacher_ID());
			pstm.setString(2, ton.getTongzhibiaoti());
			pstm.setString(3, ton.getFabushijian());
			pstm.setString(4, ton.getTixingshijian());
			pstm.setString(5, ton.getTongzhineirong());
			pstm.setString(6, ton.getBeizhu());
			pstm.setString(7, "false");
			return pstm.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}finally{
			dao.closeCon(null,pstm,con);
		}	
	}
		
	public int deleteTongzhi(String teacID,String tongzhiID){
		Connection con=null;
		PreparedStatement pstm=null;
		BaseDao dao = new BaseDao();
		try{
			
			con=dao.getConnection();
			if(con==null)
				System.out.println("连接失败");
			else
				System.out.println("连接成功");
			pstm=con.prepareStatement("delete from tongzhi where teacher_ID=? and tongzhi_ID=?");
			pstm.setString(1, teacID);
			pstm.setString(2, tongzhiID);
			return pstm.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}finally{
			dao.closeCon(null,pstm,con);
		}
	}
	
	@SuppressWarnings("null")
	public List<tongzhi> selectAll(String techID){
		Connection con=null;
		PreparedStatement pstm=null;
		BaseDao dao = new BaseDao();
		ResultSet resultSet=null;
		List<tongzhi> list=new ArrayList<tongzhi>();
		try{
				
			con=dao.getConnection();
			if(con==null)
				System.out.println("连接失败");
			else
				System.out.println("连接成功");
			pstm=con.prepareStatement("select * from tongzhi where tongzhi.teacher_ID=?");
			pstm.setString(1, techID);
			resultSet=pstm.executeQuery();
			while(resultSet.next()){	
				tongzhi tong=new tongzhi();
				tong.setTongzhi_ID(resultSet.getInt("tongzhi_ID"));
				tong.setTeacher_ID(resultSet.getString("teacher_ID"));
				tong.setTongzhibiaoti(resultSet.getString("tongzhibiaoti"));
				tong.setFabushijian(resultSet.getString("fabushijian"));
				tong.setTixingshijian(resultSet.getString("tixingshijian"));
				tong.setTongzhineirong(resultSet.getString("tongzhineirong"));
				tong.setBeizhu(resultSet.getString("beizhu"));
				list.add(tong);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			dao.closeCon(null,pstm,con);
		}
		

	}
	
	public tongzhi teacIDselectTongzhi(String techID,String bianhao){
		Connection con=null;
		PreparedStatement pstm=null;
		BaseDao dao = new BaseDao();
		ResultSet resultSet=null;
		tongzhi tong=new tongzhi();
		try{				
			con=dao.getConnection();
			if(con==null)
				System.out.println("连接失败");
			else
				System.out.println("连接成功");
			pstm=con.prepareStatement("select * from tongzhi where tongzhi.teacher_ID=? and tongzhi.tongzhi_ID=?");
			pstm.setString(1, techID);
			pstm.setString(2, bianhao);
			resultSet=pstm.executeQuery();
			while(resultSet.next()){	
				tong.setTongzhi_ID(resultSet.getInt("tongzhi_ID"));
				tong.setTeacher_ID(resultSet.getString("teacher_ID"));
				tong.setTongzhibiaoti(resultSet.getString("tongzhibiaoti"));
				tong.setFabushijian(resultSet.getString("fabushijian"));
				tong.setTixingshijian(resultSet.getString("tixingshijian"));
				tong.setTongzhineirong(resultSet.getString("tongzhineirong"));
				tong.setBeizhu(resultSet.getString("beizhu"));
			}
			return tong;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			dao.closeCon(null,pstm,con);
		}
		

	}
	
	public int updateTongzhi(tongzhi tong,String teacherId,String tongzhiID){
		Connection con=null;
		PreparedStatement pstm=null;
		BaseDao dao = new BaseDao();
		try{		
			con=dao.getConnection();
			if(con==null)
				System.out.println("连接失败");
			else
				System.out.println("连接成功");
			pstm=con.prepareStatement("update tongzhi set teacher_ID=?,tongzhibiaoti=?,fabushijian=?,tixingshijian=?,tongzhineirong=?,beizhu=? where teacher_ID=? and tongzhi_ID=?");
			pstm.setString(1, tong.getTeacher_ID());
			pstm.setString(2, tong.getTongzhibiaoti());
			pstm.setString(3, tong.getFabushijian());
			pstm.setString(4, tong.getTixingshijian());
			pstm.setString(5, tong.getTongzhineirong());
			pstm.setString(6, tong.getBeizhu());
			pstm.setString(7, teacherId);
			pstm.setString(8, tongzhiID);
			return pstm.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}finally{
			dao.closeCon(null,pstm,con);
		}
	}
	//学生
	public List<ketilunwen> StuselectAll(String student_ID){
			Connection con=null;
			PreparedStatement pstm=null;
			BaseDao dao = new BaseDao();		
			List<ketilunwen> list=new ArrayList<ketilunwen>();
			String sql="select * from tongzhi tong,xuantixinxi xuan where tong.teacher_ID=xuan.teacher_ID and xuan.student_ID=?";
			PreparedStatement preparedStatement=null;
			ResultSet resultSet=null;
			try {	
				con=dao.getConnection();
				preparedStatement=con.prepareStatement(sql);
				preparedStatement.setString(1, student_ID);
				resultSet=preparedStatement.executeQuery();
				while(resultSet.next()){
					tongzhi tong=new tongzhi();
					xuantixinxi xuan=new xuantixinxi();
					ketilunwen keti=new ketilunwen();
					tong.setTongzhi_ID(resultSet.getInt("tongzhi_ID"));
					tong.setTeacher_ID(resultSet.getString("teacher_ID"));
					tong.setTongzhibiaoti(resultSet.getString("tongzhibiaoti"));
					tong.setTixingshijian(resultSet.getString("tixingshijian"));
					tong.setFabushijian(resultSet.getString("fabushijian"));
					tong.setTongzhineirong(resultSet.getString("tongzhineirong"));
					tong.setBeizhu(resultSet.getString("beizhu"));
					xuan.setXuanti_ID(resultSet.getInt("xuanti_ID"));
					xuan.setKetimingcheng(resultSet.getString("ketimingcheng"));
					xuan.setTeacher_ID(resultSet.getString("teacher_ID"));
					xuan.setStudent_ID(resultSet.getString("student_ID"));
					xuan.setXuantishijian(resultSet.getString("xuantishijian"));
					xuan.setBeizhu(resultSet.getString("beizhu"));
					keti.setXuan(xuan);
					keti.setTon(tong);
					list.add(keti);				
				} 
				for(int i = 0 ; i< list.size();i++){   
		            System.out.println(list.get(i).getTon().getTongzhi_ID());
		            System.out.println(list.get(i).getTon().getTeacher_ID());
					System.out.println(list.get(i).getTon().getTongzhibiaoti());
					System.out.println(list.get(i).getTon().getFabushijian());
					System.out.println(list.get(i).getTon().getTixingshijian());
					System.out.println(list.get(i).getTon().getTongzhineirong());
					System.out.println(list.get(i).getTon().getBeizhu());
					System.out.println(list.get(i).getXuan().getXuanti_ID());
					System.out.println(list.get(i).getXuan().getKetimingcheng());
					System.out.println(list.get(i).getXuan().getTeacher_ID());
					System.out.println(list.get(i).getXuan().getStudent_ID());
					System.out.println(list.get(i).getXuan().getXuantishijian());
					System.out.println(list.get(i).getXuan().getBeizhu());
		        }  
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				dao.closeCon(null,pstm,con);
			}
			return list;
		}
	//学生
	public tongzhi StuselectById(int tongzhi_ID){
			Connection con=null;
			PreparedStatement pstm=null;
			BaseDao dao = new BaseDao();		
			List<ketilunwen> list=new ArrayList<ketilunwen>();
			String sql="select * from tongzhi tong,xuantixinxi xuan where tong.teacher_ID=xuan.teacher_ID and tong.Tongzhi_ID=?";
			PreparedStatement preparedStatement=null;
			ResultSet resultSet=null;
			tongzhi tong=new tongzhi();
			try {	
				con=dao.getConnection();
				preparedStatement=con.prepareStatement(sql);
				preparedStatement.setInt(1, tongzhi_ID);
				resultSet=preparedStatement.executeQuery();
				while(resultSet.next()){			
					tong.setTongzhi_ID(resultSet.getInt("tongzhi_ID"));
					tong.setTeacher_ID(resultSet.getString("teacher_ID"));
					tong.setTongzhibiaoti(resultSet.getString("tongzhibiaoti"));
					tong.setTixingshijian(resultSet.getString("tixingshijian"));
					tong.setFabushijian(resultSet.getString("fabushijian"));
					tong.setTongzhineirong(resultSet.getString("tongzhineirong"));
					tong.setBeizhu(resultSet.getString("beizhu"));		
				} 
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				dao.closeCon(null,pstm,con);
			}
			return tong;
		}
	//tag为false的个数,即为新增消息的个数
	public stutag countTag(String stu_ID){
		Connection con=null;
		PreparedStatement pstm=null;
		BaseDao dao = new BaseDao();
		ResultSet resultSet=null;
		stutag st=new stutag();
		try{				
			con=dao.getConnection();
			if(con==null)
				System.out.println("连接失败");
			else
				System.out.println("连接成功");
			pstm=con.prepareStatement("select stu.xuehao,count(tag) c from student stu,xuantixinxi xuan,tongzhi ton where xuan.student_ID=stu.xuehao and xuan.teacher_ID=ton.teacher_ID and xuan.student_ID=? and tag='false'");
			pstm.setString(1, stu_ID);
			resultSet=pstm.executeQuery();
			while(resultSet.next()){	
				st.setXuehao(resultSet.getString("xuehao"));
				st.setTagcount(resultSet.getString("c"));
			}
			return st;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			dao.closeCon(null,pstm,con);
		}
	}

	public int tongChange(String stu_ID){
		Connection con=null;
		PreparedStatement pstm=null;
		BaseDao dao = new BaseDao();
		try{			
			con=dao.getConnection();
			if(con==null)
				System.out.println("连接失败");
			else
				System.out.println("连接成功");
			pstm=con.prepareStatement("update tongzhi set tag='true'");
			return pstm.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}finally{
			dao.closeCon(null,pstm,con);
		}
	}

	public int countTongzhiDao(String student_ID){
		Connection con=null;
		PreparedStatement pstm=null;
		BaseDao dao = new BaseDao();
		List<tongzhi> list=new ArrayList<tongzhi>();
		int count=0;
		String sql="select count(*) from tongzhi tong,xuantixinxi xuan where tong.teacher_ID=xuan.teacher_ID and xuan.student_ID=?";
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {	
			con=dao.getConnection();
			preparedStatement=con.prepareStatement(sql);
			preparedStatement.setString(1, student_ID);
			resultSet=preparedStatement.executeQuery();
			if (resultSet.next())
			count = resultSet.getInt(1);		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dao.closeCon(null,pstm,con);
		}
		return count;
	}
	
	public List<tongzhi> tongzhifenye(String Student_ID,String start,String end){
		Connection con=null;
		PreparedStatement pstm=null;
		BaseDao dao = new BaseDao();
		List<tongzhi> list=new ArrayList<tongzhi>();
		String sql="select  *  from  tongzhi,xuantixinxi WHERE tongzhi.teacher_ID=xuantixinxi.teacher_ID and xuantixinxi.student_ID=? LIMIT ?,?";
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {	
			con=dao.getConnection();
			preparedStatement=con.prepareStatement(sql);
			preparedStatement.setString(1, Student_ID);
			preparedStatement.setString(2, start);
			preparedStatement.setString(3, end);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				tongzhi tong=new tongzhi();
				tong.setTongzhi_ID(resultSet.getInt("tongzhi_ID"));
				tong.setTeacher_ID(resultSet.getString("teacher_ID"));
				tong.setTongzhibiaoti(resultSet.getString("tongzhibiaoti"));
				tong.setTixingshijian(resultSet.getString("tixingshijian"));
				tong.setFabushijian(resultSet.getString("fabushijian"));
				tong.setTongzhineirong(resultSet.getString("tongzhineirong"));
				tong.setBeizhu(resultSet.getString("beizhu"));
				list.add(tong);				
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dao.closeCon(null,pstm,con);
		}
		return list;
	}
}
