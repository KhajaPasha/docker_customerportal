package devops;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.sql.*;
import java.util.Properties;

public class AddCustomer extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(HexConnection.class);

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String contactNumber = request.getParameter("contactNumber");
		String alternateContactNumber = request.getParameter("alternateContactNumber");
		String specialty = request.getParameter("specialty");
		String qualificationSummary = request.getParameter("qualificationSummary");
		
		pw.println("trying to connect..");

		pw.println("Values Inputted");

		
        int checkResult;
		
		HttpSession s1 = request.getSession(false);
		AuthUsers user =(AuthUsers) s1.getAttribute("user");
		
		if ( user != null )
		{
		 checkResult = add(name, address, contactNumber, alternateContactNumber, specialty, qualificationSummary);

		}
		else
		{
		    request.getRequestDispatcher("login.jsp").forward(request, response);
			return; // return from the method and stop the execution of the remnant of the code yourself.
		}
		
		
		if ( checkResult == 0) {
			request.setAttribute("add_fail_message", "Failed to Add new Customer.");
			request.getRequestDispatcher("add_new.jsp").forward(request, response);
		}

		else {
			request.setAttribute("add_success_message", "New Customer Added to Database.");
			request.getRequestDispatcher("add_new.jsp").forward(request, response);
		}
	}

	public int add(String name, String address, String contactNumber, String alternateContactNumber, String specialty, String qualificationSummary)
			throws ServletException, IOException {
		int check = 1;
   	System.out.println("Maven + Hibernate + MySQL");
    	
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try {
        
        session.beginTransaction();
        Customer c1 = new Customer();
        
        c1.setName(name);
        c1.setAddress(address);
        c1.setContactNumber(contactNumber);
        c1.setAlternateContactNumber(alternateContactNumber);
        c1.setSpecialty(specialty);
        c1.setQualificationSummary(qualificationSummary);
        
        session.save(c1);
        session.flush();
        session.getTransaction().commit();
        
        }
        	
        
       catch(HibernateException e) {
    	 check = 0;
    	 logger.error(e);
       }
        
        finally {
        session.close();
        }
        

			//check = prep.executeUpdate();

			//prep.close();
		
		return check;
	}

}
