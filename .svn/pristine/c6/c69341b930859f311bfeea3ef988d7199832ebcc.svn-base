package org.study.controller.blog;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.study.mode.service.IBlogService;
import org.study.mode.service.impl.BlogService;

/**
 * Servlet implementation class DeleteBlogServlet
 */
@WebServlet("/DeleteBlogServlet")
public class DeleteBlogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBlogServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String from=request.getParameter("from");
		String bid=request.getParameter("bid");
		IBlogService bs=new BlogService();
		if(bs.deleteBlog(bid)<=0)
			request.setAttribute("msg", "删除失败。");
		if(from!=null&&from.equals("manageDelete"))
			request.getRequestDispatcher("ManageServlet").forward(request, response);
		else{
			request.setAttribute("from", from);
			request.getRequestDispatcher("SelectAllUserServlet").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
