package utwente.groep18.databaseEntries;

/**
 * The sort type to sort {@link Idea}'s by when returning entries from the database.
 * 
 * @author Rob van Emous
 */
public enum SortType {
	DATE, VOTES;
	
	/**
	 * Returns the sort type associated with this ordinal (index number).<br>
	 * @param ordinal to use
	 */
	public SortType getSortType(int ordinal) {
		return values()[ordinal];
	}
	
	/**
	 * Return the sort type as an int.<br>
	 * (the ordinal of the type)
	 */
	public int toInt() {		
		return ordinal();
	}
	
	/**
	 * Describes the Sort type.
	 */
	@Override
	public String toString() {
		if (this.equals(DATE)) {
			return "date";
		} else if (this.equals(VOTES)) {
			return "votes";
		} else {
			return "unknown";
		}
	}
}
