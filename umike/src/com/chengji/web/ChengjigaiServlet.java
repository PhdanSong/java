package com.chengji.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.chengji.ChengjiServices;
import services.ketixinxi.KetixinxiServices;
import entity.chengji;
import entity.ketixinxi;

/**
 * Servlet implementation class ChengjigaiServlet
 */
@WebServlet("/ChengjigaiServlet")
public class ChengjigaiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChengjigaiServlet() {
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
		ChengjiServices chengjiServices = new ChengjiServices();
		String chengjiId= (String)request.getSession().getAttribute("chengjiId");
		System.out.println("&&&&&&&&&&&&&&&&&"+chengjiId);
		String ketibianhao=request.getParameter("ketibianhao").toString();
		String ketimingcheng=request.getParameter("ketimingcheng").toString();
		String student_ID=request.getParameter("student_ID").toString();
		String lunwenmingcheng=request.getParameter("lunwenmingcheng").toString();
		String fenshu=request.getParameter("fenshu").toString();
		String pingyu=request.getParameter("pingyu").toString();
	    String beizhu=request.getParameter("beizhu").toString();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		chengji cheng=new chengji();
		cheng.setChengji_ID(chengjiId);
		cheng.setStudent_ID(student_ID);
		cheng.setTeacher_ID(teacherId);
		cheng.setKetimingcheng(ketimingcheng);
		cheng.setLunwenmingcheng(lunwenmingcheng);
		cheng.setFenshu(fenshu);
		cheng.setPingyu(pingyu);
		cheng.setBeizhu(beizhu);
		cheng.setTianjiashijan(df.format(new Date()));
		int count = chengjiServices.updateChengji(cheng,teacherId,chengjiId);
	    if(count>0){
		   System.out.println("修改成功");
			try {
			   out.print("<script>alert('修改成功')</script>");
			   out.print("<script>location.href='chengji_te.jsp'</script>");
			   out.close();
			 } catch (Exception e) {
			    e.printStackTrace();
			 } 
				//request.getRequestDispatcher("chakangeren_te.jsp").forward(request, response);
			}else{
				System.out.println("修改失败");
			
			}
		
		out.flush();
		out.close();
	}

}
