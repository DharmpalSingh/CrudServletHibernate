package com.org.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.org.pojo.Employee;
import com.org.pojo.ListReturn;
import com.org.utils.ConnectionUtils;

/**
 * Servlet implementation class ViewServlet
 */
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Session session = ConnectionUtils.getSessionFactorys().openSession();
		Transaction tx = session.beginTransaction();

		List<Employee> list = (List<Employee>) session.createQuery("from Employee").list();
		PrintWriter writer = response.getWriter();
		writer.println("Hello " + request.getSession(false).getAttribute("name"));
		request.getRequestDispatcher("logInto.jsp").include(request, response);
		System.out.println(list);

		if (list.size() > 0) {
			writer.println("<table style='border-style:solid><tbody>");
			writer.println("<tr><th>Name</th><th>Password</th><th>Email</th><th>Country</th></tr>");

			for (Employee emp : list) {
				System.out.println(emp);
				writer.println("<tr><td>" + emp.getName() + "</td><td>" + emp.getPassword() + "</td><td>"
						+ emp.getEmail() + "</td><td>" + emp.getCountry() + "</td><td><a href='EditServlet?id="
						+ emp.getId() + "'>Edit</a></td><td><a href='DeleteServlet?id=" + emp.getId()
						+ "'>Delete</a></td></tr>");

			}
			writer.println("</tbody></table>");

		} else {
			writer.println("No data available");
		}
	}

}
