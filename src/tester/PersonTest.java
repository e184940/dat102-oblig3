package tester;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mengder.Person;

class PersonTest {
	
	Person per = new Person("Per", "Fiske");

	@Test
	void testOpprettePerson() {
		String[] perHobby = {"Fiske"};
		assertEquals("Per", per.getNavn());
		assertArrayEquals(perHobby, per.getHobby().tilTabell());
	}

}
