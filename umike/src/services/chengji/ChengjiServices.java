package services.chengji;
import java.util.List;

import dao.chengji.ChengjiDao;
import entity.chengji;
import entity.ketilunwen;
import entity.ketixinxi;

public class ChengjiServices {

	private ChengjiDao che=new ChengjiDao();

	public int insertChengji(chengji ch){
		return che.savechengji(ch);
	}
	
	public ketilunwen selectChengji(String student_ID){
		return che.selectChengji(student_ID);
	}
	
   public List<ketilunwen> teacIDselectchengji(String techID){
		
		List<ketilunwen> list=che.teacIDselectchengji(techID);
		return list;
	}
   
   public ketilunwen selectChengjiById(String teacher_ID,String chengji_ID){
	   return che.selectChengjiById(teacher_ID,chengji_ID);
   }
   
   public int updateChengji(chengji cheng,String teacherId,String chengjiId){
	   return che.updateChengji(cheng,teacherId,chengjiId);
   }
	
}
