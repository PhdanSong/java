package com.xuanti.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.ketixinxi;
import entity.xuantixinxi;
import services.ketixinxi.KetixinxiServices;
import services.xuantixinxi.XuantixinxiServices;

/**
 * Servlet implementation class StudentxuantinewServlet
 */
@WebServlet("/StudentxuantinewServlet")
public class StudentxuantinewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentxuantinewServlet() {
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
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String student_ID1=(String)request.getSession().getAttribute("id");
		String ketibianhao=request.getParameter("ketibianhao");
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		XuantixinxiServices xuantixinxiServices = new XuantixinxiServices();
		ketixinxi ke = xuantixinxiServices.selectKetixinxi2(ketibianhao);
		xuantixinxi xuanti = xuantixinxiServices.selectXuanti(student_ID1);
		System.out.println("当前"+student_ID1);
		int count=0;
		if(xuanti.getBeizhu()==null||xuanti.getBeizhu().equals("")){
			xuantixinxi xuan =new xuantixinxi();
			xuan.setTeacher_ID(ke.getTeacID());
			xuan.setKetimingcheng(ke.getKetimingcheng());
			xuan.setStudent_ID(student_ID1);
			xuan.setXuantishijian(format.format(new Date()));
			xuan.setBeizhu("wu");
			count = xuantixinxiServices.saveXuantixinxiDao(xuan);
			System.out.println("count"+count);
		}
		
		 if(count>0){
			   System.out.println("添加成功");
				try {
				   out.print("<script>alert('添加成功')</script>");
				   out.print("<script>location.href='xuanti_selectst.jsp'</script>");
				   out.close();
				 } catch (Exception e) {
				    e.printStackTrace();
				 } 
					//request.getRequestDispatcher("chakangeren_te.jsp").forward(request, response);
				}else{
					out.print("<script>alert('该同学课题已选，不需再选')</script>");
					out.print("<script>location.href='xuanti_selectst.jsp'</script>");
					System.out.println("该同学课题已选");
				
				}
			
			out.flush();
			out.close();

		
	}

}
