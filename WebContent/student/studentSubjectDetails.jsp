<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/fyp/permohonan2.css">

        <!-- Basic -->
        <title>SPM Result | fyp</title>

        <!-- Define Charset -->
        <meta charset="utf-8">

        <!-- Responsive Metatag -->
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

        <!-- Page Description and Author -->
        <meta name="description" content="Sulfur - Responsive HTML5 Template">
        <meta name="author" content="Shahriyar Ahmed">
		 <script  src="asset/jquery/jquery.js"></script>
        <script>
		$(document).ready(function(){
			$("#add").click(function(e) {
				  $("#spm").append('<div class="spm2"><select name="subjectId">' +
							 '<c:forEach items="${subjects}" var="subjects">' +
					'<option value="${subjects.subjectId}"><c:out value="${subjects.subjectName}" /></option>' +
				'</c:forEach></select> '+
				'<select name="grade"><option value="A+">A+</option><option value="A">A</option><option value="A-">A-</option>'+
				'<option value="B+">B+</option><option value="B">B</option><option value="B-">B-</option></select>'+
				'<input type="button" value="Delete" id="delete"></div>');
				});
			$('body').on('click','#delete',function(e) { 
				$(this).parent('div').remove();
			});
		});
		</script>
		
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


        <script src="asset/js/modernizrr.js"></script>
       
        
<meta charset="ISO-8859-1">
<title>SPM PAGE</title>
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
                        <a class="navbar-brand" href="/fyp/admin/indexAdmin.jsp">Course Recommendation based on Myers-Briggs </a>
                    </div>
                    
                    <div class="navbar-collapse collapse">
                      <ul class="nav navbar-nav navbar-right">
                              <li>
                              	<a href="/fyp/studentController?action=logout">Log Out</a>
                            </li>
                        </ul>
                    </div>
                    
                </div>
            </div>
            <!-- End Header Logo & Navigation -->
            
 </header>
  <section class="fun-facts">
  <div class="form">
         <h3>DETAILS </h3>
            <div class="row"> 
                <div class="col-xs-12 col-sm-12 col-md-12" data-wow-duration="2s" data-wow-delay="300ms">
                    
                          		<table border="0" width="50%" align="center">
                          		
                          			<tr>
                          				<th><label>Ic Number: </label><br></th>
                          				<th><input class="form-control" type="text" name="studentIc" id="studentIc" value="<c:out value="${user.studentIc}" />" readonly> <br></th>
                          			</tr>
                          			<tr>
                          				<th><label>Name:</label><br></th>
                          				<th><input class="form-control"type="text" name="studentName" id="studentName" value="<c:out value="${user.studentName}" />" readonly> <br></th>
                          			</tr>
                          			<tr>
                          				<th><label>Email:</label><br></th>
                          				<th><input class="form-control" type="email" name="studentEmail" id="studentEmail" value="<c:out value="${user.studentEmail}" />" readonly> <br></th>
                          			</tr>
                          			<tr>
                          				<th><label>Phone Number:</label><br></th>
                          				<th><input class="form-control" type="text" name="studentPhone" id="studentPhone" value="<c:out value="${user.studentPhone}" />" readonly> <br></th>
                          			</tr>
                          			<tr>
		                     		<th colspan ="2">
		           
									</th>
		                     		</tr>
                          		</table>								
							
                  </div>
                </div> 
                <table id="subjects" border="1" align="center">
			            <tr>
			                <th>Subject Name</th>   
			                <th>Grade</th>            
			            </tr> 
			       <c:forEach items="${grades}" var="grade">
			                <tr>
			                    <td><c:out value="${grade.subjectName}" /></td>
			                    <td><c:out value="${grade.grade}" /></td>
			                </tr> 
			    </c:forEach>
			    </table><br>
			    <center>
			    <a href="/fyp/studentController?action=updateSPM" class="btn">Resubmit Result</a>
			    </center>
			    <br><br>
			    <center>
			    <a href="/fyp/test/testQuestion.jsp" class="btn btn-primary">Take Test</a>
			    </center>
                </div> 
                </section>
                <br><br>
                

</body>

</html> 