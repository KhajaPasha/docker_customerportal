package devops;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;  


public class GetData extends HttpServlet {
	
	 public void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		 
		 PrintWriter out=response.getWriter();  
	
	HttpSession session = request.getSession();
	AuthUsers user = (AuthUsers) session.getAttribute("user");
	GetDataService data = new GetDataService();
	List<Customer> customers = data.getList(response,user);
	
	request.setAttribute("customers", customers);
	request.getRequestDispatcher("display.jsp").forward(request, response);
    
	 }

	 

}
