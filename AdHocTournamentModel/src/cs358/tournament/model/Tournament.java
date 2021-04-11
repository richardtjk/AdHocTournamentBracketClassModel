package cs358.tournament.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;


/**
 * Tournament - a tournament with configuration settings
 * 
 * @author richardtj
 *
 */
public class Tournament {
	
	public final static int MAX_TEAMS = 256;
	private final static String DEFAULT_NAME = "Tournament";
	private final static char DEFAULT_SPACER_CHAR = 'X';
	private final static int NBR_NAME_CHARS_IN_CODE = 3;
	
	static Integer accessCodeSeed = 1111;

	private String mName;  	//name of the tournament
	private String mAccessCode;  	//access code of the tournament
	
	private LocalDateTime mStartDate;   //start date of the tournament
	private LocalDateTime mEndDate;   //start date of the tournament

	private TeamManager mTeamManager;  //team's manager
	//private Bracket mBracket;  //Brackets for the tournament
	
	//participants not yet assigned to a team
	private ArrayList<Participant> mUnattachedParticipants;

	/**
	 *    Tournament constructor
	 */
	public Tournament(String name) {
		mUnattachedParticipants = new ArrayList<Participant>();
		
		//use a default name if a name is not provided
		if (name == null || name.isBlank()) {
			mName = DEFAULT_NAME;
		} else {
			mName = name.trim();
		}
		
		//generate a unique access code
		mAccessCode = generateAccessCode();
		
		//default to start today and end it tomorrow
		mStartDate = LocalDate.now().atTime(0, 0);
		mEndDate = mStartDate.plusDays(1);
		
		mTeamManager = new TeamManager();
	}
		
  public void setDates( LocalDateTime start, LocalDateTime end) throws Exception {
  
  	LocalDateTime now = LocalDate.now().atTime(0,0);
		//if not given, start it now
		if (start == null) {
			mStartDate = now;		
		} else if (start.isAfter(now) || start.isEqual(now)) {
			mStartDate = start;
		} else {
		  //if past start  given, throw exception
			throw new Exception("Invalid start date");
		}
		
		//if end date is not given, end it the next day
		if (end == null) {
			mEndDate = now.plusDays(1);
			
		//if end is before start, throw exception
		} else if (end.isBefore(mStartDate) ) {
			throw new Exception("Invalid end date");			
		}
			
	}
	
  /**
   * addParticipant - add a participant without a team
   * 
   * @param participant - a person who wants to be in the tournament
	 */
  public void addParticipant(Participant participant) throws Exception {
  	if (!mUnattachedParticipants.contains(participant)) {
  		mUnattachedParticipants.add(participant);
  	} else {
  		throw new Exception("duplicate participant");
  	}
  	
	}
  
  /**
   * getUnattachedParticipants - return all participants that are not on teams yet
   * 
   * @return ArrayList<Participant>
	 */
  public ArrayList<Participant> getUnattachedParticipants() {

  	return mUnattachedParticipants;
  	
	}
  
  
  /**
   * removeAllUnattachedParticipants - remove all participant without a team
   * 
 	 */
  public void removeAllUnattachedParticipants() {
  
  	mUnattachedParticipants.clear();
  	
	}
	/**
	 * @return the Name
	 */
	public String getName() {
		return mName;
	}
	
	/**
	 * @return the TeamManager
	 */
	public TeamManager getTeamManager() {
		return mTeamManager;
	}

	/**
	 * set the Name
	 */
	public void setName(String name) {
		//use a default name if a name is not provided
		if (name == null || name.isBlank()) {
			mName = DEFAULT_NAME;
		} else {
			mName = name;
		}
		
	}

	/**
	 * @return the mAccessCode
	 */
	public String getAccessCode() {
		return mAccessCode;
	}

	/**
	 * @return the StartDate
	 */
	public LocalDateTime getStartDate() {
		return mStartDate;
	}


	/**
	 * @return the mEndDate
	 */
	public LocalDateTime getEndDate() {
		return mEndDate;
	}

	//generate a unique access code for the tournament
  private String generateAccessCode() {
  	if (mAccessCode == null) {
  		String modifiedName = mName.stripLeading().replace(' ', DEFAULT_SPACER_CHAR);
  		if (modifiedName.length() < NBR_NAME_CHARS_IN_CODE) {
  			modifiedName.concat(Character.toString(DEFAULT_SPACER_CHAR));
  		}
  		mAccessCode = modifiedName.substring(0, NBR_NAME_CHARS_IN_CODE).toUpperCase() + (accessCodeSeed++).toString();
  	}
  	return mAccessCode;
  }
	
  @Override
  public boolean equals(Object o) {
      // self check
      if (this == o)
          return true;
      // null check
      if (o == null)
          return false;
      // type check and cast
      if (getClass() != o.getClass())
          return false;
      Tournament tourney = (Tournament) o;
      // field comparison
      return this.mAccessCode == tourney.mAccessCode;
  }

	
}
