package org.study.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.study.mode.pojo.Person;
import org.study.mode.service.IPersonService;
import org.study.mode.service.impl.PersonService;
import org.study.util.EncryptionByPass;

/**
 * Servlet implementation class UpdatePWDServlet
 */
@WebServlet("/UpdatePWDServlet")
public class UpdatePWDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdatePWDServlet() {
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
		HttpSession session = request.getSession();
		String pid = ((Person) session.getAttribute("user_cur")).getUserId();
		String userPass = ((Person) session.getAttribute("user_cur")).getUserPass();
		String oldPass = request.getParameter("oldPass");
		String newPass = request.getParameter("newPass");
		String c_op = EncryptionByPass.getBase64(oldPass);
		IPersonService ps = new PersonService();
		if (c_op.equals(userPass)) {
			if (ps.updatePwd(pid, newPass) > 0) {
				request.setAttribute("msg", "修改成功，请重新登陆。");
				request.getRequestDispatcher("LogOffServlet").forward(request, response);
			}else{
				request.setAttribute("from", "旧密码错误，修改失败");
				request.getRequestDispatcher("SelectAllUserServlet").forward(request, response);
			}
		} else {
			request.setAttribute("from", "旧密码错误，修改失败");
			request.getRequestDispatcher("SelectAllUserServlet").forward(request, response);
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
