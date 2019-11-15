package dao.xuantixinxi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import entity.ketixinxi;
import entity.ketilunwen;
import entity.lunwenxinxi;
import entity.xuantixinxi;

public class XuantixinxiDao {

	public int saveXuantixinxiDao(xuantixinxi xuan){
		Connection con=null;
		PreparedStatement pstm=null;
		BaseDao dao = new BaseDao();
		try{			
			con=dao.getConnection();
			if(con==null)
				System.out.println("链接成功");
			else
				System.out.println("链接失败");
			pstm=con.prepareStatement("insert into xuantixinxi values(?,?,?,?,?,?)");
			pstm.setInt(1, xuan.getXuanti_ID());
			pstm.setString(2, xuan.getKetimingcheng());
			pstm.setString(3, xuan.getStudent_ID());
			pstm.setString(4, xuan.getStudent_ID());
			pstm.setString(5, xuan.getXuantishijian());
			pstm.setString(6, xuan.getBeizhu());
			return pstm.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}finally{
			dao.closeCon(null,pstm,con);
		}
	}
	
	//学生
	public int updatexuantixinxi(xuantixinxi xuan,String student_ID){
			Connection con=null;
			PreparedStatement pstm=null;
			BaseDao dao = new BaseDao();
			try{			
				con=dao.getConnection();
				if(con==null)
					System.out.println("连接失败");
				else
					System.out.println("连接成功");
				pstm=con.prepareStatement("update xuantixinxi set xuanti_ID=?,ketimingcheng=?,teacher_ID=?,student_ID=?,xuantishijian=?,beizhu=? where student_ID=?");
				pstm.setInt(1, xuan.getXuanti_ID());
				pstm.setString(2, xuan.getKetimingcheng());
				pstm.setString(3, xuan.getTeacher_ID());
				pstm.setString(4, xuan.getStudent_ID());
				pstm.setString(5, xuan.getXuantishijian());
				pstm.setString(6, xuan.getBeizhu());
				pstm.setString(7,student_ID);
				return pstm.executeUpdate();
			}catch(Exception e){
				e.printStackTrace();
				return 0;
			}finally{
				dao.closeCon(null,pstm,con);
			}
		}
	
	//学生
	public int StudeleteXuantixinxi(String student_ID){
		Connection con=null;
		PreparedStatement pstm=null;
		BaseDao dao = new BaseDao();
		try{			
			con=dao.getConnection();
			if(con==null)
				System.out.println("连接失败");
			else
				System.out.println("连接成功");
			pstm=con.prepareStatement("delete from xuantixinxi where student_ID=?");
			pstm.setString(1, student_ID);
			return pstm.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}finally{
			dao.closeCon(null,pstm,con);
		}
	}
	
