package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.teacher.TeacherDao;
import dao.xuantixinxi.XuantixinxiDao;
import entity.ketilunwen;
import entity.teacher;
import entity.xuantixinxi;

/**
 * Servlet implementation class XuantixinxiInsertServlet
 */
public class XuantixinxiInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XuantixinxiInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//更改
		/*String nick0 = request.getParameter("nick0");
		String nick1 = request.getParameter("nick1");
		String nick2 = request.getParameter("nick2");
		String nick3 = request.getParameter("nick3");
		String nick4 = request.getParameter("nick4");
		String nick5 = request.getParameter("nick5");
		String nick6 = request.getParameter("nick6");
		String nick7 = request.getParameter("nick7");
		XuantixinxiDao xuanDao=new XuantixinxiDao();
		teacher tea=new teacher();
		tea.setTeacher_ID(nick1);
		tea.setXingming(nick2);
		tea.setXingbie(nick3);
		tea.setBeizhu(nick4);
		tea.setZhujiaokecheng(nick5);
		tea.setDianhua(nick6);
		tea.setMima(nick7);
		TeacherDao teaDao=new TeacherDao();
		int count=teaDao.updateteacher(tea,nick0);
		if(count>0){
			System.out.println("插入成功");
		}else{
			System.out.println("插入失败");
		}*/
		/*String nick0 = request.getParameter("nick0");
		teacher tea=new teacher();
		TeacherDao teaDao=new TeacherDao();
		tea=teaDao.selectAll(nick0);*/
		String nick0 = request.getParameter("nick0");
		String nick1 = request.getParameter("nick1");
		String nick2 = request.getParameter("nick2");
		List<ketilunwen> list=new ArrayList<ketilunwen>();
		XuantixinxiDao xuanDao=new XuantixinxiDao();
		list=xuanDao.selectxuantixinxi1(nick0,nick1,nick2);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
