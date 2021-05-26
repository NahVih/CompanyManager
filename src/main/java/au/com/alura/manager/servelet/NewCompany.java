package au.com.alura.manager.servelet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import au.com.alura.manager.model.Company;
import au.com.alura.manager.model.DataBase;

/**
 * Servlet implementation class NewABNServlet
 */
@WebServlet("/CreatedNewCompany")
public class NewCompany extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

   
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Registering new ABN");
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
		
		response.sendRedirect("listCompany");
		
//		//call JSP
//		RequestDispatcher rd = request.getRequestDispatcher("/listCompany");
//		request.setAttribute("companyName", company.getName());
//		rd.forward(request, response);
	}
	

}
