package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Items;
import services.UserService;
import services.UserServiceImpl;

/**
 * Servlet implementation class AddItemController
 */
//@WebServlet("/AddItemController")
public class AddItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserService userServices=new UserServiceImpl(); 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddItemController() {
        super();
        // TODO Auto-generated constructor stub
    } 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String action="";
		int id=0;	
		 int kid=0;
		 int vid=0;

	        if(request.getParameter("kid")!=null) 
	        {		
				 kid=Integer.parseInt(request.getParameter("kid"));	
				 System.out.println(kid);
			}
	        
	        if(request.getParameter("vid")!=null) 
	        {		
				 vid=Integer.parseInt(request.getParameter("vid"));	
				 System.out.println(vid);
			}
	        
	        
	     	if(request.getParameter("action")!=null) {		
				action=request.getParameter("action");
			}			
			if(action.equals("deletekfc")) {				
				//userServices.deleteKFCItemById(kid);
				userServices.deleteRestaurantById(kid);
				RequestDispatcher rd=request.getRequestDispatcher("/kfcadmin.jsp");
				rd.forward(request,response);			
			}
			
			
			if(action.equals("deleteveg")) {				
				//userServices.deleteVegItemById(vid);
				userServices.deleteRestaurantById(vid);
				RequestDispatcher rd=request.getRequestDispatcher("/vegworldadmin.jsp");
				rd.forward(request,response);			
			}
			
			
			
		if(request.getParameter("eid")!=null) {		
			id=Integer.parseInt(request.getParameter("eid"));			
		}
		

		if(request.getParameter("action")!=null) {		
			action=request.getParameter("action");
		}
			
		if(action.equals("delete")) 
		{	
		//userServices.deleteItemById(id);	
			userServices.deleteRestaurantById(id);
		RequestDispatcher rd=request.getRequestDispatcher("/nonvegdelightsadmin.jsp");
		rd.forward(request, response);			
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
				
			
		    String selecteditem=request.getParameter("hotelname");					  
			String itemname=request.getParameter("itemname");
			Double price=Double.parseDouble(request.getParameter("price"));			
			//String hotelname=request.getParameter("hotelname");		 
			Items items =new Items();
			items.setItemnames(itemname);
			items.setPrice(price);
			items.setHotelname(selecteditem);
			HttpSession session=request.getSession();			
			session.setAttribute("selecteditem",selecteditem);
			
			//hotelName=session.getAttribute("selecteditem").toString();

			
			if(selecteditem.equals("nonvegdelights")) {				
				//userServices.addNonVegDelightsItems(items);
				userServices.addRestaurants(items);		
				RequestDispatcher rd = request.getRequestDispatcher("/nonvegdelightsadmin.jsp");
	            rd.forward(request,response);
			}
			 if(selecteditem.equals("kfc")) {
					//userServices.addKFCItems(items);
				 userServices.addRestaurants(items);
					RequestDispatcher rd = request.getRequestDispatcher("/kfcadmin.jsp");
		            rd.forward(request,response);
			}
			 if(selecteditem.equals("vegworld")) {
					//userServices.addVegWorldItems(items);
				 userServices.addRestaurants(items);
					RequestDispatcher rd = request.getRequestDispatcher("/vegworldadmin.jsp");
		            rd.forward(request,response);
			 }
			
			
			 
			 
	}

}
