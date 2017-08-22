package org.study.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.study.mode.service.IPersonService;
import org.study.mode.service.impl.PersonService;

/**
 * Application Lifecycle Listener implementation class CountListener
 *
 */
@WebListener
public class CountListener implements ServletContextListener {
	IPersonService ps = new PersonService();
	int count;
    /**
     * Default constructor. 
     */
    public CountListener() {
        // TODO Auto-generated constructor stub
    }
    /**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	ServletContext sc = arg0.getServletContext();
    	count = ps.selectCount();
    	sc.setAttribute("count", count);
    }
	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	ServletContext sc = arg0.getServletContext();
		count = (int)sc.getAttribute("count");
		ps.updateCount(count);
    }
}
