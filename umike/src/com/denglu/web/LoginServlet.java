package com.denglu.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.student;
import entity.teacher;
import services.student.StudentServices;
import services.teacher.TeacherServices;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
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
		//try{
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		//Map<String,String> json=new HashMap<String,String>();
		//Ĭ�϶����ֻ���Ƿ�Ϊ11�ȵ���֤���ڿͻ������
		//��ȡ��¼������ֻ�ź�����
		String username=request.getParameter("username").toString();
		String password=request.getParameter("password").toString();
		String radiobutton=request.getParameter("radiobutton").toString();
		System.out.println("++++++"+username+">>>>>>>"+password+"============"+radiobutton);
		if(radiobutton.toString().equals("student")){
			StudentServices studentServices = new StudentServices();
			boolean bbb=studentServices.checkLogin(username,password);
			if(bbb){
				 request.getSession().setAttribute("id", username);
				 //request.setAttribute("id",username);//存值
				 request.getRequestDispatcher("main_st.jsp").forward(request, response);
				 //out.print("true");
			}else{
				 bbb=false;
				 out.print("false"+"++++++"+username+">>>>>>>"+password+"============"+radiobutton);
			}
		}else{
			TeacherServices teacherServices = new TeacherServices();
			boolean bbb=teacherServices.checkLogin(username,password);
			if(bbb){
				 request.getSession().setAttribute("id", username);
				 //request.setAttribute("id",username);//存值
				 request.getRequestDispatcher("main_te.jsp").forward(request, response);
				 //out.print("true");
			}else{
				 bbb=false;
				 out.print("false"+"++++++"+username+">>>>>>>"+password+"============"+radiobutton);
			}
		}
		
		
//		byte[] jsonBytes = json.toString().getBytes("utf-8");
//		response.setContentLength(jsonBytes.length);
//		response.getOutputStream().write(jsonBytes);
//		response.getOutputStream().flush();
//		response.getOutputStream().close();
//		} catch (Exception e) { 
//		e.printStackTrace();
//		}
		out.flush();
		out.close();

	}
	}


