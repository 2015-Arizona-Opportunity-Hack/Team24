

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Login() {
    	super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		response.setContentType("text/html");  
        PrintWriter pw = response.getWriter(); 
        
        String from = "web@gmail.com";
    	String host = "localhost";
    	Properties properties = System.getProperties();
    	properties.setProperty("mail.smtp.host", host);
    	Session session = Session.getDefaultInstance(properties);
        
        
        try{  
        	
        	String username = request.getParameter("username");  
            String password = request.getParameter("password");  
            String regid = request.getParameter("regid");
        	
//        	MimeMessage message = new MimeMessage(session);
//        	message.setFrom(new InternetAddress(from));
//        	message.addRecipient(Message.RecipientType.TO,new InternetAddress(username));
//        	message.setSubject("Welcome to MilkMoney");
//        	message.setText("This is actual message");
        	
            
            boolean i=false;
            Query q=new Query(); 
            if(q.userPresent(username)==false)
            {
            	i=q.addUser(username,password,regid);
            	
            }
            
            
            
            String msg=" ";
            if(i==true){  
//            	Transport.send(message);
//            	String title = "Send Email";
//                String res = "Sent message successfully....";
//                String docType =
//                "<!doctype html public \"-//w3c//dtd html 4.0 " +
//                "transitional//en\">\n";
//                pw.println(docType +
//                "<html>\n" +
//                "<head><title>" + title + "</title></head>\n" +
//                "<body bgcolor=\"#f0f0f0\">\n" +
//                "<h1 align=\"center\">" + title + "</h1>\n" +
//                "<p align=\"center\">" + res + "</p>\n" +
//                "</body></html>");  


            }  
            else{  
              msg="failed to create login";
              pw.println("<font size='6' color=blue>" + msg + "</font>");
             }  
            
          }  
          catch (Exception e){  
            pw.println(e);  
          }  

        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");  
         PrintWriter pw = response.getWriter(); 
        
        String from = "web@gmail.com";
    	String host = "localhost";
    	Properties properties = System.getProperties();
    	//properties.setProperty("mail.smtp.host", host);
    	properties.setProperty("mail.smtp.host", "10.101.3.229");
    	properties.setProperty("mail.smtp.port", "8080");
    	Session session = Session.getDefaultInstance(properties);
        
        
        try{  
        	
        	String username = request.getParameter("username");  
            String password = request.getParameter("password");
            String fname = request.getParameter("fname"); 
            String lname = request.getParameter("lname");
            String phone = request.getParameter("phone");
            String volunteer = request.getParameter("volunteer");
            String donor = request.getParameter("donor");
            String email = request.getParameter("email");
            String regid = request.getParameter("regid");
        	
//        	MimeMessage message = new MimeMessage(session);
//        	message.setFrom(new InternetAddress(from));
//        	message.addRecipient(Message.RecipientType.TO,new InternetAddress(username));
//        	message.setSubject("Welcome to MilkMoney");
//        	message.setText("This is actual message");
//        	
            
            boolean i=false;
            Query q=new Query(); 
            if(q.userPresent(username)==false)
            {
            	i=q.addUser(username,password,regid);
            	if (i==true)
            	{
            		boolean id=q.userDetails(username,fname,lname,phone,volunteer,donor,email);
            		if(id==true)
            		{
            			//success
            		}
            		
            	}
            	
            	
            	
            }
            else
            {
            	boolean id=q.validate(username,password);
            	if(id==true)
            	{
            		System.out.println(username);
            		request.setAttribute("username", username);
            	}
            }
            	
            
            
//            String msg=" ";
//            if(i==true){  
//            	System.out.println("yes");
//            	Transport.send(message);
//            	String title = "Send Email";
//                String res = "Sent message successfully....";
//                String docType =
//                "<!doctype html public \"-//w3c//dtd html 4.0 " +
//                "transitional//en\">\n";
//                pw.println(docType +
//                "<html>\n" +
//                "<head><title>" + title + "</title></head>\n" +
//                "<body bgcolor=\"#f0f0f0\">\n" +
//                "<h1 align=\"center\">" + title + "</h1>\n" +
//                "<p align=\"center\">" + res + "</p>\n" +
//                "</body></html>");  


//            }  
//            else{  
//              msg="failed to create login";
//              pw.println("<font size='6' color=blue>" + msg + "</font>");
//             }  
            
//          }  catch (MessagingException mex) {
//              mex.printStackTrace();
          }
          catch (Exception e){  
            pw.println(e);  
          }  
        request.getRequestDispatcher("index.jsp")
		.forward(request, response);

	}

}
