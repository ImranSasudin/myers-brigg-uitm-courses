              
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<head>
                        
<link rel="stylesheet" href="/fyp/register.css">
<script type="text/javascript" src="http:/ajax.googleapis.com/ajax/libs/jquery/1,8.3/jquery.min.js"></script>
<style>.alert {
	padding:20;
	background-color:#f44336;
	color:white;
}
</style>
<script>               

	function myDaftar(){
		var ic = document.getElementById("studentIc");
		var name = document.getElementById("studentName");
		//var add = document.getElementById("student_add");
		var phone = document.getElementById("studentPhone");
		var email = document.getElementById("studentEmail");
		//var pass = document.getElementById("student_pass");
		
		if(ic == null){
			alert("Enter your ic");			
		}
		else if(name == null){
			alert("Enter you IC name");
		}/*
		else if(add == null){
			alert("Sila isikan alamat");
		}*/
		else if(email == null){
			alert("Enter your email");
		}
		else if(phone == null){
			alert("Enter your phone number");
		}/*
		else if(pass == null){
			alert("Sila isikan kata laluan");
		}*/
		else{
				alert("Successful");
			}
		}
	
</script>

</head>
<center>
<div class="form">
        <div id="studentDetails">   
        <title>Student Information | FYP</title>
          <center><h2>COURSE RECOMMENDATION BASED ON MYERS-BRIGGS THEORY</h2></center>
          <h1 class="register-title">Student Information</h1>
          <form method="post" action="studentController?action=student">
          
          <div class="field-wrap">
            <p>IC Number<span class="req">*</span></p>
            <input type="text" name="studentIc" id="studentIc" required autocomplete="off"/>
          </div>
          
          
          <div class="field-wrap">
            <p>Name<span class="req">*</span></p>
			<input type="text" name="studentName" id="studentName" required autocomplete="off"/>
          </div>
          
		  
		   <div class="field-wrap">
            <p>Email<span class="req">*</span></p>
            <input type="email" name="studentEmail" id="studentEmail" required autocomplete="off"/>
          </div>
		  
		   <div class="field-wrap">
            <p>Phone Number<span class="req">*</span></p>
            <input type="text" name="studentPhone"  id="studentPhone" required autocomplete="off"/>
          </div>
          
         <br>
          <button type="submit" class="button button-block" onClick="myDaftar()">Next</button>
		  
          </form>
 </center>
  