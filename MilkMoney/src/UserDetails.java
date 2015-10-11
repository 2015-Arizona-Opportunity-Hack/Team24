

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserDetails
 */
@WebServlet("/UserDetails")
public class UserDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDetails() {
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
        
        try{  
        	
        	String username = request.getParameter("username");  
            String fname = request.getParameter("fname"); 
            String lname = request.getParameter("lname");
            String phone = request.getParameter("phone");
            String volunteer = request.getParameter("volunteer");
            String donor = request.getParameter("donor");
            String email = request.getParameter("email");
            
            boolean i=false;
            Query q=new Query(); 
            if(q.userPresent(username)==true)
            {
            	i=q.userDetails(username,fname,lname,phone,volunteer,donor,email);
            	
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
        
        try{  
        	
        	String username = request.getParameter("username");  
            String fname = request.getParameter("fname"); 
            String lname = request.getParameter("lname");
            String phone = request.getParameter("phone");
            String volunteer = request.getParameter("volunteer");
            String donor = request.getParameter("donor");
            String email = request.getParameter("email");
            
            boolean i=false;
            Query q=new Query(); 
            //if(q.userPresent(username)==true)
            {
            	i=q.userDetails(username,fname,lname,phone,volunteer,donor,email);
            	
            }
            
            
        }  
        catch (Exception e){  
          pw.println(e);  
        } 
		
	}

}
