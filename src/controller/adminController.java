package controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import dao.subjectDAO;
import dao.adminDAO;
import model.adminBean;
import model.subjectBean;

/**
 * Servlet implementation class adminController
 */
@WebServlet("/adminController")
public class adminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String REGISTER = "/addAdmin.jsp";
	private static String UPDATEAPP = "/admin/updateApp.jsp";
    private static String VIEWAPP = "/admin/viewApp.jsp";
    private static String VIEW_LIST = "/admin/viewAppList.jsp";
    private static String LIST_ADMIN = "/admin/listAdmin.jsp";
    private static String VIEWADMIN = "/admin/viewAdmin.jsp";
    private static String UPDATEADMIN = "/admin/updateAdmin.jsp";
    private static String LIST_SUBJECT = "/admin/listSubject.jsp";
    private static String INSERT = "/admin/addSubject.jsp";
    private subjectDAO dao;
    private adminDAO dao2;
    String forward="";  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminController() {
    	super();
        dao = new subjectDAO();
      //  dao2 = new adminDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String action = request.getParameter("action");

		
		 if (action.equalsIgnoreCase("listSubject")){
			forward = LIST_SUBJECT;
			request.setAttribute("subjects", dao.getAllSubject());         
		 }
		 else if(action.equalsIgnoreCase("addSubject")){
	            forward = INSERT;
	        }
		 else if (action.equalsIgnoreCase("deleteSubject")){
				//forward = UPDATEADMIN;   
				String subjectId = request.getParameter("subjectId");
				dao.deleteSubject(subjectId);   
				JOptionPane.showMessageDialog(null, "succesfully deleted" + "!");

				forward = LIST_SUBJECT;   
				request.setAttribute("subjects", dao.getAllSubject());         
		}
		else {
		        forward = REGISTER;
		        request.setAttribute("subjects", dao.getAllSubject());
		}
	
		RequestDispatcher view = request.getRequestDispatcher(forward);
	    view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String action = request.getParameter("action");
		
		subjectBean user = new subjectBean();
		
		if (action.equalsIgnoreCase("subject")){
			
			user.setsubjectId(request.getParameter("subjectId"));
			user.setsubjectName(request.getParameter("subjectName"));
		//	user.setadminPassword(request.getParameter("adminPassword"));
		//	user.setManager_id(Integer.parseInt(request.getParameter("manager_id")));
			
			String id = request.getParameter("subjectId");	

			user.setsubjectId(id);
			
			if(!user.isValid()){
	        	try {
					dao.addSubject(user);
    				//JOptionPane.showMessageDialog(null, "Succefully added" + "!");

				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
	        	//response.sendRedirect("/Rental/admin/indexAdmin.jsp");
	        	RequestDispatcher view = request.getRequestDispatcher("/admin/indexAdmin.jsp");
	            view.forward(request, response);
	        }
			
		}
		
	}

}
