package utwente.groep18.databaseEntries;

import java.util.HashMap;
import java.util.Map;

public enum IdeaDao {
	  instance;
	  
	  private Map<String, Idea> contentProvider = new HashMap<String, Idea>();
	  
	  private IdeaDao() {
	  }
	  public Map<String, Idea> getModel(){
	    return contentProvider;
	  }
	}