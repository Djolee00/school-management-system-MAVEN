package schoolmanagement.commonlib.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import schoolmanagement.commonlib.model.enums.Level;

class TutorTest {

	private Tutor tutor;

	@BeforeEach
	public void setUp() {
		tutor = new Tutor("John", "Doe", new ArrayList<>());
	}

	@AfterEach
	void tearDown() throws Exception {
		tutor = null;
	}

	@Test
	public void testGetId() {
		assertNull(tutor.getId());
	}

	@Test
	public void testSetId() {
		tutor.setId(1L);
		assertEquals(1L, tutor.getId());
	}

	@Test
	public void testSetIdWithNullId() {
		assertThrows(NullPointerException.class, () -> tutor.setId(null));
	}

	@Test
	public void testGetFirstName() {
		assertEquals("John", tutor.getFirstName());
	}

	@Test
	public void testSetFirstName() {
		tutor.setFirstName("Jane");
		assertEquals("Jane", tutor.getFirstName());
	}

	@Test
	public void testSetFirstNameWithNullFirstName() {
		assertThrows(NullPointerException.class, () -> tutor.setFirstName(null));
	}

	@Test
	public void testSetFirstNameWithShortFirstName() {
		assertThrows(IllegalArgumentException.class, () -> tutor.setFirstName("Jo"));
	}

	@Test
	public void testGetLastName() {
		assertEquals("Doe", tutor.getLastName());
	}

	@Test
	public void testSetLastName() {
		tutor.setLastName("Smith");
		assertEquals("Smith", tutor.getLastName());
	}

	@Test
	public void testSetLastNameWithNullLastName() {
		assertThrows(NullPointerException.class, () -> tutor.setLastName(null));
	}

	@Test
	public void testSetLastNameWithShortLastName() {
		assertThrows(IllegalArgumentException.class, () -> tutor.setLastName("Do"));
	}

	@Test
	public void testGetLanguages() {
		assertEquals(new ArrayList<>(), tutor.getLanguages());
	}

	@Test
	public void testSetLanguages() {
		List<Language> languages = new ArrayList<>();
		languages.add(new Language("English", Level.A1));
		languages.add(new Language("French", Level.A2));
		tutor.setLanguages(languages);
		assertEquals(languages, tutor.getLanguages());
	}

	@Test
	public void testSetLanguagesWithNullLanguages() {
		assertThrows(NullPointerException.class, () -> tutor.setLanguages(null));
	}

	@Test
	public void testToString() {
		assertEquals("John Doe", tutor.toString());
	}

	@Test
	public void testEqualsWithSameObject() {
		assertTrue(tutor.equals(tutor));
	}

	@Test
	public void testEqualsWithNullObject() {
		assertFalse(tutor.equals(null));
	}

	@Test
	public void testEqualsWithDifferentClass() {
		assertFalse(tutor.equals("John Doe"));
	}

	@ParameterizedTest
	@CsvSource({ "1, 1, true", "1, 2, false", "2, 1, false", "2, 2, true" })
	public void testEqualsWithDifferentIds(Long id1, Long id2, boolean expectedResult) {
		Tutor tutor2 = new Tutor("John", "Doe", new ArrayList<>());
		tutor.setId(id1);
		tutor2.setId(id2);
		assertEquals(expectedResult, tutor.equals(tutor2));
	}
}
