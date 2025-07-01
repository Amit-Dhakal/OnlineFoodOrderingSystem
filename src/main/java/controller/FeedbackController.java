package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Feedback;
import services.UserService;
import services.UserServiceImpl;

/**
 * Servlet implementation class FeedbackController
 */
//@WebServlet("/FeedbackController")
public class FeedbackController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserService userService=new UserServiceImpl();
	
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeedbackController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String username=request.getParameter("username");
		String email=request.getParameter("email");
		String feedback=request.getParameter("feedback");
		
	   Feedback feedBack=new Feedback();

		feedBack.setUsername(username);
		feedBack.setEmail(email);
		feedBack.setFeedback(feedback);
		
		userService.addUserFeedback(feedBack);
		
		
		
		
	}

	
	
}
