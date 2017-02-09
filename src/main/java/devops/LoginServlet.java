package devops;
 
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import javax.servlet.http.HttpSession;

import devops.*;

import java.io.PrintWriter;  
import java.util.List;
  


public class LoginServlet extends HttpServlet {
	
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	doGet(request, response);
    }
    
    public void doGet(HttpServletRequest request,HttpServletResponse response)
    		throws ServletException, IOException {
     String email1 = request.getParameter("email");   
     String password = request.getParameter("password");
     LoginService loginService = new LoginService();
     boolean result = loginService.authenticateUser(email1, password);
     AuthUsers user = loginService.getUserByEmail(email1);
     if(result == true){
    	 HttpSession session = request.getSession(true);
         session.setAttribute("user", user);    //object is available until on same session 
        
        GetDataService data = new GetDataService();
     	List<Customer> customers = data.getList(response,user);
     	request.setAttribute("customers", customers);
     	request.getRequestDispatcher("display.jsp").forward(request, response);
         
     }
     else{
         //response.sendRedirect("error.jsp");
    	 request.setAttribute("login_fail_message", "Credentials Invalid"); //attribute only available for the next page
		 request.getRequestDispatcher("login.jsp").forward(request, response);           //or till the page finishes loading
     }
}
 
}