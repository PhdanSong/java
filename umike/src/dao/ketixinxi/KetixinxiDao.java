package dao.ketixinxi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import entity.chengji;
import entity.ketilunwen;
import entity.ketixinxi;
import entity.minge;
import entity.xuantixinxi;

public class KetixinxiDao {

	public int saveKetixinxi(ketixinxi ke){
		Connection con=null;
		PreparedStatement pstm=null;
		BaseDao dao = new BaseDao();
		try{
			
			con=dao.getConnection();
			if(con==null)
				System.out.println("连接失败");
			else
				System.out.println("连接成功");
			pstm=con.prepareStatement("insert into ketixinxi values(?,?,?,?,?,?,?,?,?)");
			pstm.setString(1, ke.getKetibianhao());
			pstm.setString(2, ke.getTeacID());
			pstm.setString(3, ke.getKetimingcheng());
			pstm.setString(4, ke.getLeixing());
			pstm.setString(5, ke.getFujian());
			pstm.setString(6, ke.getKetishuliang());
			pstm.setString(7, ke.getBeizhu());
			pstm.setString(8, ke.getFabushijian());
			pstm.setString(9, ke.getBaocunming());
			return pstm.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}finally{
			dao.closeCon(null,pstm,con);
		}
	}
	
	public ketixinxi SelectKetixinxi(String techID,String ketibianhao){
		Connection con=null;
		PreparedStatement pstm=null;
		BaseDao dao = new BaseDao();
		ResultSet resultSet=null;
		ketixinxi ke = new ketixinxi();
		try{			
			con=dao.getConnection();
			if(con==null)
				System.out.println("连接失败");
			else
				System.out.println("连接成功");
			pstm=con.prepareStatement("select ke.* from  ketixinxi ke,xuantixinxi xuan where ke.ketimingcheng= xuan.ketimingcheng and ke.teacID =? and ke.ketibianhao=?");
			pstm.setString(1, techID);
			pstm.setString(2, ketibianhao);
			resultSet=pstm.executeQuery();
			while(resultSet.next()){		
				ke.setKetibianhao(resultSet.getString("ketibianhao"));
				ke.setTeacID(resultSet.getString("teacID"));
				ke.setKetimingcheng(resultSet.getString("ketimingcheng"));
				ke.setLeixing(resultSet.getString("leixing"));
				ke.setFujian(resultSet.getString("fujian"));
				ke.setKetishuliang(resultSet.getString("ketishuliang"));
				ke.setBeizhu(resultSet.getString("beizhu"));
				ke.setFabushijian(resultSet.getString("fabushijian"));
				ke.setBaocunming(resultSet.getString("baocunming"));
			}
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			dao.closeCon(null,pstm,con);
		}
		return ke;
	} 

	public int deleteKetixinxi(String teacID,String ketibianhao){
		Connection con=null;
		PreparedStatement pstm=null;
		BaseDao dao = new BaseDao();
		try{		
			con=dao.getConnection();
			if(con==null)
				System.out.println("连接失败");
			else
				System.out.println("连接成功");
			pstm=con.prepareStatement("delete from ketixinxi where teacID=? and ketibianhao=?");
			pstm.setString(1, teacID);
			pstm.setString(2, ketibianhao);
			return pstm.executeUpdate();			
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}finally{
			dao.closeCon(null,pstm,con);
		}
	}

	public int updateKetixinxi(ketixinxi ke,String techID,String ketibianhao){
		Connection con=null;
		PreparedStatement pstm=null;
		BaseDao dao = new BaseDao();
		try{
			
			con=dao.getConnection();
			if(con==null)
				System.out.println("连接失败");
			else
				System.out.println("连接成功");
			pstm=con.prepareStatement("update ketixinxi set ketibianhao=?,teacID=?,ketimingcheng=?,leixing=?,fujian=?,ketishuliang=?,beizhu=?,fabushijian=?,baocunming=? where teacID=? and ketibianhao=?");
			pstm.setString(1, ke.getKetibianhao());
			pstm.setString(2, ke.getTeacID());
			pstm.setString(3, ke.getKetimingcheng());
			pstm.setString(4, ke.getLeixing());
			pstm.setString(5, ke.getFujian());
			pstm.setString(6, ke.getKetishuliang());
			pstm.setString(7, ke.getBeizhu());
			pstm.setString(8, ke.getFabushijian());
			pstm.setString(9, ke.getBaocunming());
			pstm.setString(10, techID);
			pstm.setString(11, ketibianhao);
			return pstm.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}finally{
			dao.closeCon(null,pstm,con);
		}
	}
	
