package org.study.controller.cmt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.study.mode.service.ICmtService;
import org.study.mode.service.impl.CmtService;

/**
 * Servlet implementation class DeleteCmtServlet
 */
@WebServlet("/DeleteCmtServlet")
public class DeleteCmtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCmtServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String cid=request.getParameter("cid");
		String bid=request.getParameter("bid");
		int cmtNum=Integer.parseInt(request.getParameter("cmtNum"));
		ICmtService cs=new CmtService();
		cs.deleteCmt(cid, bid, cmtNum);
		String from=request.getParameter("from");
		if(from!=null&&from.equals("deleteCmtManage"))
			request.getRequestDispatcher("SelectBlogDetailsManageServlet").forward(request, response);
		else request.getRequestDispatcher("SelectBlogDetailsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
