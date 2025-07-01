package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import services.UserService;
import services.UserServiceImpl;


/**
 * Servlet implementation class AddUserController
 */
//@WebServlet("/AddUserController")
public class AddUserController extends HttpServlet {
	
	
private UserService userService=new UserServiceImpl();


	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());			
		RequestDispatcher rd = request.getRequestDispatcher("/alluser.jsp");
		rd.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
			
		String newuser=request.getParameter("username");
		String newpassword=request.getParameter("password");
		String newemail=request.getParameter("email");
		String newphonenumber=request.getParameter("phone");
		String newaddress=request.getParameter("address");

		
		request.setAttribute("newuser", newuser);
		request.setAttribute("newpassword", newpassword);
		
		User user=new User();
		
		user.setUsername(newuser);
		user.setPassword(newpassword);
		user.setEmail(newemail);
		user.setPhone(newphonenumber);
		user.setAddress(newaddress);
		
		userService.addUser(user);
		
		RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
		rd.forward(request, response);
			
	}

}
