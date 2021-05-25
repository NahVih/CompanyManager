package au.com.alura.manager.servelet;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/editCompany")
public class EditCompany extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		System.out.println(id);
		
		DataBase dataBase = new DataBase();
		Company company = dataBase.editCompany(id);
		System.out.println(company.getName());
		
		request.setAttribute("company", company);
		RequestDispatcher rd = request.getRequestDispatcher("/FormEditABN.jsp");
		rd.forward(request, response);
	}

}
