

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Program
 */
@WebServlet("/Program")
public class Program extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Program() {
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
        	
        	String pname = request.getParameter("pname");  
            String programid = request.getParameter("programid"); 
           
            
            boolean i=false;
            Query q=new Query(); 
            
            	i=q.addProgram(pname,programid);
            
            
            
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
        	
        	String pname = request.getParameter("pname");  
            String programid = request.getParameter("programid"); 
           
            
            boolean i=false;
            Query q=new Query(); 
            
            	i=q.addProgram(pname,programid);
            
            
            
        }  
        catch (Exception e){  
          pw.println(e);  
        } 
        
        
	}

}
