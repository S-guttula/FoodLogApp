package food_log_app.model;

public class UserProfile {
	private String username;
	private int height;
	private int weight;
	private String gender;
	private int tweight;
	
	public UserProfile(String username, int height, int weight, String gender, int tweight) {
		super();
		this.username = username;
		this.height = height;
		this.weight = weight;
		this.gender = gender;
		this.tweight = tweight;
	}
	

	public UserProfile(int height, int weight, String gender, int tweight) {
		super();
		this.height = height;
		this.weight = weight;
		this.gender = gender;
		this.tweight = tweight;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getTweight() {
		return tweight;
	}

	public void setTweight(int tweight) {
		this.tweight = tweight;
	}
	
	
}
