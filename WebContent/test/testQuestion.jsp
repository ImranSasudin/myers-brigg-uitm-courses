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
  <form action="/fyp/personalityController" method="post">
  <div class="form">
         <h3>PERSONALITY TEST </h3><br>
            <div class="row"> 
                <div class="col-xs-12 col-sm-12 col-md-12" data-wow-duration="2s" data-wow-delay="300ms">
                    
                          		<table border="1" class="table"  align="center">
                          		
                          			<tr>
                          				<th class="text-center">Num.</th>
                          				<th>Question</th>
                          				<th class="text-center">Answers</th>
                          			</tr>
                          			<tr>
                          				<td rowspan="2" class="text-center">1</td>
                          				<td>expand energy, enjoy groups</td>
                          				<td class="text-center"><input type="radio" name="q1" value="a" required/></td>
                          			</tr>
                          			<tr>
                          				<td>converse energy, enjoy one-on-one</td>
                          				<td class="text-center"><input type="radio" name="q1" value="b"/></td>
                          			</tr>
                          			<tr>
                          				<td colspan="3"></td>
                          			</tr>
                          			<tr>
                          				<td rowspan="2" class="text-center">2</td>
                          				<td>interpret matters literally, rely on common sense</td>
                          				<td class="text-center"><input type="radio" name="q2" value="a" required/></td>
                          			</tr>
                          			<tr>
                          				<td>look for meaning and possibilities, rely on foresight</td>
                          				<td class="text-center"><input type="radio" name="q2" value="b"/></td>
                          			</tr>
                          			<tr>
                          				<td colspan="3"></td>
                          			</tr>
                          			<tr>
                          				<td rowspan="2" class="text-center">3</td>
                          				<td>logical, thinking, questioning</td>
                          				<td class="text-center"><input type="radio" name="q3" value="a" required/></td>
                          			</tr>
                          			<tr>
                          				<td>empathetic, feeling, accommodating</td>
                          				<td class="text-center"><input type="radio" name="q3" value="b"/></td>
                          			</tr>
                          			<tr>
                          				<td colspan="3"></td>
                          			</tr>
                          			<tr>
                          				<td rowspan="2" class="text-center">4</td>
                          				<td>organized, orderly</td>
                          				<td class="text-center"><input type="radio" name="q4" value="a" required/></td>
                          			</tr>
                          			<tr>
                          				<td>flexible, adaptable </td>
                          				<td class="text-center"><input type="radio" name="q4" value="b"/></td>
                          			</tr>
                          			<tr>
                          				<td colspan="3"></td>
                          			</tr>
                          			<tr>
                          				<td rowspan="2" class="text-center">5</td>
                          				<td>more outgoing, think out loud</td>
                          				<td class="text-center"><input type="radio" name="q5" value="a" required/></td>
                          			</tr>
                          			<tr>
                          				<td>more reserved, think to yourself </td>
                          				<td class="text-center"><input type="radio" name="q5" value="b"/></td>
                          			</tr>
                          			<tr>
                          				<td colspan="3"></td>
                          			</tr>
                          			<tr>
                          				<td rowspan="2" class="text-center">6</td>
                          				<td>practical, realistic, experiential </td>
                          				<td class="text-center"><input type="radio" name="q6" value="a" required/></td>
                          			</tr>
                          			<tr>
                          				<td>imaginative, innovative, theoretical</td>
                          				<td class="text-center"><input type="radio" name="q6" value="b"/></td>
                          			</tr>
                          			<tr>
                          				<td colspan="3"></td>
                          			</tr>
                          			<tr>
                          				<td rowspan="2" class="text-center">7</td>
                          				<td>Candid, straight forward, frank</td>
                          				<td class="text-center"><input type="radio" name="q7" value="a" required/></td>
                          			</tr>
                          			<tr>
                          				<td>tactful, kind, encouraging</td>
                          				<td class="text-center"><input type="radio" name="q7" value="b"/></td>
                          			</tr>
                          			<tr>
                          				<td colspan="3"></td>
                          			</tr>
                          			<tr>
                          				<td rowspan="2" class="text-center">8</td>
                          				<td>plan, schedule </td>
                          				<td class="text-center"><input type="radio" name="q8" value="a" required/></td>
                          			</tr>
                          			<tr>
                          				<td>unplanned, spontaneous</td>
                          				<td class="text-center"><input type="radio" name="q8" value="b"/></td>
                          			</tr>
                          			<tr>
                          				<td colspan="3"></td>
                          			</tr>
                          			<tr>
                          				<td rowspan="2" class="text-center">9</td>
                          				<td>Seek many tasks, public activities, interaction with others</td>
                          				<td class="text-center"><input type="radio" name="q9" value="a" required/></td>
                          			</tr>
                          			<tr>
                          				<td>seek more private, solitary activities with quiet to concentrate </td>
                          				<td class="text-center"><input type="radio" name="q9" value="b"/></td>
                          			</tr>
                          			<tr>
                          				<td colspan="3"></td>
                          			</tr>
                          			<tr>
                          				<td rowspan="2" class="text-center">10</td>
                          				<td>standard, usual, conventional</td>
                          				<td class="text-center"><input type="radio" name="q10" value="a" required/></td>
                          			</tr>
                          			<tr>
                          				<td>different, novel, unique</td>
                          				<td class="text-center"><input type="radio" name="q10" value="b"/></td>
                          			</tr>
                          			<tr>
                          				<td colspan="3"></td>
                          			</tr>
                          			<tr>
                          				<td rowspan="2" class="text-center">11</td>
                          				<td>firm, tend to criticize, hold the line</td>
                          				<td class="text-center"><input type="radio" name="q11" value="a" required/></td>
                          			</tr>
                          			<tr>
                          				<td>gentle, tend to appreciate, conciliate </td>
                          				<td class="text-center"><input type="radio" name="q11" value="b"/></td>
                          			</tr>
                          			<tr>
                          				<td colspan="3"></td>
                          			</tr>
                          			<tr>
                          				<td rowspan="2" class="text-center">12</td>
                          				<td>regulated, structured </td>
                          				<td class="text-center"><input type="radio" name="q12" value="a" required/></td>
                          			</tr>
                          			<tr>
                          				<td>easy-going, "live" and "let live" </td>
                          				<td class="text-center"><input type="radio" name="q12" value="b"/></td>
                          			</tr>
                          			<tr>
                          				<td colspan="3"></td>
                          			</tr>
                          			<tr>
                          				<td rowspan="2" class="text-center">13</td>
                          				<td>external, communicative, express yourself</td>
                          				<td class="text-center"><input type="radio" name="q13" value="a" required/></td>
                          			</tr>
                          			<tr>
                          				<td>internal, reticent, keep to yourself</td>
                          				<td class="text-center"><input type="radio" name="q13" value="b"/></td>
                          			</tr>
                          			<tr>
                          				<td colspan="3"></td>
                          			</tr>
                          			<tr>
                          				<td rowspan="2" class="text-center">14</td>
                          				<td>consider immediate issues, focus on the here-and-now</td>
                          				<td class="text-center"><input type="radio" name="q14" value="a" required/></td>
                          			</tr>
                          			<tr>
                          				<td>look at the future, global perspective, ""big picture"</td>
                          				<td class="text-center"><input type="radio" name="q14" value="b"/></td>
                          			</tr>
                          			<tr>
                          				<td colspan="3"></td>
                          			</tr>
                          			<tr>
                          				<td rowspan="2" class="text-center">15</td>
                          				<td>tough-minded, just</td>
                          				<td class="text-center"><input type="radio" name="q15" value="a" required/></td>
                          			</tr>
                          			<tr>
                          				<td>tender-minded, merciful</td>
                          				<td class="text-center"><input type="radio" name="q15" value="b"/></td>
                          			</tr>
                          			<tr>
                          				<td colspan="3"></td>
                          			</tr>
                          			<tr>
                          				<td rowspan="2" class="text-center">16</td>
                          				<td>preparation, plan ahead </td>
                          				<td class="text-center"><input type="radio" name="q16" value="a" required/></td>
                          			</tr>
                          			<tr>
                          				<td>go with the flow, adapt as you go </td>
                          				<td class="text-center"><input type="radio" name="q16" value="b"/></td>
                          			</tr>
                          			<tr>
                          				<td colspan="3"></td>
                          			</tr>
                          			<tr>
                          				<td rowspan="2" class="text-center">17</td>
                          				<td>Active, initiate</td>
                          				<td class="text-center"><input type="radio" name="q17" value="a" required/></td>
                          			</tr>
                          			<tr>
                          				<td>reflective, deliberate </td>
                          				<td class="text-center"><input type="radio" name="q17" value="b"/></td>
                          			</tr>
                          			<tr>
                          				<td colspan="3"></td>
                          			</tr>
                          			<tr>
                          				<td rowspan="2" class="text-center">18</td>
                          				<td>Facts, things, seeing "what is" </td>
                          				<td class="text-center"><input type="radio" name="q18" value="a" required/></td>
                          			</tr>
                          			<tr>
                          				<td>ideas, dreams, seeing "what could be" philosophical</td>
                          				<td class="text-center"><input type="radio" name="q18" value="b"/></td>
                          			</tr>
                          			<tr>
                          				<td colspan="3"></td>
                          			</tr>
                          			<tr>
                          				<td rowspan="2" class="text-center">19</td>
                          				<td>matter of fact, issues-oriented, principled </td>
                          				<td class="text-center"><input type="radio" name="q19" value="a" required/></td>
                          			</tr>
                          			<tr>
                          				<td>sensitive, people-oriented, compassionate </td>
                          				<td class="text-center"><input type="radio" name="q19" value="b"/></td>
                          			</tr>
                          			<tr>
                          				<td colspan="3"></td>
                          			</tr>
                          			<tr>
                          				<td rowspan="2" class="text-center">20</td>
                          				<td>control, govern </td>
                          				<td class="text-center"><input type="radio" name="q20" value="a" required/></td>
                          			</tr>
                          			<tr>
                          				<td>latitude , freedom </td>
                          				<td class="text-center"><input type="radio" name="q20" value="b"/></td>
                          			</tr>
                          			<tr>
                          				<td colspan="3"></td>
                          			</tr>


                          		</table>		
                          		<br><br><center><button name="action" value="test" class="btn btn-primary align-center">Submit</button></center>			
							
                  </div>
                </div> 

                </div> 
                </form>
                </section>
                <br><br>
                

</body>

</html> 