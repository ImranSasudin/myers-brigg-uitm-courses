/**
 * 
 */
package dao;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.connectionManager;
import model.gradeBean;
import model.studentBean;
import model.subjectBean;

/**
 * @author user
 *
 */
public class gradeDAO {
	static Connection currentCon = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;
    static String grade, subjectId, studentIc;
    
    public static void addGrade(subjectBean bean, studentBean student) throws NoSuchAlgorithmException{

        subjectId  = bean.getsubjectId ();
        grade = bean.getGrade();
        studentIc = student.getstudentIc();
   
    	try {
    		
    		
    		currentCon = connectionManager.getConnection();
    		
    		ps=currentCon.prepareStatement("insert into grade (studentIc ,subjectId, grade)values(?,?,?)");
    
    		ps.setString(1,studentIc );
    		ps.setString(2,subjectId);
    		ps.setString(3, grade);
    		ps.executeUpdate();
    	
    	
    		System.out.println("Your ic no is " + studentIc );
    		System.out.println("Your subject no is " + subjectId );
    		System.out.println("Your Grade is " + grade );

            
    	}

    	catch (Exception ex) {
    		System.out.println("failed: An Exception has occurred! " + ex);
    	}

    	finally {
    		if (ps != null) {
    			try {
    				ps.close();
    			} catch (Exception e) {
    			}
    			ps = null;
    		}
    		
    		if (currentCon != null) {
    			try {
    				currentCon.close();
    			} catch (Exception e) {
    			}
    			currentCon = null;
    		}
    	}
    }
    
    public static List<gradeBean> getAllGrade(String studentIc) {
        List<gradeBean> grades = new ArrayList<gradeBean>();
        try {
        	currentCon = connectionManager.getConnection();
        	stmt = currentCon.createStatement();
            ResultSet rs = stmt.executeQuery("select s.subjectName, g.studentIc, g.grade from subjectspm s join grade g "
            		+ "on (g.subjectId = s.subjectId) where g.studentIc = '"+ studentIc +"' order by 1");
            while (rs.next()) {
            	gradeBean grade = new gradeBean();
            	grade.setStudentIc(rs.getString(2));
            	grade.setSubjectName(rs.getString(1));
            	grade.setGrade(rs.getString(3));
           
                grades.add(grade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return grades;
    }

}
