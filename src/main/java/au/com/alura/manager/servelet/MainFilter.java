package au.com.alura.manager.servelet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import au.com.alura.manager.actions.Operation;

//@WebFilter("/Main")
public class MainFilter implements Filter {

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

        System.out.println("Main Filter");

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String paramAction = request.getParameter("action");
        
        String className = "au.com.alura.manager.actions." + paramAction;
		
		String name = null;
		
		
		try {
			Class<?> xclass = Class.forName(className);
			Operation operation = (Operation) xclass.newInstance();
			name = operation.action(request,response);
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}
		
		String[] typeAddress= name.split(":");
		if(typeAddress[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + typeAddress[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(typeAddress[1]);
		}


    }

}
