package au.com.alura.manager.servelet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import au.com.alura.manager.actions.Operation;


@WebServlet("/main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramAction = request.getParameter("action");
		
		
		HttpSession session = request.getSession();
		boolean userOn = (session.getAttribute("userOn")==null);
		boolean protectedAction = !(paramAction.equals("Login") || paramAction.equals("LoginForm"));
		if (protectedAction && userOn) {
			response.sendRedirect("main?action=LoginForm");
			return;
		}
		
		
	
		
		String className = "au.com.alura.manager.actions." + paramAction;
		
		String name = null;
		
		
		try {
			Class<?> xclass = Class.forName(className);
			Operation operation = (Operation) xclass.newInstance();
			name = operation.action(request,response);
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}
		
		String[] typeAddress= name.split(":");
		if(typeAddress[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + typeAddress[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(typeAddress[1]);
		}
		
		
//		paramAction.run(req,res);
		
//		String name = null;
//		if(paramAction.equals("CompanyList")) {
//						
//			CompanyList companyList = new CompanyList();
//			name = companyList.action(request, response);
//			
//		}
//		else if (paramAction.equals("CompanyRemoving")) {
//			CompanyRemoving companyRemoving = new CompanyRemoving();
//			name = companyRemoving.action(request, response);
//
//		}
//		else if (paramAction.equals("CompanyEditing")) {
//			CompanyEditing companyEditing = new CompanyEditing();
//			name = companyEditing.action(request, response);
//
//		}
//		else if (paramAction.equals("CompanyEdited")) {
//			CompanyEdited companyEdited = new CompanyEdited();
//			name = companyEdited.action(request, response);
//
//		}
//		else if (paramAction.equals("CompanyCreated")) {
//			CompanyCreated companyCreated = new CompanyCreated();
//			name = companyCreated.action(request, response);
//
//		}else if (paramAction.equals("CompanyNew")) {
//			CompanyNew companyNew = new CompanyNew();
//			name = companyNew.action(request, response);
//
//		}
		
			
		
	}

}
