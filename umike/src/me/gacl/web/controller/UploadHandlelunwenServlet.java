package me.gacl.web.controller;
 
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import services.lunwenxinxi.LunwenxinxiServices;
import services.xuantixinxi.XuantixinxiServices;
import entity.lunwenxinxi;
import entity.xuantixinxi;
@WebServlet("/UploadHandlelunwenServlet") 
public class UploadHandlelunwenServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String lunwen_addst_mingcheng,lunwen_addst_neirong;
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
    		response.setCharacterEncoding("UTF-8");
    		request.setCharacterEncoding("UTF-8");
    		PrintWriter out1 = response.getWriter();
                //寰楀埌涓婁紶鏂囦欢鐨勪繚瀛樼洰褰曪紝灏嗕笂浼犵殑鏂囦欢瀛樻斁浜嶹EB-INF鐩綍涓嬶紝涓嶅厑璁稿鐣岀洿鎺ヨ闂紝淇濊瘉涓婁紶鏂囦欢鐨勫畨鍏�
                String savePath = this.getServletContext().getRealPath("/WEB-INF/upload");
                System.out.println("savePath"+savePath);
                //涓婁紶鏃剁敓鎴愮殑涓存椂鏂囦欢淇濆瓨鐩綍
                String tempPath = this.getServletContext().getRealPath("/WEB-INF/temp");
                System.out.println("tempPath"+tempPath);
                 File tmpFile = new File(tempPath);
                if (!tmpFile.exists()) {
                  //鍒涘缓涓存椂鐩綍
                     tmpFile.mkdir();
                }                 
                //娑堟伅鎻愮ず
                String message = "";
                String saveFilename="";
               try{
                   //浣跨敤Apache鏂囦欢涓婁紶缁勪欢澶勭悊鏂囦欢涓婁紶姝ラ锛�
                    //1銆佸垱寤轰竴涓狣iskFileItemFactory宸ュ巶
                     DiskFileItemFactory factory = new DiskFileItemFactory();
                     //璁剧疆宸ュ巶鐨勭紦鍐插尯鐨勫ぇ灏忥紝褰撲笂浼犵殑鏂囦欢澶у皬瓒呰繃缂撳啿鍖虹殑澶у皬鏃讹紝灏变細鐢熸垚涓�釜涓存椂鏂囦欢瀛樻斁鍒版寚瀹氱殑涓存椂鐩綍褰撲腑銆�
                      factory.setSizeThreshold(1024*100);//璁剧疆缂撳啿鍖虹殑澶у皬涓�00KB锛屽鏋滀笉鎸囧畾锛岄偅涔堢紦鍐插尯鐨勫ぇ灏忛粯璁ゆ槸10KB
                      //璁剧疆涓婁紶鏃剁敓鎴愮殑涓存椂鏂囦欢鐨勪繚瀛樼洰褰�
                      factory.setRepository(tmpFile);
                      //2銆佸垱寤轰竴涓枃浠朵笂浼犺В鏋愬櫒
                      ServletFileUpload upload = new ServletFileUpload(factory);
                      //鐩戝惉鏂囦欢涓婁紶杩涘害
                      upload.setProgressListener(new ProgressListener(){
                          public void update(long pBytesRead, long pContentLength, int arg2) {
                              System.out.println("鏂囦欢澶у皬涓猴細" + pContentLength + ",褰撳墠宸插鐞嗭細" + pBytesRead);
                          }
                      });
                       //瑙ｅ喅涓婁紶鏂囦欢鍚嶇殑涓枃涔辩爜
                      upload.setHeaderEncoding("UTF-8"); 
                      //3銆佸垽鏂彁浜や笂鏉ョ殑鏁版嵁鏄惁鏄笂浼犺〃鍗曠殑鏁版嵁
                      if(!ServletFileUpload.isMultipartContent(request)){
                          //鎸夌収浼犵粺鏂瑰紡鑾峰彇鏁版嵁
                          return;
                      }
                      
                      //璁剧疆涓婁紶鍗曚釜鏂囦欢鐨勫ぇ灏忕殑鏈�ぇ鍊硷紝鐩墠鏄缃负1024*1024瀛楄妭锛屼篃灏辨槸1MB
                      upload.setFileSizeMax(1024*1024);
                      //璁剧疆涓婁紶鏂囦欢鎬婚噺鐨勬渶澶у�锛屾渶澶у�=鍚屾椂涓婁紶鐨勫涓枃浠剁殑澶у皬鐨勬渶澶у�鐨勫拰锛岀洰鍓嶈缃负10MB
                      upload.setSizeMax(1024*1024*10);
                      //4銆佷娇鐢⊿ervletFileUpload瑙ｆ瀽鍣ㄨВ鏋愪笂浼犳暟鎹紝瑙ｆ瀽缁撴灉杩斿洖鐨勬槸涓�釜List<FileItem>闆嗗悎锛屾瘡涓�釜FileItem瀵瑰簲涓�釜Form琛ㄥ崟鐨勮緭鍏ラ」
                      List<FileItem> list = upload.parseRequest(request);
                      for(FileItem item : list){
                          //濡傛灉fileitem涓皝瑁呯殑鏄櫘閫氳緭鍏ラ」鐨勬暟鎹�
                          if(item.isFormField()){
                              String name = item.getFieldName();
                              //瑙ｅ喅鏅�杈撳叆椤圭殑鏁版嵁鐨勪腑鏂囦贡鐮侀棶棰�
                              String value = item.getString("UTF-8");
                              if(name.equals("lunwen_addst_mingcheng")){
                            	  lunwen_addst_mingcheng=value;
                              }
                              if(name.equals("lunwen_addst_neirong")){
                            	 lunwen_addst_neirong=value;
                              }
                              //value = new String(value.getBytes("iso8859-1"),"UTF-8");
                              System.out.println(name + "=" + value);
                          }else{//濡傛灉fileitem涓皝瑁呯殑鏄笂浼犳枃浠�
                              //寰楀埌涓婁紶鐨勬枃浠跺悕绉帮紝
                              String filename = item.getName();
                              System.out.println(filename);
                              if(filename==null || filename.trim().equals("")){
                                  continue;
                              }
                              //娉ㄦ剰锛氫笉鍚岀殑娴忚鍣ㄦ彁浜ょ殑鏂囦欢鍚嶆槸涓嶄竴鏍风殑锛屾湁浜涙祻瑙堝櫒鎻愪氦涓婃潵鐨勬枃浠跺悕鏄甫鏈夎矾寰勭殑锛屽锛� c:\a\b\1.txt锛岃�鏈変簺鍙槸鍗曠函鐨勬枃浠跺悕锛屽锛�.txt
                              //澶勭悊鑾峰彇鍒扮殑涓婁紶鏂囦欢鐨勬枃浠跺悕鐨勮矾寰勯儴鍒嗭紝鍙繚鐣欐枃浠跺悕閮ㄥ垎
                              filename = filename.substring(filename.lastIndexOf("\\")+1);
                              //寰楀埌涓婁紶鏂囦欢鐨勬墿灞曞悕
                              String fileExtName = filename.substring(filename.lastIndexOf(".")+1);
                              //濡傛灉闇�闄愬埗涓婁紶鐨勬枃浠剁被鍨嬶紝閭ｄ箞鍙互閫氳繃鏂囦欢鐨勬墿灞曞悕鏉ュ垽鏂笂浼犵殑鏂囦欢绫诲瀷鏄惁鍚堟硶
                             System.out.println("涓婁紶鐨勬枃浠剁殑鎵╁睍鍚嶆槸锛�"+fileExtName);
                             //鑾峰彇item涓殑涓婁紶鏂囦欢鐨勮緭鍏ユ祦
                             InputStream in = item.getInputStream();
                             //寰楀埌鏂囦欢淇濆瓨鐨勫悕绉�
                             saveFilename = makeFileName(filename);                             //寰楀埌鏂囦欢鐨勪繚瀛樼洰褰�
                             String realSavePath = makePath(saveFilename, savePath);
                             //鍒涘缓涓�釜鏂囦欢杈撳嚭娴�
                             FileOutputStream out = new FileOutputStream(realSavePath + "\\" + saveFilename);
                             //鍒涘缓涓�釜缂撳啿鍖�
                             byte buffer[] = new byte[1024];
                             //鍒ゆ柇杈撳叆娴佷腑鐨勬暟鎹槸鍚﹀凡缁忚瀹岀殑鏍囪瘑
                             int len = 0;
                             //寰幆灏嗚緭鍏ユ祦璇诲叆鍒扮紦鍐插尯褰撲腑锛�len=in.read(buffer))>0灏辫〃绀篿n閲岄潰杩樻湁鏁版嵁
                             while((len=in.read(buffer))>0){
                                 //浣跨敤FileOutputStream杈撳嚭娴佸皢缂撳啿鍖虹殑鏁版嵁鍐欏叆鍒版寚瀹氱殑鐩綍(savePath + "\\" + filename)褰撲腑
                                 out.write(buffer, 0, len);
                             }
                             //鍏抽棴杈撳叆娴�
                             in.close();
                             //鍏抽棴杈撳嚭娴�
                             out.close();
                             //鍒犻櫎澶勭悊鏂囦欢涓婁紶鏃剁敓鎴愮殑涓存椂鏂囦欢
                             //item.delete();
                             message = "鏂囦欢涓婁紶鎴愬姛锛�绉掑悗灏嗚烦杞埌璁烘枃娣诲姞椤甸潰...";
                         }
                    }
                }catch (FileUploadBase.FileSizeLimitExceededException e) {
                     e.printStackTrace();
                     request.setAttribute("message", "鍗曚釜鏂囦欢瓒呭嚭鏈�ぇ鍊硷紒锛侊紒");
                     request.getRequestDispatcher("/message.jsp").forward(request, response);
                     return;
                 }catch (FileUploadBase.SizeLimitExceededException e) {
                     e.printStackTrace();
                     request.setAttribute("message", "涓婁紶鏂囦欢鐨勬�鐨勫ぇ灏忚秴鍑洪檺鍒剁殑鏈�ぇ鍊硷紒锛侊紒");
                     request.getRequestDispatcher("/message.jsp").forward(request, response);
                     return;
                 }catch (Exception e) {
                    message= "鏂囦欢涓婁紶澶辫触锛�";
                     e.printStackTrace();
                 }
       		int count=0;
       		String student_ID=(String)request.getSession().getAttribute("id");      		
       		System.out.println("======"+lunwen_addst_mingcheng+"======="+lunwen_addst_neirong+"======"+student_ID);
       		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       		if((lunwen_addst_mingcheng==null||"".equals(lunwen_addst_mingcheng))){
       			out1.print("<script>alert('璁烘枃鍚嶇О涓嶈兘涓虹┖锛�)</script>");
       			out1.print("<script>location.href='lunwen_addst.jsp'</script>");
       		}
       		else{
       			LunwenxinxiServices lunwenxinxiServices = new LunwenxinxiServices();	
       			//String result=lunwenxinxiServices.IDselectlunwenxinxi(student_ID).getLun().getLunwen_ID();
           		//System.out.println("缁撴灉鏄"+result);
       			//if((result==null)||"".equals(result)){
	       		XuantixinxiServices xuantixinxiServices = new XuantixinxiServices();		
	       		xuantixinxi xuan=new xuantixinxi();
	       		xuan=xuantixinxiServices.selectXuanti(student_ID);
	       		lunwenxinxi lun=new lunwenxinxi();
		       		if(xuan.getKetimingcheng() != null){
		       			lun.setLunwen_ID(student_ID);
		       			lun.setLunwenmingcheng(lunwen_addst_mingcheng);
		       			lun.setKetimingcheng(xuan.getKetimingcheng());
		       			lun.setStudent_ID(student_ID);
		       			lun.setTeacher_ID(xuan.getTeacher_ID());
		       			lun.setFujian(lunwen_addst_neirong);
		       			lun.setTijiaoshijian(format.format(new Date()));
		       			lun.setLunbaocunming(saveFilename);
		       			LunwenxinxiServices lunServices=new LunwenxinxiServices();
		       			count=lunServices.saveLunwenxinxiDao(lun);
		       			if(count==0){
		       				out1.print("<script>alert('论文提交失败！')</script>");
		       				out1.print("<script>location.href='lunwen_selectst.jsp'</script>");
		       			}else{
		       				out1.print("<script>alert('论文提交成功！')</script>");				
		       				out1.print("<script>location.href='lunwen_selectst.jsp'</script>");
		       			}
		       		}else{
		       			out1.print("<script>alert('还未选择课题，请先选择课题！')</script>");
		       			out1.print("<script>location.href='xuanti_st.jsp'</script>");
		       		}
	        }
       	}
    
     
     private String makeFileName(String filename){  //2.jpg
         //涓洪槻姝㈡枃浠惰鐩栫殑鐜拌薄鍙戠敓锛岃涓轰笂浼犳枃浠朵骇鐢熶竴涓敮涓�殑鏂囦欢鍚�
         return UUID.randomUUID().toString() + "_" + filename;
     }
     
    private String makePath(String filename,String savePath){
         //寰楀埌鏂囦欢鍚嶇殑hashCode鐨勫�锛屽緱鍒扮殑灏辨槸filename杩欎釜瀛楃涓插璞″湪鍐呭瓨涓殑鍦板潃
         int hashcode = filename.hashCode();
         int dir1 = hashcode&0xf;  //0--15
        int dir2 = (hashcode&0xf0)>>4;  //0-15
         //鏋勯�鏂扮殑淇濆瓨鐩綍
         String dir = savePath + "\\" + dir1 + "\\" + dir2;  //upload\2\3  upload\3\5
         System.out.println("dir"+savePath);
        //File鏃㈠彲浠ヤ唬琛ㄦ枃浠朵篃鍙互浠ｈ〃鐩綍
         File file = new File(dir);
         //濡傛灉鐩綍涓嶅瓨鍦�
         if(!file.exists()){
             //鍒涘缓鐩綍
            file.mkdirs();
         }
         return dir;
    }
 
     public void doPost(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
 
         doGet(request, response);
    }
 }