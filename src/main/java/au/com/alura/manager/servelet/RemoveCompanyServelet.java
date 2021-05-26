package au.com.alura.manager.servelet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import au.com.alura.manager.model.DataBase;


@WebServlet("/removeCompany")
public class RemoveCompanyServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		System.out.println(id);
		
		DataBase dataBase = new DataBase();
		dataBase.removeCompany(id);
		
		response.sendRedirect("listCompany");
	}

}
