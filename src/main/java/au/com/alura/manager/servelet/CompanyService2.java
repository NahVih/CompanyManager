package au.com.alura.manager.servelet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import au.com.alura.manager.model.Company;
import au.com.alura.manager.model.DataBase;

/**
 * Servlet implementation class CompanyService
 */
@WebServlet("/company2")
public class CompanyService2 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Company> company = new DataBase().getCompany();
		
		XStream xstream = new XStream();
		xstream.alias("company", Company.class);
		String xml = xstream.toXML(company);
		
		response.setContentType("application/xml");
		response.getWriter().print(xml);
		
	}

}
