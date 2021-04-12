package cs358.tournament.model.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import cs358.tournament.model.Participant;

class ParticipantPersistTest {

	@Test
	void existingParticipantDB() {
		Participant maisy = new Participant(1);
		Assertions.assertEquals("Maisy", maisy.getFirstName());
		Assertions.assertEquals("Richardt", maisy.getLastName());
		Assertions.assertEquals("Pet Crew", maisy.getOrganization());

			
	}
	
	@Test
	void addParticipantDB() {
		Participant cutie = new Participant("Cutie","Richardt","Pet Crew");
		cutie.persist();
		Assertions.assertEquals("Cutie", cutie.getFirstName());
		Assertions.assertEquals("Richardt", cutie.getLastName());
		Assertions.assertEquals("Pet Crew", cutie.getOrganization());
		
		cutie.setOrganization("Hamster Crew");
		cutie.persist();
		Assertions.assertEquals("Cutie", cutie.getFirstName());
		Assertions.assertEquals("Richardt", cutie.getLastName());
		Assertions.assertEquals("Hamster Crew", cutie.getOrganization());
		
		cutie.deletePersistedObject();
		
		Assertions.assertFalse(cutie.fetchPersistedObject());
			
	}
	
	@Test
	void updateParticipantDB() {
		Participant puffy = new Participant(3,"Puffy","Richardt","Hamster Crew");
		Assertions.assertEquals("Puffy", puffy.getFirstName());
		Assertions.assertEquals("Richardt", puffy.getLastName());
		Assertions.assertEquals("Hamster Crew", puffy.getOrganization());
		
		
		//discard change to Hamster Crew
		puffy.fetchPersistedObject();
		Assertions.assertEquals("Puffy", puffy.getFirstName());
		Assertions.assertEquals("Richardt", puffy.getLastName());
		Assertions.assertEquals("Pet Crew", puffy.getOrganization());
	
		
		//rechange to Hamster Crew
		puffy.setOrganization("Hamster Crew");
		puffy.persist();
		Assertions.assertEquals("Puffy", puffy.getFirstName());
		Assertions.assertEquals("Richardt", puffy.getLastName());
		Assertions.assertEquals("Hamster Crew", puffy.getOrganization());
			
		//reset to back to Pet Crew
		puffy.setOrganization("Pet Crew");
		puffy.persist();
		Assertions.assertEquals("Puffy", puffy.getFirstName());
		Assertions.assertEquals("Richardt", puffy.getLastName());
		Assertions.assertEquals("Pet Crew", puffy.getOrganization());

		
	}


}
