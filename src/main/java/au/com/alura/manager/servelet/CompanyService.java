package au.com.alura.manager.servelet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import au.com.alura.manager.model.Company;
import au.com.alura.manager.model.DataBase;

/**
 * Servlet implementation class CompanyService
 */
@WebServlet("/company")
public class CompanyService extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Company> company = new DataBase().getCompany();
		
		Gson gson = new Gson();
		String json = gson.toJson(company);
		
		response.setContentType("application/json");
		response.getWriter().print(json);
		
	}

}
