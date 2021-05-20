package au.com.alura.manager.servelet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListCompany
 */
@WebServlet("/listCompany")
public class ListCompany extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			DataBase database = new DataBase();
			List<Company> list = database.getCompany();
		
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			out.println("<ul>");
			for (Company company : list) {
				out.println("<li>" + company.getName() + "</li>");
			}
			out.println("</ul>");
			out.println("</html></body>");
			
	}

}
