package utwente.groep18.databaseEntries;

import java.util.ArrayList;

/**
 * Represents a field of study which is associated with several skills<br>
 * 
 * @author Rob van Emous
 */
public class FieldOfStudy {
	
	private String description;
	private ArrayList<Skill> skills;
	
	/**
	 * Creates a new field of study.
	 * 
	 * @param description the description of the field of study
	 * @param skills associated with this field of study
	 */
	public FieldOfStudy(String description, ArrayList<Skill> skills) {
		this.description = description;
		this.skills = skills;
	}
	
	/**
	 * Returns the description of the field of study.
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Returns the skills associated with this field of study.
	 */
	public ArrayList<Skill> getSkills() {
		return skills;
	}
	
	/**
	 * Sets the skills of this field of study.
	 */
	public void setSkills(ArrayList<Skill> skills) {
		skills.clear();
		skills.addAll(skills);
	}
	
	/**
	 * Adds skills to this field of study.
	 */
	public void addSkills(ArrayList<Skill> skills) {
		skills.addAll(skills);
	}
	
	/**
	 * Adds a skill to this field of study.
	 */
	public void addSkill(Skill skill) {
		skills.add(skill);
	}

	/**
	 * Describes the Field of study.
	 */
	@Override
	public String toString() {
		return "Field of study - Description: " + description + ", Skills: " + skills.toString();
	}
}
