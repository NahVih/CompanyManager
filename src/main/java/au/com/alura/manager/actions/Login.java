package au.com.alura.manager.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import au.com.alura.manager.model.DataBase;
import au.com.alura.manager.model.User;

public class Login implements Operation {

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("login");
		String password = request.getParameter("password");

		System.out.println("Login: " + login);
		
		DataBase database = new DataBase();
		User user = database.isUser(login, password);
		
		if (user != null) {
			System.out.println("Valid User");
			HttpSession session = request.getSession();
			session.setAttribute("userOn", user);
			return "redirect:main?action=CompanyList";
		} else {
			return "redirect:main?action=LoginForm";
		}

		
		
	}

}
