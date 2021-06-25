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

public class CompanyEdited implements Operation{
	
	public String action (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String dateOpeningDay = request.getParameter("date");
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Date formatedDateOpeningDay = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			formatedDateOpeningDay = sdf.parse(dateOpeningDay);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		DataBase dataBase = new DataBase();
		Company company = dataBase.editCompany(id);
		company.setName(name);
		company.setOpeningDay(formatedDateOpeningDay);
		
		System.out.println("Editing Companies");
		System.out.println(id);

		return "redirect:main?action=CompanyList";
		
		
	}

	
}