	//老师
	public List<ketilunwen>teacIDselectxuantixinxi(String techID){
		Connection con=null;
		PreparedStatement pstm=null;
		BaseDao dao = new BaseDao();
		ResultSet resultSet=null;
		List<ketilunwen> list=new ArrayList<ketilunwen>();
		try{			
			con=dao.getConnection();
			if(con==null)
				System.out.println("连接失败");
			else
				System.out.println("连接成功");
			pstm=con.prepareStatement("select ke.*,xuan.*,count(xuan.student_ID) yixuan from ketixinxi ke,xuantixinxi xuan where ke.ketimingcheng=xuan.ketimingcheng and xuan.teacher_ID=? group by xuan.ketimingcheng");
			pstm.setString(1, techID);
			resultSet=pstm.executeQuery();
			while(resultSet.next()){	
				ketilunwen keti=new ketilunwen();
				ketixinxi ke =new ketixinxi();
				ke.setKetibianhao(resultSet.getString("ketibianhao"));
				ke.setKetimingcheng(resultSet.getString("ketimingcheng"));
				ke.setLeixing(resultSet.getString("leixing"));
				ke.setKetishuliang(resultSet.getString("ketishuliang"));
				ke.setFabushijian(resultSet.getString("fabushijian"));
				keti.setKe(ke);
				xuantixinxi xuan=new xuantixinxi();
				xuan.setXuanti_ID(resultSet.getInt("xuanti_ID"));
				xuan.setKetimingcheng(resultSet.getString("ketimingcheng"));
				xuan.setTeacher_ID(resultSet.getString("teacher_ID"));
				xuan.setStudent_ID(resultSet.getString("student_ID"));
				xuan.setXuantishijian(resultSet.getString("xuantishijian"));
				xuan.setBeizhu(resultSet.getString("beizhu"));
				keti.setXuan(xuan);
				keti.setYiyuan( Integer.toString(resultSet.getInt(1)));
				list.add(keti);				
			}
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			dao.closeCon(null,pstm,con);
		}
		return list;
	}
	//学生
	public ketilunwen stuIDselectxuantixinxi(String student_ID){
		Connection con=null;
		PreparedStatement pstm=null;
		BaseDao dao = new BaseDao();
		ResultSet resultSet=null;
		xuantixinxi xuan=new xuantixinxi();
		ketilunwen keti=new ketilunwen();
		ketixinxi ke=new ketixinxi();
		try{					
			con=dao.getConnection();
			if(con==null)
				System.out.println("连接失败");
			else
				System.out.println("连接成功");
			pstm=con.prepareStatement("select ke.*,xuan.* from ketixinxi ke,xuantixinxi xuan where ke.ketimingcheng=xuan.ketimingcheng and xuan.student_ID=?");
			pstm.setString(1,student_ID);
			resultSet=pstm.executeQuery();
			while(resultSet.next()){				
				xuan.setXuanti_ID(resultSet.getInt("xuan.xuanti_ID"));
				xuan.setKetimingcheng(resultSet.getString("xuan.ketimingcheng"));
				xuan.setTeacher_ID(resultSet.getString("xuan.teacher_ID"));
				xuan.setStudent_ID(resultSet.getString("xuan.student_ID"));
				xuan.setXuantishijian(resultSet.getString("xuan.xuantishijian"));
				xuan.setBeizhu(resultSet.getString("xuan.beizhu"));
				ke.setKetibianhao(resultSet.getString("ke.ketibianhao"));
				ke.setTeacID(resultSet.getString("ke.teacID"));
				ke.setKetimingcheng(resultSet.getString("ke.ketimingcheng"));
				ke.setLeixing(resultSet.getString("ke.leixing"));
				ke.setFujian(resultSet.getString("ke.fujian"));
				ke.setKetishuliang(resultSet.getString("ke.ketishuliang"));
				ke.setBeizhu(resultSet.getString("ke.beizhu"));
				ke.setFabushijian(resultSet.getString("ke.fabushijian"));
				ke.setBaocunming(resultSet.getString("baocunming"));
				keti.setKe(ke);
				keti.setXuan(xuan);
			}
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			dao.closeCon(null,pstm,con);
		}
		return keti;
	}
		
	//学生
	public List<ketilunwen> selectxuantixinxi1(String xuan_ID,String kechengmingcheng,String tea_ID){
		Connection con=null;
		PreparedStatement pstm=null;
		BaseDao dao = new BaseDao();
		ResultSet resultSet=null;
		ketilunwen kelun=new ketilunwen();
		lunwenxinxi lun=new lunwenxinxi();
		ketixinxi ke=new ketixinxi();
		xuantixinxi xuan=new xuantixinxi();
		List<ketilunwen> list=new ArrayList<ketilunwen>();
		String sql="select * from xuantixinxi xuan,ketixinxi ke where xuan.teacher_ID=ke.teacID and xuan.xuanti_ID=?and xuan.ketimingcheng=? and xuan.teacher_ID=?";
		try{					
			con=dao.getConnection();
			if(con==null)
				System.out.println("连接失败");
			else
				System.out.println("连接成功");
			pstm=con.prepareStatement(sql);
			pstm.setString(1, xuan_ID);
			pstm.setString(2, kechengmingcheng);
			pstm.setString(3, tea_ID);
			resultSet=pstm.executeQuery();
			while(resultSet.next()){	
				xuan.setXuanti_ID(resultSet.getInt("xuanti_ID"));
				xuan.setKetimingcheng(resultSet.getString("ketimingcheng"));
				xuan.setTeacher_ID(resultSet.getString("teacher_ID"));
				xuan.setStudent_ID(resultSet.getString("student_ID"));
				xuan.setBeizhu(resultSet.getString("beizhu"));
				xuan.setXuantishijian(resultSet.getString("xuantishijian"));
				ke.setKetibianhao(resultSet.getString("ketibianhao"));
				ke.setTeacID(resultSet.getString("teacID"));
				ke.setKetimingcheng(resultSet.getString("ketimingcheng"));
				ke.setLeixing(resultSet.getString("leixing"));
				ke.setFujian(resultSet.getString("fujian"));
				ke.setKetishuliang(resultSet.getString("ketishuliang"));
				ke.setBeizhu(resultSet.getString("beizhu"));
				kelun.setKe(ke);
				kelun.setLun(lun);
				list.add(kelun);				
			}
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			dao.closeCon(null,pstm,con);
		}
		return list;
	
	}
	
