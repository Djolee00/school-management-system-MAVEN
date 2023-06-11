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

class LanguageTest {

	private Language language;
	private List<Tutor> tutors;
	private List<Course> courses;

	@BeforeEach
	public void setup() {
		language = new Language("English", Level.A1);
		tutors = new ArrayList<>();
		courses = new ArrayList<>();
	}

	@AfterEach
	void tearDown() throws Exception {
		language = null;
		tutors = null;
		courses = null;
	}

	@Test
	public void testLanguageConstructor() {
		assertEquals("English", language.getName());
		assertEquals(Level.A1, language.getLevel());
		assertNull(language.getId());
		assertNull(language.getTutors());
		assertNull(language.getCourses());
	}

	@Test
	public void testGetId() {
		assertNull(language.getId());
	}

	@Test
	public void testSetId() {
		language.setId(1L);
		assertEquals(1L, language.getId());
	}

	@Test
	public void testGetName() {
		assertEquals("English", language.getName());
	}

	@Test
	public void testSetName() {
		language.setName("French");
		assertEquals("French", language.getName());
	}

	@Test
	public void testGetLevel() {
		assertEquals(Level.A1, language.getLevel());
	}

	@Test
	public void testGetTutors() {
		assertNull(language.getTutors());
	}

	@Test
	public void testSetTutors() {
		language.setTutors(tutors);
		assertEquals(tutors, language.getTutors());
	}

	@Test
	public void testGetCourses() {
		assertNull(language.getCourses());
	}

	@Test
	public void testSetCourses() {
		language.setCourses(courses);
		assertEquals(courses, language.getCourses());
	}

	@Test
	public void testSetLevel() {
		language.setLevel(Level.A2);
		assertEquals(Level.A2, language.getLevel());
	}

	@Test
	public void testToString() {
		String expectedString = "English A1";
		assertEquals(expectedString, language.toString());
	}

	@Test
	public void testEqualsWithSameObject() {
		assertTrue(language.equals(language));
	}

	@Test
	public void testEqualsWithNull() {
		assertFalse(language.equals(null));
	}

	@Test
	public void testEqualsWithDifferentClass() {
		String str = "English";
		assertFalse(language.equals(str));
	}

	@ParameterizedTest
	@CsvSource({ "English, A1, English, A1, true", "English, A1, English, B2, false", "English, A1, French, A1, false",
			"English, A1, French, B2, false"})
	public void testEquals(String name1, Level level1, String name2, Level level2, boolean expected) {
		Language language1 = new Language(name1, level1);
		Language language2 = new Language(name2, level2);
		assertEquals(expected, language1.equals(language2));
	}

}
