function validatePhoneNo()  
{  
  var phoneno = /^\d{10}$/;  
  
  var phonenocheck = document.getElementById("PhNo").value;
  
  if (phonenocheck.match(phoneno)) 
        {  
      return true;  
        }  
      else  
        {  
        alert("Phone number must be a ten digit valid Number");  
        return false;  
        }  
} 

function validate()
{
	
	var x = document.forms["Registration"]["e_id"].value;
	var atpos = x.indexOf("@");
    var dotpos = x.lastIndexOf(".");
	
     var new_password = document.getElementById("pass1").value;
     var confirm_new_password = document.getElementById("pass2").value;

     if (new_password.length < 3)
     {
         alert("Please ensure your password is at least 3 characters long.");
         return false;
     }
     else if ( new_password != confirm_new_password)
     {
         alert("Passwords do not match.");
         return false;
     }
     
     else if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length) {
         alert("Not a valid e-mail address");
         return false;
     }
     
     
     else
     {
          return true;
     }
 }
