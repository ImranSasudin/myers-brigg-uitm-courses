package controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.spmResultDAO;
import dao.studentDAO;
import model.studentBean;

/**
 * Servlet implementation class personalityController
 */
@WebServlet("/personalityController")
public class personalityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public personalityController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		Integer E = 0, I = 0, S = 0, N = 0, T = 0, F = 0, J = 0, P = 0;
		String section1 = null, section2 = null, section3 = null, section4 = null;
		HttpSession session = request.getSession(true);
		String studentIc = (String) session.getAttribute("currentSessionUser");
		
		studentBean student = new studentBean();
		student.setstudentIc(studentIc);
		
		if(action.equalsIgnoreCase("test")) {
			String q1 = request.getParameter("q1");
			String q2 = request.getParameter("q2");
			String q3 = request.getParameter("q3");
			String q4 = request.getParameter("q4");
			String q5 = request.getParameter("q5");
			String q6 = request.getParameter("q6");
			String q7 = request.getParameter("q7");
			String q8 = request.getParameter("q8");
			String q9 = request.getParameter("q9");
			String q10 = request.getParameter("q10");
			String q11 = request.getParameter("q11");
			String q12 = request.getParameter("q12");
			String q13 = request.getParameter("q13");
			String q14 = request.getParameter("q14");
			String q15 = request.getParameter("q15");
			String q16 = request.getParameter("q16");
			String q17 = request.getParameter("q17");
			String q18 = request.getParameter("q18");
			String q19 = request.getParameter("q19");
			String q20 = request.getParameter("q20");
			
			if(q1.equalsIgnoreCase("a")) {
				E = E + 1;
			}
			else {
				I = I + 1;
			}
			if(q5.equalsIgnoreCase("a")) {
				E = E + 1;
			}
			else {
				I = I + 1;
			}
			if(q9.equalsIgnoreCase("a")) {
				E = E + 1;
			}
			else {
				I = I + 1;
			}
			if(q13.equalsIgnoreCase("a")) {
				E = E + 1;
			}
			else {
				I = I + 1;
			}
			if(q17.equalsIgnoreCase("a")) {
				E = E + 1;
			}
			else {
				I = I + 1;
			}
			if(q2.equalsIgnoreCase("a")) {
				S = S + 1;
			}
			else {
				N = N + 1;
			}
			if(q6.equalsIgnoreCase("a")) {
				S = S + 1;
			}
			else {
				N = N + 1;
			}
			if(q10.equalsIgnoreCase("a")) {
				S = S + 1;
			}
			else {
				N = N + 1;
			}
			if(q14.equalsIgnoreCase("a")) {
				S = S + 1;
			}
			else {
				N = N + 1;
			}
			if(q18.equalsIgnoreCase("a")) {
				S = S + 1;
			}
			else {
				N = N + 1;
			}
			if(q3.equalsIgnoreCase("a")) {
				T = T + 1;
			}
			else {
				F = F + 1;
			}
			if(q7.equalsIgnoreCase("a")) {
				T = T + 1;
			}
			else {
				F = F + 1;
			}
			if(q11.equalsIgnoreCase("a")) {
				T = T + 1;
			}
			else {
				F = F + 1;
			}
			if(q15.equalsIgnoreCase("a")) {
				T = T + 1;
			}
			else {
				F = F + 1;
			}
			if(q19.equalsIgnoreCase("a")) {
				T = T + 1;
			}
			else {
				F = F + 1;
			}
			if(q4.equalsIgnoreCase("a")) {
				J = J + 1;
			}
			else {
				P = P + 1;
			}
			if(q8.equalsIgnoreCase("a")) {
				J = J + 1;
			}
			else {
				P = P + 1;
			}
			if(q12.equalsIgnoreCase("a")) {
				J = J + 1;
			}
			else {
				P = P + 1;
			}
			if(q16.equalsIgnoreCase("a")) {
				J = J + 1;
			}
			else {
				P = P + 1;
			}
			if(q20.equalsIgnoreCase("a")) {
				J = J + 1;
			}
			else {
				P = P + 1;
			}
			
			System.out.println("E:" + E + " I:" + I + " S:" + S + " N:" + N + " T:" + T + " F:" + F + " J:" + J + " P:" + P);
		
			if(E > I) {
				section1 = "E";
			}
			else if(I > E) {
				section1 = "I";
			}
			if(S > N) {
				section2 = "S";
			}
			else if(N > S) {
				section2 = "N";
			}
			if(T > F) {
				section3 = "T";
			}
			else if(F > T) {
				section3 = "F";
			}
			if(J > P) {
				section4 = "J";
			}
			else if(P > J) {
				section4 = "P";
			}
			
			System.out.println("S1:"+ section1 +" S2:" + section2 + " S3:" + section3 + " S4:" + section4);
				
			String resultTest = section1.concat(section2).concat(section3).concat(section4);
			
			System.out.println("Result:" + resultTest);
			
			Integer personalityID = studentDAO.getPersonalityID(resultTest);
			String personalityDesc = studentDAO.getPersonalityDesc(resultTest);
			try {
				studentDAO.updateStudentPersonality(student, personalityID);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String [] personalityType = {"INTP","ISTP","ENTP","ESTP","INTJ","ISTJ"
					,"ENTJ","ESTJ","INFP","ISFP","ENFP","ESFP","INFJ","ISFJ","ENFJ","ESFJ"};
			
			String [] personality1 = {"INTP","ISTP","INTJ","ISTJ","INFP"};
			
			String [] personality2 = {"INTP","ISTJ","ENTJ","ISFJ","ESFJ"};
			
			String [] personality3 = {"ISFP"};
			
			student.setstudentIc(studentIc);
			
			spmResultDAO.getRequirement1(student);
			if(student.isValid()) {
				if(Arrays.asList(personality1).contains(resultTest)) {
					request.setAttribute("faculty1", "Faculty of Computer Science");
					request.setAttribute("course1", "CS110 - Diploma of Science Computer");
				}
				else {
					request.setAttribute("faculty1", null);
					request.setAttribute("course1", null);
				}
			}
			spmResultDAO.getRequirement2(student);
			if(student.isValid()) {
				if(Arrays.asList(personality2).contains(resultTest)) {
					request.setAttribute("faculty2", "Faculty of Accountancy");
					request.setAttribute("course2", "AC110 - Diploma of Accountancy ");
				}
				else {
					request.setAttribute("faculty2", null);
					request.setAttribute("course2", null);
				}
			}
			spmResultDAO.getRequirement3(student);
			if(student.isValid()) {
				if(Arrays.asList(personality3).contains(resultTest)) {
					request.setAttribute("faculty3", "Faculty of Hotel and Tourism Management");
					request.setAttribute("course3", "HM111 - Diploma in Tourism Management ");
				}
				else {
					request.setAttribute("faculty3", null);
					request.setAttribute("course3", null);
				}
			}
			
			request.setAttribute("personalityType", resultTest);
			request.setAttribute("personalityDesc", personalityDesc);
			RequestDispatcher view = request.getRequestDispatcher("/test/testResult.jsp");
            view.forward(request, response);
			
			
			
		}
	}

}
