package com.org.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.org.pojo.Employee;
import com.org.pojo.ListReturn;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Employee> list = ListReturn.getList();
		PrintWriter writer = response.getWriter();
		request.getRequestDispatcher("index.jsp").include(request, response);
		System.out.println(list);
		writer.println("<table style='border-style:solid><tbody>");
		writer.println("<tr><th>Name</th><th>Password</th><th>Email</th><th>Country</th></tr>");
		for(Employee emp :list)
		{
			System.out.println(emp);
			writer.println("<tr><td>"+emp.getName() +"</td><td>"+emp.getPassword()+"</td><td>"+emp.getEmail()+"</td><td>"+emp.getCountry()+"</td><td><a href='EditServlet'>Edit</a></td><td><a href='DeleteServlet'>Delete</a></td></tr>");
			
		}
		writer.println("</tbody></table>");
		
		
	}

}