	public ketixinxi teacIDselectKetixinxi(String techID,String ketibianhao){
		Connection con=null;
		PreparedStatement pstm=null;
		BaseDao dao = new BaseDao();
		ResultSet resultSet=null;
		ketixinxi ke=new ketixinxi();
		try{
			
			con=dao.getConnection();
			if(con==null)
				System.out.println("连接失败");
			else
				System.out.println("连接成功");
			pstm=con.prepareStatement("select * from ketixinxi where teacID=? and ketibianhao=?");
			pstm.setString(1, techID);
			pstm.setString(2, ketibianhao);
			resultSet=pstm.executeQuery();
			while(resultSet.next()){		
				ke.setKetibianhao(resultSet.getString("ketibianhao"));
				ke.setTeacID(resultSet.getString("teacID"));
				ke.setKetimingcheng(resultSet.getString("ketimingcheng"));
				ke.setLeixing(resultSet.getString("leixing"));
				ke.setFujian(resultSet.getString("fujian"));
				ke.setKetishuliang(resultSet.getString("ketishuliang"));
				ke.setBeizhu(resultSet.getString("beizhu"));
				ke.setFabushijian(resultSet.getString("fabushijian"));
				ke.setBaocunming(resultSet.getString("baocunming"));
			}
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			dao.closeCon(null,pstm,con);
		}
		return ke;
	} 
	
	public List<ketixinxi> getKetixinxi(String techID){
		Connection con=null;
		PreparedStatement pstm=null;
		BaseDao dao = new BaseDao();
		ResultSet resultSet=null;
		List<ketixinxi> list=new ArrayList<ketixinxi>();
		try{
			
			con=dao.getConnection();
			if(con==null)
				System.out.println("连接失败");
			else
				System.out.println("连接成功");
			pstm=con.prepareStatement("select * from ketixinxi where teacID=?");
			pstm.setString(1, techID);
			resultSet=pstm.executeQuery();
			while(resultSet.next()){
				ketixinxi ke = new ketixinxi();
				ke.setKetibianhao(resultSet.getString("ketibianhao"));
				ke.setTeacID(resultSet.getString("teacID"));
				ke.setKetimingcheng(resultSet.getString("ketimingcheng"));
				ke.setLeixing(resultSet.getString("leixing"));
				ke.setFujian(resultSet.getString("fujian"));
				ke.setKetishuliang(resultSet.getString("ketishuliang"));
				ke.setBeizhu(resultSet.getString("beizhu"));
				ke.setFabushijian(resultSet.getString("fabushijian"));
				ke.setBaocunming(resultSet.getString("baocunming"));
				list.add(ke);
			}
		    return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			dao.closeCon(null,pstm,con);
		}
		
	} 
	
	public List<ketixinxi> selectKetixinxiBymingcheng(String techID,String mingcheng){
		Connection con=null;
		PreparedStatement pstm=null;
		BaseDao dao = new BaseDao();
		ResultSet resultSet=null;
		List<ketixinxi> list=new ArrayList<ketixinxi>();
		try{
			
			con=dao.getConnection();
			if(con==null)
				System.out.println("连接失败");
			else
				System.out.println("连接成功");
			pstm=con.prepareStatement("select * from ketixinxi where teacID=? and ketimingcheng like '%"+mingcheng+"%'");
			pstm.setString(1, techID);
			resultSet=pstm.executeQuery();
			while(resultSet.next()){
				ketixinxi ke = new ketixinxi();
				ke.setKetibianhao(resultSet.getString("ketibianhao"));
				ke.setTeacID(resultSet.getString("teacID"));
				ke.setKetimingcheng(resultSet.getString("ketimingcheng"));
				ke.setLeixing(resultSet.getString("leixing"));
				ke.setFujian(resultSet.getString("fujian"));
				ke.setKetishuliang(resultSet.getString("ketishuliang"));
				ke.setBeizhu(resultSet.getString("beizhu"));
				ke.setFabushijian(resultSet.getString("fabushijian"));
				ke.setBaocunming(resultSet.getString("baocunming"));
				list.add(ke);
			}
		    return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			dao.closeCon(null,pstm,con);
		}
		
	} 
		
