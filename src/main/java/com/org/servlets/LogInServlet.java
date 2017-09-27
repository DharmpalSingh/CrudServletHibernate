package com.org.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.org.pojo.Employee;
import com.org.utils.ConnectionUtils;

/**
 * Servlet implementation class LogInServlet
 */
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession sess = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LogInServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Session session = ConnectionUtils.getSessionFactorys().openSession();
		Transaction tx = session.beginTransaction();

		List<Employee> list = (List<Employee>) session.createQuery("from Employee").list();
		PrintWriter writer = response.getWriter();

		for (Employee emps : list) {
			if (emps.getEmail().equals(email) && emps.getPassword().equals(password)) {
				sess = request.getSession();
				sess.setAttribute("name", emps.getName());
				writer.println("Hello " + emps.getName());
				request.getRequestDispatcher("logInto.jsp").include(request, response);

			}
		}
	}

}
