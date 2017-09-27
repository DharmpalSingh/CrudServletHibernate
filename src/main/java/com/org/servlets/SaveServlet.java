package com.org.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.org.pojo.Employee;
import com.org.utils.ConnectionUtils;

//import com.org.pojo.ListReturn;
//import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

//import org.hibernate.cfg.Configuration;
//import org.hibernate.service.ServiceRegistry;
//import org.hibernate.service.ServiceRegistryBuilder;
/**
 * Servlet implementation class SaveServlet
 */
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaveServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Employee emp = new Employee(request.getParameter("name"), request.getParameter("password"),
				request.getParameter("email"), request.getParameter("country"));
		Session session = ConnectionUtils.getSessionFactorys().openSession();
		Transaction tx = session.beginTransaction();
		//emp.setId(1006);
		session.save(emp);
		tx.commit();
		session.close();

		PrintWriter writer = response.getWriter();
		writer.println("Hello " + request.getSession(false).getAttribute("name"));
		request.getRequestDispatcher("logInto.jsp").include(request, response);
		writer.println("Employee added successfully");

	}

}
