package com.xuanti.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.xuantixinxi.XuantixinxiServices;

/**
 * Servlet implementation class StudentDeleteXuanServlet
 */
@WebServlet("/StudentDeleteXuanServlet")
public class StudentDeleteXuanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentDeleteXuanServlet() {
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
		if(student_ID.equals(" ")){
			out.print("<script>alert('老师已打分，不可再更改论文！')</script>");
		}
		else{
			XuantixinxiServices lunserviceshan=new XuantixinxiServices();
			lunserviceshan.StudeleteXuantixinxi(student_ID); 
			request.getRequestDispatcher("xuanti_selectst.jsp").forward(request, response);
		}
	}

}
