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

public class spmResultDAO {

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
    		
    		ps=currentCon.prepareStatement("insert into spmresult (userid ,subjectId, gradeid)values(?,?,?)");
    
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
            ResultSet rs = stmt.executeQuery("select ss.subjectName, g.gradename from student s join spmresult sr on (s.userid = sr.userid) join grade g on (g.gradeid = sr.gradeid)" + 
            		"join spmsubject ss on (ss.subjectid = sr.subjectid) where s.userid = '"+ studentIc +"' order by 1");
            while (rs.next()) {
            	gradeBean grade = new gradeBean();
            	grade.setSubjectName(rs.getString(1));
            	grade.setGrade(rs.getString(2));
           
                grades.add(grade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return grades;
    }
    

}
