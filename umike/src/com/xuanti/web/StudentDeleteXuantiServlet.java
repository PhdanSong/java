package com.xuanti.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.xuantixinxi.XuantixinxiServices;
import entity.xuantixinxi;

/**
 * Servlet implementation class StudentUpdateXuantiServlet
 */
@WebServlet("/StudentDeleteXuantiServlet")
public class StudentDeleteXuantiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentDeleteXuantiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String student_ID=(String)request.getSession().getAttribute("id");
		/*String name1=request.getParameter("name1");
		String name2=request.getParameter("name2");
		String name3=request.getParameter("name3");
		String name4=request.getParameter("name4");
		String name5=request.getParameter("name5");
		String name6=request.getParameter("name6");
		xuantixinxi xuan =new xuantixinxi();
		//xuan.setXuanti_ID(name);
		xuan.setKetimingcheng(name1);
		xuan.setTeacher_ID(name3);
		xuan.setTeacher_ID(student_ID1);
		xuan.setXuantishijian(name5);
		xuan.setBeizhu(name6);
		XuantixinxiServices xuanServices=new XuantixinxiServices();
		xuanServices.updatexuantixinxi(xuan,student_ID1);
		String bianhao=request.getParameter("name");
		System.out.println();
		String ketibianhao=request.getParameter("action");*/
		System.out.println("最终数据是"+student_ID);
	}

}
