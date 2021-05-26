package au.com.alura.manager.servelet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramAction = request.getParameter("action");
		
		if(paramAction.equals("listCompany")) {
			System.out.println("Listing Companies");
		}
		else if (paramAction.equals("companyEdited")) {
			System.out.println("Company Editeding");

		}
	}

}
