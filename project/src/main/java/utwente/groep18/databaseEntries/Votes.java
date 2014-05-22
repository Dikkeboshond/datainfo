package utwente.groep18.databaseEntries;

/**
 * Represents the votes on an {@link Idea} or a {@link Comment}.
 * 
 * @author Rob
 */
public class Votes {
	
	int upVotes;
	int downVotes;
	
	/**
	 * Create a new Votes holder with the default up- and down-votes (both zero).
	 */
	public Votes() {
		upVotes = 0;
		downVotes = 0;
	}
	
	/**
	 * Create a new Votes holder with already defined up- and down-votes.
	 * 
	 * @param upVotes the amount of up-votes
	 * @param downVotes the amount of down-votes
	 */
	public Votes(int upVotes, int downVotes) {
		this.upVotes = upVotes;
		this.downVotes = downVotes;
	}
	
	/**
	 * Create a new Votes holder which is a copy of the provided votes.
	 * 
	 * @param votes to copy from
	 */
	public Votes(Votes votes) {
		this.upVotes = votes.getUpVotes();
		this.downVotes = votes.getDownVotes();
	}
	
	/**
	 * Add one vote to the up-votes.
	 */
	public void voteUp() {
		upVotes++;
	}
	
	/**
	 * Add one vote to the down-votes.
	 */
	public void voteDown() {
		downVotes++;
	}
	
	/**
	 * Returns the amount of up-votes.
	 */
	public int getUpVotes() {
		return upVotes;
	}
	
	/**
	 * Returns the amount of down-votes.
	 */
	public int getDownVotes() {
		return downVotes;
	}
	
	/**
	 * Returns the netto votes: upVotes minus downVotes.<br>
	 * This could be a negative number.
	 */
	public int getNettoMark() {
		return upVotes - downVotes;
	}
	
	/**
	 * Set the amount of up-votes.
	 * @param upVotes the new number of up-votes
	 */
	public void setUpVotes(int upVotes) {
		this.upVotes = upVotes;
	}
	
	/**
	 * Set the amount of down-votes.
	 * @param upVotes the new number of down-votes
	 */
	public void setDownVotes(int downVotes) {
		this.downVotes = downVotes;
	}
	
	/**
	 * Describes the Votes.
	 */
	@Override
	public String toString() {
		return "Vote - netto mark: " + getNettoMark() + ", upvotes: " + upVotes + ", downvotes: " + downVotes;
	}
}
