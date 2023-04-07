package food_log_app.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import food_log_app.dao.UserDAO;
import food_log_app.model.User;

/**
 * Servlet implementation class UserServletLogin
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init() {
		userDAO = new UserDAO();
	}
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher rd=null;
		String username = request.getParameter("username");
	 	String password = request.getParameter("password");
	 	User existingUser = new User(username,password);
	 	//existingUser.setUsername(username);
	 	//existingUser.setPassword(password);
	 	User user = userDAO.selectUser(existingUser);
	 	//PrintWriter pw = response.getWriter();
	 	//pw.print("<h1>"+ username + " hi </h1>");
	 	if(user!=null) {
			rd = request.getRequestDispatcher("Login1.jsp");
			request.setAttribute("userName", username);
	 		request.setAttribute("lastName", user.getLastname());
	 		request.setAttribute("firstName", user.getFirstname());
	 		rd.forward(request, response);
	 		//response.sendRedirect("loginsuccess.html");
	 	} else {
	 		rd=request.getRequestDispatcher("index.html");
			request.setAttribute("message", "Employee Insertion Failed!!!");
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
