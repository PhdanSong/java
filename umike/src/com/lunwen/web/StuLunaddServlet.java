package com.lunwen.web;

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

import entity.lunwenxinxi;
import entity.xuantixinxi;
import services.lunwenxinxi.LunwenxinxiServices;
import services.xuantixinxi.XuantixinxiServices;

/**
 * Servlet implementation class StuLunaddServlet
 */
@WebServlet("/StuLunaddServlet")
public class StuLunaddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StuLunaddServlet() {
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
		int count=0;
		String lunwen_addst_mingcheng=request.getParameter("lunwen_addst_mingcheng");
		String lunwen_addst_neirong=request.getParameter("lunwen_addst_neirong");		
		String lunwen_addst_beizhu=request.getParameter("lunwen_addst_beizhu");
		String student_ID=(String)request.getSession().getAttribute("id");
		
		System.out.println("======"+lunwen_addst_mingcheng+"======="+lunwen_addst_neirong+"====="+lunwen_addst_beizhu+"===="+student_ID);
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if((lunwen_addst_mingcheng==null||"".equals(lunwen_addst_mingcheng))){
			out.print("<script>alert('论文名称不能为空！')</script>");
			out.print("<script>location.href='lunwen_addst.jsp'</script>");
		}
		else{
		XuantixinxiServices xuantixinxiServices = new XuantixinxiServices();		
		xuantixinxi xuan=new xuantixinxi();
		xuan=xuantixinxiServices.selectXuanti(student_ID);
		lunwenxinxi lun=new lunwenxinxi();
		if(xuan.getKetimingcheng() != null){
			lun.setLunwen_ID(student_ID);
			lun.setLunwenmingcheng(lunwen_addst_mingcheng);
			lun.setKetimingcheng(xuan.getKetimingcheng());
			lun.setStudent_ID(student_ID);
			lun.setTeacher_ID(xuan.getTeacher_ID());
			lun.setFujian(lunwen_addst_neirong);
			lun.setBeizhu(lunwen_addst_beizhu);
			lun.setTijiaoshijian(format.format(new Date()));
			LunwenxinxiServices lunServices=new LunwenxinxiServices();
			count=lunServices.saveLunwenxinxiDao(lun);
			if(count==0){
				out.print("<script>alert('该同学已添加论文，不需再添加！')</script>");
				request.getRequestDispatcher("lunwen_selectst.jsp").forward(request, response);
			}else{
				out.print("<script>alert('添加论文成功！')</script>");				
				request.getRequestDispatcher("lunwen_selectst.jsp").forward(request, response);
			}
		}else{
			out.print("<script>alert('还未选择课题，请先选择课题！')</script>");
		}
	
	}
	}
}
