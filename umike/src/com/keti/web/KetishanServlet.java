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
 * Servlet implementation class KetishanServlet
 */
@WebServlet("/KetishanServlet")
public class KetishanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KetishanServlet() {
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
		String bianhao= (String)request.getSession().getAttribute("bianhao");
		System.out.println("&&&&&&&&&&&&&&&&&"+bianhao);
		
		int count=ketixinxiServices.deleteKetixinxi(teacherId,bianhao);
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
	
		out.flush();
		out.close();
	}

}
