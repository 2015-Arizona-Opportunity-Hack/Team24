
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Driver;
import java.sql.ResultSet;
import java.sql.Statement;


public class Query {

	String url,dbName,driver,sql;
    
    Query()
    {
    	
    	url="jdbc:mysql://localhost:3306/";
    	dbName="milkmoney";
    	driver="com.mysql.jdbc.Driver";	
    }
   
    public boolean userPresent(String username) 
    {
    	
    	
    	try {
    		Connection conn=null;
        	Class.forName(driver).newInstance();
    	conn = DriverManager.getConnection(url+dbName,"root", "Security@18");
    	
    	sql = "SELECT * from login WHERE username = '" + username+"'";
    	Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        if(rs.absolute(1)) {
            conn.close();
            return true;
        }
        else
        	return false;
    	}
    	catch (Exception e){  
            System.out.println(e); 
            return false;
          } 
    	
    	
    }
    

	public boolean addUser(String username, String password, String regid) {
		// TODO Auto-generated method stub
		
    	try {
    		Connection conn=null;
        	Class.forName(driver).newInstance();
    	conn = DriverManager.getConnection(url+dbName,"root", "Security@18");
    	PreparedStatement pst =(PreparedStatement) conn.prepareStatement("insert into login (username,password,regid) values(?,?,?)");  

    	 pst.setString(1,username);  
       pst.setString(2,password);
       pst.setString(3,regid);
    	int n= pst.executeUpdate();

        if(n>=1) {
        	//conn.commit(); 
            //conn.close();
            return true;
        }
        else
        	return false;
    	}
    	catch (Exception e){  
            System.out.println(e); 
            return false;
          }
	}
    	public boolean userDetails(String username, String fname,String lname, String phone, String volunteer,String donor, String email) {
    		// TODO Auto-generated method stub
    		
        	try {
        		Connection conn=null;
            	Class.forName(driver).newInstance();
        	conn = DriverManager.getConnection(url+dbName,"root", "Security@18");
        	PreparedStatement pst =(PreparedStatement) conn.prepareStatement("insert into user (username,fname,lname,phone,volunteer,donor,email) values(?,?,?,?,?,?,?)");  

        	pst.setString(1,username);  
            pst.setString(2,fname); 
            pst.setString(3,lname);
            pst.setString(4,phone);
            pst.setString(5,volunteer);
            pst.setString(6,donor);
            pst.setString(7,email);
            
            
        	int n= pst.executeUpdate();

            if(n>=1) {
            	//conn.commit(); 
                //conn.close();
                return true;
            }
            else
            	return false;
        	}
        	catch (Exception e){  
                System.out.println(e); 
                return false;
              }
    	}
    	
    	public boolean addProgram(String pname, String programid) {
    		// TODO Auto-generated method stub
    		
        	try {
        		Connection conn=null;
            	Class.forName(driver).newInstance();
        	conn = DriverManager.getConnection(url+dbName,"root", "Security@18");
        	PreparedStatement pst =(PreparedStatement) conn.prepareStatement("insert into program (pname,programid) values(?,?)");  

        	pst.setString(1,pname);  
            pst.setString(2,programid); 
        	int n= pst.executeUpdate();

            if(n>=1) {
            	//conn.commit(); 
                //conn.close();
                return true;
            }
            else
            	return false;
        	}
        	catch (Exception e){  
                System.out.println(e); 
                return false;
              }
    	}
    	
    	
    	public boolean userPreference(String username, String pname) {
    		// TODO Auto-generated method stub
    		
        	try {
        		Connection conn=null;
            	Class.forName(driver).newInstance();
        	conn = DriverManager.getConnection(url+dbName,"root", "Security@18");
        	PreparedStatement pst =(PreparedStatement) conn.prepareStatement("select programid from program where pname=?");
        	pst.setString(1,pname);
        	ResultSet rs=pst.executeQuery();
        	
        	String programid="";
        	if(rs.next())
        		programid=rs.getString(1);
        	
        	pst =(PreparedStatement) conn.prepareStatement("insert into userpreference (username,programid) values(?,?)");  

        	pst.setString(1,username);  
            pst.setString(2,programid); 
        	int n= pst.executeUpdate();

            if(n>=1) {
            	//conn.commit(); 
                //conn.close();
                return true;
            }
            else
            	return false;
        	}
        	catch (Exception e){  
                System.out.println(e); 
                return false;
              }
    	}
    	
    	
    	public boolean addEvent(String eventid, String programid,String date, String time, String vcount,String description,String eventname,String imageurl,String attend,String address) {
    		// TODO Auto-generated method stub
    		
        	try {
        		Connection conn=null;
            	Class.forName(driver).newInstance();
        	conn = DriverManager.getConnection(url+dbName,"root", "Security@18");
        	PreparedStatement pst =(PreparedStatement) conn.prepareStatement("insert into event (eventid,programid,date,time,vcount,description,eventname,imageurl,attend,address) values(?,?,?,?,?,?,?,?,?,?)");  

        	pst.setString(1,eventid);  
            pst.setString(2,programid); 
            pst.setString(3,date);
            pst.setString(4,time);
            pst.setString(5,vcount);
            pst.setString(6,description);
            pst.setString(7,eventname);
            pst.setString(8,imageurl);
            pst.setString(9,attend);
            pst.setString(10,address);
            
            
        	int n= pst.executeUpdate();

            if(n>=1) {
            	//conn.commit(); 
                //conn.close();
                return true;
            }
            else
            	return false;
        	}
        	catch (Exception e){  
                System.out.println(e); 
                return false;
              }
    	}
    	
    	
    	
