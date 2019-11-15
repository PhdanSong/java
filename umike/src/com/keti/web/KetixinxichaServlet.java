package com.keti.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.ketixinxi;
import services.ketixinxi.KetixinxiServices;

/**
 * Servlet implementation class KetixinxichaServlet
 */
@WebServlet("/KetixinxichaServlet")
public class KetixinxichaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KetixinxichaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String teacherId = (String) request.getSession().getAttribute("id");
		KetixinxiServices ketixinxiServices = new KetixinxiServices();
		String ketibianhao= request.getParameter("ketibianhao");
		String ketimingcheng= request.getParameter("ketimingcheng");
		request.getSession().setAttribute("ketimingcheng",ketimingcheng);
		request.getSession().setAttribute("ketibianhao",ketibianhao);
		System.out.println("&&&&&&&&&&&&&&&&&"+ketibianhao+ketimingcheng);
		
		
		//获取上传文件的目录
        String uploadFilePath = this.getServletContext().getRealPath("/WEB-INF/upload");
        //存储要下载的文件名
        Map<String,String> fileNameMap = new HashMap<String,String>();
        //递归遍历filepath目录下的所有文件和目录，将文件的文件名存储到map集合中
        listfile(new File(uploadFilePath),fileNameMap);//File既可以代表一个文件也可以代表一个目录
        //将Map集合发送到listfile.jsp页面进行显示
        request.setAttribute("fileNameMap", fileNameMap);
       // request.getRequestDispatcher("/listfile.jsp").forward(request, response);
		
		
		
		
		
		
		if(ketibianhao==null||ketibianhao.equals("")){
			//课题名称和编号都没有
			if(ketimingcheng==null||ketimingcheng.equals("")){
			request.getRequestDispatcher("keti_select.jsp").forward(request, response);	
			}else{
			//没有课题编号有课题名称
			List<ketixinxi> ketilist=ketixinxiServices.selectKetixinxiBymingcheng(teacherId,ketimingcheng);
			request.getSession().setAttribute("ketilist",ketilist);
			request.getRequestDispatcher("keti_select.jsp").forward(request, response);	
			}
		}else{
			//课题编号有课题名称没有
			if(ketimingcheng==null||ketimingcheng.equals("")){
				ketixinxi ketione = ketixinxiServices.selectKetixinxiBybianhao(teacherId, ketibianhao);
				request.getSession().setAttribute("ketione",ketione);
				request.getRequestDispatcher("keti_select.jsp").forward(request, response);	
			}else{
				//课题编号和课题名称都有
			    ketixinxi ketitwo = ketixinxiServices.selectKetiBymingandbian(teacherId,ketibianhao,ketimingcheng);
				request.getSession().setAttribute("ketitwo",ketitwo);
				request.getRequestDispatcher("keti_select.jsp").forward(request, response);	
				}
		}
		/*int count=ketixinxiServices.deleteKetixinxi(teacherId,bianhao);
        if(count>0){
 		   System.out.println("删除成功");
 			try {
 			   out.print("<script>alert('删除成功')</script>");
 			   out.print("<script>location.href='keti_select.jsp'</script>");
 			   out.close();
 			 } catch (Exception e) {
 			    e.printStackTrace();
 			 } 
 				//request.getRequestDispatcher("chakangeren_te.jsp").forward(request, response);
 			}else{
 				System.out.println("删除失败");
 			
 			}
*/	
		out.flush();
		out.close();
		
		
	}
	
	
	
	
    /**
	35     * @Method: listfile
	36     * @Description: 递归遍历指定目录下的所有文件
	37     * @Anthor:孤傲苍狼
	38     * @param file 即代表一个文件，也代表一个文件目录
	39     * @param map 存储文件名的Map集合
	40     */ 
	     public void listfile(File file,Map<String,String> map){
	         //如果file代表的不是一个文件，而是一个目录
	         if(!file.isFile()){
	             //列出该目录下的所有文件和目录
	             File files[] = file.listFiles();
	             //遍历files[]数组
	             for(File f : files){
	                 //递归
	                listfile(f,map);
	             }
	         }else{
	             /**
	53              * 处理文件名，上传后的文件是以uuid_文件名的形式去重新命名的，去除文件名的uuid_部分
	54                 file.getName().indexOf("_")检索字符串中第一次出现"_"字符的位置，如果文件名类似于：9349249849-88343-8344_阿_凡_达.avi
	55                 那么file.getName().substring(file.getName().indexOf("_")+1)处理之后就可以得到阿_凡_达.avi部分
	56              */
	             String realName = file.getName().substring(file.getName().indexOf("_")+1);
	             //file.getName()得到的是文件的原始名称，这个名称是唯一的，因此可以作为key，realName是处理过后的名称，有可能会重复
	             map.put(file.getName(), realName);
	         }

}

}
