package org.study.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.study.mode.pojo.Person;
import org.study.mode.service.IPersonService;
import org.study.mode.service.impl.PersonService;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateUserServlet() {
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
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		// 生日
		String DOB=request.getParameter("dayOfBirth");
		Date dayOfBirth=null;
		try {
			java.util.Date dayOfBirth_util = new SimpleDateFormat("yyyy-MM-dd").parse(DOB);
			dayOfBirth=new Date(dayOfBirth_util.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calendar c = Calendar.getInstance();
		int year_now=c.get(Calendar.YEAR);
		c.setTime(dayOfBirth);
		int year_birth=c.get(Calendar.YEAR);
		int age = year_now-year_birth;
		IPersonService ps = new PersonService();
		HttpSession session = request.getSession();
		String userId=((Person)session.getAttribute("user_cur")).getUserId();
		int limit=((Person)session.getAttribute("user_cur")).getLimits();
		Date registrationdate=((Person)session.getAttribute("user_cur")).getRegistrationdate();
		String pwd=((Person)session.getAttribute("user_cur")).getUserPass();
		Person p = new Person(userId, request.getParameter("userName"),
				"", age, request.getParameter("sex"), dayOfBirth, registrationdate,
				request.getParameter("email"), request.getParameter("phone"),limit, request.getParameter("address"));
		int i = ps.updatePerson(p);
		if (i > 0) {
			p.setUserPass(pwd);
			session.setAttribute("user_cur", p);
			request.getRequestDispatcher("UserManageServlet?pid="+userId).forward(request, response);
		} else {
			request.setAttribute("msg", "修改失败");
			request.getRequestDispatcher("person/update.jsp").forward(request, response);
		}
	}

}
