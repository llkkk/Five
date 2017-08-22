package org.study.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.study.mode.pojo.Blog;
import org.study.mode.pojo.Person;
import org.study.mode.service.IBlogService;
import org.study.mode.service.IPersonService;
import org.study.mode.service.impl.BlogService;
import org.study.mode.service.impl.PersonService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		IPersonService ps = new PersonService();
		String name = request.getParameter("userName");
		String pass = request.getParameter("userPass");
		Person p = ps.login(name, pass);
		if (p != null) {
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(3000);
			session.setAttribute("user_cur", p);
			ServletContext sc = this.getServletContext();
			Integer count = (Integer) sc.getAttribute("count");
			if (count == 0) {
				count = 1;
			} else {
				count++;
			}
			sc.setAttribute("count", count);
			request.setAttribute("from", "loginServlet");
			request.getRequestDispatcher("IndexInitServlet").forward(request, response);
		} else {
			request.setAttribute("msg", "账号或者密码错误。");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
