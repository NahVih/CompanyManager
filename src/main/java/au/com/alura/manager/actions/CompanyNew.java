package au.com.alura.manager.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CompanyNew{
	
	public String action (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("New Company");
		
		return "forward:FormNewABN.jsp";
		
	}

	
}
