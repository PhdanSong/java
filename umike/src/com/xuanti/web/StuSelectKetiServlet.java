package com.xuanti.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.ketixinxi.KetixinxiServices;
import entity.ketilunwen;

/**
 * Servlet implementation class StuSelectKetiServlet
 */
@WebServlet("/StuSelectKetiServlet")
public class StuSelectKetiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StuSelectKetiServlet() {
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
		String xuanti_st_ketibianhao=request.getParameter("xuanti_st_ketibianhao");
		String xuanti_st_keti=request.getParameter("xuanti_st_keti");
		String xuanti_st_fabujiaoshi=request.getParameter("xuanti_st_fabujiaoshi");
		System.out.println("��������"+xuanti_st_ketibianhao);
		System.out.println("������"+xuanti_st_keti);
		System.out.println("��ʦ��"+xuanti_st_fabujiaoshi);
		System.out.println("ѡ��"+xuanti_st_ketibianhao.isEmpty());
		System.out.println("����"+xuanti_st_keti.isEmpty());
		KetixinxiServices ketiservice=new KetixinxiServices();
		List<ketilunwen> list=new ArrayList<ketilunwen>();
		//ֻ��������Ų�ѯ
		if(!xuanti_st_ketibianhao.isEmpty()&&xuanti_st_keti.isEmpty()&&xuanti_st_fabujiaoshi.isEmpty()){
		list=ketiservice.count1(xuanti_st_ketibianhao);
		System.out.println("StuSelectKetiServletִ��"+xuanti_st_ketibianhao);
		System.out.println("������"+list.size()+"==="+list);
		request.getSession().setAttribute("list1",list.size());
		for(int i=0;i<list.size();i++){
		request.getSession().setAttribute("listcontent"+i,list.get(i));
		}
		request.getRequestDispatcher("xuanti_st.jsp").forward(request, response);
		}
		
		//ֻ����γ����Ʋ�ѯ
		if(xuanti_st_ketibianhao.isEmpty()&&!xuanti_st_keti.isEmpty()&&xuanti_st_fabujiaoshi.isEmpty()){
			list=ketiservice.count2(xuanti_st_keti);
			System.out.println("StuSelectKetiServletִ��"+xuanti_st_keti);
			System.out.println("������"+list.size()+"==="+list);
			request.getSession().setAttribute("list1",list.size());
			for(int i=0;i<list.size();i++){
			request.getSession().setAttribute("listketi"+i,list.get(i));
			}
			request.getRequestDispatcher("xuanti_st.jsp").forward(request, response);
		}
		//ֻ�䷢����ʦ��ѯ
		if(xuanti_st_ketibianhao.isEmpty()&&xuanti_st_keti.isEmpty()&&!xuanti_st_fabujiaoshi.isEmpty()){
			list=ketiservice.count3(xuanti_st_fabujiaoshi);
			System.out.println("StuSelectKetiServletִ��"+xuanti_st_keti);
			System.out.println("������"+list.size()+"==="+list);
			request.getSession().setAttribute("list1",list.size());
			for(int i=0;i<list.size();i++){
			request.getSession().setAttribute("listjiaoshi"+i,list.get(i));
			}
			request.getRequestDispatcher("xuanti_st.jsp").forward(request, response);
		}
		//����γ����ƣ������ţ�������ʦ��ѯ
		if(!xuanti_st_ketibianhao.isEmpty()&&!xuanti_st_keti.isEmpty()&&!xuanti_st_fabujiaoshi.isEmpty()){
			list=ketiservice.count4(xuanti_st_ketibianhao,xuanti_st_keti,xuanti_st_fabujiaoshi);
			System.out.println("StuSelectKetiServletִ��"+xuanti_st_keti);
			System.out.println("������"+list.size()+"==="+list);
			request.getSession().setAttribute("list1",list.size());
			for(int i=0;i<list.size();i++){
			request.getSession().setAttribute("listthree"+i,list.get(i));
			}
			request.getRequestDispatcher("xuanti_st.jsp").forward(request, response);
		}
		//����γ����ƣ�������
		if(!xuanti_st_ketibianhao.isEmpty()&&!xuanti_st_keti.isEmpty()&&xuanti_st_fabujiaoshi.isEmpty()){
			list=ketiservice.count5(xuanti_st_ketibianhao,xuanti_st_keti);
			System.out.println("StuSelectKetiServletִ��"+xuanti_st_keti);
			System.out.println("������"+list.size()+"==="+list);
			request.getSession().setAttribute("list1",list.size());
			for(int i=0;i<list.size();i++){
			request.getSession().setAttribute("listthree"+i,list.get(i));
			}
			request.getRequestDispatcher("xuanti_st.jsp").forward(request, response);
		}
		//����γ̱�ţ�������ʦ
		if(!xuanti_st_ketibianhao.isEmpty()&&xuanti_st_keti.isEmpty()&&!xuanti_st_fabujiaoshi.isEmpty()){
			list=ketiservice.count6(xuanti_st_ketibianhao,xuanti_st_fabujiaoshi);
			System.out.println("StuSelectKetiServletִ��"+xuanti_st_keti);
			System.out.println("������"+list.size()+"==="+list);
			request.getSession().setAttribute("list1",list.size());
			for(int i=0;i<list.size();i++){
			request.getSession().setAttribute("listthree"+i,list.get(i));
			}
			request.getRequestDispatcher("xuanti_st.jsp").forward(request, response);
		}
		//����γ����ƣ�������ʦ
		if(xuanti_st_ketibianhao.isEmpty()&&!xuanti_st_keti.isEmpty()&&!xuanti_st_fabujiaoshi.isEmpty()){
			list=ketiservice.count7(xuanti_st_keti,xuanti_st_fabujiaoshi);
			System.out.println("StuSelectKetiServletִ��"+xuanti_st_keti);
			System.out.println("������"+list.size()+"==="+list);
			request.getSession().setAttribute("list1",list.size());
			for(int i=0;i<list.size();i++){
			request.getSession().setAttribute("listthree"+i,list.get(i));
			}
			request.getRequestDispatcher("xuanti_st.jsp").forward(request, response);
		}
	}

}
