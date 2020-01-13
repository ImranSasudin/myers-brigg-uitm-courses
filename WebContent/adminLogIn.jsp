<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<head>
<link rel="stylesheet" href="/fyp/loginR.css">
</head>
<div class="form">
      
      <ul class="tab-group">
       <li class="tab active"><a href="adminLogIn.jsp">Admin</a></li>
      </ul>
      
      <div class="#">  
          <h1>Course Recommendation Based On Myers-Briggs Theory</h1>
          
          <form method="get" action="LogInController" id="loginRAdmin">
          
          <div class="field-wrap">
            <p>Email<span class="req">*</span></p>
			<input type="email" name="email" required autocomplete="off"/>
          </div>
          
          <div class="field-wrap">
            <p>Password<span class="req">*</span></p>
            <input type="password" name="password" required autocomplete="off"/>
          </div>
          
          <br>
          <button type="submit" class="button button-block">SIGN IN</button>
          </form>

      </div><!-- tab-content -->
      
</div> <!-- /form -->