package services.xuantixinxi;

import java.util.List;

import dao.student.StudentDao;
import dao.xuantixinxi.XuantixinxiDao;
import entity.ketilunwen;
import entity.ketixinxi;
import entity.student;
import entity.xuantixinxi;

public class XuantixinxiServices {
	
	private XuantixinxiDao xuanDao=new XuantixinxiDao();
	public int saveXuantixinxiDao(xuantixinxi xuan){
		
		return xuanDao.saveXuantixinxiDao(xuan);
	}

	public int updatexuantixinxi(xuantixinxi xuan,String student_ID){
		
		return xuanDao.updatexuantixinxi(xuan, student_ID);
	}
 public int StudeleteXuantixinxi(String student_ID){
		
		return xuanDao.StudeleteXuantixinxi(student_ID);
	}
	
	
public List<ketilunwen> teacIDselectxuantixinxi(String techID){
		
		List<ketilunwen> list=xuanDao.teacIDselectxuantixinxi(techID);
		return list;
	}
	
	public List<ketilunwen> stuIDselectxuantixinxi(){
		
		 return xuanDao.stuIDselectxuantixinxi();
	 }
	
     public ketilunwen stuIDselectxuantixinxi(String student_ID){
		
		return xuanDao.stuIDselectxuantixinxi(student_ID);
	}
	
	public List<ketilunwen> selectxuantixinxi1(String xuan_ID,String kechengmingcheng,String teacher_ID){
		
		return xuanDao.selectxuantixinxi1(xuan_ID,kechengmingcheng,teacher_ID);
	}
	
	public ketilunwen selectKetixinxi(String ketibianhao,String student_ID1){
		return xuanDao.selectKetixinxi(ketibianhao,student_ID1);
	}
	public ketixinxi selectKetixinxi2(String ketibianhao){
		return xuanDao.selectKetixinxi2(ketibianhao);
	}
	
	public xuantixinxi selectXuanti(String stuID){
		return xuanDao.selectXuanti(stuID);
	}

	public xuantixinxi StudentIsxuanlun(String student_ID){
		return xuanDao.StudentIsxuanlun(student_ID);
	}
}