	public ketixinxi selectKetixinxiBybianhao(String techID,String bianhao){
		Connection con=null;
		PreparedStatement pstm=null;
		BaseDao dao = new BaseDao();
		ResultSet resultSet=null;
		ketixinxi ke=new ketixinxi();
		try{
			
			con=dao.getConnection();
			if(con==null)
				System.out.println("连接失败");
			else
				System.out.println("连接成功");
			pstm=con.prepareStatement("select * from ketixinxi where teacID=? and ketibianhao=?");
			pstm.setString(1, techID);
			pstm.setString(2, bianhao);
			resultSet=pstm.executeQuery();
			while(resultSet.next()){
				ke.setKetibianhao(resultSet.getString("ketibianhao"));
				ke.setTeacID(resultSet.getString("teacID"));
				ke.setKetimingcheng(resultSet.getString("ketimingcheng"));
				ke.setLeixing(resultSet.getString("leixing"));
				ke.setFujian(resultSet.getString("fujian"));
				ke.setKetishuliang(resultSet.getString("ketishuliang"));
				ke.setBeizhu(resultSet.getString("beizhu"));
				ke.setFabushijian(resultSet.getString("fabushijian"));
				ke.setBaocunming(resultSet.getString("baocunming"));
			}
		    return ke;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			dao.closeCon(null,pstm,con);
		}
		
	} 
		
	public ketixinxi selectKetixinxiBymingandbian(String techID,String bianhao,String mingcheng){
		Connection con=null;
		PreparedStatement pstm=null;
		BaseDao dao = new BaseDao();
		ResultSet resultSet=null;
		ketixinxi ke=new ketixinxi();
		try{
			
			con=dao.getConnection();
			if(con==null)
				System.out.println("连接失败");
			else
				System.out.println("连接成功");
			pstm=con.prepareStatement("select * from ketixinxi where teacID=? and ketibianhao=? and ketimingcheng like '%"+mingcheng+"%'");
			pstm.setString(1, techID);
			pstm.setString(2, bianhao);
			resultSet=pstm.executeQuery();
			while(resultSet.next()){
				ke.setKetibianhao(resultSet.getString("ketibianhao"));
				ke.setTeacID(resultSet.getString("teacID"));
				ke.setKetimingcheng(resultSet.getString("ketimingcheng"));
				ke.setLeixing(resultSet.getString("leixing"));
				ke.setFujian(resultSet.getString("fujian"));
				ke.setKetishuliang(resultSet.getString("ketishuliang"));
				ke.setBeizhu(resultSet.getString("beizhu"));
				ke.setFabushijian(resultSet.getString("fabushijian"));
				ke.setBaocunming(resultSet.getString("baocunming"));
			}
		    return ke;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			dao.closeCon(null,pstm,con);
		}
		
	} 
	//老师
		public ketixinxi mingchengselectKetixinxi(String mingcheng,String ketibianhao,String teacID){
			Connection con=null;
			PreparedStatement pstm=null;
			BaseDao dao = new BaseDao();
			ResultSet resultSet=null;
			ketixinxi ke=new ketixinxi();
			try{
				con=dao.getConnection();
				if(con==null)
					System.out.println("连接失败");
				else
					System.out.println("连接成功");
				pstm=con.prepareStatement("select * from ketixinxi where ketimingcheng=?,ketibianhao=?,teachID=?");
				pstm.setString(1, mingcheng);
				pstm.setString(2, ketibianhao);
				pstm.setString(3, teacID);
				resultSet=pstm.executeQuery();
				while(resultSet.next()){				
					ke.setKetibianhao(resultSet.getString("ketibianhao"));
					ke.setTeacID(resultSet.getString("teachID"));
					ke.setKetimingcheng(resultSet.getString("ketimingcheng"));
					ke.setLeixing(resultSet.getString("leixing"));
					ke.setFujian(resultSet.getString("fujian"));
					ke.setKetishuliang(resultSet.getString("ketishuliang"));
					ke.setBeizhu(resultSet.getString("beizhu"));
					ke.setFabushijian(resultSet.getString("fabushijian"));
					ke.setBaocunming(resultSet.getString("baocunming"));
				}
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}finally{
				dao.closeCon(null,pstm,con);
			}
			return ke;
		}
		
