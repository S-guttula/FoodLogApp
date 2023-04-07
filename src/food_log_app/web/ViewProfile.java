package food_log_app.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import food_log_app.dao.UserDAO;
import food_log_app.model.UserProfile;

/**
 * Servlet implementation class ViewProfile
 */
@WebServlet("/ViewProfile")
public class ViewProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    /* public ViewProfile() {
        super();
        // TODO Auto-generated constructor stub
    } */
    public void init() {
		userDAO = new UserDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher rd=null;
		String firstName = request.getParameter("firstname");
		String userName = request.getParameter("username");
		ArrayList<UserProfile> viewUserProfile = userDAO.viewUserProfile(userName);
		rd = request.getRequestDispatcher("ViewUserProfile.jsp");
		request.setAttribute("userprofile", viewUserProfile);
		request.setAttribute("firstname", firstName);
		request.setAttribute("username", userName);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
