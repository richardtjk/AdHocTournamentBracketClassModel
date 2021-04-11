package cs358.tournament.model.test;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import cs358.tournament.model.Tournament;
import cs358.tournament.model.TournamentManager;

class TournamentManagerTest {

	@Test
	void testAddFindingTournaments() {
    Tournament pingPong = new Tournament("PingPong");
    Tournament tennis = new Tournament("Tennis");
    Tournament nullTourney = new Tournament(null);
    Tournament empty = new Tournament("");

    Assertions.assertFalse(nullTourney.equals(empty));

    
    TournamentManager.getInstance().addTournament(pingPong);
    TournamentManager.getInstance().addTournament(tennis); 
    TournamentManager.getInstance().addTournament(nullTourney);    
    TournamentManager.getInstance().addTournament(empty);
    
    Tournament found = TournamentManager.getInstance().findTournament(pingPong.getAccessCode());
    Assertions.assertTrue(pingPong.equals(found));
    
    Tournament found2 = TournamentManager.getInstance().findTournament(nullTourney.getAccessCode());
    Assertions.assertTrue(nullTourney.equals(found2));
    
	}

	@Test
	void testGettingTournaments() {
    Tournament pingPong = new Tournament("PingPong");
    Tournament tennis = new Tournament("Tennis");
    Tournament nullTourney = new Tournament(null);
    Tournament empty = new Tournament("");
  
    TournamentManager.getInstance().addTournament(pingPong);
    TournamentManager.getInstance().addTournament(tennis); 
    TournamentManager.getInstance().addTournament(nullTourney);    
    TournamentManager.getInstance().addTournament(empty);
    
    ArrayList<Tournament> list = TournamentManager.getInstance().getAllTournaments();
    Assertions.assertTrue(list.contains(pingPong));
    Assertions.assertTrue(list.contains(tennis));
    Assertions.assertTrue(list.contains(nullTourney));
    Assertions.assertTrue(list.contains(empty));
    
    Assertions.assertEquals(4, list.size());
	}

}
