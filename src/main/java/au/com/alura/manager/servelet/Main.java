package au.com.alura.manager.servelet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import au.com.alura.manager.actions.CompanyCreated;
import au.com.alura.manager.actions.CompanyEdited;
import au.com.alura.manager.actions.CompanyEditing;
import au.com.alura.manager.actions.CompanyList;
import au.com.alura.manager.actions.CompanyRemoving;


@WebServlet("/main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramAction = request.getParameter("action");
		String name = null;
		if(paramAction.equals("listCompany")) {
						
			CompanyList companyList = new CompanyList();
			name = companyList.action(request, response);
			
		}
		else if (paramAction.equals("companyRemoving")) {
			CompanyRemoving companyRemoving = new CompanyRemoving();
			name = companyRemoving.action(request, response);

		}
		else if (paramAction.equals("companyEditing")) {
			CompanyEditing companyEditing = new CompanyEditing();
			companyEditing.action(request, response);

		}
		else if (paramAction.equals("companyEdited")) {
			CompanyEdited companyEdited = new CompanyEdited();
			companyEdited.action(request, response);

		}
		else if (paramAction.equals("companyCreated")) {
			CompanyCreated companyCreated = new CompanyCreated();
			companyCreated.action(request, response);

		}
		
		String[] typeAddress= name.split(":");
		if(typeAddress[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher(typeAddress[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(typeAddress[1]);
		}
		
		
		
		
	}

}
