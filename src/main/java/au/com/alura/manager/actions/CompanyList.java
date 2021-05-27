package au.com.alura.manager.actions;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import au.com.alura.manager.model.Company;
import au.com.alura.manager.model.DataBase;

public class CompanyList{
	
	public void action (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DataBase database = new DataBase();
		List<Company> list = database.getCompany();

		request.setAttribute("companies", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("/companyList.jsp");
		rd.forward(request, response);
		
		System.out.println("Listing Companies");
		
	}

	
}
