package au.com.alura.manager.actions;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import au.com.alura.manager.model.Company;
import au.com.alura.manager.model.DataBase;

public class CompanyEdited{
	
	public void action (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
		
		System.out.println(id);
		
		DataBase dataBase = new DataBase();
		Company company = dataBase.editCompany(id);
		company.setName(name);
		company.setOpeningDay(formatedDateOpeningDay);
		
		response.sendRedirect("main?action=listCompany");
		
		System.out.println("Editing Companies");
		
	}

	
}
