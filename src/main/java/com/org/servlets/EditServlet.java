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
 * Servlet implementation class EditServlet
 */
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditServlet() {
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

		int id = Integer.parseInt(request.getParameter("id"));
		// List<Employee> list = (List<Employee>) session.createQuery("from
		// Employee").list();
		List<Employee> list = (List<Employee>)session.createQuery("from Employee e where e.id =:id").setInteger("id", id).list();
		Iterator<Employee> itr = list.iterator();
		Employee emp =null;
		if(itr.hasNext())
		{
			emp = itr.next();
		}
		
		PrintWriter out = response.getWriter();
		out.println("Hello " + request.getSession(false).getAttribute("name"));
		out.print("<form action='EditServlet2' method='post'>");
		out.print("<table>");

		out.print("<tr><td>Name:</td><td><input type='text' name='name' value='" + emp.getName() + "'/></td></tr>");
		out.print("<tr><td>Password:</td><td><input type='password' name='password' value='" + emp.getPassword()
				+ "'/></td></tr>");
		out.print("<tr><td>Email:</td><td><input type='email' name='email' value='" + emp.getEmail() + "'/></td></tr>");

		out.print("<tr><td>Country:</td><td>");
		out.print("<select name='country' style='width:150px'>");
		out.print("<option>India</option>");
		out.print("<option>USA</option>");
		out.print("<option>UK</option>");
		out.print("<option>Other</option>");
		out.print("</select>");
		out.print("</td></tr>");
		out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");
		out.print("</table>");
		out.print("</form>");
	}

}