		//学生
		public ketixinxi stuselectKetixinxi(String mingcheng,String ketibianhao){
			Connection con=null;
			PreparedStatement pstm=null;
			BaseDao dao = new BaseDao();
			ResultSet resultSet=null;
			ketixinxi ke=new ketixinxi();
			try{
				con=dao.getConnection();
				if(con==null)
					System.out.println("连接失败");
				else
					System.out.println("连接成功");
				pstm=con.prepareStatement("select * from ketixinxi where ketimingcheng=? and ketibianhao=?");
				pstm.setString(1, mingcheng);
				pstm.setString(2, ketibianhao);
				resultSet=pstm.executeQuery();
				while(resultSet.next()){				
					ke.setKetibianhao(resultSet.getString("ketibianhao"));
					ke.setTeacID(resultSet.getString("teacID"));
					ke.setKetimingcheng(resultSet.getString("ketimingcheng"));
					ke.setLeixing(resultSet.getString("leixing"));
					ke.setFujian(resultSet.getString("fujian"));
					ke.setKetishuliang(resultSet.getString("ketishuliang"));
					ke.setBeizhu(resultSet.getString("beizhu"));
					ke.setFabushijian(resultSet.getString("fabushijian"));
					ke.setBaocunming(resultSet.getString("baocunming"));
				}
				System.out.println(ke.getKetibianhao());
				System.out.println(ke.getTeacID());
				System.out.println(ke.getKetimingcheng());
				System.out.println(ke.getLeixing());
				System.out.println(ke.getFabushijian());
				System.out.println(ke.getKetishuliang());
				System.out.println(ke.getBeizhu());
				System.out.println(ke.getFabushijian());
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}finally{
				dao.closeCon(null,pstm,con);
			}
			return ke;
		}

		//学生,教师编号和对应的已选名额
		public List<minge> countKetixinxi(){
			Connection con=null;
			ResultSet resultSet=null;
			PreparedStatement pstm=null;
			BaseDao dao = new BaseDao();
			List<minge> list=new ArrayList<minge>();		
			try{			
				con=dao.getConnection();
				if(con==null)
					System.out.println("连接失败");
				else
					System.out.println("连接成功");
				pstm=con.prepareStatement("select xuan.teacher_ID,count(ke.teacID) c from xuantixinxi xuan,ketixinxi ke where xuan.teacher_ID=ke.teacID group by xuan.teacher_ID");
				resultSet=pstm.executeQuery(); 
				while(resultSet.next()){		
					minge min=new minge();
					int shengcount=0;
					String count=resultSet.getString("c");
					shengcount=5-Integer.parseInt(count);
					min.setCount(Integer.toString(shengcount));
					min.setTeacher_ID(resultSet.getString("xuan.teacher_ID"));
					list.add(min);
				}
				for(int i = 0 ; i< list.size();i++){   
		            System.out.println("宸查�鍚嶉"+list.get(i).getCount()+"鍜屽搴旂殑鏁欏笀缂栧彿鏄"+list.get(i).getTeacher_ID());
		        }
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}finally{
				dao.closeCon(null,pstm,con);
			}
			return list;
		}
		
