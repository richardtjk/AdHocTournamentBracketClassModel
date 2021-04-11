package cs358.tournament.model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * TournamentManager - Singleton to manage the tournaments based on the access code
 *
 * @author richardtj
 *
 */
public class TournamentManager {

	//Map of tournaments based on access key string
	private HashMap<String, Tournament> mTournaments;
	
	//singleton instance
	private static TournamentManager instance = null;
	
	
	//private constructor
	private TournamentManager() {
		mTournaments = new HashMap<String, Tournament>();
	}
	
	/**
	 * getInstance returns the TournamentManager singleton
	 * @return TournamentManager
	 */
	public static TournamentManager getInstance() {
	
	  //if instance hasn't been created yet
		if (instance == null) {
			instance = new TournamentManager();
		}
		
		return instance;
	}
	
	/**
	 * findTournament - finds the tournament based on the access code
	 * @return Tournament
	 *
	 */
	public Tournament findTournament(String accessCode) {
		return mTournaments.get(accessCode);
	}
	
	/**
	 * addTournament - add tournament to the manager
	 * @param Tournament
	 *
	 */
	public void addTournament(Tournament tourney) {
		mTournaments.put(tourney.getAccessCode(), tourney);
	}
	
	/**
	 * getAllTournaments - return all tournaments
	 *
	 */
	public ArrayList<Tournament> getAllTournaments() {
		return new ArrayList<Tournament>(mTournaments.values());
	}
}
