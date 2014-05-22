package utwente.groep18.databaseEntries;

import java.util.ArrayList;

/**
 * An elaborated Idea for the ThinkTank.<br>
 * This idea is the extended version of {@link Idea}.
 * 
 * @author Rob van Emous
 */
public class ConcreteIdea extends Idea {
	
	private ArrayList<Skill> customSkills;
	
	/**
	 * Create a new concrete idea.
	 * 
	 * @param idea the idea to use
	 * @param customSkills the skills added by the {@link User}
	 */
	public ConcreteIdea(Idea idea, ArrayList<Skill> customSkills) {
		super(idea);
		this.customSkills = customSkills;
	}
	
	/**
	 * Returns the skills of all fields of study associated with this 
	 * idea and the skills added by the {@link User}.
	 */
	@Override
	public ArrayList<Skill> getSkills() {
		ArrayList<Skill> AllSkills = new ArrayList<Skill>(super.getSkills());
		AllSkills.addAll(customSkills);
		return AllSkills;
	}
	
	/**
	 * Describes the Concrete idea.
	 */
	@Override
	public String toString() {
		return "Concrete idea - (" + super.toString() + "), Custom skills: " + customSkills.toString();
	}
}
