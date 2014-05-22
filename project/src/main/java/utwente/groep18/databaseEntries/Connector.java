package utwente.groep18.databaseEntries;

import java.util.ArrayList;

/**
 * Test class that provides dummy ideas to load on the webpage while the database query functions are not yet available.
 * @author Christiaan
 */

public class Connector {
	public static final String dummyDescription = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus...";
	public static final String dummyTitle = "Lorem ipsum dolor sit amet";
	public static Object[] getIdeas() {
		ArrayList<Idea> ideas = new ArrayList<Idea>();
		ArrayList<FieldOfStudy> fields = new ArrayList<FieldOfStudy>();
		ArrayList<Skill> skills = new ArrayList<Skill>();
		skills.add(new Skill("CSS"));
		skills.add(new Skill("JavaScript"));
		fields.add(new FieldOfStudy(dummyDescription, skills));
		ideas.add(new Idea(new Node(dummyTitle, false), fields, dummyDescription, null, new Votes(15151, 1684)));
		ideas.add(new Idea(new Node(dummyTitle, false), fields, dummyDescription, null, new Votes(1233, 442)));
		ideas.add(new Idea(new Node(dummyTitle, false), fields, dummyDescription, null, new Votes(12314, 2332)));
		return ideas.toArray();
	}
}
