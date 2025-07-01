package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import connection.DbConnection;
import model.Items;
import model.User;
import services.UserService;
import services.UserServiceImpl;

/**
 * Servlet implementation class OrderController
 */

//@WebServlet("/OrderController")
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	UserService userService=new UserServiceImpl();
	Items items=new Items();
	
	User user=new User();
    
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderController() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());	
		    int vid=0;
			int id=0;
			int nid=0;
			String action=null;
			
			Connection conn;
			PreparedStatement ps;
			ResultSet rs;
			HttpSession session=request.getSession();
			
          if(request.getParameter("eid")!=null) {			
			id=Integer.parseInt(request.getParameter("eid"));		
		}       
	          
          if(request.getParameter("vid")!=null) {			
  			vid=Integer.parseInt(request.getParameter("vid"));		
  		}   
          
          if(request.getParameter("nid")!=null) {
        	  
        	  nid=Integer.parseInt(request.getParameter("nid"));
          }
  	          

          
		if(request.getParameter("action")!=null) {
					
			action=request.getParameter("action");
		}
		
		if(action.equals("vorder")) {	
			
			//items=userService.vegItemsById(vid);
			items=userService.getRestaurantsItems(vid);
			
			System.out.println(items.getId());
			System.out.println(items.getItemnames());
			System.out.println(items.getPrice());
			System.out.println(session.getAttribute("userid").toString());		
			userService.addUserOrders(items,session.getAttribute("userid").toString());	
			
			RequestDispatcher rd=request.getRequestDispatcher("/userorders.jsp");
			rd.forward(request, response);	
		}	
		if(action.equals("norder")) {
			//items=userService.getKFCItemsById(nid);
			items=userService.getRestaurantsItems(nid);
			userService.addUserOrders(items,session.getAttribute("userid").toString());	
			
			RequestDispatcher rd=request.getRequestDispatcher("/userorders.jsp");
			rd.forward(request, response);	

		}

		if(action.equals("order")) {		
			//items=userService.ItemsById(id);
			items=userService.getRestaurantsItems(id);
			userService.addUserOrders(items,session.getAttribute("userid").toString());	
			
			RequestDispatcher rd=request.getRequestDispatcher("/userorders.jsp");
			rd.forward(request, response);	
			System.out.println(items.getId());
			System.out.println(items.getItemnames());
			System.out.println(items.getPrice());
			System.out.println(session.getAttribute("userid").toString());		
		}	
		
					
//		try {		
//			conn=DbConnection.getDbConnection();
//			String sql="insert into orderitem (itemname,price,username) values(?,?,?)";			
//			ps=(PreparedStatement) conn.prepareStatement(sql);			
//			ps.setString(1,items.getItemnames());
//			ps.setDouble(2,items.getPrice());
//			ps.setString(3,session.getAttribute("userid").toString());				
//			int i=ps.executeUpdate();		
//			System.out.println("data inserted successfully with "+i);					
//			RequestDispatcher rd=request.getRequestDispatcher("/userorders.jsp");
//			rd.forward(request, response);				
//					
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}	
//		
		
		
			}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);	
	}
}
