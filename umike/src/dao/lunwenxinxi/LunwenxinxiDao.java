package dao.lunwenxinxi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import entity.ketilunwen;
import entity.ketixinxi;
import entity.lunwenxinxi;
import entity.xuantixinxi;

public class LunwenxinxiDao {
	//学生
	public int saveLunwenxinxiDao(lunwenxinxi lun){
		Connection con=null;
		PreparedStatement pstm=null;
		BaseDao dao = new BaseDao();
		try{			
			con=dao.getConnection();
			if(con==null)
				System.out.println("连接失败");
			else
				System.out.println("连接成功");
			pstm=con.prepareStatement("insert into lunwenxinxi values(?,?,?,?,?,?,?,?,?)");
			pstm.setString(1, lun.getLunwen_ID());
			pstm.setString(2, lun.getLunwenmingcheng());
			pstm.setString(3, lun.getKetimingcheng());
			pstm.setString(4, lun.getStudent_ID());
			pstm.setString(5, lun.getTeacher_ID());
			pstm.setString(6, lun.getFujian());
			pstm.setString(7, lun.getBeizhu());
			pstm.setString(8, lun.getTijiaoshijian());
			pstm.setString(9, lun.getLunbaocunming());
			return pstm.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}finally{
			dao.closeCon(null,pstm,con);
		}
	}
	//学生	
	public ketilunwen IDselectlunwenxinxi(String student_ID){
		Connection con=null;
		PreparedStatement pstm=null;
		BaseDao dao = new BaseDao();
		ResultSet resultSet=null;
		lunwenxinxi lun=new lunwenxinxi();
		ketilunwen keti=new ketilunwen();
		ketixinxi ke=new ketixinxi();
		try{					
			con=dao.getConnection();
			if(con==null)
				System.out.println("连接失败");
			else
				System.out.println("连接成功");
			    pstm=con.prepareStatement("select * from lunwenxinxi lun,ketixinxi ke where lun.ketimingcheng=ke.ketimingcheng and lun.student_ID=?");
				pstm.setString(1, student_ID);
				resultSet=pstm.executeQuery();
				while(resultSet.next()){				
					lun.setLunwen_ID(resultSet.getString("lun.lunwen_ID"));
					lun.setLunwenmingcheng(resultSet.getString("lun.lunwenmingcheng"));
					lun.setKetimingcheng(resultSet.getString("lun.ketimingcheng"));
					lun.setStudent_ID(resultSet.getString("lun.student_ID"));
					lun.setTeacher_ID(resultSet.getString("lun.teacher_ID"));
					lun.setFujian(resultSet.getString("lun.fujian"));
					lun.setBeizhu(resultSet.getString("lun.beizhu"));
					lun.setTijiaoshijian(resultSet.getString("lun.tijiaoshijian"));
					lun.setLunbaocunming(resultSet.getString("lun.lunbaocunming"));
					ke.setKetibianhao(resultSet.getString("ke.ketibianhao"));
					ke.setTeacID(resultSet.getString("ke.teacID"));
					ke.setKetimingcheng(resultSet.getString("ke.ketimingcheng"));
					ke.setLeixing(resultSet.getString("ke.leixing"));
					ke.setFujian(resultSet.getString("ke.fujian"));
					ke.setKetishuliang(resultSet.getString("ke.ketishuliang"));
					ke.setBeizhu(resultSet.getString("ke.beizhu"));
					ke.setFabushijian(resultSet.getString("ke.fabushijian"));
					keti.setLun(lun);
					keti.setKe(ke);
				}
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}finally{
				dao.closeCon(null,pstm,con);
			}
			return keti;
		}

	public lunwenxinxi selectlunwenxinxi(String student_ID){
		Connection con=null;
		PreparedStatement pstm=null;
		BaseDao dao = new BaseDao();
		ResultSet resultSet=null;
		lunwenxinxi lun=new lunwenxinxi();
		ketilunwen keti=new ketilunwen();
		ketixinxi ke=new ketixinxi();
		try{					
			con=dao.getConnection();
			if(con==null)
				System.out.println("连接失败");
			else
				System.out.println("连接成功");
			    pstm=con.prepareStatement("select * from lunwenxinxi lun,ketixinxi ke where lun.ketimingcheng=ke.ketimingcheng and lun.student_ID=?");
				pstm.setString(1, student_ID);
				resultSet=pstm.executeQuery();
				while(resultSet.next()){				
					lun.setLunwen_ID(resultSet.getString("lunwen_ID"));
					lun.setLunwenmingcheng(resultSet.getString("lunwenmingcheng"));
					lun.setKetimingcheng(resultSet.getString("ketimingcheng"));
					lun.setStudent_ID(resultSet.getString("student_ID"));
					lun.setTeacher_ID(resultSet.getString("teacher_ID"));
					lun.setFujian(resultSet.getString("fujian"));
					lun.setBeizhu(resultSet.getString("beizhu"));
					lun.setTijiaoshijian(resultSet.getString("tijiaoshijian"));
					lun.setLunbaocunming(resultSet.getString("lunbaocunming"));
					
				}
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}finally{
				dao.closeCon(null,pstm,con);
			}
			return lun;
		}
	
