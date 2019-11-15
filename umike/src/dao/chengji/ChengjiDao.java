package dao.chengji;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import entity.chengji;
import entity.ketilunwen;
import entity.ketixinxi;
import entity.lunwenxinxi;
import entity.xuantixinxi;

public class ChengjiDao {

	public int savechengji(chengji ch){
		Connection con=null;
		PreparedStatement pstm=null;
		BaseDao dao = new BaseDao();
		try{
			
			con=dao.getConnection();
			if(con==null)
				System.out.println("连接失败");
			else
				System.out.println("连接成功");
			pstm=con.prepareStatement("insert into chengji(chengji_ID,student_ID,teacher_ID,ketimingcheng,luntimingcheng,fenshu,pingyu,beizhu) values(?,?,?,?,?,?,?,?,?)");
			pstm.setString(1, ch.getChengji_ID());
			pstm.setString(2, ch.getStudent_ID());
			pstm.setString(3, ch.getTeacher_ID());
			pstm.setString(4, ch.getKetimingcheng());
			pstm.setString(5, ch.getLunwenmingcheng());
			pstm.setString(6, ch.getFenshu());
			pstm.setString(7, ch.getPingyu());
			pstm.setString(8, ch.getTianjiashijan());
			pstm.setString(9, ch.getBeizhu());
			return pstm.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}finally{
			dao.closeCon(null,pstm,con);
		}
	}
	
	
	//学生
	public ketilunwen selectChengji(String student_ID){
		Connection con=null;
		PreparedStatement pstm=null;
		ResultSet resultSet=null;
		BaseDao dao = new BaseDao();
		chengji che=new chengji();
		ketixinxi ke=new ketixinxi();
		lunwenxinxi lun=new lunwenxinxi();
		ketilunwen keti=new ketilunwen();
		try{			
			con=dao.getConnection();
			if(con==null)
				System.out.println("连接失败");
			else
				System.out.println("连接成功");
			pstm=con.prepareStatement("select * from chengji che,ketixinxi ke,lunwenxinxi lun where che.ketimingcheng=ke.ketimingcheng and lun.ketimingcheng=che.ketimingcheng and che.student_ID=?");
			pstm.setString(1,student_ID);
			resultSet=pstm.executeQuery();
			while(resultSet.next()){				
				che.setChengji_ID(resultSet.getString("chengji_ID"));
				che.setStudent_ID(resultSet.getString("student_ID"));
				che.setTeacher_ID(resultSet.getString("teacher_ID"));
				che.setKetimingcheng(resultSet.getString("ketimingcheng"));
				che.setLunwenmingcheng(resultSet.getString("lunwenmingcheng"));
				che.setFenshu(resultSet.getString("fenshu"));
				che.setPingyu(resultSet.getString("pingyu"));
				che.setTianjiashijan(resultSet.getString("tianjiashijan"));
				che.setBeizhu(resultSet.getString("beizhu"));
				ke.setKetibianhao(resultSet.getString("ketibianhao"));
				ke.setTeacID(resultSet.getString("teacID"));
				ke.setKetimingcheng(resultSet.getString("ketimingcheng"));
				ke.setLeixing(resultSet.getString("leixing"));
				ke.setFujian(resultSet.getString("fujian"));
				ke.setKetishuliang(resultSet.getString("ketishuliang"));
				ke.setBeizhu(resultSet.getString("beizhu"));
				ke.setFabushijian(resultSet.getString("fabushijian"));
				lun.setLunwen_ID(resultSet.getString("lunwen_ID"));
				lun.setLunwenmingcheng(resultSet.getString("lunwenmingcheng"));
				lun.setKetimingcheng(resultSet.getString("ketimingcheng"));
				lun.setStudent_ID(resultSet.getString("student_ID"));
				lun.setTeacher_ID(resultSet.getString("teacher_ID"));
				lun.setFujian(resultSet.getString("fujian"));
				lun.setBeizhu(resultSet.getString("beizhu"));
				lun.setTijiaoshijian(resultSet.getString("tijiaoshijian"));
				keti.setChe(che);
				keti.setKe(ke);
				keti.setLun(lun);
			}
			System.out.println(keti.getChe().getChengji_ID());
			System.out.println(keti.getChe().getStudent_ID());
			System.out.println(keti.getChe().getTeacher_ID());
			System.out.println(keti.getChe().getKetimingcheng());
			System.out.println(keti.getChe().getLunwenmingcheng());
			System.out.println(keti.getChe().getFenshu());
			System.out.println(keti.getChe().getPingyu());
			System.out.println(keti.getChe().getTianjiashijan());
			System.out.println(keti.getKe().getKetibianhao());
			System.out.println(keti.getKe().getTeacID());
			System.out.println(keti.getKe().getKetimingcheng());
			System.out.println(keti.getKe().getLeixing());
			System.out.println(keti.getKe().getFujian());
			System.out.println(keti.getKe().getKetishuliang());
			System.out.println(keti.getKe().getBeizhu());
			System.out.println(keti.getKe().getFabushijian());
			System.out.println(keti.getLun().getLunwen_ID());
			System.out.println(keti.getLun().getLunwenmingcheng());
			System.out.println(keti.getLun().getKetimingcheng());
			System.out.println(keti.getLun().getStudent_ID());
			System.out.println(keti.getLun().getTeacher_ID());
			System.out.println(keti.getLun().getFujian());
			System.out.println(keti.getLun().getBeizhu());
			System.out.println(keti.getLun().getTijiaoshijian());
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			dao.closeCon(null,pstm,con);
		}
		return keti;
	}
	
