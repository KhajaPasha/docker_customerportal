package devops;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.servlet.http.HttpServletResponse;

public class GetDataService {
	public List<Customer> getList(HttpServletResponse res,AuthUsers auth1)throws IOException {
		
	      List<Customer> customers = new ArrayList<Customer>();
		  SessionFactory factory = HibernateUtil.getSessionFactory();
	      Session session = factory.openSession();
	 
	      if (auth1 == null || auth1.getEmail() == null) {
	    	  //customers = null;
	    	  
	    	  res.sendRedirect("login.jsp"); //to call a jsp from a java class: you need to use HttpServletResponse
	      }
	      
	      
	      else {
	      Transaction tx = null;
	      try {
	          tx = session.getTransaction();
	          tx.begin();
	          customers = session.createQuery("from Customer").list();                       
	          tx.commit();
	      } catch (Exception e) {
	          if (tx != null) {
	              tx.rollback();
	          }
	          e.printStackTrace();
	      }
	      
	      finally {
	    	  session.flush();
	    	  session.close();
	      }
	      
	      }
	      
	      return customers;
	    
	}
	

}
