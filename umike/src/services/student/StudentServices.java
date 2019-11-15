package services.student;

import java.util.List;


import dao.chengji.ChengjiDao;
import dao.student.StudentDao;
import entity.chengji;
import entity.student;

public class StudentServices {

	private StudentDao stuDao=new StudentDao();

	public int saveStudentDao(student stu){
		return stuDao.saveStudentDao(stu);
	}

	public List<student> selectAll(){
		List<student> list=stuDao.selectAll();
		return list;
	}
	
	
   public student selectAll(String xuehao){
		
		student stu=stuDao.selectAll(xuehao);
		return stu;
	}
	
	public int stuUpdate(String xuehao,student stu){
		
		return stuDao.stuUpdate(xuehao,stu);
	}
	
	private StudentDao studentDao=new StudentDao();
	public boolean checkLogin(String username,String password){
		boolean aaaa=studentDao.checkLogin(username,password);
		return aaaa;
	}

}
