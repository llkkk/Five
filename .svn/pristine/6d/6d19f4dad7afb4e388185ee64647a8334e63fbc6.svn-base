package org.study.controller.blog;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.study.mode.pojo.Blog;
import org.study.mode.pojo.Person;
import org.study.mode.service.IBlogService;
import org.study.mode.service.impl.BlogService;

/**
 * Servlet implementation class InsertBlogServlet
 */
@WebServlet("/InsertBlogServlet")
public class InsertBlogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertBlogServlet() {
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
		request.setAttribute("from", request.getParameter("from"));
		String userId=((Person)session.getAttribute("user_cur")).getUserId();
		String userName=((Person)session.getAttribute("user_cur")).getUserName();
		String blogContent=request.getParameter("blogContent");
		String blogName=request.getParameter("blogName");
		if(blogName==null) blogName="无标题";
		Date dayOfPublication=new Date();
		Blog b=new Blog(null, userId, blogName, blogContent, dayOfPublication, 0, userName);
		IBlogService bs=new BlogService();
		if(bs.insertBlog(b)>0)
			request.getRequestDispatcher("SelectAllUserServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
