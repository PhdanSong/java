package com.tongzhi.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.ketixinxi.KetixinxiServices;
import services.tongzhi.TongzhiServices;
import entity.ketixinxi;
import entity.tongzhi;

/**
 * Servlet implementation class TongxhinewServlet
 */
@WebServlet("/TongzhinewServlet")
public class TongzhinewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TongzhinewServlet() {
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
		TongzhiServices tongzhiServices = new TongzhiServices();
		String tongzhibiaoti=request.getParameter("tongzhibiaoti").toString();
		String tixingshijian=request.getParameter("tixingshijian").toString();
		String tongzhineirong=request.getParameter("tongzhineirong").toString();
		String beizhu=request.getParameter("beizhu").toString();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//璁剧疆鏃ユ湡鏍煎紡
		tongzhi tong = new tongzhi();
		tong.setTeacher_ID(teacherId);
		tong.setTongzhibiaoti(tongzhibiaoti);
		tong.setFabushijian(df.format(new Date()));
		tong.setTixingshijian(tixingshijian);
		tong.setTongzhineirong(tongzhineirong);
		tong.setBeizhu(beizhu);
		tong.setTag("false");
		int count = tongzhiServices.saveTongzhiDao(tong);
		if(count>0){
			System.out.println("娣诲姞鎴愬姛");
			try {
				 out.print("<script>alert('新增通知成功')</script>");
				 out.print("<script>location.href='tongzhi_select.jsp'</script>");
				 out.close();
				 } catch (Exception e) {
				 e.printStackTrace();
				 } 
			//request.getRequestDispatcher("chakangeren_te.jsp").forward(request, response);
		}else{
			System.out.println("娣诲姞澶辫触");
		
		}
		
		out.flush();
		out.close();
	}

}
