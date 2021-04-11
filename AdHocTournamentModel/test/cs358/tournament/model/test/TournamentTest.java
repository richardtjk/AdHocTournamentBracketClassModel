package cs358.tournament.model.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import cs358.tournament.model.Participant;
import cs358.tournament.model.Tournament;

class TournamentTest {

	@Test
	void defaultConstructorTest() {
      Tournament pingPong = new Tournament("PingPong");
      
      //check default start date is today
      LocalDateTime now = LocalDate.now().atTime(0,0);
      Assertions.assertTrue(now.equals(pingPong.getStartDate()));
      System.out.println("Start date: " + pingPong.getStartDate());
      System.out.println("Now: " + now);
     
      //check default end date is tomorrow
      Assertions.assertTrue(now.plusDays(1).equals(pingPong.getEndDate()));
      System.out.println("End date: " + pingPong.getEndDate());
      
      //check code minus last two unique chars
      String code = pingPong.getAccessCode();
  		System.out.println(code);

      Assertions.assertEquals("PIN11", code.substring(0,5));
      System.out.println("Access Code: " + pingPong.getAccessCode());
     
      Assertions.assertEquals("PingPong", pingPong.getName());
      
	}
	
	@Test
	void nullConstructorTest() {
      Tournament nullTourney = new Tournament(null);
      
      //check default start date is today
      LocalDateTime now = LocalDate.now().atTime(0,0);
      Assertions.assertTrue(now.equals(nullTourney.getStartDate()));
      System.out.println("Start date: " + nullTourney.getStartDate());
      System.out.println("Now: " + now);
     
      //check default end date is tomorrow
      Assertions.assertTrue(now.plusDays(1).equals(nullTourney.getEndDate()));
      System.out.println("End date: " + nullTourney.getEndDate());
      
      //check code minus last two unique chars
      String code = nullTourney.getAccessCode();
      Assertions.assertEquals("TOU11", code.substring(0,5));
      System.out.println("Access Code: " + nullTourney.getAccessCode());
     
      Assertions.assertEquals("Tournament", nullTourney.getName());
 
      
	}
	
	@Test
	void setNameTests() {
	  Tournament pingPong = new Tournament("Ping Pong");
	  
	  pingPong.setName("Family Reunion Ping Pong Tournament");
	  Assertions.assertEquals("Family Reunion Ping Pong Tournament", pingPong.getName());
	  
	  //use default name on bad input
	  pingPong.setName("     ");
	  Assertions.assertEquals("Tournament", pingPong.getName());
	  
	  //use default name on null
	  pingPong.setName(null);
	  Assertions.assertEquals("Tournament", pingPong.getName());
	  
	}

	
	@Test
	void setValidDatesTests() {
	  Tournament pingPong = new Tournament("Ping Pong");
	  
	  
    LocalDateTime now = LocalDate.now().atTime(0,0);
    
    //valid dates
	  try {
			pingPong.setDates(now, now.plusDays(1));
		} catch (Exception e) {
			Assertions.fail("valid dates threw an exception");
		}
	  
	}

	@Test
	void setStartAfterEndDatesTests() {
	  Tournament pingPong = new Tournament("Ping Pong");
	  
	  
    LocalDateTime now = LocalDate.now().atTime(0,0);
  
	  
    //start after end
	  boolean exceptionWasThrown =false;
	  try {
			pingPong.setDates(now.plusDays(1), now);
		} catch (Exception e) {
			exceptionWasThrown = true;
		}
	  Assertions.assertTrue(exceptionWasThrown);
	  
	}
	
	@Test
	void setStartAfterTodayTests() {
	  Tournament pingPong = new Tournament("Ping Pong");
	  
	  
    LocalDateTime now = LocalDate.now().atTime(0,0);
	  
    //start before today
	  Boolean exceptionWasThrown =false;
	  try {
			pingPong.setDates(now.minusDays(1), now);
		} catch (Exception e) {
			exceptionWasThrown = true;
		}
	  Assertions.assertTrue(exceptionWasThrown);
	}

	@Test void addParticipantsTest() {
		
	  Tournament pingPong = new Tournament("Ping Pong");
		
	
		for (int i=0; i< 30; i++) {
			try {
				pingPong.addParticipant(new Participant("Joe"+i,"Schmoe","Fake place"));
			} catch (Exception e) {
				Assertions.fail("exception adding participants");
			}
			Assertions.assertEquals(i+1, pingPong.getUnattachedParticipants().size());
		}
		
		//add a duplicate
	  Boolean exceptionWasThrown =false;
		try {
			pingPong.addParticipant(new Participant("Joe0","Schmoe","Fake place"));
		} catch (Exception e) {
			exceptionWasThrown =true;
		}
		Assertions.assertTrue(exceptionWasThrown);
		Assertions.assertEquals(30, pingPong.getUnattachedParticipants().size());
	}
	

}
