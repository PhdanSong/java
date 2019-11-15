package services.tongzhi;

import java.util.List;

import dao.student.StudentDao;
import dao.tongzhi.TongzhiDao;
import entity.ketilunwen;
import entity.student;
import entity.stutag;
import entity.tongzhi;

public class TongzhiServices {

	
	private TongzhiDao tongDao=new TongzhiDao();
	
	public int saveTongzhiDao(tongzhi ton){
		return tongDao.saveTongzhiDao(ton);
	}
	

	public List<tongzhi> selectAll(String teacID){
		List<tongzhi> list=tongDao.selectAll(teacID);
		return list;
	}
	
	public tongzhi teacIDselectTongzhi(String teacherId,String bianhao){
		return tongDao.teacIDselectTongzhi(teacherId,bianhao);
	}
	
	public int updateTongzhi(tongzhi tong,String teacherId,String tongzhiID){
		return tongDao.updateTongzhi(tong,teacherId,tongzhiID);
	}
	
	public int deleteTongzhi(String teacherId,String tongzhiID){
		return tongDao.deleteTongzhi(teacherId,tongzhiID);
	}
	
   public List<ketilunwen> StuselectAll(String student_ID){
		
		return tongDao.StuselectAll(student_ID);
	}
	
	public tongzhi StuselectById(int tongzhi_ID){
		return tongDao.StuselectById(tongzhi_ID);
	}
	
	public stutag countTag(String stu_ID){
		return tongDao.countTag(stu_ID);
	}
	
	public int tongChange(String stu_ID){
		return tongDao.tongChange(stu_ID);
	}
	
	public int countTongzhiDao(String student_ID){
		return tongDao.countTongzhiDao(student_ID);
	}
	
	public List<tongzhi> tongzhifenye(String Student_ID,String start,String end){
		return tongDao.tongzhifenye(Student_ID,start,end);
	}
}
