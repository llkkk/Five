package org.study.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.study.mode.pojo.Person;
import org.study.mode.service.IPersonService;
import org.study.mode.service.impl.PersonService;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertServlet() {
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
		// 生日
//		int yob = Integer.parseInt(request.getParameter("yearOfBirth"));
//		int mob = Integer.parseInt(request.getParameter("monthOfBirth"));
//		int dob = Integer.parseInt(request.getParameter("dayOfBirth"));
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
		Date registrationdate=new Date(c.getTime().getTime());
		int year_now=c.get(Calendar.YEAR);
		c.setTime(dayOfBirth);
		int year_birth=c.get(Calendar.YEAR);
		int age = year_now-year_birth;
		IPersonService ps = new PersonService();
		Person p = new Person(null, request.getParameter("userName1"), request.getParameter("userPass1"), age,
				request.getParameter("sex"), dayOfBirth, registrationdate, request.getParameter("email"),
				request.getParameter("phone"), 0, request.getParameter("address"));
		int i = ps.insertPerson(p);
		if (i > 0) {
			request.setAttribute("msg", "注册成功。");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("registered.jsp").forward(request, response);
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