	public ketilunwen selectChengjiById(String teacher_ID,String chengji_ID){
		Connection con=null;
		PreparedStatement pstm=null;
		ResultSet resultSet=null;
		BaseDao dao = new BaseDao();
		try{			
			con=dao.getConnection();
			if(con==null)
				System.out.println("连接失败");
			else
				System.out.println("连接成功");
			pstm=con.prepareStatement("select ke.ketibianhao,ke.ketimingcheng,ke.leixing,lun.lunwenmingcheng,lun.teacher_ID,lun.teacher_ID,cheng.* from ketixinxi ke,lunwenxinxi lun,chengji cheng where ke.ketimingcheng=lun.ketimingcheng and lun.ketimingcheng=cheng.ketimingcheng and cheng.teacher_ID=? and cheng.chengji_ID=?");
			pstm.setString(1,teacher_ID);
			pstm.setString(2,chengji_ID);
			resultSet=pstm.executeQuery();
			ketilunwen keti=new ketilunwen();
			while(resultSet.next()){	
				ketixinxi ke =new ketixinxi();
				ke.setKetibianhao(resultSet.getString("ketibianhao"));
				ke.setKetimingcheng(resultSet.getString("ketimingcheng"));
				ke.setLeixing(resultSet.getString("leixing"));
				keti.setKe(ke);
				lunwenxinxi lun=new lunwenxinxi();
				lun.setLunwenmingcheng(resultSet.getString("lunwenmingcheng"));
				lun.setTeacher_ID(resultSet.getString("teacher_ID"));
				lun.setStudent_ID(resultSet.getString("student_ID"));
				keti.setLun(lun);
				chengji che=new chengji();
				che.setChengji_ID(resultSet.getString("chengji_ID"));
				che.setStudent_ID(resultSet.getString("student_ID"));
				che.setTeacher_ID(resultSet.getString("teacher_ID"));
				che.setKetimingcheng(resultSet.getString("ketimingcheng"));
				che.setLunwenmingcheng(resultSet.getString("lunwenmingcheng"));
				che.setFenshu(resultSet.getString("fenshu"));
				che.setPingyu(resultSet.getString("pingyu"));
				che.setBeizhu(resultSet.getString("beizhu"));
				che.setTianjiashijan(resultSet.getString("tianjiashijan"));
				keti.setChe(che);
			}
			return keti;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			dao.closeCon(null,pstm,con);
		}
		
	}
	
