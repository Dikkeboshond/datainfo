package utwente.groep18.databaseEntries;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Represents an item with a title and date on the ThinkTank website.<br>
 * This could for instance be an {@link Idea} or a {@link ConcreteIdea}.
 * 
 * @author Rob van Emous
 */
public class Node {
	private static final String[] monthString = {
		"Januari",
		"Februari",
		"March",
		"April",
		"May",
		"June",
		"Juli",
		"August",
		"October",
		"November",
		"December"
	};
	private Integer id;
	private String title;
	private GregorianCalendar dateAndTime;
	private ArrayList<Comment> comments;
	private boolean commentsEnabled;
	
	/**
	 * Creates a new Node.
	 * @param title the title of the node
	 * @param time the time (of creation) of the node
	 * @param comments the comments on this node
	 */
	public Node(String title, long time, ArrayList<Comment> comments) {
		this.title = title;
		dateAndTime = new GregorianCalendar(Locale.FRANCE);
		dateAndTime.setTimeInMillis(time);
		this.comments = new ArrayList<Comment>();
		if (comments != null) {
			addComments(comments);
		} 
		commentsEnabled = true;
	}
	
	/**
	 * Creates a new Node with date and time set to 
	 * <code>System.currentTimeMillis()</code>.
	 * @param title the title of the node
	 * @param commentsEnabled whether or not comments are allowed on this
	 * 		  node
	 */
	public Node(String title, boolean commentsEnabled) {
		this.title = title;
		dateAndTime = new GregorianCalendar(Locale.FRANCE);
		dateAndTime.setTimeInMillis(System.currentTimeMillis());
		this.comments = new ArrayList<Comment>();
		this.commentsEnabled = commentsEnabled;
	}
	
	/**
	 * Creates a new node which is a copy of the provided node.
	 * 
	 * @param node to be copied
	 */
	public Node(Node node) {
		this.title = node.getTitle();
		dateAndTime = new GregorianCalendar(Locale.FRANCE);
		dateAndTime.setTimeInMillis(node.getDateAndTimeLong());
		this.comments = new ArrayList<Comment>(node.getComments());
		this.commentsEnabled = node.commentsEnabled();
	}
	
	
	/**
	 * Returns the title of the node.
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Returns the {@link GregorianCalendar} object associated
	 * with this node from which the date and time can be obtained.
	 */
	public GregorianCalendar getDateAndTime() {
		@SuppressWarnings("unused")
		Date date = new Date(dateAndTime.getTimeInMillis());
		//TODO
		return null;
	}
	
	/**
	 * Returns the time in ms from epoc (01.01.1970) associated with this 
	 * node.
	 */
	public long getDateAndTimeLong() {
		return dateAndTime.getTimeInMillis();
	}
	
	/**
	 * Returns the time as a formatted String (MONTH, DAY, YEAR - HOUR:MINUTES)
	 */
	public String getDateAndTimeString() {
		int month = dateAndTime.get(Calendar.MONTH);
		int day = dateAndTime.get(Calendar.DAY_OF_MONTH);
		int year = dateAndTime.get(Calendar.YEAR);
		int hour = dateAndTime.get(Calendar.HOUR_OF_DAY);
		int minute = dateAndTime.get(Calendar.MINUTE);
		return monthString[month] + " " + day + ", " + year + " - " + hour + ":" + minute;
	}
	
	/**
	 * Returns whether comments are enabled on this node.
	 */
	public boolean commentsEnabled() {
		return commentsEnabled;
	}
	
	/**
	 * Returns the comments on this node. Returns <code>null</code>
	 * if <code>!commentsEnabled()</code> or if no comments were added to 
	 * this node.
	 */
	public ArrayList<Comment> getComments() {
		return comments;
	}
	
	/**
	 * Set the comments of this node. 
	 * @param comments the comments on this node
	 */
	public void setComments(ArrayList<Comment> comments) {
		this.comments = comments;
	}
	
	/**
	 * Add a comment to this node. 
	 * @param comment the comment to add to this node
	 */
	public void addComment(Comment comment) {
		this.comments.add(comment);
	}
	
	/**
	 * Add the comments to this node. 
	 * @param comments the comments to add to this node
	 */
	public void addComments(ArrayList<Comment> comments) {
		this.comments.addAll(comments);
	}
	
	/**
	 * 
	 * @return the id of this Node
	 */
	public Integer getId() {
		 return id;
	}
	
	/**
	 * Set the id of this Node
	 * @param idArg the id that will replace the current id
	 */
	public void setId(int idArg) {
		id = idArg;
	}
	
	/**
	 * Describes the Node.
	 */
	@Override
	public String toString() {
		return "Node - title: " + title + ", date and time: " + dateAndTime.toString() + ", " + "Comments enabled: " + new Boolean(commentsEnabled).toString() + (commentsEnabled ? ", comments: " + comments.toString() : "");
	}
}
