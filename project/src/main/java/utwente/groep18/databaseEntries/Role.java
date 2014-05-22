package utwente.groep18.databaseEntries;

/**
 * The role of a {@link User} within the ThinkTank community.<br>
 * <li> USER - a normal user of the community with no administrative rights.
 * <li> ADMIN - an admin user of the community with all administrative rights.
 * @author Rob en René
 */
 public enum Role {
	
	USER, ADMIN;
	
	/**
	 * Return the role belonging to the description.
	 * 
	 * @param description of the role
	 */
	public Role getRole(String description) {
		if (description.equals("user")) {
			return Role.USER;
		} else if (description.equals("admin")) {
			return Role.ADMIN;
		} else {
			return null;
		}
	}
	
	/**
	 * Returns the String description of the role.
	 */
	@Override
	public String toString() {
		if (this.equals(USER)) {
			return "user";
		} else if (this.equals(ADMIN)) {
			return "admin";
		} else {
			return "unknown";
		}
	}
	
}
