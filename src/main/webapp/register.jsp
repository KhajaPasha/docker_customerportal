<html>
<head>
<script src="validation.js">

</script>

<style>

.wrapper {
    min-height: 100%;
    height: auto !important;
    height: 100%;
    margin: 0 auto -142px; /* the bottom margin is the negative value of the footer's height */
    position: relative;
}
.footer, .push {
    height: 142px; /* .push must be the same height as .footer */
}

legend {
    display: block;
    padding-left: 2px;
    padding-right: 2px;
    border: none;
    font-size: 20px;
}

#header {
	position: relative;
	height: 7em;
	margin-top: -1em;
	margin-left: -1em;
	border-bottom: 1px solid black;
} 

#footer {
	clear: both;
	position: relative;
	z-index: 10;
	height: 3em;
	margin-top: -3em;
}


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



</style>

</head>
<body>

<div class="wrapper">

	<div id="header" style="background-color: #add8e6;">
		<TABLE class="headerclass">
			<tr>
				<TD><img src="hexaware_logo.png" alt="logo" /></TD>
				<TD><h1>DevOps Solutions</h1></TD>
				
			</tr>
		</TABLE>
	</div>
	


<form action="RegisterServlet" method="post" name="Registration" id="registerform">

<fieldset style="padding:20px;top:230px;left:450px; position: absolute;"> 

<legend>Registration</legend>

<TABLE  cellpadding="5">


<TR>
	<TD>Email</TD>
		<TD><INPUT TYPE="TEXT" NAME="email" SIZE="25" id="e_id" required>
		</TD>
</TR>
<TR>
    <TD>Password</TD>
      <TD><INPUT TYPE="password" NAME="password" SIZE="25" id="pass1" required>
	</TD>
</TR>

<TR>
    <TD>Confirm Password</TD>
      <TD><INPUT TYPE="password" NAME="password" SIZE="25" id="pass2" required>
	</TD>
</TR>

<TR>
    
	<TD><button type="submit" form="registerform" value="Register!" onclick="return validate();">Submit</button></TD>
	<TD><a href="login.jsp">Login</a></TD>
	
</TR>

</TABLE>

<div id="msg_position" style="color: #FF0000;">${register_fail_message}</div>

</fieldset> 
</form>

</div>

<div class="footer">
<footer style="position: absolute; left: 60px;">&#169; Hexaware Technologies Limited. All rights reserved 2016 </footer>
</div>

</body>
</html>