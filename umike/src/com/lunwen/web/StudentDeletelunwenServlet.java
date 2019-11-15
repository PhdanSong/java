package com.lunwen.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.ketilunwen;
import entity.ketixinxi;
import entity.lunwenxinxi;
import services.lunwenxinxi.LunwenxinxiServices;
import services.xuantixinxi.XuantixinxiServices;

/**
 * Servlet implementation class StudentDeletelunwenServlet
 */
@WebServlet("/StudentDeletelunwenServlet")
public class StudentDeletelunwenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentDeletelunwenServlet() {
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
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String student_ID=(String)request.getSession().getAttribute("id");
		System.out.println("编号是"+student_ID);
		LunwenxinxiServices lunservice1=new LunwenxinxiServices();
		lunwenxinxi result=(lunwenxinxi)lunservice1.StuSelectlunche(student_ID);
		if(result.getLunwen_ID()==null || result.getLunwen_ID().equals("")){
			System.out.println("删除成功");
			LunwenxinxiServices lunservice2=new LunwenxinxiServices();
			int result2=(int)lunservice2.deletelunwenxinxi(student_ID);
			request.getRequestDispatcher("lunwen_selectst.jsp").forward(request, response);
		}
		else{	
			/*System.out.println("删除失败");
			request.getRequestDispatcher("lunwen_selectst.jsp").forward(request, response);*/
			out.print("<script>alert('教师已对该学生的论文打分，不可再删除论文信息！')</script>");
			out.print("<script>location.href='lunwen_selectst.jsp'</script>");
		}
	}

}
