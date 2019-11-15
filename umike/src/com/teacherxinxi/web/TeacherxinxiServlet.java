package com.teacherxinxi.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.ketilunwen;
import entity.ketixinxi;
import entity.teacher;
import entity.tongzhi;
import services.chengji.ChengjiServices;
import services.ketixinxi.KetixinxiServices;
import services.teacher.TeacherServices;
import services.tongzhi.TongzhiServices;
import services.xuantixinxi.XuantixinxiServices;

/**
 * Servlet implementation class TeacherxinxiServlet
 */
@WebServlet("/TeacherxinxiServlet")
public class TeacherxinxiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherxinxiServlet() {
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
		String password = (String)request.getSession().getAttribute("password");
		TeacherServices teacherServices = new TeacherServices();
		teacher teacher = teacherServices.selectAll(teacherId);
		request.getSession().setAttribute("teacher",teacher);
		System.out.println("+++++++++++++++++"+teacher.getDianhua());
		System.out.println("+++++++++++++++++"+teacher.getTeacher_ID());
		
		/*KetixinxiServices ketixinxiServices = new KetixinxiServices();
		List<ketixinxi> keti = new ArrayList<ketixinxi>();
		keti = ketixinxiServices.getKetixinxi(teacherId);
		request.getSession().setAttribute("ketixinxi",ketixinxi); 
		ketixinxi keti = (ketixinxi)request.getSession().getAttribute("ketixinxi");
		System.out.println("--------------------"+keti);
		for(int i=0;i<keti.size();i++){
			System.out.println(">>>>>>>>>>>>>>>>>"+keti.get(i).getKetibianhao());
		}
		XuantixinxiServices xuantixinxiServices =new XuantixinxiServices();
		List<ketilunwen> xuanti = new ArrayList<ketilunwen>();
		xuanti = xuantixinxiServices.teacIDselectxuantixinxi(teacherId);
		System.out.println("==================="+xuanti);
		/*System.out.println("+++++++"+keti);
		System.out.println(keti.getBeizhu());
		ChengjiServices chengjiServices =new ChengjiServices();
		List<ketilunwen> chengji = new ArrayList<ketilunwen>();
		chengji = chengjiServices.teacIDselectchengji(teacherId);
		System.out.println(">>>>>>>>>>>>>>>>>"+chengji);
		TongzhiServices tongzhiServices =new TongzhiServices();
		List<tongzhi> tongzhi = new ArrayList<tongzhi>();
		tongzhi = tongzhiServices.selectAll(teacherId);
		System.out.println(">>>>>>>>>>>>>>>>>"+tongzhi);*/
		
		String gonghao=request.getParameter("gonghao").toString();
		String xingming=request.getParameter("xingming").toString();
		String xingbie=request.getParameter("xingbie").toString();
		String dianhua=request.getParameter("dianhua").toString();
		String zhujiaokecheng=request.getParameter("zhujiaokecheng").toString();
		String beizhu=request.getParameter("beizhu").toString();
		teacher tea = new teacher();
		tea.setTeacher_ID(gonghao);
		tea.setMima(password);
		tea.setXingming(xingming);
		tea.setXingbie(xingbie);
		tea.setDianhua(dianhua);
		tea.setZhujiaokecheng(zhujiaokecheng);
		tea.setBeizhu(beizhu);
		int count=teacherServices.updateteacher(tea,teacherId);
		if(count>0){
			System.out.println("提交成功");
			try {
				 out.print("<script>alert('修改成功')</script>");
				 out.print("<script>location.href='chakangeren_te.jsp'</script>");
				 out.close();
				 } catch (Exception e) {
				 e.printStackTrace();
				 } 
			//request.getRequestDispatcher("chakangeren_te.jsp").forward(request, response);
		}else{
			System.out.println("更新失败");
		
		}
		
		
		
		
		
		
		out.flush();
		out.close();
	}

}
