package utwente.groep18.databaseEntries;

import java.util.HashMap;
import java.util.Map;

public enum IdeaDao {
	  instance;
	  
	  private Map<Integer, Idea> contentProvider = new HashMap<Integer, Idea>();
	  
	  private IdeaDao() {
	  }
	  public Map<Integer, Idea> getModel(){
	    return contentProvider;
	  }
	}