package org.study.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.study.mode.pojo.Person;
import org.study.mode.service.IPersonService;
import org.study.mode.service.impl.PersonService;

/**
 * Servlet Filter implementation class ManageFilter
 */
@WebFilter(filterName="/ManageFilter",urlPatterns="/person/manage/*")
public class ManageFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ManageFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req=(HttpServletRequest)request;
		HttpSession session=req.getSession();
		Person cur=(Person) session.getAttribute("user_cur");
		String pid=cur.getUserId();
		IPersonService ps=new PersonService();
		int limit=ps.selectLimits(pid);
		if(limit==-1){
			req.setAttribute("msg", "您已经被删除，请重新登陆。");
			req.getRequestDispatcher("../../login.jsp").forward(request, response);
		}else if(limit==0){
			req.setAttribute("msg", "您已经不是管理员，请重新登陆。");
			req.getRequestDispatcher("../../login.jsp").forward(request, response);
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
