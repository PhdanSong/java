package services.ketixinxi;

import java.util.List;

import dao.ketixinxi.KetixinxiDao;
import entity.chengji;
import entity.ketilunwen;
import entity.ketixinxi;


public class KetixinxiServices {

	private KetixinxiDao keDao=new KetixinxiDao();
	
	public int insertKetixinxi(ketixinxi ke){
		
		return keDao.saveKetixinxi(ke);
	}
	public int deleteKetixinxi(String teacID,String ketibianhao){
	
		return keDao.deleteKetixinxi(teacID,ketibianhao);
		
	}
	
	public ketixinxi  SelectKetixinxi(String techID,String ketibianhao){
		return keDao.SelectKetixinxi(techID,ketibianhao);
	}
	
	public List<ketixinxi>  selectKetixinxiBymingcheng(String teacID,String mingcheng){
		return keDao.selectKetixinxiBymingcheng(teacID,mingcheng);
	}
	
	public ketixinxi  selectKetixinxiBybianhao(String teacID,String bianhao){
		return keDao.selectKetixinxiBybianhao(teacID,bianhao);
	}
	
	public ketixinxi  selectKetiBymingandbian(String teacID,String bianhao,String mingcheng){
		return keDao.selectKetixinxiBymingandbian(teacID,bianhao,mingcheng);
	}
	

	public int updateKetixinxi(ketixinxi ke,String techID,String ketibianhao){
	
		return keDao.updateKetixinxi(ke,techID,ketibianhao);
		
	}
	
	public ketixinxi teacIDselectKetixinxi(String techID,String ketibianhao){
		
		ketixinxi ke=keDao.teacIDselectKetixinxi(techID,ketibianhao);
		return ke;
	}
	
	public List<ketixinxi> getKetixinxi(String teacID){
		List<ketixinxi> ke=keDao.getKetixinxi(teacID);
		return ke;
	}
	

	public ketixinxi mingchengselectKetixinxi(String mingcheng,String ketibianhao,String teacID){
		
		return keDao.mingchengselectKetixinxi(mingcheng,ketibianhao,teacID);
		
	}
	
	
	public ketixinxi stuselectKetixinxi(String mingcheng,String ketibianhao){
		
		return keDao.stuselectKetixinxi(mingcheng,ketibianhao);
	}
	
	public List<ketilunwen> count(){
		return keDao.count();
	}
		
	public List<ketilunwen> count1(String ketibianhao){
		
		return keDao.count1(ketibianhao);
	}
	
	public List<ketilunwen> count2(String ketimingcheng){
		
		return keDao.count2(ketimingcheng);
	}
	
	public List<ketilunwen> count3(String teacID){
		
		return keDao.count3(teacID);
	}
	
	public List<ketilunwen> count4(String ketibianhao,String ketimingcheng,String teacID){
		
		return keDao.count4(ketibianhao,ketimingcheng,teacID);
	}
	
	public List<ketilunwen> count5(String ketibianhao,String ketimingcheng){
		
		return keDao.count5(ketibianhao,ketimingcheng);
	}
	public List<ketilunwen> count6(String ketibianhao,String teacID){
		
		return keDao.count6(ketibianhao,teacID);
	}
	public List<ketilunwen> count7(String ketimingcheng,String teacID){
		
		return keDao.count7(ketimingcheng,teacID);
	}
	public List<ketilunwen> count8(String ketibianhao){
		
		return keDao.count8(ketibianhao);
	}
}
