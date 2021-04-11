package cs358.tournament.model.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

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
	void nullConstructorTest1() {
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


}
