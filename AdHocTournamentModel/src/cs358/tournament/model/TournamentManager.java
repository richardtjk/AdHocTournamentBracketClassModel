package cs358.tournament.model;

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
	private static TournamentManager mInstance = null;
	
	
	//private constructor
	private TournamentManager() {
		mTournaments = new HashMap<String, Tournament>();
	}
	
	/**
	 * getInstance returns the TournamentManager singleton
	 * @return
	 */
	public static TournamentManager getInstance() {
	
	  //if instance hasn't been created yet
		if (mInstance == null) {
			mInstance = new TournamentManager();
		}
		
		return mInstance;
	}
}