		public List<ketilunwen> count(){
			Connection con=null;
			ResultSet resultSet=null;
			PreparedStatement pstm=null;
			BaseDao dao = new BaseDao();
			List<ketilunwen> list=new ArrayList<ketilunwen>();			
			try{			
				con=dao.getConnection();
				if(con==null)
					System.out.println("连接失败");
				else
					System.out.println("连接成功");
				pstm=con.prepareStatement("select xuan.*,ke.*,ke.ketishuliang - count(xuan.student_ID) shengyu from ketixinxi ke,xuantixinxi xuan  where ke.ketimingcheng = xuan.ketimingcheng group by xuan.ketimingcheng");
				resultSet=pstm.executeQuery(); 
				while(resultSet.next()){		
					ketixinxi ke=new ketixinxi();
					xuantixinxi xuan=new xuantixinxi();
					ketilunwen keti=new ketilunwen();
					minge min=new minge();
					ke.setKetibianhao(resultSet.getString("ketibianhao"));
					ke.setTeacID(resultSet.getString("teacID"));
					ke.setKetimingcheng(resultSet.getString("ketimingcheng"));
					ke.setLeixing(resultSet.getString("leixing"));
					ke.setFujian(resultSet.getString("fujian"));
					ke.setKetishuliang(resultSet.getString("ketishuliang"));
					ke.setBeizhu(resultSet.getString("beizhu"));
					ke.setFabushijian(resultSet.getString("fabushijian"));
					ke.setBaocunming(resultSet.getString("baocunming"));
					xuan.setXuanti_ID(resultSet.getInt("xuanti_ID"));
					xuan.setKetimingcheng(resultSet.getString("ketimingcheng"));
					xuan.setTeacher_ID(resultSet.getString("teacher_ID"));
					xuan.setStudent_ID(resultSet.getString("student_ID"));
					xuan.setXuantishijian(resultSet.getString("xuantishijian"));
					xuan.setBeizhu(resultSet.getString("beizhu"));
					min.setCount(resultSet.getString("shengyu"));
					keti.setKe(ke);
					keti.setXuan(xuan);
					keti.setMin(min);
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
		//只输入课题编号查询
		public List<ketilunwen> count1(String ketibianhao){
			Connection con=null;
			ResultSet resultSet=null;
			PreparedStatement pstm=null;
			BaseDao dao = new BaseDao();
			List<ketilunwen> list=new ArrayList<ketilunwen>();			
			try{			
				con=dao.getConnection();
				if(con==null)
					System.out.println("连接失败");
				else
					System.out.println("连接成功");
				pstm=con.prepareStatement("select xuan.*,ke.*,ke.ketishuliang - count(xuan.student_ID) shengyu from ketixinxi ke,xuantixinxi xuan  where ke.ketimingcheng = xuan.ketimingcheng and ke.ketibianhao=? group by xuan.ketimingcheng");
				pstm.setString(1, ketibianhao);
				resultSet=pstm.executeQuery(); 
				while(resultSet.next()){		
					ketixinxi ke=new ketixinxi();
					xuantixinxi xuan=new xuantixinxi();
					ketilunwen keti=new ketilunwen();
					minge min=new minge();
					ke.setKetibianhao(resultSet.getString("ketibianhao"));
					ke.setTeacID(resultSet.getString("teacID"));
					ke.setKetimingcheng(resultSet.getString("ketimingcheng"));
					ke.setLeixing(resultSet.getString("leixing"));
					ke.setFujian(resultSet.getString("fujian"));
					ke.setKetishuliang(resultSet.getString("ketishuliang"));
					ke.setBeizhu(resultSet.getString("beizhu"));
					ke.setFabushijian(resultSet.getString("fabushijian"));
					ke.setBaocunming(resultSet.getString("baocunming"));
					xuan.setXuanti_ID(resultSet.getInt("xuanti_ID"));
					xuan.setKetimingcheng(resultSet.getString("ketimingcheng"));
					xuan.setTeacher_ID(resultSet.getString("teacher_ID"));
					xuan.setStudent_ID(resultSet.getString("student_ID"));
					xuan.setXuantishijian(resultSet.getString("xuantishijian"));
					xuan.setBeizhu(resultSet.getString("beizhu"));
					min.setCount(resultSet.getString("shengyu"));
					keti.setKe(ke);
					keti.setXuan(xuan);
					keti.setMin(min);
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
		
		//只输入课题名称查询
		public List<ketilunwen> count2(String ketimingcheng){
				Connection con=null;
				ResultSet resultSet=null;
				PreparedStatement pstm=null;
				BaseDao dao = new BaseDao();
				List<ketilunwen> list=new ArrayList<ketilunwen>();			
				try{			
					con=dao.getConnection();
					if(con==null)
						System.out.println("连接失败");
					else
						System.out.println("连接成功");
					pstm=con.prepareStatement("select xuan.*,ke.*,ke.ketishuliang - count(xuan.student_ID) shengyu from ketixinxi ke,xuantixinxi xuan  where ke.ketimingcheng = xuan.ketimingcheng and ke.ketimingcheng=? group by xuan.ketimingcheng");
					pstm.setString(1, ketimingcheng);
					resultSet=pstm.executeQuery(); 
					while(resultSet.next()){		
						ketixinxi ke=new ketixinxi();
						xuantixinxi xuan=new xuantixinxi();
						ketilunwen keti=new ketilunwen();
						minge min=new minge();
						ke.setKetibianhao(resultSet.getString("ketibianhao"));
						ke.setTeacID(resultSet.getString("teacID"));
						ke.setKetimingcheng(resultSet.getString("ketimingcheng"));
						ke.setLeixing(resultSet.getString("leixing"));
						ke.setFujian(resultSet.getString("fujian"));
						ke.setKetishuliang(resultSet.getString("ketishuliang"));
						ke.setBeizhu(resultSet.getString("beizhu"));
						ke.setFabushijian(resultSet.getString("fabushijian"));
						ke.setBaocunming(resultSet.getString("baocunming"));
						xuan.setXuanti_ID(resultSet.getInt("xuanti_ID"));
						xuan.setKetimingcheng(resultSet.getString("ketimingcheng"));
						xuan.setTeacher_ID(resultSet.getString("teacher_ID"));
						xuan.setStudent_ID(resultSet.getString("student_ID"));
						xuan.setXuantishijian(resultSet.getString("xuantishijian"));
						xuan.setBeizhu(resultSet.getString("beizhu"));
						min.setCount(resultSet.getString("shengyu"));
						keti.setKe(ke);
						keti.setXuan(xuan);
						keti.setMin(min);
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
		
		//只输入发布教师查询	
		public List<ketilunwen> count3(String teacID){
			Connection con=null;
			ResultSet resultSet=null;
			PreparedStatement pstm=null;
			BaseDao dao = new BaseDao();
			List<ketilunwen> list=new ArrayList<ketilunwen>();			
			try{			
				con=dao.getConnection();
				if(con==null)
					System.out.println("连接失败");
				else
					System.out.println("连接成功");
				pstm=con.prepareStatement("select xuan.*,ke.*,ke.ketishuliang - count(xuan.student_ID) shengyu from ketixinxi ke,xuantixinxi xuan  where ke.ketimingcheng = xuan.ketimingcheng and ke.teacID=? group by xuan.ketimingcheng");
				pstm.setString(1, teacID);
				resultSet=pstm.executeQuery(); 
				while(resultSet.next()){		
					ketixinxi ke=new ketixinxi();
					xuantixinxi xuan=new xuantixinxi();
					ketilunwen keti=new ketilunwen();
					minge min=new minge();
					ke.setKetibianhao(resultSet.getString("ketibianhao"));
					ke.setTeacID(resultSet.getString("teacID"));
					ke.setKetimingcheng(resultSet.getString("ketimingcheng"));
					ke.setLeixing(resultSet.getString("leixing"));
					ke.setFujian(resultSet.getString("fujian"));
					ke.setKetishuliang(resultSet.getString("ketishuliang"));
					ke.setBeizhu(resultSet.getString("beizhu"));
					ke.setFabushijian(resultSet.getString("fabushijian"));
					ke.setBaocunming(resultSet.getString("baocunming"));
					xuan.setXuanti_ID(resultSet.getInt("xuanti_ID"));
					xuan.setKetimingcheng(resultSet.getString("ketimingcheng"));
					xuan.setTeacher_ID(resultSet.getString("teacher_ID"));
					xuan.setStudent_ID(resultSet.getString("student_ID"));
					xuan.setXuantishijian(resultSet.getString("xuantishijian"));
					xuan.setBeizhu(resultSet.getString("beizhu"));
					min.setCount(resultSet.getString("shengyu"));
					keti.setKe(ke);
					keti.setXuan(xuan);
					keti.setMin(min);
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
		//输入课题编号，课题信息，发布教师查询
		public List<ketilunwen> count4(String ketibianhao,String ketimingcheng,String teacID){
			Connection con=null;
			ResultSet resultSet=null;
			PreparedStatement pstm=null;
			BaseDao dao = new BaseDao();
			List<ketilunwen> list=new ArrayList<ketilunwen>();			
			try{			
				con=dao.getConnection();
				if(con==null)
					System.out.println("连接失败");
				else
					System.out.println("连接成功");
				pstm=con.prepareStatement("select xuan.*,ke.*,ke.ketishuliang - count(xuan.student_ID) shengyu from ketixinxi ke,xuantixinxi xuan  where ke.ketimingcheng = xuan.ketimingcheng and ke.ketibianhao=? and ke.ketimingcheng=? and ke.teacID=? group by xuan.ketimingcheng");
				pstm.setString(1, ketibianhao);
				pstm.setString(2, ketimingcheng);
				pstm.setString(3, teacID);
				resultSet=pstm.executeQuery(); 
				while(resultSet.next()){		
					ketixinxi ke=new ketixinxi();
					xuantixinxi xuan=new xuantixinxi();
					ketilunwen keti=new ketilunwen();
					minge min=new minge();
					ke.setKetibianhao(resultSet.getString("ketibianhao"));
					ke.setTeacID(resultSet.getString("teacID"));
					ke.setKetimingcheng(resultSet.getString("ketimingcheng"));
					ke.setLeixing(resultSet.getString("leixing"));
					ke.setFujian(resultSet.getString("fujian"));
					ke.setKetishuliang(resultSet.getString("ketishuliang"));
					ke.setBeizhu(resultSet.getString("beizhu"));
					ke.setFabushijian(resultSet.getString("fabushijian"));
					ke.setBaocunming(resultSet.getString("baocunming"));
					xuan.setXuanti_ID(resultSet.getInt("xuanti_ID"));
					xuan.setKetimingcheng(resultSet.getString("ketimingcheng"));
					xuan.setTeacher_ID(resultSet.getString("teacher_ID"));
					xuan.setStudent_ID(resultSet.getString("student_ID"));
					xuan.setXuantishijian(resultSet.getString("xuantishijian"));
					xuan.setBeizhu(resultSet.getString("beizhu"));
					min.setCount(resultSet.getString("shengyu"));
					keti.setKe(ke);
					keti.setXuan(xuan);
					keti.setMin(min);
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
		//输入课题编号，课题名称查询
		public List<ketilunwen> count5(String ketibianhao,String ketimingcheng){
			Connection con=null;
			ResultSet resultSet=null;
			PreparedStatement pstm=null;
			BaseDao dao = new BaseDao();
			List<ketilunwen> list=new ArrayList<ketilunwen>();			
			try{			
				con=dao.getConnection();
				if(con==null)
					System.out.println("连接失败");
				else
					System.out.println("连接成功");
				pstm=con.prepareStatement("select xuan.*,ke.*,ke.ketishuliang - count(xuan.student_ID) shengyu from ketixinxi ke,xuantixinxi xuan  where ke.ketimingcheng = xuan.ketimingcheng and ke.ketibianhao=? and ke.ketimingcheng=? group by xuan.ketimingcheng");
				pstm.setString(1, ketibianhao);
				pstm.setString(2, ketimingcheng);
				resultSet=pstm.executeQuery(); 
				while(resultSet.next()){		
					ketixinxi ke=new ketixinxi();
					xuantixinxi xuan=new xuantixinxi();
					ketilunwen keti=new ketilunwen();
					minge min=new minge();
					ke.setKetibianhao(resultSet.getString("ketibianhao"));
					ke.setTeacID(resultSet.getString("teacID"));
					ke.setKetimingcheng(resultSet.getString("ketimingcheng"));
					ke.setLeixing(resultSet.getString("leixing"));
					ke.setFujian(resultSet.getString("fujian"));
					ke.setKetishuliang(resultSet.getString("ketishuliang"));
					ke.setBeizhu(resultSet.getString("beizhu"));
					ke.setFabushijian(resultSet.getString("fabushijian"));
					ke.setBaocunming(resultSet.getString("baocunming"));
					xuan.setXuanti_ID(resultSet.getInt("xuanti_ID"));
					xuan.setKetimingcheng(resultSet.getString("ketimingcheng"));
					xuan.setTeacher_ID(resultSet.getString("teacher_ID"));
					xuan.setStudent_ID(resultSet.getString("student_ID"));
					xuan.setXuantishijian(resultSet.getString("xuantishijian"));
					xuan.setBeizhu(resultSet.getString("beizhu"));
					min.setCount(resultSet.getString("shengyu"));
					keti.setKe(ke);
					keti.setXuan(xuan);
					keti.setMin(min);
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
		//输入课题编号，发布教师查询
		public List<ketilunwen> count6(String ketibianhao,String teacID){
			Connection con=null;
			ResultSet resultSet=null;
			PreparedStatement pstm=null;
			BaseDao dao = new BaseDao();
			List<ketilunwen> list=new ArrayList<ketilunwen>();			
			try{			
				con=dao.getConnection();
				if(con==null)
					System.out.println("连接失败");
				else
					System.out.println("连接成功");
				pstm=con.prepareStatement("select xuan.*,ke.*,ke.ketishuliang - count(xuan.student_ID) shengyu from ketixinxi ke,xuantixinxi xuan  where ke.ketimingcheng = xuan.ketimingcheng and ke.ketibianhao=? and ke.teacID=? group by xuan.ketimingcheng");
				pstm.setString(1, ketibianhao);
				pstm.setString(2, teacID);
				resultSet=pstm.executeQuery(); 
				while(resultSet.next()){		
					ketixinxi ke=new ketixinxi();
					xuantixinxi xuan=new xuantixinxi();
					ketilunwen keti=new ketilunwen();
					minge min=new minge();
					ke.setKetibianhao(resultSet.getString("ketibianhao"));
					ke.setTeacID(resultSet.getString("teacID"));
					ke.setKetimingcheng(resultSet.getString("ketimingcheng"));
					ke.setLeixing(resultSet.getString("leixing"));
					ke.setFujian(resultSet.getString("fujian"));
					ke.setKetishuliang(resultSet.getString("ketishuliang"));
					ke.setBeizhu(resultSet.getString("beizhu"));
					ke.setFabushijian(resultSet.getString("fabushijian"));
					ke.setBaocunming(resultSet.getString("baocunming"));
					xuan.setXuanti_ID(resultSet.getInt("xuanti_ID"));
					xuan.setKetimingcheng(resultSet.getString("ketimingcheng"));
					xuan.setTeacher_ID(resultSet.getString("teacher_ID"));
					xuan.setStudent_ID(resultSet.getString("student_ID"));
					xuan.setXuantishijian(resultSet.getString("xuantishijian"));
					xuan.setBeizhu(resultSet.getString("beizhu"));
					min.setCount(resultSet.getString("shengyu"));
					keti.setKe(ke);
					keti.setXuan(xuan);
					keti.setMin(min);
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
		//输入课题名称，发布教师查询
		public List<ketilunwen> count7(String ketimingcheng,String teacID){
			Connection con=null;
			ResultSet resultSet=null;
			PreparedStatement pstm=null;
			BaseDao dao = new BaseDao();
			List<ketilunwen> list=new ArrayList<ketilunwen>();			
			try{			
				con=dao.getConnection();
				if(con==null)
					System.out.println("连接失败");
				else
					System.out.println("连接成功");
				pstm=con.prepareStatement("select xuan.*,ke.*,ke.ketishuliang - count(xuan.student_ID) shengyu from ketixinxi ke,xuantixinxi xuan  where ke.ketimingcheng = xuan.ketimingcheng  and ke.ketimingcheng=? and ke.teacID=? group by xuan.ketimingcheng");
				pstm.setString(1, ketimingcheng);
				pstm.setString(2, teacID);
				resultSet=pstm.executeQuery(); 
				while(resultSet.next()){		
					ketixinxi ke=new ketixinxi();
					xuantixinxi xuan=new xuantixinxi();
					ketilunwen keti=new ketilunwen();
					minge min=new minge();
					ke.setKetibianhao(resultSet.getString("ketibianhao"));
					ke.setTeacID(resultSet.getString("teacID"));
					ke.setKetimingcheng(resultSet.getString("ketimingcheng"));
					ke.setLeixing(resultSet.getString("leixing"));
					ke.setFujian(resultSet.getString("fujian"));
					ke.setKetishuliang(resultSet.getString("ketishuliang"));
					ke.setBeizhu(resultSet.getString("beizhu"));
					ke.setFabushijian(resultSet.getString("fabushijian"));
					ke.setBaocunming(resultSet.getString("baocunming"));
					xuan.setXuanti_ID(resultSet.getInt("xuanti_ID"));
					xuan.setKetimingcheng(resultSet.getString("ketimingcheng"));
					xuan.setTeacher_ID(resultSet.getString("teacher_ID"));
					xuan.setStudent_ID(resultSet.getString("student_ID"));
					xuan.setXuantishijian(resultSet.getString("xuantishijian"));
					xuan.setBeizhu(resultSet.getString("beizhu"));
					min.setCount(resultSet.getString("shengyu"));
					keti.setKe(ke);
					keti.setXuan(xuan);
					keti.setMin(min);
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
		 //点击我要选题实现剩余名额减一的功能
		public List<ketilunwen> count8(String ketibianhao){
			Connection con=null;
			ResultSet resultSet=null;
			PreparedStatement pstm=null;
			BaseDao dao = new BaseDao();
			List<ketilunwen> list=new ArrayList<ketilunwen>();			
			try{			
				con=dao.getConnection();
				if(con==null)
					System.out.println("连接失败");
				else
					System.out.println("连接成功");
				pstm=con.prepareStatement("select xuan.*,ke.*,ke.ketishuliang - count(xuan.student_ID)-1 shengyu from ketixinxi ke,xuantixinxi xuan  where ke.ketimingcheng = xuan.ketimingcheng  and ke.ketibianhao=?");
				resultSet=pstm.executeQuery(); 
				while(resultSet.next()){		
					ketixinxi ke=new ketixinxi();
					xuantixinxi xuan=new xuantixinxi();
					ketilunwen keti=new ketilunwen();
					minge min=new minge();
					ke.setKetibianhao(resultSet.getString("ketibianhao"));
					ke.setTeacID(resultSet.getString("teacID"));
					ke.setKetimingcheng(resultSet.getString("ketimingcheng"));
					ke.setLeixing(resultSet.getString("leixing"));
					ke.setFujian(resultSet.getString("fujian"));
					ke.setKetishuliang(resultSet.getString("ketishuliang"));
					ke.setBeizhu(resultSet.getString("beizhu"));
					ke.setFabushijian(resultSet.getString("fabushijian"));
					ke.setBaocunming(resultSet.getString("baocunming"));
					xuan.setXuanti_ID(resultSet.getInt("xuanti_ID"));
					xuan.setKetimingcheng(resultSet.getString("ketimingcheng"));
					xuan.setTeacher_ID(resultSet.getString("teacher_ID"));
					xuan.setStudent_ID(resultSet.getString("student_ID"));
					xuan.setXuantishijian(resultSet.getString("xuantishijian"));
					xuan.setBeizhu(resultSet.getString("beizhu"));
					min.setCount(resultSet.getString("shengyu"));
					keti.setKe(ke);
					keti.setXuan(xuan);
					keti.setMin(min);
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
}
