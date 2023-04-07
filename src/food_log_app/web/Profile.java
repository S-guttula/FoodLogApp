package food_log_app.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import food_log_app.dao.UserDAO;
import food_log_app.model.UserProfile;

/**
 * Servlet implementation class Profile
 */
@WebServlet("/Profile")
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private UserDAO userDAO;
       
    /* public Profile(String userName, int height, int weight, String gender, int tWeight) {
		// TODO Auto-generated constructor stub
	} */

	/**
     * @see HttpServlet#HttpServlet()
     */
    /* public Profile() {
        super();
        // TODO Auto-generated constructor stub
    } */
    /* public void init() {
		userDAO = new UserDAO();
	} */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String firstName = request.getParameter("firstname");
		String userName = request.getParameter("username");
		//int height = Integer.parseInt(request.getParameter("height"));
		//int weight = Integer.parseInt(request.getParameter("weight"));
		//String gender = request.getParameter("gender");
		//int tWeight = Integer.parseInt(request.getParameter("tweight"));
		//UserProfile newProfile = new UserProfile(userName,height,weight,gender,tWeight);
		//boolean result = userDAO.createProfile(newProfile);
		request.setAttribute("firstname", firstName);
		request.setAttribute("username", userName );
		request.getRequestDispatcher("createProfile.jsp").forward(request, response);
			//response.sendRedirect("success.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
