<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
  response.setHeader("Cache-Control","no-cache");
  response.setHeader("Cache-Control","no-store");
  response.setHeader("Pragma","no-cache");
  response.setDateHeader ("Expires", 0);
  
  if(session.getAttribute("currentSessionUser1")==null)
      response.sendRedirect("/fyp/addStudent.jsp");
%>

 
%>
<%----%>
      
      
<!DOCTYPE html>
<html lang = "en">

<head>

<title>CRMB</title>

 <!-- Define Charset -->
 
        <meta charset="utf-8">

        <!-- Responsive Metatag -->
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

        <!-- Page Description and Author -->
        <meta name="description" content="Sulfur - Responsive HTML5 Template">
        <meta name="author" content="Shahriyar Ahmed">

        <!-- Bootstrap CSS  -->
        <link rel="stylesheet" href="/fyp/asset/bootstrap/css/bootstrap.min.css" type="text/css">

        <!-- Font Awesome CSS -->
        <link rel="stylesheet" href="/fyp/asset/font-awesome/css/font-awesome.min.css" type="text/css">

        <!-- Owl Carousel CSS -->
        <link rel="stylesheet" href="/fyp/asset/css/owl.carousel.css" type="text/css">
        <link rel="stylesheet" href="/fyp/asset/css/owl.theme.css" type="text/css">
        <link rel="stylesheet" href="/fyp/asset/css/owl.transitions.css" type="text/css">
        
        <!-- Css3 Transitions Styles  -->
        <link rel="stylesheet" type="text/css" href="/fyp/asset/css/animate.css">
        
        <!-- Lightbox CSS -->
        <link rel="stylesheet" type="text/css" href="/fyp/asset/css/lightbox.css">

        <!-- Sulfur CSS Styles  -->
        <link rel="stylesheet" type="text/css" href="/fyp/asset/css/style.css">

        <!-- Responsive CSS Style -->
        <link rel="stylesheet" type="text/css" href="/fyp/asset/css/responsive.css">
        
        <link rel="stylesheet" href="/fyp/permohonan2.css">


        <script src="/fyp/asset/js/modernizrr.js"></script>

</head>
<body>

     <header class="clearfix">
        
            <!-- Start  Logo & Navigation  -->
            <div class="navbar navbar-default navbar-top">
                <div class="container">
                    <div class="navbar-header">
                        <!-- Stat Toggle Nav Link For Mobiles -->
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                            <i class="fa fa-bars"></i>
                        </button>
                        <!-- End Toggle Nav Link For Mobiles -->
                        <a class="navbar-brand" href="/fyp/student/index.jsp">Sistem Sewaan Barang</a>
                    </div>
                    <div class="navbar-collapse collapse">
                        
                        <!-- Start Navigation List -->
                        <ul class="nav navbar-nav navbar-right">
                            <li>
                                <a class="active" href="/fyp/index.jsp">Student</a>
                            </li>
                            <li>
                                <a class="active" href="/fyp/index.jsp">Admin</a>
                            </li>
                            <li>
                                <a class="active" href="/fyp/index.jsp">About MBTI</a>
                            </li>
                            <li>
                                <a class="active" href="/fyp/index.jsp">About Test</a>
                            </li>    
                        </ul>
                        
                        <!-- End Navigation List -->
                        
                        
                    </div>
                </div>
            </div>
            <!-- End Header Logo & Navigation -->  
        </header>
 

<!-- Start Form Section -->
    <section class="fun-facts">
    
        <div class="form">
         <h3>DETAILS </h3>
            <div class="row"> 
                <div class="col-xs-12 col-sm-12 col-md-12" data-wow-duration="2s" data-wow-delay="300ms">
                     <form>
                          		<table border="0" width="50%" align="center">
                          		
                          			<tr>
                          				<th><label>Ic Number: </label><br></th>
                          				<th><input class="form-control" type="text" name="studentIc" id="studentIc" value="<c:out value="${user.studentIc}" />" readonly> <br></th>
                          			</tr>
                          			<tr>
                          				<th><label>Name:</label><br></th>
                          				<th><input class="form-control"type="text" name="student_name" id="student_name" value="<c:out value="${user.student_name}" />" readonly> <br></th>
                          			</tr>
                          			<tr>
                          				<th><label>Email:</label><br></th>
                          				<th><input class="form-control" type="email" name="student_email" id="student_email" value="<c:out value="${user.student_email}" />" readonly> <br></th>
                          			</tr>
                          			<tr>
                          				<th><label>Phone Number:</label><br></th>
                          				<th><input class="form-control" type="text" name="student_pn" id="student_pn" value="<c:out value="${user.student_pn}" />" readonly> <br></th>
                          			</tr>
                          			<tr>
		                     		<th colspan ="2">
		           
									</th>
		                     		</tr>
                          		</table>								
							</form>
                  </div>
                </div> 
                </div> 
    </section>
    <!-- End Form Section -->	
    
	<!-- Sulfur JS File -->
        <script src="/fyp/sset/js/jquery-2.1.3.min.js"></script>
        <script src="/fyp/asset/js/jquery-migrate-1.2.1.min.js"></script>
        <script src="/fyp/asset/bootstrap/js/bootstrap.min.js"></script>
        <script src="/fyp/asset/js/owl.carousel.min.js"></script>
        <script src="/fyp/asset/js/jquery.appear.js"></script>
        <script src="/fyp/asset/js/jquery.fitvids.js"></script>
        <script src="/fyp/asset/js/jquery.nicescroll.min.js"></script>
        <script src="/fyp/asset/js/lightbox.min.js"></script>
        <script src="/fyp/asset/js/count-to.js"></script>
        <script src="/fyp/asset/js/styleswitcher.js"></script>
        
        <script src="/fyp/asset/js/map.js"></script>
        <script src="/fyp/http://maps.googleapis.com/maps/api/js?sensor=false"></script>
        <script src="/fyp/asset/js/script.js"></script> 
        
</body>
</html>