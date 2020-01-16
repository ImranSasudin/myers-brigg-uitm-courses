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
import model.studentBean;


public class studentDAO {
	static Connection currentCon = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;
    static String studentName, studentIc,  student_add, studentEmail, studentPhone,password;
    //static int student_id;
    
    
    /*login
    public static studentBean loginUser(studentBean bean) throws NoSuchAlgorithmException {
    	
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
            	String name = rs.getString("studentName");
            	int id = rs.getInt("student_id");
           
           		System.out.println("Welcome " + name);
           		System.out.println("Welcome " + id);
                bean.setstudentName(name);
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
    //add new user (register)
    public void addUser(studentBean bean) throws NoSuchAlgorithmException{

        studentIc = bean.getstudentIc();
        studentName = bean.getstudentName();
        studentEmail = bean.getstudentEmail();
        studentPhone = bean.getstudentPhone();
      //  password = bean.getPassword();

       
    	try {
    		
    		
    		currentCon = connectionManager.getConnection();
    		
    		ps=currentCon.prepareStatement("insert into users (useric,username,useremail,userphone)values(?,?,?,?)");
    		//ps.setInt(1,student_id);
    		ps.setString(1,studentIc);
    		ps.setString(2,studentName);
    		ps.setString(3,studentEmail);
    		ps.setString(4,studentPhone);
    		//ps.setString(3,student_add);
    		//ps.setString(6,password);
    		ps.executeUpdate();
    	
    		System.out.println("Your email is " + studentEmail);
    		System.out.println("Your ic no is " + studentIc);
            
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
    public void addStudent(studentBean bean) throws NoSuchAlgorithmException{

        studentIc = bean.getstudentIc();

    	try {
    		
    		
    		currentCon = connectionManager.getConnection();
    		
    		ps=currentCon.prepareStatement("insert into student (userid) values(?)");
    		
    		ps.setString(1,studentIc);
  
    		ps.executeUpdate();
    	
    		System.out.println("Your email is " + studentEmail);
    		System.out.println("Your ic no is " + studentIc);
            
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
    
  //get list of all student name 
    public List<studentBean> getAllStudentName() {
        List<studentBean> students = new ArrayList<studentBean>();
        try {
        	currentCon = connectionManager.getConnection();
        	stmt = currentCon.createStatement();
            ResultSet rs = stmt.executeQuery("select * from student");
            
            while (rs.next()) {
            	studentBean user = new studentBean();
            	user.setstudentIc(rs.getString("studentIc"));
                user.setstudentName(rs.getString("studentName"));
                //user.setstudent_email(rs.getString("student_email"));
                //user.setManager_id(rs.getInt("manager_id"));
                students.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }
    
    public static void deleteSPM(String studentIc) {
        try {
        	currentCon = connectionManager.getConnection();
        	ps=currentCon.prepareStatement("delete from spmresult where userid=?");
            ps.setString(1, studentIc);
           ps.executeUpdate();

       } catch (SQLException e) {
          e.printStackTrace();
        }    
      }

    //update account
   public static void updateStudentPersonality(studentBean bean, Integer personality) throws NoSuchAlgorithmException {
    	System.out.println("dah masuk update app");
    	//student_id = bean.getstudent_id(); 
    	//student_add = bean.getstudent_add();  
    	studentIc = bean.getstudentIc();    	
    //	password = bean.getPassword(); 
    	
        String searchQuery = "UPDATE student SET personalityid='" + personality + "' WHERE userid= '" + studentIc + "'";
    	
    	try {

            currentCon = connectionManager.getConnection();
            stmt = currentCon.createStatement();
            stmt.executeUpdate(searchQuery);
            System.out.println("dah update personality");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
   public static Integer getPersonalityID(String personality) {
   	Integer personalityID = null;
       try {
       	currentCon = connectionManager.getConnection();
           ps=currentCon.prepareStatement("select * from personality where personalitytype=?");
           
           ps.setString(1, personality);

           ResultSet rs = ps.executeQuery();

           if (rs.next()) {
           
               personalityID = rs.getInt("personalityid");
 
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }

       return personalityID;
   }
   public static String getPersonalityDesc(String personality) {
	   	String personalitydesc = null;
	       try {
	       	currentCon = connectionManager.getConnection();
	           ps=currentCon.prepareStatement("select * from personality where personalitytype=?");
	           
	           ps.setString(1, personality);

	           ResultSet rs = ps.executeQuery();

	           if (rs.next()) {
	           
	        	   personalitydesc = rs.getString("personalitydesc");
	 
	           }
	       } catch (SQLException e) {
	           e.printStackTrace();
	       }

	       return personalitydesc;
	   }
    
    public static void updateUserByIC(studentBean bean) throws NoSuchAlgorithmException {
    	System.out.println("dah masuk update app");
    	studentIc = bean.getstudentIc(); 
    //	student_add = bean.getstudent_add();  
    	studentEmail = bean.getstudentEmail();    	
    	studentPhone = bean.getstudentPhone(); 
    	studentName = bean.getstudentName();
    //	password = bean.getPassword(); 
    	
        String searchQuery = "UPDATE user SET useric='" + studentIc + "', username='" + studentName + "', userphone='" + studentPhone + "', useremail='" + studentEmail + "' WHERE useric= '" + studentIc + "'";
    	
    	try {

            currentCon = connectionManager.getConnection();
            stmt = currentCon.createStatement();
            stmt.executeUpdate(searchQuery);
            System.out.println("dah update student");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    //get all user
    public List<studentBean> getAllUser() {
        List<studentBean> users = new ArrayList<studentBean>();
        try {
        	currentCon = connectionManager.getConnection();
        	stmt = currentCon.createStatement();
            ResultSet rs = stmt.executeQuery("select * from student");
            
            while (rs.next()) {
                studentBean user = new studentBean();
                user.setstudentIc(rs.getString("studentIc"));
                user.setstudentName(rs.getString("studentName"));
                user.setstudentPhone(rs.getString("studentPhone"));
                user.setstudentEmail(rs.getString("studentEmail"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }
    
    //get user by ic
    public studentBean getUserByIC(String ic) {
    	studentBean user = new studentBean();
        try {
        	currentCon = connectionManager.getConnection();
            ps=currentCon.prepareStatement("select * from student s join users u on(s.userid = u.useric) where s.userid=?");
            
            ps.setString(1, ic);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
            
                user.setstudentIc(rs.getString("useric"));
                user.setstudentName(rs.getString("username"));
                user.setstudentEmail(rs.getString("useremail"));
                user.setstudentPhone(rs.getString("userphone"));
         
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
    
    
  //get user by email
public static studentBean getUser(studentBean bean)  {
    	
        studentIc = bean.getstudentIc();

        String searchQuery = "select * from student where userid='" + studentIc + "'";

        try {
            currentCon = connectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean more = rs.next();

            // if user exists set the isValid variable to true
            if (more) {
            	String ic = rs.getString("userid");
           
                bean.setstudentIc(ic);
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
public static studentBean getSPM(studentBean bean)  {
	
    studentIc = bean.getstudentIc();

    String searchQuery = "select * from spmresult where userid='" + studentIc + "'";

    try {
        currentCon = connectionManager.getConnection();
        stmt = currentCon.createStatement();
        rs = stmt.executeQuery(searchQuery);
        boolean more = rs.next();

        // if user exists set the isValid variable to true
        if (more) {
        	String ic = rs.getString("userid");
       
            bean.setstudentIc(ic);
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
