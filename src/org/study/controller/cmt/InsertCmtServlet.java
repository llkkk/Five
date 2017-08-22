package org.study.controller.cmt;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.study.mode.pojo.Cmt;
import org.study.mode.pojo.Person;
import org.study.mode.service.ICmtService;
import org.study.mode.service.impl.CmtService;

/**
 * Servlet implementation class InsertCmtSevlet
 */
@WebServlet("/InsertCmtServlet")
public class InsertCmtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertCmtServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session=request.getSession();
		Person user=(Person)session.getAttribute("user_cur");
		String blogId=request.getParameter("bid");
		String cmtContent=request.getParameter("cmtContent");
		int cmtNum=Integer.parseInt(request.getParameter("cmtNum"));
		Date dayOfCmt=new Date();
		Cmt cmt=new Cmt(null, blogId, user.getUserId(), cmtContent, dayOfCmt, user.getUserName());
		ICmtService cs=new CmtService();
		if(cs.insertCmt(cmt,cmtNum)<1)
			request.setAttribute("msg", "发表失败。");
		request.getRequestDispatcher("SelectBlogDetailsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
