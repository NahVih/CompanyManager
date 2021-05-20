package au.com.alura.manager.servelet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NewABNServlet
 */
@WebServlet("/CreatedNewCompany")
public class NewCompany extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

   
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Registering new ABN");
		String name = request.getParameter("name");
		Company company = new Company();
		company.setName(name);
		
		DataBase dataBase = new DataBase();
		dataBase.add(company);
		
		//call JSP
		RequestDispatcher rd = request.getRequestDispatcher("/newCompanyCreated.jsp");
		request.setAttribute("companyName", company.getName());
		rd.forward(request, response);
	}
	

}
