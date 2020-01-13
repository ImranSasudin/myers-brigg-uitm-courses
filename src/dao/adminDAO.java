package dao;

//import java.util.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
//import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import model.adminBean;
import connection.connectionManager;

public class adminDAO {
	static Connection currentCon = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;
    static String adminName, adminEmail, adminPassword, adminPhone, adminIc;
    
    
    //login admin
    public static adminBean adminLogIn(adminBean bean) throws NoSuchAlgorithmException {
    	
        adminEmail = bean.getadminEmail();
        adminPassword = bean.getadminPassword();

        String searchQuery = "select * from admin where adminEmail='" + adminEmail + "' AND adminPassword='" + adminPassword + "'";

        System.out.println("Your email is " + adminEmail);
        System.out.println("Your password is " + adminPassword);
        System.out.println("Query: " + searchQuery);

        try {
            currentCon = connectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean more = rs.next();

            // if user exists set the isValid variable to true
            if (more) {
            	String email = rs.getString("adminEmail");
           
           		System.out.println("Welcome " + email);
                bean.setadminEmail(email);
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
    
    //add new admin (register)
    public void addAdmin(adminBean bean) throws NoSuchAlgorithmException{
    	
    	adminIc	= bean.getadminIc();
        adminName = bean.getadminName();
        adminEmail = bean.getadminEmail();
        adminPhone = bean.getadminPhone();
        adminPassword = bean.getadminPassword();

       
    	try {
    		currentCon = connectionManager.getConnection();
    		ps=currentCon.prepareStatement("insert into admin (adminIc,adminName,adminEmail,adminPhone,adminPassword)values(?,?,?,?,?)");
    		ps.setString(1,adminIc);
    		ps.setString(2,adminName);
    		ps.setString(3,adminEmail);
    		ps.setString(4,adminPhone);
    		ps.setString(5,adminPassword);
    		ps.executeUpdate();
    	
    		System.out.println("Your name is " + adminName);
    		System.out.println("Your email is " + adminEmail);
            
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

    //delete admin
    public void deleteAdmin(int adminIc) {
        try {
        	currentCon = connectionManager.getConnection();
        	ps=currentCon.prepareStatement("delete from admin where adminIc=?");
            ps.setInt(1, adminIc);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

  /* //update admin details
    public void updateAdmin(adminBean bean) throws NoSuchAlgorithmException {

    	adminIc = bean.getadminIc();
    	adminName = bean.getadminName();
    	adminEmail = bean.getadminEmail();
        adminPassword = bean.getadminPassword();
      //  manager_id = bean.getManager_id();
    	
       
        String searchQuery = "UPDATE admin SET adminName='" + adminName + "', adminEmail='" + adminEmail + "', adminPassword='" + adminPassword + "', manager_id='" + manager_id + "' WHERE adminIc= '" + adminIc + "'";
    	
    	try {

            currentCon = connectionManager.getConnection();
            stmt = currentCon.createStatement();
            stmt.executeUpdate(searchQuery);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    */
    
    
   //get list of all admin
    public List<adminBean> getAllAdmin() {
        List<adminBean> admins = new ArrayList<adminBean>();
        try {
        	currentCon = connectionManager.getConnection();
        	stmt = currentCon.createStatement();
            ResultSet rs = stmt.executeQuery("select * from admin order by adminIc");
            
            while (rs.next()) {
            	adminBean user = new adminBean();
            	user.setadminIc(rs.getString("adminIc"));
                user.setadminName(rs.getString("adminName"));
                user.setadminEmail(rs.getString("adminEmail"));
                user.setadminPhone(rs.getString("adminPhone"));

               admins.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return admins;
    }
    
    //get list of all admin name 
    public List<adminBean> getAllAdminName() {
        List<adminBean> admins = new ArrayList<adminBean>();
        try {
        	currentCon = connectionManager.getConnection();
        	stmt = currentCon.createStatement();
            ResultSet rs = stmt.executeQuery("select * from admin");
            
            while (rs.next()) {
            	adminBean user = new adminBean();
            	user.setadminIc(rs.getString("adminIc"));
                user.setadminName(rs.getString("adminName"));
                user.setadminEmail(rs.getString("adminEmail"));
                user.setadminPhone(rs.getString("adminPhone"));

                //user.setManager_id(rs.getInt("manager_id"));
                admins.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return admins;
    }
    
    //get admin details by email
    public adminBean getAdminByEmail(String adminEmail) {
    	adminBean user = new adminBean();
        try {
        	currentCon = connectionManager.getConnection();
            ps=currentCon.prepareStatement("select * from admin where adminEmail=?");
            
            ps.setString(1, adminEmail);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                
            	user.setadminIc(rs.getString("adminIc"));
                user.setadminName(rs.getString("adminName"));
                user.setadminEmail(rs.getString("adminEmail"));
                user.setadminPhone(rs.getString("adminPhone"));
                user.setadminPassword(rs.getString("adminPassword"));

          //      user.setManager_id(rs.getInt("manager_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
    
  //get admin details by ic
    public adminBean getAdminById(int adminIc) {
    	adminBean user = new adminBean();
        try {
        	currentCon = connectionManager.getConnection();
            ps=currentCon.prepareStatement("select * from admin where adminIc=?");
            
            ps.setInt(1, adminIc);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                
            	user.setadminIc(rs.getString("adminIc"));
                user.setadminName(rs.getString("adminName"));
                user.setadminEmail(rs.getString("adminEmail"));
                user.setadminPhone(rs.getString("adminPhone"));
                user.setadminPassword(rs.getString("adminPassword"));
             //   user.setManager_id(rs.getInt("manager_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
    
    //get manager name by email
    public adminBean getManagerName(int id) {
    	adminBean admins = new adminBean();
        try {
        	currentCon = connectionManager.getConnection();
            ps=currentCon.prepareStatement("select m.* from admin a join admin m on a.manager_id = m.adminIc where a.adminIc = ?");
            
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                
            	admins.setadminName(rs.getString("adminName"));
                //user.setadminPassword(rs.getString("adminPassword"));
                //user.setadminEmail(rs.getString("adminEmail"));
                //user.setManager_id(rs.getInt("manager_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return admins;
    }
    
    //set admin validity by email
    public static adminBean getAdmin(adminBean bean)  {
    	
        adminIc = bean.getadminIc();

        String searchQuery = "select * from admin where adminIc='" + adminIc + "'";

        try {
            currentCon = connectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean more = rs.next();

            // if user exists set the isValid variable to true
            if (more) {
            	String adminIc = rs.getString("adminIc");
           
                bean.setadminIc(adminIc);
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
