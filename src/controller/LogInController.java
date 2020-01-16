package controller;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import connection.connectionManager;
//import dao;
import model.adminBean;
import dao.studentDAO;
import dao.adminDAO;
import model.studentBean;


/**
 * Servlet implementation class LogInController
 */
@WebServlet("/LogInController")
public class LogInController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private  dao;
	private studentDAO daoA;
	private adminDAO dao;
	
    HttpServletRequest request;
    HttpServletResponse response;
    String forward="";
    String action="";
    
    static Connection currentCon = null;
    static ResultSet rs = null;
    static PreparedStatement ps=null;
    static Statement stmt=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogInController() {
        super();
        dao = new adminDAO();
        daoA = new studentDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		action = request.getParameter("action");
		
        	try {
        		adminBean user = new adminBean();
        		user.setadminIc(request.getParameter("adminIc"));
    			user.setadminPassword(request.getParameter("password"));
    			/*
        		studentBean userA = new studentBean();
        		userA.setstudent_emai(request.getParameter("email"));
    			userA.setPassword(request.getParameter("password"));
    			*/

    			user = adminDAO.adminLogIn(user);
    			//userA = studentDAO.loginUser(userA);

    			if(user.isValid())
    			{
    				String searchQuery = "select * from users where useric='" + user.getadminIc() + "'";
    				currentCon = connectionManager.getConnection();
    				stmt = currentCon.createStatement();
    				rs= stmt.executeQuery(searchQuery);
    				boolean more = rs.next();
    				
    				if(more) {
    					String adminIc = rs.getString("useric");
    					HttpSession session = request.getSession(true);
        				session.setAttribute("currentSessionUser", adminIc);
        				RequestDispatcher view = request.getRequestDispatcher("/admin/indexAdmin.jsp");
        	            view.forward(request, response);
    				
    				}
    		
    			}    			
    			else
    			{
    				JOptionPane.showMessageDialog(null, "Incorrect Username and Password" + "!");
    				RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
    				view.forward(request, response);
    			}
    		}

    		catch (Throwable ex) {
    			System.out.println(ex);
    		}
 
	}


}
