package com.keti.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.ketixinxi.KetixinxiServices;

/**
 * Servlet implementation class KetifujianServlet
 */
@WebServlet("/KetifujianServlet")
public class KetifujianServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KetifujianServlet() {
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
		String fujianID= request.getParameter("fujianID");
		List<Map> list= (List<Map>)request.getSession().getAttribute("fujianlist");
		for(int i=0;i<list.size();i++){
			if(list.get(i).keySet().toString()  == fujianID){
				//获取文件名
				list.get(i).get(list.get(i).keySet().toString());
			}
		}
		
	}

}
