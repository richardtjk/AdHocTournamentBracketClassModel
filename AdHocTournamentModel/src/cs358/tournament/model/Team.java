/**
 * 
 */
package cs358.tournament.model;

import java.util.ArrayList;

/**
 * Team - named list of participants to play in a tournament
 * @author jocelyn
 *
 */
public class Team {

	private final static String DEFAULT_TEAM_NAME = "Team";
	
	private ArrayList<Participant> mMembers;
	private String mTeamName;
	

	/**
	 * Constructor
	 * @param name - name of the team
	 */
	public Team(String name) {
		mMembers = new ArrayList<Participant>();
		if (name==null || name.isBlank()){
			mTeamName = DEFAULT_TEAM_NAME;
		} else {
			mTeamName = name.trim();
		}
	}
	
	/**
	 * addMember - adds a participant to a team
	 * 
	 * @param participant to add to the team
	 * @throws Exception 
	 */
	public void addMember(Participant participant) throws Exception {
		if (!mMembers.contains(participant)) {
			mMembers.add(participant);
		} else {
			throw new Exception("Duplicate participant");
		}
	}
  
	/**
	 * removeMember - removes a participant from a team
	 * 
	 * @param participant to remove from the team
	 */
	public void removeMember(Participant participant) {
		mMembers.remove(participant);
	}
	
	/**
	 * getMembers - returns list of members from the team
	 * @return 
	 * 
	 */
	public ArrayList<Participant> getMembers() {
		return mMembers;
	}
}
