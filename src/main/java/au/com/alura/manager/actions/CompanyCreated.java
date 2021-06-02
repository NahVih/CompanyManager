package au.com.alura.manager.actions;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import au.com.alura.manager.model.Company;
import au.com.alura.manager.model.DataBase;

public class CompanyCreated {
	
	public String action (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		String dateOpeningDay = request.getParameter("date");
		
		Date formatedDateOpeningDay = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			formatedDateOpeningDay = sdf.parse(dateOpeningDay);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Company company = new Company();
		company.setName(name);
		company.setOpeningDay(formatedDateOpeningDay);
		
		DataBase dataBase = new DataBase();
		dataBase.add(company);
		
		System.out.println("Company Created");
		
		return "redirect:main?action=listCompany";
		

	}
}
