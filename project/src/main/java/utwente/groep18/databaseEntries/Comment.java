package utwente.groep18.databaseEntries;

import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Represents a comment of a user on an item extending {@link Node}.<br>
 * For instance on an {@link Idea} or {@link ConcreteIdea}.
 * 
 * @author Rob van Emous
 */
public class Comment {

	private GregorianCalendar dateAndTime;
	private String message;
	private Votes votes;
	
	/**
	 * Creates a new comment with date and time set to 
	 * <code>System.currentTimeMillis()</code> and the default: 
	 * (<code>new Votes()</code>) {@link Votes} object.<br>
	 * @param message the actual message of the comment
	 * @param votes the {@link Votes} belonging to this comment.
	 */
	public Comment(String message) {
		dateAndTime = new GregorianCalendar(Locale.FRANCE);
		dateAndTime.setTimeInMillis(System.currentTimeMillis());
		this.message = message;
		this.votes = new Votes();
	}
	
	/**
	 * Creates a new comment with date and time set to 
	 * <code>System.currentTimeMillis()</code>.
	 * @param message the actual message of the comment
	 * @param votes the {@link Votes} belonging to this comment.
	 */
	public Comment(String message, Votes votes) {
		dateAndTime = new GregorianCalendar(Locale.FRANCE);
		dateAndTime.setTimeInMillis(System.currentTimeMillis());
		this.message = message;
		this.votes = votes;
	}
	
	/**
	 * Creates a new comment.
	 * @param time the time (of creation) of the comment
	 * @param message the actual message of the comment
	 * @param votes the {@link Votes} belonging to this comment.
	 */
	public Comment(long time, String message, Votes votes) {
		dateAndTime = new GregorianCalendar(Locale.FRANCE);
		dateAndTime.setTimeInMillis(time);
		this.message = message;
		this.votes = votes;
	}
	
	/**
	 * Returns the {@link GregorianCalendar} object associated
	 * with this comment from which the date and time can be obtained.
	 */
	public GregorianCalendar getDateAndTime() {
		//TODO
		return dateAndTime;
	}
	
	/**
	 * Returns the time in ms from epoc (01.01.1970) associated with this 
	 * comment.
	 */
	public long getDateAndTimeLong() {
		return dateAndTime.getTimeInMillis();
	}
	
	/**
	 * Returns the actual message of this comment.
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * Returns the {@link Votes} belonging to this comment.
	 */
	public Votes getVotes() {
		return votes;
	}
	
	/**
	 * Describes the Concrete idea.
	 */
	@Override
	public String toString() {
		return "Comment - date and time: " + dateAndTime + ", Message: " + message + ", Votes: " + votes.toString();
	}
	
}
