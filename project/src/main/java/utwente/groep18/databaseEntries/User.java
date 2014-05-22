package utwente.groep18.databaseEntries;

/**
 * A thinkTank user.<br>
 * This can be a normal user or an admin based on it's {@link Role}.
 * 
 * @author Rob & René 
 */
public class User {
	
	private String smdNumber;
	private String name;
	private Role role;
	
	/**
	 * Creates a new user.
	 * 
	 * @param smdNumber the s/m/d number of the user 
	 * @param name the name of the user
	 * @param role the {@link role} of the user
	 */
	public User(String smdNumber, String name, Role role) {
		this.smdNumber = smdNumber;
		this.name = name;
		this.role = role;
	}
	
	/**
	 * Returns the s/m/d number of the user.<br>
	 * This String begins with an 's', 'm' or 'd' followed by 8 numbers.
	 */
	public String getSmdNumber() {
		return smdNumber;
	}
	
	/**
	 * Returns the name of the user.<br>
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns the {@link Role} of the user.<br>
	 */
	public Role getRole() {
		return role;
	}
	
	/**
	 * Describes the User.
	 */
	@Override
	public String toString() {
		return "User - s/m/d-number: " + smdNumber + ", Name: " + name + ", Role: " + role.toString();
	}
	
}
