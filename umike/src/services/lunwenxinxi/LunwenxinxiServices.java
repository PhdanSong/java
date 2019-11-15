package services.lunwenxinxi;

import java.util.List;

import dao.chengji.ChengjiDao;
import dao.lunwenxinxi.LunwenxinxiDao;
import entity.chengji;
import entity.ketilunwen;
import entity.lunwenxinxi;

public class LunwenxinxiServices {

	private LunwenxinxiDao lunDao=new LunwenxinxiDao();

	public int saveLunwenxinxiDao(lunwenxinxi lun){
		
		return lunDao.saveLunwenxinxiDao(lun);
	}

	public ketilunwen IDselectlunwenxinxi(String student_ID){
		return lunDao.IDselectlunwenxinxi(student_ID);
	}
	
	public lunwenxinxi selectlunwenxinxi(String student_ID){
		return lunDao.selectlunwenxinxi(student_ID);
	}
	
    public List<ketilunwen> teacIDselectlunwenxinxi(String techID){
		
		List<ketilunwen> list=lunDao.teacIDselectlunwenxinxi(techID);
		return list;
	}

	public int updatelunwenxinxi(lunwenxinxi lun,String student_ID,String lunwenID){
		
		return lunDao.updatelunwenxinxi(lun,student_ID,lunwenID);
	}
	
	public int deletelunwenxinxi(String student_ID){
		
		return lunDao.deletelunwenxinxi(student_ID);
	}
	
	public List<ketilunwen> teaselectlunwenxinxi(String teacher_ID){
		
		return lunDao.teaselectlunwenxinxi(teacher_ID);
	}
	
	public List<ketilunwen> teaselectlunwenxinxi2(String teacher_ID,String lunwenmingcheng,String xuan_ID,String student_ID){
		
		return lunDao.teaselectlunwenxinxi2(teacher_ID,lunwenmingcheng,xuan_ID,student_ID);
	}
	
	public lunwenxinxi StuSelectlunche(String lunwen_ID){
		 
		return lunDao.StuSelectlunche(lunwen_ID);
	}
}
