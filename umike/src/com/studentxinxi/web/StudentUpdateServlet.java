package com.studentxinxi.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.student.StudentServices;
import entity.student;

/**
 * Servlet implementation class StudentUpdateServlet
 */
@WebServlet("/StudentUpdateServlet")
public class StudentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentUpdateServlet() {
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
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String student_ID1=(String)request.getSession().getAttribute("id");
		String tab_st_student_ID=request.getParameter("tab_st_student_ID");
		String tab_st_xingming=request.getParameter("tab_st_xingming");
		String tab_st_xingbie=request.getParameter("tab_st_xingbie");
		String tab_st_dianhua=request.getParameter("tab_st_dianhua");
		String tab_st_jiguan=request.getParameter("tab_st_jiguan");
		String tab_st_xueyuan=request.getParameter("tab_st_xueyuan");
		String tab_st_zhuanye=request.getParameter("tab_st_zhuanye");
		String tab_st_banji=request.getParameter("tab_st_banji");
		String tab_st_beizhu=request.getParameter("tab_st_beizhu");
		student stu1=new student();
		stu1.setXuehao(tab_st_student_ID);
		stu1.setXingming(tab_st_xingming);
		stu1.setXingbie(tab_st_xingbie);
		stu1.setDianhua(tab_st_dianhua);
		stu1.setJiguan(tab_st_jiguan);
		stu1.setXueyuan(tab_st_xueyuan);
		stu1.setZhuanye(tab_st_zhuanye);
		stu1.setBanji(tab_st_banji);
		stu1.setBeizhu(tab_st_beizhu);
		StudentServices stuservice1=new StudentServices(); 
		int result=stuservice1.stuUpdate(student_ID1, stu1);
		if(result!=0){
			 request.getRequestDispatcher("chakangeren_st.jsp").forward(request, response);
		}else{
			 out.print("ÐÞ¸ÄÊ§°Ü");
		}		
	}

}
