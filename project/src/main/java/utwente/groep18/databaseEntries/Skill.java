package utwente.groep18.databaseEntries;

/**
 * A skill of a {@link User} or skills belonging to an {@link Idea}<br>
 * 
 * @author Rob & René
 */
public class Skill {
	
	private String description;
	
	/**
	 * Creates a new skill.
	 * 
	 * @param description of the skill
	 */
	public Skill(String description) {
		this.description = description;
	}
	
	/**
	 * Returns the description of the skill.
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Describes the Skill.
	 */
	@Override
	public String toString() {
		return "Skill - Description: " + description;
	}
}