	//学生
	public List<ketilunwen> stuIDselectxuantixinxi(){
			Connection con=null;
			PreparedStatement pstm=null;
			BaseDao dao = new BaseDao();
			ResultSet resultSet=null;
			List<ketilunwen> list=new ArrayList<ketilunwen>();
			try{					
				con=dao.getConnection();
				if(con==null)
					System.out.println("连接失败");
				else
					System.out.println("连接成功");
				pstm=con.prepareStatement("select * from xuantixinxi xuan,ketixinxi ke where xuan.ketimingcheng=ke.ketimingcheng");
				resultSet=pstm.executeQuery();
				while(resultSet.next()){	
					xuantixinxi xuan=new xuantixinxi();
					ketilunwen keti=new ketilunwen();
					ketixinxi ke=new ketixinxi();
					xuan.setXuanti_ID(resultSet.getInt("xuan.xuanti_ID"));
					xuan.setKetimingcheng(resultSet.getString("xuan.ketimingcheng"));
					xuan.setTeacher_ID(resultSet.getString("xuan.teacher_ID"));
					xuan.setStudent_ID(resultSet.getString("xuan.student_ID"));
					xuan.setXuantishijian(resultSet.getString("xuan.xuantishijian"));
					xuan.setBeizhu(resultSet.getString("xuan.beizhu"));
					ke.setKetibianhao(resultSet.getString("ke.ketibianhao"));
					ke.setTeacID(resultSet.getString("ke.teacID"));
					ke.setKetimingcheng(resultSet.getString("ke.ketimingcheng"));
					ke.setLeixing(resultSet.getString("ke.leixing"));
					ke.setFujian(resultSet.getString("ke.fujian"));
					ke.setKetishuliang(resultSet.getString("ke.ketishuliang"));
					ke.setBeizhu(resultSet.getString("ke.beizhu"));
					ke.setFabushijian(resultSet.getString("ke.fabushijian"));
					keti.setKe(ke);
					keti.setXuan(xuan);
					list.add(keti);
				}
				for(int i=0;i<list.size();i++){
				System.out.println("Xuanti_ID"+list.get(i).getXuan().getXuanti_ID());
				System.out.println("Ketimingcheng"+list.get(i).getXuan().getKetimingcheng());
				System.out.println("getTeacher_ID"+list.get(i).getXuan().getTeacher_ID());
				System.out.println("Student_ID"+list.get(i).getXuan().getStudent_ID());
				System.out.println("Xuantishijian"+list.get(i).getXuan().getXuantishijian());
				System.out.println("Beizhu"+list.get(i).getXuan().getBeizhu());
				System.out.println("Ketibianhao"+list.get(i).getKe().getKetibianhao());
				System.out.println("TeacID"+list.get(i).getKe().getTeacID());
				System.out.println("Ketimingcheng"+list.get(i).getKe().getKetimingcheng());
				System.out.println("Leixing"+list.get(i).getKe().getLeixing());
				System.out.println("Fujian"+list.get(i).getKe().getFujian());
				System.out.println("Ketishuliang"+list.get(i).getKe().getKetishuliang());
				System.out.println("Beizhu"+list.get(i).getKe().getBeizhu());
				System.out.println("Fabushijian"+list.get(i).getKe().getFabushijian());
				}
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}finally{
				dao.closeCon(null,pstm,con);
			}
			return list;
		}
		