    	public void displayEvents(String username)
    	{
    		try {
        		Connection conn=null;
            	Class.forName(driver).newInstance();
        	conn = DriverManager.getConnection(url+dbName,"root", "Security@18");
        	PreparedStatement pst =(PreparedStatement) conn.prepareStatement("select * from event as e, userevents as u where e.date>current_date()  and e.eventid=u.eventid and u.username='"+username+"'");  
        	
        	//pst.setString(1,username);
        	ResultSet rs=pst.executeQuery();
        	
        	
        	if(rs.next())
        	{
        		System.out.println(rs.getString(1));
        		System.out.println(rs.getString(2));
        		System.out.println(rs.getString(3));
        		System.out.println(rs.getString(4));
        		System.out.println(rs.getString(5));
        		System.out.println(rs.getString(6));
        		System.out.println(rs.getString(7));
        		System.out.println(rs.getString(8));
        		System.out.println(rs.getString(9));
        		System.out.println(rs.getString(10));
        	}
        	

    		}
        	catch (Exception e){  
                System.out.println(e); 
                
              }
    	}
    	
    	
    	public boolean eventRsvp(String eventid, String username){
    		
    		try {
        		Connection conn=null;
            	Class.forName(driver).newInstance();
        	conn = DriverManager.getConnection(url+dbName,"root", "Security@18");
        	
        	PreparedStatement pst =(PreparedStatement) conn.prepareStatement("insert into userevents (username,eventid) values(?,?)");  

        	pst.setString(1,username);  
            pst.setString(2,eventid);
            
            int n= pst.executeUpdate();
            
            if(n>=1)
            {
            	pst =(PreparedStatement) conn.prepareStatement("select attend from event where eventid='"+eventid+"'");
            	ResultSet rs=pst.executeQuery();
            	
            	int x=0;
            	if (rs.next())
            	x=Integer.parseInt(rs.getString(1));
            	
            	x++;
            	
            	pst =(PreparedStatement) conn.prepareStatement("insert into event (attend) values(?) where eventid='"+eventid+"'");
            	StringBuilder sb = new StringBuilder();
            	sb.append("");
            	sb.append(x);
            	String y = sb.toString();
            	
            	pst.setString(1,y);
            	int t= pst.executeUpdate();
            	
            	 if(t>=1) {
                 	//conn.commit(); 
                     //conn.close();
                     return true;
                 }
                 else
                 	return false;
            	
            }
            else
             	return false;
    		}
        	catch (Exception e){  
                System.out.println(e); 
                return false;
              }
			
    		
    	}

		public boolean validate(String username, String password) {
			// TODO Auto-generated method stub
			try {
        		Connection conn=null;
            	Class.forName(driver).newInstance();
        	conn = DriverManager.getConnection(url+dbName,"root", "Security@18");
        	
        	PreparedStatement pst =(PreparedStatement) conn.prepareStatement("select password from login where username='"+username+"'");
        	
        	ResultSet rs=pst.executeQuery();
        	
        	String pass="";
        	if(rs.next())
        	pass=rs.getString(1);
        	return pass.equals(password);
        	
        	
			}
        	catch (Exception e){  
                System.out.println(e); 
                return false;
              }
		}
	}
	    
   
    
	

