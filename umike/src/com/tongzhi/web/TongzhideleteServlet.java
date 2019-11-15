package com.tongzhi.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.tongzhi.TongzhiServices;
import entity.tongzhi;

/**
 * Servlet implementation class TongzhideleteServlet
 */
@WebServlet("/TongzhideleteServlet")
public class TongzhideleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TongzhideleteServlet() {
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
		TongzhiServices tongzhiServices = new TongzhiServices();
		String tongzhiID= request.getParameter("tongzhiID");
		System.out.println("&&&&&&&&&&&&&&&&&"+tongzhiID);
		if(tongzhiID!=null){
		int count = tongzhiServices.deleteTongzhi(teacherId,tongzhiID);
	    if(count>0){
		   System.out.println("删除成功");
			try {
			   out.print("<script>alert('删除成功')</script>");
			   out.print("<script>location.href='tongzhi_select.jsp'</script>");
			   out.close();
			 } catch (Exception e) {
			    e.printStackTrace();
			 } 
				//request.getRequestDispatcher("chakangeren_te.jsp").forward(request, response);
			}else{
				System.out.println("删除失败");
			
			}
		}
	    //批量删除
	    String deleteIds= request.getParameter("deleteIds");
	    System.out.println("------------"+deleteIds);
	    if(deleteIds.equals("undefined") || deleteIds==null || deleteIds.equals("")) {
	    	 out.print("<script>alert('请选择要删除的记录！')</script>");  
	    	 out.print("<script>location.href='tongzhi_select.jsp'</script>");
	    }else{  
	    
	    String[] list = deleteIds.split(",");
	    int sum = 0;
	    int len = list.length;  
	    for(int i=0; i<len; i++) {  	    	
	    	if(!list[i].equals("undefined")){
	    		if(!list[i].equals("checkall")){
	    		System.out.println("{{{{{{{{{{{{{{{"+list[i]);
	    	    int count = tongzhiServices.deleteTongzhi(teacherId,list[i]);
	    	    sum++;
	    	    if(count==0){
	    	    	System.out.println("+++++批量删除失败");	
	    	     }
	    		}
	    	 }
         } 
	    if(sum>0){
			   System.out.println("批量删除成功");
				try {
				   out.print("<script>alert('批量删除成功')</script>");
				   out.print("<script>location.href='tongzhi_select.jsp'</script>");
				   out.close();
				 } catch (Exception e) {
				    e.printStackTrace();
				 } 
					//request.getRequestDispatcher("chakangeren_te.jsp").forward(request, response);
				}else{
					System.out.println("批量删除失败");
					out.print("<script>alert('批量删除失败')</script>");
					out.print("<script>location.href='tongzhi_select.jsp'</script>");
				}
			
	    }
	    
	    
	    
	    
	    
	    
		out.flush();
		out.close();
	}

}
