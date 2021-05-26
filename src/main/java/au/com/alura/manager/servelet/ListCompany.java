package au.com.alura.manager.servelet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import au.com.alura.manager.model.Company;
import au.com.alura.manager.model.DataBase;

/**
 * Servlet implementation class ListCompany
 */
@WebServlet("/listCompany")
public class ListCompany extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			DataBase database = new DataBase();
			List<Company> list = database.getCompany();
		
			request.setAttribute("companies", list);
			
			RequestDispatcher rd = request.getRequestDispatcher("/companyList.jsp");
			rd.forward(request, response);
			
	}

}