	public ketilunwen selectKetixinxi(String ketibianhao,String student_ID1){
			Connection con=null;
			PreparedStatement pstm=null;
			BaseDao dao = new BaseDao();
			ResultSet resultSet=null;
			ketixinxi ke=new ketixinxi();
			xuantixinxi xuan=new xuantixinxi();
			ketilunwen list=new ketilunwen();
			try{			
				con=dao.getConnection();
				if(con==null)
					System.out.println("连接失败");
				else
					System.out.println("连接成功");
				pstm=con.prepareStatement("select ke.*,xuan.* from ketixinxi ke,xuantixinxi xuan where ke.ketimingcheng=xuan.ketimingcheng and ketibianhao=? and student_ID=?");
				pstm.setString(1, ketibianhao);
				pstm.setString(2, student_ID1);
				resultSet=pstm.executeQuery();
				while(resultSet.next()){		
					//ke.setKetibianhao(resultSet.getString("ketibianhao"));
					ke.setTeacID(resultSet.getString("teacID"));
					ke.setKetimingcheng(resultSet.getString("ketimingcheng"));
					ke.setLeixing(resultSet.getString("leixing"));
					ke.setFujian(resultSet.getString("fujian"));
					ke.setKetishuliang(resultSet.getString("ketishuliang"));
					ke.setBeizhu(resultSet.getString("beizhu"));
					ke.setFabushijian(resultSet.getString("fabushijian"));
					xuan.setXuanti_ID(resultSet.getInt("xuan.xuanti_ID"));
					xuan.setKetimingcheng(resultSet.getString("xuan.ketimingcheng"));
					xuan.setTeacher_ID(resultSet.getString("xuan.teacher_ID"));
					xuan.setStudent_ID(resultSet.getString("xuan.student_ID"));
					xuan.setXuantishijian(resultSet.getString("xuan.xuantishijian"));
					xuan.setBeizhu(resultSet.getString("xuan.beizhu"));
					list.setKe(ke);
					list.setXuan(xuan);

				}
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}finally{
				dao.closeCon(null,pstm,con);
			}
			return list;
		}
	public ketixinxi selectKetixinxi2(String ketibianhao){
		Connection con=null;
		PreparedStatement pstm=null;
		BaseDao dao = new BaseDao();
		ResultSet resultSet=null;
		ketixinxi ke=new ketixinxi();
		xuantixinxi xuan=new xuantixinxi();
		ketilunwen list=new ketilunwen();
		try{			
			con=dao.getConnection();
			if(con==null)
				System.out.println("连接失败");
			else
				System.out.println("连接成功");
			pstm=con.prepareStatement("select * from ketixinxi  where ketibianhao=? ");
			pstm.setString(1, ketibianhao);
			resultSet=pstm.executeQuery();
			while(resultSet.next()){		
				//ke.setKetibianhao(resultSet.getString("ketibianhao"));
				ke.setTeacID(resultSet.getString("teacID"));
				ke.setKetimingcheng(resultSet.getString("ketimingcheng"));
				ke.setLeixing(resultSet.getString("leixing"));
				ke.setFujian(resultSet.getString("fujian"));
				ke.setKetishuliang(resultSet.getString("ketishuliang"));
				ke.setBeizhu(resultSet.getString("beizhu"));
				ke.setFabushijian(resultSet.getString("fabushijian"));
			}
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			dao.closeCon(null,pstm,con);
		}
		return ke;
	}
		
	public xuantixinxi selectXuanti(String stuID){
			Connection con=null;
			PreparedStatement pstm=null;
			BaseDao dao = new BaseDao();
			ResultSet resultSet=null;
			xuantixinxi xuan=new xuantixinxi();
			try{			
				con=dao.getConnection();
				if(con==null)
					System.out.println("连接失败");
				else
					System.out.println("连接成功");
				pstm=con.prepareStatement("select * from xuantixinxi where student_ID=?");
				pstm.setString(1, stuID);
				resultSet=pstm.executeQuery();
				while(resultSet.next()){		
					xuan.setXuanti_ID(resultSet.getInt("xuanti_ID"));
					xuan.setKetimingcheng(resultSet.getString("ketimingcheng"));
					xuan.setTeacher_ID(resultSet.getString("teacher_ID"));
					xuan.setStudent_ID(resultSet.getString("student_ID"));
					xuan.setXuantishijian(resultSet.getString("xuantishijian"));
					xuan.setBeizhu(resultSet.getString("beizhu"));
				}
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}finally{
				dao.closeCon(null,pstm,con);
			}
			return xuan;
		}

	public xuantixinxi StudentIsxuanlun(String student_ID){
		Connection con=null;
		xuantixinxi xuan=new xuantixinxi();
		PreparedStatement pstm=null;
		BaseDao dao = new BaseDao();
		ResultSet resultSet=null;
		try{			
			con=dao.getConnection();
			if(con==null)
				System.out.println("连接失败");
			else
				System.out.println("连接成功");
			pstm=con.prepareStatement("select xuan.* from xuantixinxi xuan,lunwenxinxi lun where xuan.ketimingcheng=lun.ketimingcheng");
			pstm.setString(1, student_ID);
			resultSet=pstm.executeQuery();
			while(resultSet.next()){				
				xuan.setXuanti_ID(resultSet.getInt("xuan.xuanti_ID"));
				xuan.setKetimingcheng(resultSet.getString("xuan.ketimingcheng"));
				xuan.setTeacher_ID(resultSet.getString("xuan.teacher_ID"));
				xuan.setStudent_ID(resultSet.getString("xuan.student_ID"));
				xuan.setXuantishijian(resultSet.getString("xuan.xuantishijian"));
				xuan.setBeizhu(resultSet.getString("xuan.beizhu"));
			}
		}catch(Exception e){
			e.printStackTrace();
			return xuan;
		}finally{
			dao.closeCon(null,pstm,con);
		}
		return xuan;
	}
}
