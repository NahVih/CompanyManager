package au.com.alura.manager.actions;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import au.com.alura.manager.model.Company;
import au.com.alura.manager.model.DataBase;

public class CompanyEditing{
	
	public void action (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		DataBase dataBase = new DataBase();
		Company company = dataBase.editCompany(id);
		System.out.println(company.getName());
		
		request.setAttribute("company", company);
		RequestDispatcher rd = request.getRequestDispatcher("/FormEditABN.jsp");
		rd.forward(request, response);
		
		System.out.println("Editing Companies");
		
	}

	
}
