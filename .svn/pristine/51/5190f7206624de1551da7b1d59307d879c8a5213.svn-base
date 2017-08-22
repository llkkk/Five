package org.study.controller.blog;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.study.mode.pojo.Blog;
import org.study.mode.pojo.Person;
import org.study.mode.service.IBlogService;
import org.study.mode.service.impl.BlogService;

/**
 * Servlet implementation class SelectBlogServlet
 */
@WebServlet("/SelectAllBlogServlet")
public class SelectAllBlogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectAllBlogServlet() {
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
		List<Blog> lst_blog=bs.selectBlog();
		request.setAttribute("lst_blog", lst_blog);
		String from=(String) request.getAttribute("from");
		if(from!=null&&from.equals("ManageIndex"))
			request.getRequestDispatcher("person/manage/manage.jsp").forward(request, response);
		else{
			request.getRequestDispatcher("person/index.jsp").forward(request, response);
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
