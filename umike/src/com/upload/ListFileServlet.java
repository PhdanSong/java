package com.upload;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListFileServlet
 */
@WebServlet("/ListFileServlet")
public class ListFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListFileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		         //鑾峰彇涓婁紶鏂囦欢鐨勭洰褰�
		         String uploadFilePath = this.getServletContext().getRealPath("/WEB-INF/upload");
		         //瀛樺偍瑕佷笅杞界殑鏂囦欢鍚�
		         Map<String,String> fileNameMap = new HashMap<String,String>();
		         //閫掑綊閬嶅巻filepath鐩綍涓嬬殑鎵�湁鏂囦欢鍜岀洰褰曪紝灏嗘枃浠剁殑鏂囦欢鍚嶅瓨鍌ㄥ埌map闆嗗悎涓�
		         listfile(new File(uploadFilePath),fileNameMap);//File鏃㈠彲浠ヤ唬琛ㄤ竴涓枃浠朵篃鍙互浠ｈ〃涓�釜鐩綍
		         //灏哅ap闆嗗悎鍙戦�鍒發istfile.jsp椤甸潰杩涜鏄剧ず
		         request.getSession().setAttribute("fileNameMap", fileNameMap);
		         System.out.println("鎵撳嵃锛氾細锛氾細锛氾細锛"+fileNameMap);
		         request.getRequestDispatcher("/listfile.jsp").forward(request, response);
		     }
		     
		     /**
		35     * @Method: listfile
		36     * @Description: 閫掑綊閬嶅巻鎸囧畾鐩綍涓嬬殑鎵�湁鏂囦欢
		37     * @Anthor:瀛ゅ偛鑻嶇嫾
		38     * @param file 鍗充唬琛ㄤ竴涓枃浠讹紝涔熶唬琛ㄤ竴涓枃浠剁洰褰�
		39     * @param map 瀛樺偍鏂囦欢鍚嶇殑Map闆嗗悎
		40     */ 
		     public void listfile(File file,Map<String,String> map){
		         //濡傛灉file浠ｈ〃鐨勪笉鏄竴涓枃浠讹紝鑰屾槸涓�釜鐩綍
		         if(!file.isFile()){
		             //鍒楀嚭璇ョ洰褰曚笅鐨勬墍鏈夋枃浠跺拰鐩綍
		             File files[] = file.listFiles();
		             //閬嶅巻files[]鏁扮粍
		             for(File f : files){
		                 //閫掑綊
		                listfile(f,map);
		             }
		         }else{
		             /**
		53              * 澶勭悊鏂囦欢鍚嶏紝涓婁紶鍚庣殑鏂囦欢鏄互uuid_鏂囦欢鍚嶇殑褰㈠紡鍘婚噸鏂板懡鍚嶇殑锛屽幓闄ゆ枃浠跺悕鐨剈uid_閮ㄥ垎
		54                 file.getName().indexOf("_")妫�储瀛楃涓蹭腑绗竴娆″嚭鐜�_"瀛楃鐨勪綅缃紝濡傛灉鏂囦欢鍚嶇被浼间簬锛�349249849-88343-8344_闃縚鍑杈�avi
		55                 閭ｄ箞file.getName().substring(file.getName().indexOf("_")+1)澶勭悊涔嬪悗灏卞彲浠ュ緱鍒伴樋_鍑杈�avi閮ㄥ垎
		56              */
		             String realName = file.getName().substring(file.getName().indexOf("_")+1);
		             //file.getName()寰楀埌鐨勬槸鏂囦欢鐨勫師濮嬪悕绉帮紝杩欎釜鍚嶇О鏄敮涓�殑锛屽洜姝ゅ彲浠ヤ綔涓簁ey锛宺ealName鏄鐞嗚繃鍚庣殑鍚嶇О锛屾湁鍙兘浼氶噸澶�
		             map.put(file.getName(), realName);
		         }

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
