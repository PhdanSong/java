package com.student.tongzhi;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.tongzhi;
import services.tongzhi.TongzhiServices;

/**
 * Servlet implementation class TongzhifenyeServlet
 */
@WebServlet("/Tongzhifenye")
public class Tongzhifenye extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tongzhifenye() {
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
		//执行分页操作
		TongzhiServices tonservice=new TongzhiServices();
		System.out.println("tongzhifenye");
		String student_ID=(String)request.getSession().getAttribute("id");
		int countRow =tonservice.countTongzhiDao(student_ID);
	    int pageCount=0;
	    System.out.println("学号是"+student_ID+"条数是"+countRow);
	    if (countRow % 8 > 0)
			pageCount = countRow / 8 + 1;
		else
			pageCount = countRow / 8;	    
	    List<tongzhi> list=new ArrayList<tongzhi>();
	    TongzhiServices tonser=new TongzhiServices();
		String pageNoString =request.getParameter("pageNo");//第几个8
		System.out.println("pageNO"+pageNoString);
		if(pageNoString==null||pageNoString.equals("")){
			list=tonser.tongzhifenye(student_ID,"0","8");
		}
		else{
		int start=Integer.valueOf(pageNoString);
		String realStart=Integer.toString((start-1)*8);
		String realEnd=Integer.toString(start*8-1);
	    list=tonser.tongzhifenye(student_ID,realStart,realEnd);
		}
		//消息提醒
		tonser.tongChange(student_ID);
	    System.out.println("list"+list);
	    request.setAttribute("List", list);
		request.setAttribute("pageNo", countRow);
		request.setAttribute("pageCount", pageCount);
		request.getRequestDispatcher("tongzhi_selectst.jsp").forward(request, response);
	}

}
