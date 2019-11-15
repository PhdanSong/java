package com.keti.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.ketixinxi.KetixinxiServices;
import entity.ketixinxi;

/**
 * Servlet implementation class KetideleteServlet
 */
@WebServlet("/KetideleteServlet")
public class KetideleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KetideleteServlet() {
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
		String bianhao= request.getParameter("bianhao");
		System.out.println("PPPPPPPPPPPPPPPPPP"+bianhao);
		ketixinxi aa=ketixinxiServices.SelectKetixinxi(teacherId,bianhao);
		System.out.println("AAAAAAAAAAAAAAAAAAA"+aa.getBeizhu());
		int count=0;
		if(aa.getBeizhu()==null||aa.getBeizhu().equals("")){
		  count = ketixinxiServices.deleteKetixinxi(teacherId,bianhao);
		  System.out.println("走进去了");
		}
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
				out.print("<script>alert('当前课题已被学生选取，不能删除')</script>");
			    out.print("<script>location.href='keti_select.jsp'</script>");
				System.out.println("删除失败");
			
			}
	    
	    //批量删除
	    /*String deleteIds= request.getParameter("deleteIds");
	    System.out.println("------------"+deleteIds);
	    if(deleteIds.equals("undefined") || deleteIds==null || deleteIds.equals("")) {
	    	 out.print("<script>alert('请选择要删除的记录！')</script>");  
	    	 out.print("<script>location.href='keti_select.jsp'</script>");
	    }else{  
	    
	    String[] list = deleteIds.split(",");
	    int sum = 0;
	    int len = list.length;  
	    for(int i=0; i<len; i++) {  	    	
	    	if(!list[i].equals("undefined")){
	    		if(!list[i].equals("checkall")){
	    		System.out.println("{{{{{{{{{{{{{{{"+list[i]);
	    	    int count2 = ketixinxiServices.deleteKetixinxi(teacherId,list[i]);
	    	    sum++;
	    	    if(count2==0){
	    	    	System.out.println("+++++批量删除失败");	
	    	     }
	    		}
	    	 }
         } 
	    if(sum>0){
			   System.out.println("批量删除成功");
				try {
				   out.print("<script>alert('批量删除成功')</script>");
				   out.print("<script>location.href='keti_select.jsp'</script>");
				   out.close();
				 } catch (Exception e) {
				    e.printStackTrace();
				 } 
					//request.getRequestDispatcher("chakangeren_te.jsp").forward(request, response);
				}else{
					System.out.println("批量删除失败");
					out.print("<script>alert('批量删除失败')</script>");
					out.print("<script>location.href='keti_select.jsp'</script>");
				}
			
	    }*/
	    

		out.flush();
		out.close();
	}

}
