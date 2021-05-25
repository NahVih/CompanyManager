package au.com.alura.manager.servelet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;

/**
 * Servlet implementation class CompanyEditedServelet
 */
@WebServlet("/companyEdited")
public class CompanyEditedServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Editing new ABN");
		
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
		
		response.sendRedirect("listCompany");
	}

}
