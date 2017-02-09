<html>
<head>

<title>UserLogin</title>
<link rel="shortcut icon" href="favicon.ico" />
<link rel="stylesheet" type="text/css" href="PageStyle.css">

</head>
<body>

<%@ page session="false" %>
           <%@ page import="devops.*"%>
	       <%@ page import="java.util.Properties"%>
	       <%@ page import="java.io.*"%>
	       <%
     Properties prop = new Properties();
     InputStream input = null;
		String filename = "database_config.properties";
		input = getClass().getClassLoader().getResourceAsStream(
				filename);
		if (input == null) {
			System.out.println("Sorry, unable to find " + filename);
			//pw.println("file not found");
			return;
		}

		//load a properties file from class path, inside static method
		prop.load(input);
		String productVersion = prop.getProperty("product_version");
           %>
<div class="wrapper">

	<div id="header" style="background-color: #add8e6;">
		<TABLE class="headerclass">
			<tr>
				<TD><img src="hexaware_logo.png" alt="logo" /></TD>
				<TD><h1>DevOps Solutions</h1></TD>
				<TD>
				<TABLE class="productVersionclass">
				<tr>
				<TD>Product Version: <%= productVersion %></TD>
				</tr>
				</TABLE>
				</TD>
            
			</tr>
		</TABLE>
	</div>



<form action="LoginServlet" method="post" >

<fieldset style="padding:30px;top:230px;left:450px; position: absolute;">

<legend>Login</legend>


<TABLE cellpadding="5">


<TR>
	<TD>Email</TD>
		<TD><INPUT TYPE="TEXT" NAME="email" SIZE="25" required></TD>
</TR>
<TR>
    <TD>Password</TD>
      <TD><INPUT TYPE="password" NAME="password" SIZE="25" required></TD>
</TR>

<TR>
    
	<TD><INPUT TYPE="SUBMIT" VALUE="Login!" NAME="B1"> </TD>
	     <TD><a href="register.jsp">Register</a></TD>
</TR>

</TABLE>

<div id="msg_position" style="color: #FF0000;">${login_fail_message}</div>

</fieldset>

</form>
<div class="push"></div>


</div>




<div class="footer">
<footer style="position: absolute; left: 60px;">&#169; Hexaware Technologies Limited. All rights reserved 2016 </footer>
</div>


</body>
</html>