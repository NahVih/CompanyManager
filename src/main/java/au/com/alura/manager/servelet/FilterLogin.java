package au.com.alura.manager.servelet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebFilter("/main")
public class FilterLogin implements Filter {

   
	
	public void doFilter(ServletRequest serveletRequest, ServletResponse serveletResponse, FilterChain chain) throws IOException, ServletException {

		System.out.println("Filter Login");
		
		HttpServletRequest request = (HttpServletRequest) serveletRequest;
		HttpServletResponse response = (HttpServletResponse) serveletResponse;
		
		String paramAction = request.getParameter("action");
		
		HttpSession session = request.getSession();
		boolean userOn = (session.getAttribute("userOn")==null);
		boolean protectedAction = !(paramAction.equals("Login") || paramAction.equals("LoginForm"));
		if (protectedAction && userOn) {
			response.sendRedirect("main?action=LoginForm");
			return;
		}
		
		chain.doFilter(request, response);
	}
}
