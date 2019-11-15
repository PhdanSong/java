package com.lunwen.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.lunwenxinxi;
import services.lunwenxinxi.LunwenxinxiServices;

/**
 * Servlet implementation class StulunUpdateServlet
 */
@WebServlet("/StulunUpdateServlet")
public class StulunUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StulunUpdateServlet() {
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
		String lunwen_gaist_mingcheng=(String)request.getParameter("lunwen_gaist_mingcheng");
		String lunwen_gaist_neirong=(String)request.getParameter("lunwen_gaist_neirong");
		String lunwen_gaist_beizhu=(String)request.getParameter("lunwen_gaist_beizhu");
		LunwenxinxiServices lunServices=new LunwenxinxiServices();	
		lunwenxinxi lun=new lunwenxinxi();
		lun.setLunwenmingcheng(lunwen_gaist_mingcheng);
		lun.setFujian(lunwen_gaist_neirong);
		lun.setBeizhu(lunwen_gaist_beizhu);
		/*int count=lunServices.updatelunwenxinxi(lun,student_ID,lunwenID);	
		if(count==0){
			out.print("<script>alert('论文修改失败！请重试')</script>");
			out.print("<script>location.href='lunwen_gaist.jsp'</script>");
		}else{
			out.print("<script>alert('论文修改成功！')</script>");
			out.print("<script>location.href='lunwen_selectst.jsp'</script>");
		}*/
	}

}