	public lunwenxinxi StuSelectlunche(String student_ID){
		Connection con=null;
		PreparedStatement pstm=null;
		BaseDao dao = new BaseDao();
		ResultSet resultSet=null;
		lunwenxinxi lun=new lunwenxinxi();
		try{					
			con=dao.getConnection();
			if(con==null)
				System.out.println("连接失败");
			else
				System.out.println("连接成功");
			    pstm=con.prepareStatement("select lun.* from lunwenxinxi lun,chengji che where lun.lunwenmingcheng=che.lunwenmingcheng and lun.student_ID=?");
				pstm.setString(1, student_ID);
				resultSet=pstm.executeQuery();
				while(resultSet.next()){				
					lun.setLunwen_ID(resultSet.getString("lunwen_ID"));
					lun.setLunwenmingcheng(resultSet.getString("lunwenmingcheng"));
					lun.setKetimingcheng(resultSet.getString("ketimingcheng"));
					lun.setStudent_ID(resultSet.getString("student_ID"));
					lun.setTeacher_ID(resultSet.getString("teacher_ID"));
					lun.setFujian(resultSet.getString("fujian"));
					lun.setBeizhu(resultSet.getString("beizhu"));
					lun.setTijiaoshijian(resultSet.getString("tijiaoshijian"));
					lun.setLunbaocunming(resultSet.getString("lunbaocunming"));
				}
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}finally{
				dao.closeCon(null,pstm,con);
			}
			return lun;
	}
	//学生
	public int updatelunwenxinxi(lunwenxinxi lun,String student_ID,String lunwenID){
		Connection con=null;
		PreparedStatement pstm=null;
		BaseDao dao = new BaseDao();
		try{			
			con=dao.getConnection();
			if(con==null)
				System.out.println("连接失败");
			else
				System.out.println("连接成功");
			pstm=con.prepareStatement("update lunwenxinxi set lunwenmingcheng=?,fujian=?,beizhu=?,lunbaocunming=?,tijiaoshijian=? where student_ID=? and lunwen_ID= ?");					
			pstm.setString(1, lun.getLunwenmingcheng());	
			pstm.setString(2, lun.getFujian());
			pstm.setString(3, lun.getBeizhu());
			pstm.setString(4, lun.getLunbaocunming());
			pstm.setString(5, lun.getTijiaoshijian());
			pstm.setString(6,student_ID);
			pstm.setString(7,lunwenID);
			return pstm.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}finally{
			dao.closeCon(null,pstm,con);
		}
	}
	
	//学生
	public int deletelunwenxinxi(String student_ID){
		Connection con=null;
		PreparedStatement pstm=null;
		BaseDao dao = new BaseDao();
		try{			
			con=dao.getConnection();
			if(con==null)
				System.out.println("连接失败");
			else
				System.out.println("连接成功");
			pstm=con.prepareStatement("delete from lunwenxinxi WHERE lunwenxinxi.student_ID=?");	
			
			pstm.setString(1, student_ID);
			return pstm.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}finally{
			dao.closeCon(null,pstm,con);
		}
	}
	
