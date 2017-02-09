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

public class DeleteCustomer extends HttpServlet {
	
	private static final Logger logger = Logger.getLogger(HexConnection.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		
		int check = 0;
		pw.println("trying to connect..");
		
		
		HttpSession s1 = request.getSession(false);
		AuthUsers user =(AuthUsers) s1.getAttribute("user");
		
		if (user != null) {
			
	    int param_id = Integer.parseInt(request.getParameter("id")); // Emp iD to be deleted
	    //pw.println(param_id);
	    
		check = delete(param_id);
		
		}
		
		else
		{
			response.sendRedirect("login.jsp");

			//request.getRequestDispatcher("login.jsp").forward(request, response);
			return; // return from the method and stop the execution of the remnant of the code.
		} 
		
		if (check == 0) {
			//request.setAttribute("delete_fail_message", "Failed to delete Customer Data");
			request.getRequestDispatcher("GetData").forward(request, response);
		
		}
		

		else {

			//request.setAttribute("delete_success_message", "Customer data Deleted Successfully.");
			request.getRequestDispatcher("GetData").forward(request, response);
			
			
		}
	}

	public int delete(int param_id)
			throws ServletException, IOException {
		int check = 1;
	 	System.out.println("Maven + Hibernate + MySQL");
    	
        Session session = HibernateUtil.getSessionFactory().openSession();
       
        try {
    	   
        session.beginTransaction();
 
        Customer c1 = 
                (Customer)session.get(Customer.class,param_id); 
        session.delete(c1);
        
        session.flush();
        session.getTransaction().commit();
	}
        catch(HibernateException e)
        {
        	check = 0;
        	logger.error(e);
        }
        
        finally {
        session.close();
        }
        
		return check;
	}
}
