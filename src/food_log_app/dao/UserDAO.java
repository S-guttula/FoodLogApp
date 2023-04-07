package food_log_app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import food_log_app.model.FoodItems;
import food_log_app.model.User;
import food_log_app.model.UserProfile;

public class UserDAO {
	
	private String jdbcURL = "jdbc:mysql://127.0.0.1:3306/app";
	private String jdbcUsername = "phanindra";
	private String jdbcPassword = "123456789";
	
	private static final String INSERT_USERS_SQL = ("INSERT INTO users" + "(firstname,lastname,username,pwd) VALUES  "+"(?,?,?,?);");
	private static final String INSERT_PROFILE_SQL = ("INSERT INTO profile" + "(username,height,weight,gender,tweight) VALUES  "+"(?,?,?,?,?);");
	private static final String SELECT_USER_BY_ID = "select * from users where username=? and pwd=?";
	private static final String SELECT_USERPROFILE_BY_USERNAME = "select * from (select username, height, weight, gender, tweight, row_number() over(partition by ? order by id desc) as rn from profile)t where t.rn=1";
	private static final String DELETE_USERPROFILE_BY_USERNAME_SQL = "DELETE FROM profile WHERE username=?";
	private static final String UPDATE_USERPROFILE_BY_USERNAME_SQL = "UPDATE profile SET height=?,weight=?,gender=?,tweight=? WHERE username=?";
	private static final String CALCULATE_CALORIES_BY_USERNAME_SQL = "SELECT * FROM fooditems WHERE item=?";
	//private static final String SELECT_ALL_USERS = "SELECT * FROM users";
	//private static final String DELETE_USERS_SQL = "DELETE FROM users WHERE id=?";
	//private static final String UPDATE_USERS_SQL = "UPDATE users SET name=?,email=?,country=? WHERE id=?";
	
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	public boolean insertUser(User newUser) throws SQLException {
		boolean result = false;
		try(Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)){
				preparedStatement.setString(1, newUser.getFirstname());
				preparedStatement.setString(2, newUser.getLastname());
				preparedStatement.setString(3, newUser.getUsername());
				preparedStatement.setString(4, newUser.getPassword());
				int t = preparedStatement.executeUpdate();
				if(t>0) {
					result = true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return result;
			
		}
	/* public boolean updateUser(User user) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
		PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);){
		statement.setString(1, user.getName());
		statement.setString(2, user.getEmail());
		statement.setString(3, user.getCountry());
		statement.setInt(4, user.getId());
		
		rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
      } */
	 public User selectUser(User existingUser) {
		User user = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID)) {
			preparedStatement.setString(1, existingUser.getUsername());
			preparedStatement.setString(2, existingUser.getPassword());
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String firstName = rs.getString("firstname");
				String lastName = rs.getString("lastname");
				String userName = rs.getString("username");
				String passWord = rs.getString("pwd");
				user = new User(firstName, lastName, userName, passWord);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	} 
	/* public List<User> selectAllUsers() {
		List<User> users = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String country = rs.getString("country");
				users.add(new User(id, name, email, country));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	} */
	/* public boolean deleteUser(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	} */

	public boolean createProfile(UserProfile newProfile) {
		// TODO Auto-generated method stub
		boolean result = false;
		try(Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PROFILE_SQL)){
						preparedStatement.setString(1, newProfile.getUsername());
						preparedStatement.setInt(2, newProfile.getHeight());
						preparedStatement.setInt(3, newProfile.getWeight());
						preparedStatement.setString(4, newProfile.getGender());
						preparedStatement.setInt(5, newProfile.getTweight());
						int t = preparedStatement.executeUpdate();
						if(t>0) {
							result = true;
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				return result;
	}

	public ArrayList<UserProfile> viewUserProfile(String userName) {
		// TODO Auto-generated method stub
		ArrayList<UserProfile> userProfile = new ArrayList<>();
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USERPROFILE_BY_USERNAME);){
			preparedStatement.setString(1, userName);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int height = rs.getInt("height");
				int weight = rs.getInt("weight");
				String gender = rs.getString("gender");
				int tWeight = rs.getInt("tweight");
				userProfile.add(new UserProfile(height, weight, gender, tWeight));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return userProfile;
	}

	public boolean deleteProfile(String userName) {
		// TODO Auto-generated method stub
		boolean result = false;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERPROFILE_BY_USERNAME_SQL);) {
			preparedStatement.setString(1, userName);
			int t = preparedStatement.executeUpdate();
			if(t>0) {
				result = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public boolean updateUserProfile(UserProfile newProfile) {
		// TODO Auto-generated method stub
		boolean result = false;
		try(Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERPROFILE_BY_USERNAME_SQL)){
						preparedStatement.setInt(1, newProfile.getHeight());
						preparedStatement.setInt(2, newProfile.getWeight());
						preparedStatement.setString(3, newProfile.getGender());
						preparedStatement.setInt(4, newProfile.getTweight());
						preparedStatement.setString(5, newProfile.getUsername());
						int t = preparedStatement.executeUpdate();
						if(t>0) {
							result = true;
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				return result;
	}

	public ArrayList<FoodItems> calculateCalories(FoodItems calCalories) {
		// TODO Auto-generated method stub
		ArrayList<FoodItems> calCount = new ArrayList<>();
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(CALCULATE_CALORIES_BY_USERNAME_SQL);){
			/* preparedStatement.setString(1, calCalories.getUserName()); */
			preparedStatement.setString(1, calCalories.getFoodItem());
			/* preparedStatement.setInt(3, calCalories.getQuantity()); */
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				/* String userName = rs.getString("username"); */
				String item = rs.getString("item");
				/* int quantity = rs.getInt("quantity"); */
				float itemValue = rs.getFloat("itemvalue");
				/* int calories = rs.getInt("calories"); */
				calCount.add(new FoodItems(item,itemValue));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return calCount;
		
	} 

}
