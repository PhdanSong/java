package com.upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownLoadServlet
 */
@WebServlet("/downLoadServlet")
public class DownLoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownLoadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		         //filename灏辨槸key
		         String fileName = request.getParameter("filename");  //23239283-92489-闃垮嚒杈�avi
		         System.out.println("涓嬭浇鐨勬枃浠秄ilename鈥溾�鈥溾�鈥溾�鈥溾�鈥溾�鈥溾�鈥溾�鈥溾�鈥"+fileName);
		         fileName = new String(fileName.getBytes("iso8859-1"),"UTF-8");
		         String fujianID = request.getParameter("fujianID");  
		         //涓婁紶鐨勬枃浠堕兘鏄繚瀛樺湪/WEB-INF/upload鐩綍涓嬬殑瀛愮洰褰曞綋涓�
		         String fileSaveRootPath=this.getServletContext().getRealPath("/WEB-INF/upload");
		        //閫氳繃鏂囦欢鍚嶆壘鍑烘枃浠剁殑鎵�湪鐩綍
		         String path = findFileSavePathByFileName(fileName,fileSaveRootPath);
		         String biaoshipath = path+"\\"+fujianID;
		         request.getSession().setAttribute("biaoshipath", biaoshipath);
		         System.out.println("涓嬭浇鏂囦欢瀛樺彇璺緞锛�++++++"+biaoshipath);
		         //寰楀埌瑕佷笅杞界殑鏂囦欢
		         File file = new File(path + "\\" + fileName);
	            //濡傛灉鏂囦欢涓嶅瓨鍦�
		        if(!file.exists()){
		             request.setAttribute("message", "鎮ㄨ涓嬭浇鐨勮祫婧愬凡琚垹闄わ紒锛");
		             request.getRequestDispatcher("/message.jsp").forward(request, response);
		             return;
		         }
		         //澶勭悊鏂囦欢鍚�
		         String realname = fileName.substring(fileName.indexOf("_")+1);
		         //璁剧疆鍝嶅簲澶达紝鎺у埗娴忚鍣ㄤ笅杞借鏂囦欢
		         response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(realname, "UTF-8"));
		         //璇诲彇瑕佷笅杞界殑鏂囦欢锛屼繚瀛樺埌鏂囦欢杈撳叆娴�
		         FileInputStream in = new FileInputStream(path + "\\" + fileName);
		         //鍒涘缓杈撳嚭娴�
		         OutputStream out = response.getOutputStream();
		         //鍒涘缓缂撳啿鍖�
		         byte buffer[] = new byte[1024];
		         int len = 0;
		         //寰幆灏嗚緭鍏ユ祦涓殑鍐呭璇诲彇鍒扮紦鍐插尯褰撲腑
		         while((len=in.read(buffer))>0){
		            //杈撳嚭缂撳啿鍖虹殑鍐呭鍒版祻瑙堝櫒锛屽疄鐜版枃浠朵笅杞�
		             out.write(buffer, 0, len);
		         }
		         //鍏抽棴鏂囦欢杈撳叆娴�
		         in.close();
		         //鍏抽棴杈撳嚭娴�
		         out.close();
		     }
		     
		     /**
		56     * @Method: findFileSavePathByFileName
		57     * @Description: 閫氳繃鏂囦欢鍚嶅拰瀛樺偍涓婁紶鏂囦欢鏍圭洰褰曟壘鍑鸿涓嬭浇鐨勬枃浠剁殑鎵�湪璺緞
		58     * @Anthor:瀛ゅ偛鑻嶇嫾
		59     * @param filename 瑕佷笅杞界殑鏂囦欢鍚�
		60     * @param saveRootPath 涓婁紶鏂囦欢淇濆瓨鐨勬牴鐩綍锛屼篃灏辨槸/WEB-INF/upload鐩綍
		61     * @return 瑕佷笅杞界殑鏂囦欢鐨勫瓨鍌ㄧ洰褰�
		62     */ 
		     public String findFileSavePathByFileName(String filename,String saveRootPath){
		         int hashcode = filename.hashCode();
		         int dir1 = hashcode&0xf;  //0--15
		         int dir2 = (hashcode&0xf0)>>4;  //0-15
		         String dir = saveRootPath + "\\" + dir1 + "\\" + dir2;  //upload\2\3  upload\3\5
		         File file = new File(dir);
		         if(!file.exists()){
		            //鍒涘缓鐩綍
		             file.mkdirs();
		         }
		         return dir;

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
