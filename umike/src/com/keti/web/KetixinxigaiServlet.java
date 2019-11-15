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

import entity.ketixinxi;
import services.ketixinxi.KetixinxiServices;

/**
 * Servlet implementation class KetixinxigaiServlet
 */
@WebServlet("/KetixinxigaiServlet")
public class KetixinxigaiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KetixinxigaiServlet() {
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
		String bianhao= (String)request.getSession().getAttribute("bianhaoketi");
		System.out.println("&&&&&&&&&&&&&&&&&"+bianhao);
		String ketibianhao=request.getParameter("ketibianhao").toString();
		String ketimingcheng=request.getParameter("ketimingcheng").toString();
		String leixing=request.getParameter("leixing").toString();
		String ketishuliang=request.getParameter("ketishuliang").toString();
		String fujian=request.getParameter("fujian").toString();
	    String beizhu=request.getParameter("beizhu").toString();
	    String baocunming = request.getParameter("baocunming").toString();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		ketixinxi ketix = new ketixinxi();
		ketix.setKetibianhao(ketibianhao);
		ketix.setTeacID(teacherId);
		ketix.setKetimingcheng(ketimingcheng);
		ketix.setLeixing(leixing);
		ketix.setFujian(fujian);
		ketix.setKetishuliang(ketishuliang);
		ketix.setBeizhu(beizhu);
		ketix.setFabushijian(df.format(new Date()));
		ketix.setBaocunming(baocunming);
		int count = ketixinxiServices.updateKetixinxi(ketix,teacherId,bianhao);
	    if(count>0){
		   System.out.println("修改成功");
			try {
			   out.print("<script>alert('修改成功')</script>");
			   out.print("<script>location.href='keti_select.jsp'</script>");
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
