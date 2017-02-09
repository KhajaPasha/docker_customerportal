<!DOCTYPE html>
<html>
<head>
<style>
form {
	font-size: 14px;
	font-family: Helvetica, Arial, sans-serif;
	color: rgb(51, 51, 51);
}

body {
	font-size: 14px;
	font-family: Helvetica, Arial, sans-serif;
	color: rgb(51, 51, 51);
}

#footer {
	clear: both;
	position: relative;
	z-index: 10;
	height: 3em;
	margin-top: -3em;
}

#header {
	position: relative;
	height: 7em;
	margin-top: -1em;
	margin-left: -1em;
	border-bottom: 1px solid black;
}

.headerclass {
	margin-left: 4em;
}

hr {
	border: 0;
	height: 0;
	border-top: 1px solid rgba(0, 0, 0, 0.1);
	border-bottom: 1px solid rgba(255, 255, 255, 0.3);
}
</style>

<%@ page import="devops.*"%>

<%@ page import="java.io.*"%>
<%@ page import="javax.servlet.*"%>
<%@ page import="javax.servlet.http.*"%>
<%@ page import="java.io.InputStream"%>

<%@ page import="org.hibernate.cfg.*,org.hibernate.*" %>
<%@ page import="org.hibernate.Session"%>
<%@ page import="java.util.*"%>


<%
    AuthUsers user = (AuthUsers)session.getAttribute("user");
if (user == null) {
	
     
    //session.setAttribute("user",user);  (Dont need to set it again. Valid throughout session)
             
    // The session has been expired (or a hacker supplied a fake cookie)
            	 response.sendRedirect("login.jsp");
             }
    
    else {
    	int clickedLinkId = Integer.parseInt(request.getParameter("id"));
    
%>

</head>
<body>
	<%
			 
			  SessionFactory factory = HibernateUtil.getSessionFactory();
		      Session session1 = factory.openSession();
		 
		      Customer c1 = new Customer();
		      c1 = (Customer) session1.get(Customer.class, clickedLinkId);
		      Transaction tx = null;
		      try {
		    	 
		          tx = session1.getTransaction();
		          tx.begin();                     
		          tx.commit();
		      } catch (Exception e) {
		          if (tx != null) {
		              tx.rollback();
		          }
		          e.printStackTrace();
		      }
		      
		      
		      finally {
		  		session1.close();
		  	}
					 
	%>
	
	
	
	<div id="header" style="background-color: #add8e6;">
		<TABLE class="headerclass">
			<tr>
				<TD><img src="hexaware_logo.png" alt="logo" /></TD>
				<TD><h1>DevOps Solutions</h1></TD>
			</tr>
		</TABLE>
	</div>
	<br />
	<div style="margin-left: 5em;">
		<h3>Edit Customer</h3>
		<hr />
		<FORM METHOD="POST" ACTION="update">
			<TABLE cellspacing="15">
				<TR>
					<TD>Name</TD>
					<TD><INPUT TYPE="TEXT" NAME="name" SIZE="20"
						value="<%=c1.getName()%>" required></TD>
				</TR>
				<TR>
					<TD>Gender</TD>
					<TD><INPUT TYPE="TEXT" NAME="address" SIZE="20"
						value="<%=c1.getAddress()%>" required></TD>
				</TR>
				<TR>
					<TD>Contact Number</TD>
					<TD><INPUT TYPE="TEXT" NAME="contactNumber" SIZE="20"
						value="<%=c1.getContactNumber()%>" required></TD>
				</TR>
				<TR>
					<TD>AlternateContactNumber</TD>
					<TD><INPUT TYPE="TEXT" NAME="alternateContactNumber" SIZE="25"
						value="<%=c1.getAlternateContactNumber()%>" required></TD>
				</TR>
				<TR>
					<TD>Specialty</TD>
					<TD><INPUT TYPE="TEXT" NAME="specialty" SIZE="25"
						value="<%=c1.getSpecialty()%>" required></TD>                                       
				</TR>
				<TR>
					<TD>QualificationSummary</TD>
					<TD><INPUT TYPE="TEXT" NAME="qualificationSummary" SIZE="25"
						value="<%=c1.getQualificationSummary()%>" required></TD>
				</TR>
				<input type="hidden" name="ID_to_update" value="<%=c1.getId()%>">

				<TR>
					<TD></TD>
					<TD><INPUT TYPE="SUBMIT" VALUE="Submit" NAME="B1">
						<INPUT TYPE="RESET" VALUE="Reset" NAME="B2">
					</TD>
				</TR>

			</TABLE>
		</FORM>
		
		<%
    }
	
	%>
		
		<br/>
		
		<div class="msg_position" style="color: #FF0000;">${update_fail_message}</div>
	    <div class="msg_position" style="color: #009933;">${update_success_message}</div>
    
	<a href="GetData"> Back to Customer List</a>
	<br/>
	<hr/>
	<br/>
	<footer>&#169; Hexaware Technologies Limited. All rights reserved 2016 </footer>
	<br/>
	</div>
</body>
</html>
