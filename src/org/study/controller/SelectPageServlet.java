package org.study.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.study.mode.pojo.Person;
import org.study.mode.service.IPersonService;
import org.study.mode.service.impl.PersonService;

/**
 * Servlet implementation class SelectAllServlet
 */
@WebServlet("/SelectPageServlet")
public class SelectPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		IPersonService ps = new PersonService();
		int page =Integer.parseInt(request.getParameter("pageNum"));
		List<Person> list = ps.selectPage(page);
		int maxpage=ps.getMaxPage();
		request.setAttribute("list", list);
		request.setAttribute("page", page);
		request.setAttribute("maxpage", maxpage);
		request.getRequestDispatcher("person/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
