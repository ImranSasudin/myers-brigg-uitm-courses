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
        <title>SPM Result | FYP</title>

        <!-- Define Charset -->
        <meta charset="utf-8">

        <!-- Responsive Metatag -->
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

        <!-- Page Description and Author -->
        <meta name="description" content="Sulfur - Responsive HTML5 Template">
        <meta name="author" content="Shahriyar Ahmed">
		 <script  src="asset/jquery/jquery.js"  align="center"> ></script>
        <script>
		$(document).ready(function(){
			$("#add").click(function(e) {
				  $("#spm").append('<div class="spm2"><select name="subjectId">' +
							 '<c:forEach items="${subjects}" var="subjects">' +
					'<option value="${subjects.subjectId}"><c:out value="${subjects.subjectName}" /></option>' +
				'</c:forEach></select> '+
				'<select name="grade"><option value="1">A+</option><option value="2">A</option><option value="3">A-</option>'+
				'<option value="4">B+</option><option value="5">B</option><option value="6">C+</option><option value="7">C</option><option value="8">D</option><option value="9">E</option><option value="10">G</option></select>'+
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
        <link rel="stylesheet" href="/fyp/asset/cs
        s/owl.theme.css" type="text/css">
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
<title>SPM Result</title>
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
                        <a class="navbar-brand" href="/fyp/index.jsp">Course Recommendation based on Myers-Briggs </a>
                    </div>
                </div>
            </div>
            <!-- End Header Logo & Navigation -->
            
 </header>
  <form action="studentController" method="post">
 
<input type="hidden" name="studentIc" value="${user.studentIc}">               

<br>
<br>
<br>

<h2 align="center">Update SPM Result</h2>
 <br><br>
 			
			<div id="spm">
			<div class="spm2">
			
			<select name="subjectId">
			<c:forEach items="${subjects}" var="subjects">
			 <option value="${subjects.subjectId}"><c:out value="${subjects.subjectName}" /></option>
			</c:forEach>
			</select>
			
				<select name="grade">
				<option value="1">A+</option>
				<option value="2">A</option>
				<option value="3">A-</option>
				<option value="4">B+</option>
				<option value="5">B</option>
				<option value="6">C+</option>
				<option value="7">C</option>
				<option value="8">D</option>
				<option value="9">E</option>
				<option value="10">G</option>
			</select>
			
			</div>
			</div>
			
			<button type="button" id="add" role="button">Add Subject</button>
			<br><br>
        	 <button  type="submit" class="button button-block" name="action" value="update">Submit</button>
          </form>
</body>
<input type="hidden"  id="duplicate" value="${duplicate}">
<script>
if($('#duplicate').val() == 'true'){
	alert('Duplicate Subjects');
	}
</script>

</html> 