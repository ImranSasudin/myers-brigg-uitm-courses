<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
    <%
  response.setHeader("Cache-Control","no-cache");
  response.setHeader("Cache-Control","no-store");
  response.setHeader("Pragma","no-cache");
  response.setDateHeader ("Expires", 0);
  if(session.getAttribute("currentSessionUser")==null)
      response.sendRedirect("/fyp/adminLogIn.jsp");
%>
<!DOCTYPE html>
<html>
<head>

        <!-- Basic -->
        <title>ADD SUBJECT | FYP</title>

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


        <script src="/fyp/asset/js/modernizrr.js"></script>
<style>
#customers {
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 100%;
    align: center;
    padding-left: 40px;
    padding-right: 40px;
}

#customers td, #customers th {
    border: 1px solid #ddd;
    padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}


#customers th {
    padding-top: 15px;
    padding-bottom: 12px;
    text-align: left;
    background-color: #1ab188;
    color: white;
}
</style>
</head>
<body>
<%	String adminEmail = (String)session.getAttribute("currentSessionUser");%>

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
                        <a class="navbar-brand" href="/fyp/admin/indexAdmin.jsp">Course Recommendation Based on Myers-Briggs Theory</a>
                    </div>
                    <div class="navbar-collapse collapse">
                        
                       <!-- Start Navigation List -->
                        <ul class="nav navbar-nav navbar-right">
                           <li>
                                <a href="/fyp/adminController?action=listStudent">Student List</a>
                            </li>
                            <li>
                                <a href="/fyp/adminController?action=listCourse">Course List</a>
                            </li>
                           
                              <li>
                              	<a href="/fyp/adminController?action=logout">Log Out</a>
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
            <!--<div class="row">-->
        <div class="form">
          <h3>List Students</h3>
          <br/>
        <form>
		<table class="table" id="subjects" border="1">
            <tr>
                <th>Faculty</th>
                <th>Course</th>   

            </tr> 
       <c:forEach items="${courses}" var="course">
 
                <tr>
                    <td><c:out value="${course.courseFaculty}" /></td>
                    <td><c:out value="${course.courseName}" /></td>
                    
                </tr> 
    </c:forEach>
    </table>
    </form> 
    		</div>
    </div>
    </div>
    
</section>
    
       <!-- Sulfur JS File -->
        <script src="/fyp/asset/js/jquery-2.1.3.min.js"></script>
        <script src="/fyp/asset/js/jquery-migrate-1.2.1.min.js"></script>
        <script src="/fyp/asset/bootstrap/js/bootstrap.min.js"></script>
        <script src="/fyp/asset/js/owl.carousel.min.js"></script>
        <script src="/fyp/asset/js/jquery.appear.js"></script>
        <script src="/fyp/asset/js/jquery.fitvids.js"></script>
        <script src="/fyp/asset/js/jquery.nicescroll.min.js"></script>
        <script src="/fyp/asset/js/lightbox.min.js"></script>
        <script src="/fyp/vasset/js/count-to.js"></script>
        <script src="/fyp/asset/js/styleswitcher.js"></script>
        
        <script src="/fyp/asset/js/map.js"></script>
        <script src="http://maps.googleapis.com/maps/api/js?sensor=false"></script>
        <script src="/fyp/asset/js/script.js"></script> 
        
        
        <!-- jQuery -->
    <script src="/fyp/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/fyp/bootstrap-loan/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="/fyp/metisMenu/metisMenu.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src="/fyp/raphael/raphael.min.js"></script>
    <script src="/fyp/morrisjs/morris.min.js"></script>
    <script src="/fyp/data/morris-data.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="/fyp/dist/js/sb-admin-2.js"></script>
    
    </body>
</html>