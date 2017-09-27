package com.org.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.org.pojo.Employee;
import com.org.utils.ConnectionUtils;

/**
 * Servlet implementation class DeleteServlet
 */
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Session session = ConnectionUtils.getSessionFactorys().openSession();
		Transaction tx = session.beginTransaction();

		int id = Integer.parseInt(request.getParameter("id"));
		// List<Employee> list = (List<Employee>) session.createQuery("from
		// Employee").list();
		List<Employee> list = (List<Employee>) session.createQuery("from Employee e where e.id =:id")
				.setInteger("id", id).list();
		Iterator<Employee> itr = list.iterator();
		Employee emp = null;
		if (itr.hasNext()) {
			emp = itr.next();
		}
		session.delete(emp);
		tx.commit();
		session.close();
		PrintWriter writer = response.getWriter();

		writer.println("Hello " + request.getSession(false).getAttribute("name"));
		request.getRequestDispatcher("logInto.jsp").include(request, response);
		writer.println("Employee deleted  successfully");
		writer.close();
	}

}
