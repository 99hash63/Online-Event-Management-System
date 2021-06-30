package em.user;

//implementation of UserDetails class 
public class UserDetails {

	private int id; 
	private String name; 
	private String email;
	private String address;
	private String phone; 
	private String username; 
	private String password; 
	
//	EventManager constructor
	public UserDetails(int id, String name, String email, String address, String phone, String username,
			String password) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.username = username;
		this.password = password;
	}

//	getters for attributes of EventManager class
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

}
