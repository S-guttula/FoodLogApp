package food_log_app.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import food_log_app.dao.UserDAO;
import food_log_app.model.UserProfile;

/**
 * Servlet implementation class DeleteProfile
 */
@WebServlet("/DeleteProfile")
public class DeleteProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    /* public DeleteProfile() {
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
		boolean result = false;
		String firstName = request.getParameter("firstname");
		String userName = request.getParameter("username");
		if(userName!=null) {
				result = userDAO.deleteProfile(userName);
				if(result==true) {
					rd = request.getRequestDispatcher("deleteProfileSuccess.jsp");
					request.setAttribute("username", "userName");
					request.setAttribute("firstname", "firstName");
					rd.forward(request, response);
				} else {
					rd = request.getRequestDispatcher("deleteProfileFailure.jsp");
					request.setAttribute("username", "userName");
					request.setAttribute("firstname", "firstName");
					rd.forward(request, response);
				}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