	public List<ketilunwen>teacIDselectchengji(String techID){
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
			pstm=con.prepareStatement("select ke.ketibianhao,ke.ketimingcheng,ke.leixing,lun.lunwenmingcheng,lun.teacher_ID,lun.teacher_ID,cheng.* from ketixinxi ke,lunwenxinxi lun,chengji cheng where ke.ketimingcheng=lun.ketimingcheng and lun.ketimingcheng=cheng.ketimingcheng and cheng.teacher_ID=?");
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
				keti.setLun(lun);
				chengji cheng=new chengji();
				cheng.setChengji_ID(resultSet.getString("chengji_ID"));
				cheng.setFenshu(resultSet.getString("fenshu"));
				cheng.setPingyu(resultSet.getString("pingyu"));
				cheng.setTianjiashijan(resultSet.getString("tianjiashijan"));
				cheng.setBeizhu(resultSet.getString("beizhu"));
				keti.setChe(cheng);
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
	
	
	public int updateChengji(chengji cheng,String techID,String chengjiId){
		Connection con=null;
		PreparedStatement pstm=null;
		BaseDao dao = new BaseDao();
		try{
			
			con=dao.getConnection();
			if(con==null)
				System.out.println("连接失败");
			else
				System.out.println("连接成功");
			pstm=con.prepareStatement("update chengji set chengji_ID=?,student_ID=?,teacher_ID=?,ketimingcheng=?,lunwenmingcheng=?,fenshu=?,pingyu=?,beizhu=?,tianjiashijan=? where teacher_ID=? and chengji_ID=?");
			pstm.setString(1, cheng.getChengji_ID());
			pstm.setString(2, cheng.getStudent_ID());
			pstm.setString(3, cheng.getTeacher_ID());
			pstm.setString(4, cheng.getKetimingcheng());
			pstm.setString(5, cheng.getLunwenmingcheng());
			pstm.setString(6, cheng.getFenshu());
			pstm.setString(7, cheng.getPingyu());
			pstm.setString(8, cheng.getBeizhu());
			pstm.setString(9, cheng.getTianjiashijan());
			pstm.setString(10, techID);
			pstm.setString(11, chengjiId);
			return pstm.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}finally{
			dao.closeCon(null,pstm,con);
		}
	}

		
	//老师根据工号查看学生的成绩
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
				    pstm=con.prepareStatement("select * from lunwenxinxi lun,ketixinxi ke,chengji che where lun.teacher_ID=ke.teacID and che.teacher_ID=lun.teacher_ID and lun.teacher_ID=?");
				    pstm.setString(1, teacher_ID);
				    resultSet=pstm.executeQuery();
					while(resultSet.next()){
						ketilunwen keti=new ketilunwen();
						lunwenxinxi lun=new lunwenxinxi();
						ketixinxi ke = new ketixinxi();
						chengji che=new chengji();
						lun.setLunwen_ID(resultSet.getString("lun.lunwen_ID"));
						lun.setLunwenmingcheng(resultSet.getString("lun.lunwenmingcheng"));
						lun.setKetimingcheng(resultSet.getString("lun.ketimingcheng"));
						lun.setStudent_ID(resultSet.getString("lun.student_ID"));
						lun.setTeacher_ID(resultSet.getString("lun.teacher_ID"));
						lun.setFujian(resultSet.getString("lun.fujian"));
						lun.setBeizhu(resultSet.getString("lun.beizhu"));
						lun.setTijiaoshijian(resultSet.getString("lun.tijiaoshijian"));
						ke.setKetibianhao(resultSet.getString("ke.ketibianhao"));
						ke.setTeacID(resultSet.getString("ke.teacID"));
						ke.setKetimingcheng(resultSet.getString("ke.ketimingcheng"));
						ke.setLeixing(resultSet.getString("ke.leixing"));
						ke.setFujian(resultSet.getString("ke.fujian"));
						ke.setKetishuliang(resultSet.getString("ke.ketishuliang"));
						ke.setBeizhu(resultSet.getString("ke.beizhu"));
						ke.setFabushijian(resultSet.getString("ke.fabushijian"));
						che.setChengji_ID(resultSet.getString("chengji_ID"));
						che.setStudent_ID(resultSet.getString("student_ID"));
						che.setTeacher_ID(resultSet.getString("teacher_ID"));
						che.setKetimingcheng(resultSet.getString("ketimingcheng"));
						che.setLunwenmingcheng(resultSet.getString("lunwenmingcheng"));
						che.setFenshu(resultSet.getString("fenshu"));
						che.setPingyu(resultSet.getString("pingyu"));
						che.setTianjiashijan(resultSet.getString("tianjiashijan"));
						che.setBeizhu(resultSet.getString("beizhu"));
						keti.setLun(lun);
						keti.setKe(ke);
						keti.setChe(che);	
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
						System.out.println(keti.getChe().getChengji_ID());
						System.out.println(keti.getChe().getStudent_ID());
						System.out.println(keti.getChe().getTeacher_ID());
						System.out.println(keti.getChe().getKetimingcheng());
						System.out.println(keti.getChe().getLunwenmingcheng());
						System.out.println(keti.getChe().getFenshu());
						System.out.println(keti.getChe().getPingyu());
						System.out.println(keti.getChe().getTianjiashijan());
					}
				}catch(Exception e){
					e.printStackTrace();
					return null;
				}finally{
					dao.closeCon(null,pstm,con);
				}
				return list;
			}
		
		//老师修改成绩
		public int UpdateTeachengji(chengji ch,String teacher_ID){
			Connection con=null;
			PreparedStatement pstm=null;
			BaseDao dao = new BaseDao();
			try{
				
				con=dao.getConnection();
				if(con==null)
					System.out.println("连接失败");
				else
					System.out.println("连接成功");
				pstm=con.prepareStatement("update chengji set chengji_ID=?,student_ID=?,teacher_ID=?,ketimingcheng=?,lunwenmingcheng=?,fenshu=?,pingyu=?,tianjiashijan=?,beizhu=?where teacher_ID=?");
				pstm.setString(1, ch.getChengji_ID());
				pstm.setString(2, ch.getStudent_ID());
				pstm.setString(3, ch.getTeacher_ID());
				pstm.setString(4, ch.getKetimingcheng());
				pstm.setString(5, ch.getLunwenmingcheng());
				pstm.setString(6, ch.getFenshu());
				pstm.setString(7, ch.getPingyu());
				pstm.setString(8, ch.getTianjiashijan());
				pstm.setString(9, ch.getBeizhu());
				pstm.setString(10, teacher_ID);
				return pstm.executeUpdate();
			}catch(Exception e){
				e.printStackTrace();
				return 0;
			}finally{
				dao.closeCon(null,pstm,con);
			}
		}
	
}