	//根据教师工号查找
	public List<ketilunwen> teaselectlunwenxinxi(String teacher_ID){

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
			    pstm=con.prepareStatement("select * from lunwenxinxi lun,ketixinxi ke,xuantixinxi xuan where lun.teacher_ID=ke.teacID and xuan.teacher_ID=lun.teacher_ID");
				resultSet=pstm.executeQuery();
				while(resultSet.next()){
					ketilunwen keti=new ketilunwen();
					lunwenxinxi lun=new lunwenxinxi();
					ketixinxi ke = new ketixinxi();
					xuantixinxi xuan=new xuantixinxi();			
					lun.setLunwen_ID(resultSet.getString("lun.lunwen_ID"));
					lun.setLunwenmingcheng(resultSet.getString("lun.lunwenmingcheng"));
					lun.setKetimingcheng(resultSet.getString("lun.ketimingcheng"));
					lun.setStudent_ID(resultSet.getString("lun.student_ID"));
					lun.setTeacher_ID(resultSet.getString("lun.teacher_ID"));
					lun.setFujian(resultSet.getString("lun.fujian"));
					lun.setBeizhu(resultSet.getString("lun.beizhu"));
					lun.setLunbaocunming(resultSet.getString("lunbaocunming"));
					lun.setTijiaoshijian(resultSet.getString("lun.tijiaoshijian"));
					ke.setKetibianhao(resultSet.getString("ke.ketibianhao"));
					ke.setTeacID(resultSet.getString("ke.teacID"));
					ke.setKetimingcheng(resultSet.getString("ke.ketimingcheng"));
					ke.setLeixing(resultSet.getString("ke.leixing"));
					ke.setFujian(resultSet.getString("ke.fujian"));
					ke.setKetishuliang(resultSet.getString("ke.ketishuliang"));
					ke.setBeizhu(resultSet.getString("ke.beizhu"));
					ke.setFabushijian(resultSet.getString("ke.fabushijian"));
					xuan.setXuanti_ID(resultSet.getInt("xuanti_ID"));
					xuan.setKetimingcheng(resultSet.getString("ketimingcheng"));
					xuan.setTeacher_ID(resultSet.getString("teacher_ID"));
					xuan.setStudent_ID(resultSet.getString("student_ID"));
					xuan.setBeizhu(resultSet.getString("beizhu"));
					xuan.setXuantishijian(resultSet.getString("xuantishijan"));
					keti.setLun(lun);
					keti.setKe(ke);
					keti.setXuan(xuan);	
					list.add(keti);
					System.out.println(keti.getLun().getLunwen_ID());
					System.out.println(keti.getLun().getLunwenmingcheng());
					System.out.println(keti.getLun().getKetimingcheng());
					System.out.println(keti.getLun().getStudent_ID());
					System.out.println(keti.getLun().getTeacher_ID());
					System.out.println(keti.getLun().getFujian());
					System.out.println(keti.getLun().getBeizhu());
					System.out.println(keti.getLun().getTijiaoshijian());
					System.out.println(keti.getKe().getKetibianhao());
					System.out.println(keti.getKe().getTeacID());
					System.out.println(keti.getKe().getKetimingcheng());
					System.out.println(keti.getKe().getLeixing());
					System.out.println(keti.getKe().getFujian());
					System.out.println(keti.getKe().getKetishuliang());
					System.out.println(keti.getKe().getBeizhu());
					System.out.println(keti.getKe().getFabushijian());
					System.out.println(keti.getXuan().getXuanti_ID());
					System.out.println(keti.getXuan().getKetimingcheng());
					System.out.println(keti.getXuan().getTeacher_ID());
					System.out.println(keti.getXuan().getStudent_ID());
					System.out.println(keti.getXuan().getXuantishijian());
					System.out.println(keti.getXuan().getBeizhu());
				}
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}finally{
				dao.closeCon(null,pstm,con);
			}
			return list;
		}
	//教师根据论文题目、选题编号、提交人查找
	public List<ketilunwen> teaselectlunwenxinxi2(String teacher_ID,String lunwenmingcheng,String xuan_ID,String student_ID){

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
			    pstm=con.prepareStatement("select * from lunwenxinxi lun,ketixinxi ke,xuantixinxi xuan where lun.teacher_ID=ke.teacID and xuan.teacher_ID=lun.teacher_ID");
				resultSet=pstm.executeQuery();
				while(resultSet.next()){
					ketilunwen keti=new ketilunwen();
					lunwenxinxi lun=new lunwenxinxi();
					ketixinxi ke = new ketixinxi();
					xuantixinxi xuan=new xuantixinxi();			
					lun.setLunwen_ID(resultSet.getString("lun.lunwen_ID"));
					lun.setLunwenmingcheng(resultSet.getString("lun.lunwenmingcheng"));
					lun.setKetimingcheng(resultSet.getString("lun.ketimingcheng"));
					lun.setStudent_ID(resultSet.getString("lun.student_ID"));
					lun.setTeacher_ID(resultSet.getString("lun.teacher_ID"));
					lun.setFujian(resultSet.getString("lun.fujian"));
					lun.setBeizhu(resultSet.getString("lun.beizhu"));
					lun.setTijiaoshijian(resultSet.getString("lun.tijiaoshijian"));
					lun.setLunbaocunming(resultSet.getString("lunbaocunming"));
					ke.setKetibianhao(resultSet.getString("ke.ketibianhao"));
					ke.setTeacID(resultSet.getString("ke.teacID"));
					ke.setKetimingcheng(resultSet.getString("ke.ketimingcheng"));
					ke.setLeixing(resultSet.getString("ke.leixing"));
					ke.setFujian(resultSet.getString("ke.fujian"));
					ke.setKetishuliang(resultSet.getString("ke.ketishuliang"));
					ke.setBeizhu(resultSet.getString("ke.beizhu"));
					ke.setFabushijian(resultSet.getString("ke.fabushijian"));
					xuan.setXuanti_ID(resultSet.getInt("xuanti_ID"));
					xuan.setKetimingcheng(resultSet.getString("ketimingcheng"));
					xuan.setTeacher_ID(resultSet.getString("teacher_ID"));
					xuan.setStudent_ID(resultSet.getString("student_ID"));
					xuan.setBeizhu(resultSet.getString("beizhu"));
					xuan.setXuantishijian(resultSet.getString("xuantishijian"));
					keti.setLun(lun);
					keti.setKe(ke);
					keti.setXuan(xuan);	
					list.add(keti);
					System.out.println(keti.getLun().getLunwen_ID());
					System.out.println(keti.getLun().getLunwenmingcheng());
					System.out.println(keti.getLun().getKetimingcheng());
					System.out.println(keti.getLun().getStudent_ID());
					System.out.println(keti.getLun().getTeacher_ID());
					System.out.println(keti.getLun().getFujian());
					System.out.println(keti.getLun().getBeizhu());
					System.out.println(keti.getLun().getTijiaoshijian());
					System.out.println(keti.getKe().getKetibianhao());
					System.out.println(keti.getKe().getTeacID());
					System.out.println(keti.getKe().getKetimingcheng());
					System.out.println(keti.getKe().getLeixing());
					System.out.println(keti.getKe().getFujian());
					System.out.println(keti.getKe().getKetishuliang());
					System.out.println(keti.getKe().getBeizhu());
					System.out.println(keti.getKe().getFabushijian());
					System.out.println(keti.getXuan().getXuanti_ID());
					System.out.println(keti.getXuan().getKetimingcheng());
					System.out.println(keti.getXuan().getTeacher_ID());
					System.out.println(keti.getXuan().getStudent_ID());
					System.out.println(keti.getXuan().getXuantishijian());
					System.out.println(keti.getXuan().getBeizhu());
				}
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}finally{
				dao.closeCon(null,pstm,con);
			}
			return list;
		}
	
	public List<ketilunwen>teacIDselectlunwenxinxi(String techID){
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
			pstm=con.prepareStatement("select ke.*,lun.* from ketixinxi ke,lunwenxinxi lun where ke.ketimingcheng=lun.ketimingcheng and lun.teacher_ID=?");
			pstm.setString(1, techID);
			resultSet=pstm.executeQuery();
			while(resultSet.next()){	
				ketilunwen keti=new ketilunwen();
				ketixinxi ke =new ketixinxi();
				ke.setKetibianhao(resultSet.getString("ketibianhao"));
				ke.setKetimingcheng(resultSet.getString("ketimingcheng"));
				ke.setLeixing(resultSet.getString("leixing"));
				keti.setKe(ke);
				lunwenxinxi lun=new lunwenxinxi();
				lun.setLunwenmingcheng(resultSet.getString("lunwenmingcheng"));
				lun.setTeacher_ID(resultSet.getString("teacher_ID"));
				lun.setStudent_ID(resultSet.getString("student_ID"));
				lun.setFujian(resultSet.getString("fujian"));
				lun.setTijiaoshijian(resultSet.getString("tijiaoshijian"));
				lun.setBeizhu(resultSet.getString("beizhu"));
				lun.setLunbaocunming(resultSet.getString("lunbaocunming"));
				keti.setLun(lun);
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
	
//	public List<lunwenxinxi> teaselectlunwenxinxi(String teacher_ID){
//
//		Connection con=null;
//		PreparedStatement pstm=null;
//		BaseDao dao = new BaseDao();
//		ResultSet resultSet=null;
//		List<lunwenxinxi> list=new List<lunwenxinxi>();
//		lunwenxinxi lun=new lunwenxinxi();
//		try{
//					
//			con=dao.getConnection();
//			if(con==null)
//				System.out.println("连接失败");
//			else
//				System.out.println("连接成功");
//			    pstm=con.prepareStatement("select * from lunwenxinxi lun,ketixinxi ke where lun.teacher_ID=ke.teacID");
//				pstm.setString(1, student_ID);
//				resultSet=pstm.executeQuery();
//				while(resultSet.next()){				
//					lun.setLunwen_ID(resultSet.getString("lunwen_ID"));
//					lun.setLunwenmingcheng(resultSet.getString("lunwenmingcheng"));
//					lun.setKetimingcheng(resultSet.getString("ketimingcheng"));
//					lun.setStudent_ID(resultSet.getString("student_ID"));
//					lun.setTeacher_ID(resultSet.getString("teacher_ID"));
//					lun.setFujian(resultSet.getString("fujian"));
//					lun.setBeizhu(resultSet.getString("beizhu"));
//					lun.setTijiaoshijian(resultSet.getString("tijiaoshijian"));
//				}
//			}catch(Exception e){
//				e.printStackTrace();
//				return null;
//			}finally{
//				dao.closeCon(null,pstm,con);
//			}
//			return lun;
//		}
}
