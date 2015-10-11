

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Event
 */
@WebServlet("/Event")
public class Event extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Event() {
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
        	
        	String eventid = request.getParameter("eventid");  
            String programid = request.getParameter("programid"); 
            String date = request.getParameter("date");
            String time = request.getParameter("time");
            String vcount = request.getParameter("vcount");
            String description = request.getParameter("description");
            String eventname = request.getParameter("eventname");
            String imageurl = request.getParameter("imageurl");
            String attend = request.getParameter("attend");
            String address = request.getParameter("address");
            
            boolean i=false;
            Query q=new Query(); 
            
            	i=q.addEvent(eventid,programid,date,time,vcount,description,eventname,imageurl,attend,address);
            
            
            
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
        	
        	String eventid = request.getParameter("eventid");  
            String programid = request.getParameter("programid"); 
            String date = request.getParameter("date");
            String time = request.getParameter("time");
            String vcount = request.getParameter("vcount");
            String description = request.getParameter("description");
            String eventname = request.getParameter("eventname");
            String imageurl = request.getParameter("imageurl");
            String attend = request.getParameter("attend");
            String address = request.getParameter("address");
            
            boolean i=false;
            Query q=new Query(); 
            
            	i=q.addEvent(eventid,programid,date,time,vcount,description,eventname,imageurl,attend,address);
            
            
            
        }  
        catch (Exception e){  
          pw.println(e);  
        } 
        
	}

}
