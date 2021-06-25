package au.com.alura.manager.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import au.com.alura.manager.model.DataBase;

public class CompanyRemoving implements Operation{
	
	public String action (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		DataBase dataBase = new DataBase();
		dataBase.removeCompany(id);
		
//		response.sendRedirect("main?action=listCompany");
		
		System.out.println("Removing Companies");
		
		return "redirect:main?action=CompanyList";
		
	}

	
}
