package org.study.controller.cmt;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.study.mode.pojo.Cmt;
import org.study.mode.service.ICmtService;
import org.study.mode.service.impl.CmtService;

/**
 * Servlet implementation class SelectCmtByBid
 */
@WebServlet("/SelectCmtByBidServlet")
public class SelectCmtByBidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectCmtByBidServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		ICmtService cs=new CmtService();
		String bid=request.getParameter("bid");
		List<Cmt> lst=cs.selectCmtByBlogId(bid);
		request.setAttribute("lst_cmt", lst);
		String from=(String) request.getAttribute("from");
		if(from.equals("SelectBlogDetailsManageServlet"))
			request.getRequestDispatcher("person/manage/cmtManage.jsp").forward(request, response);
		else request.getRequestDispatcher("person/cmt.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
