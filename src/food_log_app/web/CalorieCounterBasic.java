package food_log_app.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import food_log_app.dao.UserDAO;

/**
 * Servlet implementation class CalorieCounter
 */
@WebServlet("/CalorieCounterBasic")
public class CalorieCounterBasic extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    /* public CalorieCounter() {
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
		RequestDispatcher rd = null;
		String firstName = request.getParameter("firstname");
		String userName = request.getParameter("username");
		if(userName!=null) {
			rd = request.getRequestDispatcher("chooseFoodItems.jsp");
			request.setAttribute("firstname","firstName");
			request.setAttribute("username","userName");
			rd.forward(request, response);
		} else {
			rd = request.getRequestDispatcher("Login1.jsp");
			request.setAttribute("firstname","firstName");
			request.setAttribute("username","userName");
			rd.forward(request, response);
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
