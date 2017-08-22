package org.study.controller.blog;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.study.mode.pojo.Blog;
import org.study.mode.service.IBlogService;
import org.study.mode.service.impl.BlogService;

/**
 * Servlet implementation class SelectBlogDetails
 */
@WebServlet("/SelectBlogDetailsServlet")
public class SelectBlogDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectBlogDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		IBlogService bs=new BlogService();
		String bid=request.getParameter("bid");
		Blog blog=bs.selectBlogByBid(bid);
		request.setAttribute("blog", blog);
		request.setAttribute("from", "SelectBlogDetailsServlet");
		request.getRequestDispatcher("IndexInitServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
