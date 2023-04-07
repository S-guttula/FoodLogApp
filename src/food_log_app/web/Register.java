package food_log_app.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import food_log_app.dao.UserDAO;
import food_log_app.model.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	/* public UserServlet() {
		super();
	} */
	public void init() {
		userDAO = new UserDAO();
	}
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 //String action = request.getParameter("username");
		 // print statement
		/* try {
			switch (action) {
			case "/basic":
				showNewForm(request, response);
				break;
			case "/insert":
				insertUser(request, response);
				break;
		     case "/delete":
				deleteUser(request, response);
				break; 
			 case "/edit":
				showEditForm(request, response);
				break; 
			 case "/update":
				updateUser(request, response);
				break; 
			 default:
				listUser(request, response);
				break;  
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		} */
		 /* if("Login".equals(action)) {
			 	String username = request.getParameter("username");
			 	String password = request.getParameter("password");
			 	User existingUser = new User(username,password);
			 	//existingUser.setUsername(username);
			 	//existingUser.setPassword(password);
			 	userDAO.selectUser(existingUser);
			 	response.sendRedirect("loginsuccess.html");
		 }else if("Register".equals(action)) { */
			 	String firstname = request.getParameter("firstname");
				String lastname = request.getParameter("lastname");
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				User newUser = new User(firstname,lastname,username,password);
				// newUser.setFirstname(firstname);
				// newUser.setLastname(lastname);
				// newUser.setUsername(username);
				// newUser.setPassword(password);
				try {
					boolean result = userDAO.insertUser(newUser);
					if(result == true) {
						request.setAttribute("name", firstname);
						request.getRequestDispatcher("Success1.jsp").forward(request, response);
						//response.sendRedirect("success.html");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		 //}
	}
	
	 /* private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<User> listUser = userDAO.selectAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user_list.jsp");
		dispatcher.forward(request, response);
	} */ 
	 /* private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 	String username = request.getParameter("username");
		 	String password = request.getParameter("password");
		 	User existingUser = new User(username,password);
		 	existingUser.setUsername(username);
		 	existingUser.setPassword(password);
		 	userDAO.selectUser(username, password);
		 	response.sendRedirect("loginsuccess.html");
		 	//RequestDispatcher dispatcher = request.getRequestDispatcher("user_form.jsp");
		 	//dispatcher.forward(request, response);
		} */
		 	 
	 /* private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		User existingUser = userDAO.selectUser(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user_form.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);

	} */
	 /* private void insertUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		 	String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			User newUser = new User(firstname,lastname,username,password);
			newUser.setFirstname(firstname);
			newUser.setLastname(lastname);
			newUser.setUsername(username);
			newUser.setPassword(password);
			try {
				userDAO.insertUser(newUser);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("success.html");
		} */   
	 /* private void updateUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");

		User book = new User(id, name, email, country);
		userDAO.updateUser(book);
		response.sendRedirect("list");
	} 
	 private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		userDAO.deleteUser(id);
		response.sendRedirect("list");

	} */ 


} 
