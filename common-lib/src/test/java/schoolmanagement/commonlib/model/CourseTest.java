package schoolmanagement.commonlib.model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import schoolmanagement.commonlib.model.enums.Level;

class CourseTest {

	private Course course;
	private Language language;

	@BeforeEach
	void setUp() throws Exception {
		language = new Language("English", Level.A1);

		course = new Course("English", LocalDate.now(), LocalDate.now().plusMonths(3), 30, language);
	}

	@AfterEach
	void tearDown() throws Exception {
		course = null;
		language = null;
	}

	@Test
	public void testGetId() {
		assertNull(course.getId());
	}

	@Test
	public void testSetId() {
		Long id = 12345L;
		course.setId(id);
		assertEquals(id, course.getId());
	}

	@Test
	public void testGetName() {
		assertEquals("English", course.getName());
	}

	@Test
	public void testSetName() {
		String newName = "German";
		course.setName(newName);
		assertEquals(newName, course.getName());
	}

	@Test
	public void testGetStartDate() {
		assertEquals(LocalDate.now(), course.getStartDate());
	}

	@Test
	public void testSetStartDate() {
		LocalDate newStartDate = LocalDate.now().minusDays(1);
		course.setStartDate(newStartDate);
		assertEquals(newStartDate, course.getStartDate());
	}

	@Test
	public void testGetEndDate() {
		assertEquals(LocalDate.now().plusMonths(3), course.getEndDate());
	}

	@Test
	public void testSetEndDate() {
		LocalDate newEndDate = LocalDate.now().plusMonths(4);
		course.setEndDate(newEndDate);
		assertEquals(newEndDate, course.getEndDate());
	}

	@Test
	public void testGetGroupCapacity() {
		assertEquals(30, course.getGroupCapacity());
	}

	@Test
	public void testSetGroupCapacity() {
		int newGroupCapacity = 40;
		course.setGroupCapacity(newGroupCapacity);
		assertEquals(newGroupCapacity, course.getGroupCapacity());
	}

	@Test
	public void testGetLanguage() {
		assertEquals(language, course.getLanguage());
	}

	@Test
	public void testSetLanguage() {
		Language newLanguage = new Language("Spanish", Level.B1);
		course.setLanguage(newLanguage);
		assertEquals(newLanguage, course.getLanguage());
	}

	@Test
	public void testGetCourseEnrollments() {
		assertNull(course.getCourseEnrollments());
	}

	@Test
	public void testSetCourseEnrollments() {
		List<CourseEnrollment> enrollments = new ArrayList<>();
		enrollments.add(new CourseEnrollment());
		course.setCourseEnrollments(enrollments);
		assertEquals(enrollments, course.getCourseEnrollments());
	}

	@Test
	public void testGetCourseGroups() {
		assertNull(course.getCourseGroups());
	}

	@Test
	public void testSetCourseGroups() {
		List<CourseGroup> groups = new ArrayList<>();
		groups.add(new CourseGroup());
		course.setCourseGroups(groups);
		assertEquals(groups, course.getCourseGroups());
	}

	@Test
	public void testToString() {
		assertEquals("English", course.toString());
	}

	@Test
	public void testEqualsSameInstance() {
		assertEquals(course, course);
	}

	@Test
	public void testEqualsNull() {
		assertNotEquals(course, null);
	}

	@Test
	public void testEqualsDifferentClass() {
		assertNotEquals(course, "English");
	}

	@ParameterizedTest
	@CsvSource({ "true, 12345, 12345", "false, 12345, 67890" })
	public void testEqualsSameId(boolean expectedResult, Long id1, Long id2) {
		Course other = new Course("Math", LocalDate.now(), LocalDate.now().plusMonths(3), 30, language);
		other.setId(id2);
		course.setId(id1);
		assertEquals(expectedResult, course.equals(other));
	}

}
