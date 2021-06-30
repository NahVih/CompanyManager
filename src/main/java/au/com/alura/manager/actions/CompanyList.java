package au.com.alura.manager.actions;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import au.com.alura.manager.model.Company;
import au.com.alura.manager.model.DataBase;

public class CompanyList implements Operation{
	
	public String action (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		DataBase database = new DataBase();
		List<Company> list = database.getCompany();

		request.setAttribute("companies", list);

		
		return "forward:companyList.jsp";
		
	}

	
}
