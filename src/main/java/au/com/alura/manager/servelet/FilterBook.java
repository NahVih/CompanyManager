package au.com.alura.manager.servelet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//@WebFilter(urlPatterns = "/main")
public class FilterBook implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("Filter Book");
		
		long before = System.currentTimeMillis();
		
		String action = request.getParameter("action");
		
		chain.doFilter(request, response);
		
		long after = System.currentTimeMillis();
		System.out.println("Execution Time: " + action + "-> " + (after - before));
		
	}

}
