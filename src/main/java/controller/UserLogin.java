package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import connection.DbConnection;

/**
 * Servlet implementation class UserLogin
 */

public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				Connection conn=null;
				PreparedStatement ps;
				ResultSet rs;
				
		 String username=request.getParameter("uname");
		 String password=request.getParameter("pwd");
		  String adminusername=request.getParameter("uname"); 
		  String adminpassword=request.getParameter("pwd");
		  
		  if(adminusername.equalsIgnoreCase("admin") && adminpassword.equalsIgnoreCase("test"))
		  { 
		  RequestDispatcher rd = request.getRequestDispatcher("/custumerfeedback.jsp");
		  rd.forward(request,response); 
		  }
		 
		 		
try {
	
	conn=DbConnection.getDbConnection();
	String sql="select * from user where username=? and password=?";
	
	ps=conn.prepareStatement(sql);
	
	ps.setString(1,username);
	ps.setString(2,password);

	rs=ps.executeQuery();
	
	if(rs.next()) {
		
		//request.setAttribute("userid",username);	
		/*
		 * System.out.println(rs.getString(2)); System.out.println(rs.getString(3));
		 * System.out.println(rs.getString(4));
		 */
		
		HttpSession session=request.getSession();
		session.setAttribute("userid",username);
		
		HttpSession session1=request.getSession();
		session1.setAttribute("email",rs.getString(4));

		 RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
	     rd.forward(request,response);  	
	}
	  else{ 	
		  response.getWriter().append("login failed!!!"); 		 
		 }
	
} 
catch (Exception e) 
{
	// TODO: handle exception
}		
		
		
	}
	
	 	 
	
	
	

}
