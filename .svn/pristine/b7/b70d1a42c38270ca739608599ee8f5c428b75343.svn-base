package org.study.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.study.mode.service.IPersonService;
import org.study.mode.service.impl.PersonService;

/**
 * Servlet implementation class NameCheckServlet
 */
@WebServlet("/NameCheckServlet")
public class NameCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    IPersonService ps = new PersonService(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NameCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/xml; charset=UTF-8");
		//以下两句为取消在本地的缓存
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		String name = request.getParameter("name");
		PrintWriter out = response.getWriter();  
		if(ps.isUsed(name)) {
	        out.print("该用户名已被使用");  
		}else {
			out.print("");
		}
		out.flush();  
		out.close();  
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
