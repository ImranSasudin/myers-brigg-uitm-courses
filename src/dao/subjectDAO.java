package dao;

import java.security.NoSuchAlgorithmException;
//import java.sql.connection;]
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.connectionManager;
import model.subjectBean;
import model.subjectBean;


public class subjectDAO {
	static Connection currentCon = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;
    static String subjectName, subjectId ;
    
    
    /*login
    public static subjectBean loginUser(subjectBean bean) throws NoSuchAlgorithmException {
    	
    	//student_id = bean.getstudent_id();
    	studentEmail = bean.getstudentEmail();
    	//password = bean.getPassword();

        String searchQuery = "select * from student where studentEmail='" + studentEmail + "' AND password='" + password + "'";

        System.out.println("Your email is " + studentEmail);
        System.out.println("Your password is " + password);
        System.out.println("Your id is " + student_id);
        System.out.println("Query: " + searchQuery);

        try {
            currentCon = connectionManager.getconnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean more = rs.next();

            // if user exists set the isValid variable to true
            if (more) {
            	String name = rs.getString("subjectName");
            	int id = rs.getInt("student_id");
           
           		System.out.println("Welcome " + name);
           		System.out.println("Welcome " + id);
                bean.setsubjectName(name);
                bean.setstudent_id(id);
                bean.setValid(true);
           	}
           
            // if user does not exist set the isValid variable to false
            else if (!more) {
            	System.out.println("Sorry, you are not a registered user! Please sign up first");
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
    */
    
    //add new subject (register)
    public void addSubject(subjectBean bean) throws NoSuchAlgorithmException{

        subjectId  = bean.getsubjectId ();
        subjectName = bean.getsubjectName();
   
    	try {
    		
    		
    		currentCon = connectionManager.getConnection();
    		
    		ps=currentCon.prepareStatement("insert into subjectspm (subjectId ,subjectName)values(?,?)");
    
    		ps.setString(1,subjectId );
    		ps.setString(2,subjectName);
    		ps.executeUpdate();
    	
    	
    		System.out.println("Your ic no is " + subjectId );
            
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
    
  //get list of all subject name 
    public List<subjectBean> getAllSubjectName() {
        List<subjectBean> subjects = new ArrayList<subjectBean>();
        try {
        	currentCon = connectionManager.getConnection();
        	stmt = currentCon.createStatement();
            ResultSet rs = stmt.executeQuery("select * from subjectspm order by 2");
            
            while (rs.next()) {
            	subjectBean subject = new subjectBean();
            	subject.setsubjectId(rs.getString("subjectId"));
            	subject.setsubjectName(rs.getString("subjectName"));
           
                subjects.add(subject);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return subjects;
    }
  
    public void deleteSubject(String subjectId) {
        try {
        	currentCon = connectionManager.getConnection();
        	ps=currentCon.prepareStatement("delete from subjectspm where subjectId=?");
            ps.setString(1, subjectId);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //update account
/*    public void updateUser(subjectBean bean) throws NoSuchAlgorithmException {
    	System.out.println("dah masuk update app");
    	//student_id = bean.getstudent_id(); 
    	//student_add = bean.getstudent_add();  
    	studentEmail = bean.getstudentEmail();    	
    	studentPhone = bean.getstudentPhone(); 
    //	password = bean.getPassword(); 
    	
        String searchQuery = "UPDATE student SET student_add='" + student_add + "', studentEmail='" + studentEmail + "', studentPhone='" + studentPhone + "', password='" + password + "' WHERE student_id= '" + student_id + "'";
    	
    	try {

            currentCon = connectionManager.getconnection();
            stmt = currentCon.createStatement();
            stmt.executeUpdate(searchQuery);
            System.out.println("dah update app");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateUserByIC(subjectBean bean) throws NoSuchAlgorithmException {
    	System.out.println("dah masuk update app");
    	subjectId  = bean.getsubjectId (); 
    //	student_add = bean.getstudent_add();  
    	studentEmail = bean.getstudentEmail();    	
    	studentPhone = bean.getstudentPhone(); 
    //	password = bean.getPassword(); 
    	
        String searchQuery = "UPDATE student SET student_add='" + student_add + "', studentEmail='" + studentEmail + "', studentPhone='" + studentPhone + "', password='" + password + "' WHERE subjectId = '" + subjectId  + "'";
    	
    	try {

            currentCon = connectionManager.getconnection();
            stmt = currentCon.createStatement();
            stmt.executeUpdate(searchQuery);
            System.out.println("dah update app");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
*/
//    //get all subject
    public List<subjectBean> getAllSubject() {
        List<subjectBean> subjects = new ArrayList<subjectBean>();
        try {
        	currentCon = connectionManager.getConnection();
        	stmt = currentCon.createStatement();
            ResultSet rs = stmt.executeQuery("select * from subjectspm");
            
            while (rs.next()) {
                subjectBean subject = new subjectBean();
                subject.setsubjectId (rs.getString("subjectId"));
                subject.setsubjectName(rs.getString("subjectName"));
                subjects.add(subject);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return subjects;
    }
    
    //get user by ic
    public subjectBean getUserByIC(String ic) {
    	subjectBean user = new subjectBean();
        try {
        	currentCon = connectionManager.getConnection();
            ps=currentCon.prepareStatement("select * from student where subjectId =?");
            
            ps.setString(1, ic);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
            	user.setsubjectId (rs.getString("subjectId "));
                user.setsubjectName(rs.getString("subjectName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
    
    //get user by id
    public subjectBean getsubjectById(String id) {
    	subjectBean user = new subjectBean();
        try {
        	currentCon = connectionManager.getConnection();
            ps=currentCon.prepareStatement("select * from subject where subjectId=?");
            
            ps.setString(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                
            	//user.setstudent_id(rs.getInt("student_id"));
                user.setsubjectName(rs.getString("subjectName"));
               
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
    
  //get user by email
public static subjectBean getUser(subjectBean bean)  {
    	
        subjectId  = bean.getsubjectId();

        String searchQuery = "select * from student where subjectId ='" + subjectId  + "'";

        try {
            currentCon = connectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean more = rs.next();

            // if user exists set the isValid variable to true
            if (more) {
            	String ic = rs.getString("subjectId ");
           
                bean.setsubjectId (ic);
                bean.setValid(true);
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
