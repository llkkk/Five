package org.study.controller;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class SelectAllUserServlet
 */
@WebServlet("/SelectAllUserServlet")
public class SelectAllUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectAllUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String from=(String)request.getAttribute("from");
		if(from==null){
			from=request.getParameter("from");
		}
		IPersonService ps = new PersonService();
		List<Person> lst_user=ps.selectAllUser();
		request.setAttribute("lst_user", lst_user);
		if(from==null||from.equals("loginServlet")||from.equals("ManageIndex")){
			request.getRequestDispatcher("SelectAllBlogServlet").forward(request, response);
		}else if(from.equals("SelectBlogDetailsServlet")||from.equals("SelectBlogDetailsManageServlet")){
			request.getRequestDispatcher("SelectCmtByBidServlet").forward(request, response);
		}else if(from.equals("SelectBlogByUserIdServlet")){
//			HttpSession session=request.getSession();
//			Person user=(Person)session.getAttribute("user_cur");
			String userId=request.getParameter("pid");
			IBlogService bs=new BlogService();
			List<Blog> lst=bs.selectBlogByUserId(userId);
			request.setAttribute("lst_blog_cur", lst);
			request.getRequestDispatcher("person/userInfo.jsp").forward(request, response);
		}else if(from.equals("userManage")){
			request.getRequestDispatcher("person/updateUser.jsp").forward(request, response);
		}else if(from.equals("用户中心")){
			Person p1=null;
			String userId=request.getParameter("pid");
			for(int i=0;i<lst_user.size();i++){
				if(lst_user.get(i).getUserId().equals(userId)){
					p1=lst_user.get(i);
					break;
				}
			}
			request.setAttribute("user_other", p1);//当前自己正在访问的其他用户
			request.getRequestDispatcher("person/userManage.jsp").forward(request, response);
		}else if(from.equals("updatePWD")){
			request.getRequestDispatcher("person/updatePwd.jsp").forward(request, response);
		}else if(from.equals("旧密码错误，修改失败")){
			request.setAttribute("msg", "旧密码错误，修改失败");
			request.getRequestDispatcher("person/updatePwd.jsp").forward(request, response);
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
