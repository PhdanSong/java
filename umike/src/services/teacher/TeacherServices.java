package services.teacher;

import java.util.List;


import dao.student.StudentDao;
import dao.teacher.TeacherDao;
import entity.student;
import entity.teacher;

public class TeacherServices {
	
	private TeacherDao teaDao=new TeacherDao();

	public int saveTeacherDao(teacher tea){
		return teaDao.saveTeacherDao(tea);
	}

	public teacher selectAll(String teacher_ID){
		teacher tea= teaDao.selectAll(teacher_ID);
		return tea;
	}
	
	public int updateteacher(teacher tea,String techID){
		return teaDao.updateteacher(tea,techID);
		
	}
	
	private TeacherDao teacherDao=new TeacherDao();
	public boolean checkLogin(String username,String password){
		boolean aaaa=teacherDao.checkLogin(username,password);
		return aaaa;
	}
}
