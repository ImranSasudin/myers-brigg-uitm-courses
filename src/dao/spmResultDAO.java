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
    public static studentBean getRequirement1(studentBean bean)  {
    	
        studentIc = bean.getstudentIc();

        String searchQuery = "select (select count(s.userid) from student s join spmresult sr on (s.userid = sr.userid) join grade g on (g.gradeid = sr.gradeid)" + 
        		"join spmsubject ss on (ss.subjectid = sr.subjectid) where s.userid = '" + studentIc +"' " + 
        		"AND ((g.grademark >= 4 AND sr.subjectid = '1')" + 
        		"OR (g.grademark >= 4 AND sr.subjectid = '2')" + 
        		"OR (g.grademark >= 4 AND sr.subjectid = '3')" + 
        		"OR (g.grademark >= 1 AND (sr.subjectid = '5')))) as count1,(select count(s.userid) from student s join spmresult sr on (s.userid = sr.userid) join grade g on (g.gradeid = sr.gradeid)" + 
        		"join spmsubject ss on (ss.subjectid = sr.subjectid) where s.userid = '" + studentIc +"' " + 
        		"AND (g.grademark >= 4 " + 
        		"AND (sr.subjectid = '4' OR sr.subjectid= '10' OR sr.subjectid = '9' OR sr.subjectid ='21'))) as count2 from dual";

        try {
            currentCon = connectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean more = rs.next();

            // if user exists set the isValid variable to true
            if (more) {
            	Integer count1 = rs.getInt(1);
            	Integer count2 = rs.getInt(2);
            	
            	if(count1 == 4 && count2 >= 1) {
            		bean.setValid(true);
            	}
            	else {
            		bean.setValid(false);
            	}
           
                
           	}
           
            else if (!more) {
            	System.out.println("Sorry");
            	bean.setValid(false);
            }
           
        }

        catch (Exception ex) {
            System.out.println("Log In failed: An Exception has occurred! " + ex);
        }

        finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                }
                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception e) {
                }
                stmt = null;
            }

            if (currentCon != null) {
                try {
                    currentCon.close();
                } catch (Exception e) {
                }

                currentCon = null;
            }
        }

        return bean;
    }
public static studentBean getRequirement2(studentBean bean)  {
    	
        studentIc = bean.getstudentIc();

        String searchQuery = "select (select count(s.userid) from student s join spmresult sr on (s.userid = sr.userid) join grade g on (g.gradeid = sr.gradeid)" + 
        		"join spmsubject ss on (ss.subjectid = sr.subjectid) where s.userid = '" + studentIc +"' " + 
        		"AND ((g.grademark >= 5 AND (sr.subjectid = '5'))" + 
        		"OR (g.grademark >= 1 AND (sr.subjectid = '6'))" + 
        		"OR (g.grademark >= 4 AND (sr.subjectid = '1')))) as count1,(select count(s.userid) from student s join spmresult sr on (s.userid = sr.userid) join grade g on (g.gradeid = sr.gradeid)" + 
        		"join spmsubject ss on (ss.subjectid = sr.subjectid) where s.userid = '" + studentIc +"' " + 
        		"AND (g.grademark >= 4 " + 
        		"AND (sr.subjectid = '2' OR sr.subjectid= '3'))) as count2, (select count(s.userid) from student s join spmresult sr on (s.userid = sr.userid) join grade g on (g.gradeid = sr.gradeid)" + 
        		"join spmsubject ss on (ss.subjectid = sr.subjectid) where s.userid = '" + studentIc +"' " + 
        		"AND (g.grademark >= 4)) as count3 from dual";

        try {
            currentCon = connectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean more = rs.next();

            // if user exists set the isValid variable to true
            if (more) {
            	Integer count1 = rs.getInt(1);
            	Integer count2 = rs.getInt(2);
            	Integer count3 = rs.getInt(3);
            	
            	if(count1 == 3 && count2 >= 1 && count3 >= 5) {
            		bean.setValid(true);
            	}
            	else {
            		bean.setValid(false);
            	}
           
                
           	}
           
            else if (!more) {
            	System.out.println("Sorry");
            	bean.setValid(false);
            }
           
        }

        catch (Exception ex) {
            System.out.println("Log In failed: An Exception has occurred! " + ex);
        }

        finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                }
                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception e) {
                }
                stmt = null;
            }

            if (currentCon != null) {
                try {
                    currentCon.close();
                } catch (Exception e) {
                }

                currentCon = null;
            }
        }

        return bean;
    }
public static studentBean getRequirement3(studentBean bean)  {
	
    studentIc = bean.getstudentIc();

    String searchQuery = "select count(s.userid) as count1 from student s join spmresult sr on (s.userid = sr.userid) join grade g on (g.gradeid = sr.gradeid)" + 
    		"join spmsubject ss on (ss.subjectid = sr.subjectid) where s.userid = '" + studentIc +"' " + 
    		"AND (g.grademark >= 4 " + 
    		"AND (sr.subjectid = '1' OR sr.subjectid= '2' OR sr.subjectid = '5'))";

    try {
        currentCon = connectionManager.getConnection();
        stmt = currentCon.createStatement();
        rs = stmt.executeQuery(searchQuery);
        boolean more = rs.next();

        // if user exists set the isValid variable to true
        if (more) {
        	Integer count1 = rs.getInt(1);
 
        	
        	if(count1 == 3) {
        		bean.setValid(true);
        	}
        	else {
        		bean.setValid(false);
        	}
       
            
       	}
       
        else if (!more) {
        	System.out.println("Sorry");
        	bean.setValid(false);
        }
       
    }

    catch (Exception ex) {
        System.out.println("Log In failed: An Exception has occurred! " + ex);
    }

    finally {
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
            }
            rs = null;
        }

        if (stmt != null) {
            try {
                stmt.close();
            } catch (Exception e) {
            }
            stmt = null;
        }

        if (currentCon != null) {
            try {
                currentCon.close();
            } catch (Exception e) {
            }

            currentCon = null;
        }
    }

    return bean;
}
    

}
