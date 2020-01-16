package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.gradeDAO;
import dao.spmResultDAO;
import dao.studentDAO;
import model.studentBean;
import dao.subjectDAO;
import model.subjectBean;

/**
 * Servlet implementation class studentController
 */
@WebServlet("/studentController")
public class studentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String REGISTER = "/addStudent.jsp";
	private static String UPDATE = "/student/updateApp.jsp";
	private static String INDEX = "/student/index.jsp";
    private static String VIEW = "/student/viewApp.jsp";
	private static String TESTPAGE = "/student/testPage.jsp";
	private static String SPMPAGE = "/Spm/spm1.jsp";   
	private static String ADDSUBJECT = "/admin/addSubject.jsp";
	private static String INDEXADMIN = "/admin/indexAdmin.jsp";
	private static String DETAILS = "/student/studentSubjectDetails.jsp";

    private studentDAO dao;
    private subjectDAO dao1;
    String forward="";  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public studentController() {
        super();
        dao = new studentDAO();
        dao1 = new subjectDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		   
        String action = request.getParameter("action");

		if (action.equalsIgnoreCase("updateApp")){
					forward = UPDATE;
					String studentIc = request.getParameter("studentIc");
					studentBean user = dao.getUserByIC(studentIc);
	            	request.setAttribute("user", user);
	        }
		
		else if (action.equalsIgnoreCase("viewApp")){
					forward = VIEW;   
					String studentIc = request.getParameter("studentIc");
					studentBean user = dao.getUserByIC(studentIc);
					request.setAttribute("user", user);           
		}

		else if (action.equalsIgnoreCase("home")){
					forward = DETAILS;   
					String studentIc = request.getParameter("studentIc");
					studentBean student = dao.getUserByIC(studentIc);
					request.setAttribute("user", student);
					request.setAttribute("grades", spmResultDAO.getAllGrade(studentIc));  
		}
		
		else if (action.equalsIgnoreCase("testPage")){
			forward = TESTPAGE;   
			//String admin_email= request.getParameter("admin_email");
			//int admin_id = Integer.parseInt(request.getParameter("admin_id"));
			//subjectBean user = dao2.getsubjectById(admin_id);
			//request.setAttribute("user", user);
			//request.setAttribute("admins", dao2.getAllAdminName());
	}
		else if (action.equalsIgnoreCase("spmPage")) {
			forward = SPMPAGE;   
			String studentIc = request.getParameter("studentIc");
			studentBean student = dao.getUserByIC(studentIc);
			request.setAttribute("user", student);
			request.setAttribute("subjects", dao1.getAllSubjectName());
		}
		else if (action.equalsIgnoreCase("details")) {
			forward = DETAILS;
			studentBean student = new studentBean();
			String studentIc = request.getParameter("studentIc");
			student = dao.getUserByIC(studentIc);
			request.setAttribute("user", student);
			request.setAttribute("grades", gradeDAO.getAllGrade(studentIc));
		}
		
		else {
		           forward = REGISTER;
		}
	
		RequestDispatcher view = request.getRequestDispatcher(forward);
	    view.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
				String action = request.getParameter("action");
				
				studentBean user = new studentBean();
				subjectBean subject = new subjectBean();
				
				//user.setstudent_id(Integer.parseInt(request.getParameter("student_id")));
				user.setstudentIc(request.getParameter("studentIc"));
				user.setstudentName(request.getParameter("studentName"));
				user.setstudentPhone(request.getParameter("studentPhone"));
				user.setstudentEmail(request.getParameter("studentEmail"));
				//user.setstudent_pn(request.getParameter("student_pn"));
				//user.setPassword(request.getParameter("password"));
				
			//	String ic = request.getParameter("studentIc");
				
				//user.setstudentIc(ic);
				
				user = studentDAO.getUser(user);
				if (action.equalsIgnoreCase("student")) {

					if(!user.isValid()){
			        	try {
			        	
							dao.addUser(user);
							dao.addStudent(user);
							HttpSession session = request.getSession(true);
	        				session.setAttribute("currentSessionUser", user.getstudentIc());
						} catch (NoSuchAlgorithmException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			        	
			        	forward = SPMPAGE;   
						
						studentBean student = dao.getUserByIC(request.getParameter("studentIc"));
						request.setAttribute("user", student);
						request.setAttribute("subjects", dao1.getAllSubjectName());
						
						RequestDispatcher view = request.getRequestDispatcher(forward);
					    view.forward(request, response);
			        }
					else {
						try {
							studentDAO.updateUserByIC(user);
						} catch (NoSuchAlgorithmException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						user = studentDAO.getSPM(user);
						if(!user.isValid()){ //belum bgi result spm
						
							forward = SPMPAGE;   
							String studentIc = request.getParameter("studentIc");
							studentBean student = dao.getUserByIC(studentIc);
							HttpSession session = request.getSession(true);
	        				session.setAttribute("currentSessionUser", user.getstudentIc());
							request.setAttribute("user", student);
							request.setAttribute("subjects", dao1.getAllSubjectName());
							
							RequestDispatcher view = request.getRequestDispatcher(forward);
						    view.forward(request, response);
						}
						else { //dh bgi result spm
							forward = DETAILS;
								
							String studentIc = request.getParameter("studentIc");
							studentBean student = dao.getUserByIC(studentIc);
							HttpSession session = request.getSession(true);
	        				session.setAttribute("currentSessionUser", user.getstudentIc());
							request.setAttribute("user", student);
							request.setAttribute("grades", spmResultDAO.getAllGrade(studentIc));
							RequestDispatcher view = request.getRequestDispatcher(forward);
							view.forward(request, response);
							
						}
					}
					
				} 

				else if (action.equalsIgnoreCase("spm")) {
					String subjectId[] = request.getParameterValues("subjectId");
					String grade[] = request.getParameterValues("grade");
					String studentIc = request.getParameter("studentIc");
					
					studentBean student = new studentBean();
					student.setstudentIc(studentIc);
					for(int i = 0; i<subjectId.length; i++) {
						subject.setsubjectId(subjectId[i]);
						subject.setGrade(grade[i]);
						try {
							spmResultDAO.addGrade(subject, student);
							
						} catch (NoSuchAlgorithmException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					response.setContentType("text/html");
				      PrintWriter pw = response.getWriter();
				      pw.println("<script>");
				      pw.println("alert('The order has been updated');");
				      pw.println("</script>");
				      
				      forward = DETAILS;
	
						student = dao.getUserByIC(studentIc);
						request.setAttribute("user", student);
						request.setAttribute("grades", spmResultDAO.getAllGrade(studentIc));
						RequestDispatcher view = request.getRequestDispatcher(forward);
						view.forward(request, response);
					
					
				}
				else if (action.equalsIgnoreCase("update")) {
					String subjectId[] = request.getParameterValues("subjectId");
					String grade[] = request.getParameterValues("grade");
					String studentIc = request.getParameter("studentIc");
					
					studentBean student = new studentBean();
					student.setstudentIc(studentIc);
					
					studentDAO.deleteSPM(studentIc);
					for(int i = 0; i<subjectId.length; i++) {
						subject.setsubjectId(subjectId[i]);
						subject.setGrade(grade[i]);
						try {
							spmResultDAO.addGrade(subject, student);
							
						} catch (NoSuchAlgorithmException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					response.setContentType("text/html");
				      PrintWriter pw = response.getWriter();
				      pw.println("<script>");
				      pw.println("alert('The order has been updated');");
				      pw.println("</script>");
				      
				      forward = DETAILS;
	
						student = dao.getUserByIC(studentIc);
						request.setAttribute("user", student);
						request.setAttribute("grades", spmResultDAO.getAllGrade(studentIc));
						RequestDispatcher view = request.getRequestDispatcher(forward);
						view.forward(request, response);
					
					
				}
				
	}
}
