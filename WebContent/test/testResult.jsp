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

%>
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
                      
                    </div>
                    
                </div>
            </div>
            <!-- End Header Logo & Navigation -->
            
 </header>
  <section class="fun-facts">
  <div class="form">
         <h3>RESULT</h3><br>
            <div class="row"> 
                <div class="col-xs-12 col-sm-12 col-md-12" data-wow-duration="2s" data-wow-delay="300ms">
                <center>
                <h1>${personalityType}</h1><br>
                <h3>${personalityDesc}</h3><br><br>
                </center>
                    
                          		<table border="1" width="50%" align="center">
                          		
                          			<tr>
                          				<th>Faculty</th>
                          				<th>Course</th>
                          			</tr>
                          			<c:choose>
                          				<c:when test="${faculty1 != null}">
                          					<tr>
		                          				<td>${faculty1}</td>
		                          				<td>${course1}</td>
		                          			</tr>
                          				</c:when>
                          				<c:when test="${faculty2 != null}">
                          					<tr>
		                          				<td>${faculty2}</td>
		                          				<td>${course2}</td>
		                          			</tr>
                          				</c:when>
                          				<c:when test="${faculty3 != null}">
                          					<tr>
		                          				<td>${faculty3}</td>
		                          				<td>${course3}</td>
		                          			</tr>
                          				</c:when>
                          			</c:choose>
                          			
                          			


                          		</table>		
                          		<%String studentIc = (String) session.getAttribute("currentSessionUser"); %>
                          		<br><br><center><a href="/fyp/studentController?action=home&studentIc=<%=studentIc%>" value="test" class="btn btn-primary align-center">Home</a></center>			
							
                  </div>
                </div> 

                </div> 
                </section>
                <br><br>
                

</body>

</html> 