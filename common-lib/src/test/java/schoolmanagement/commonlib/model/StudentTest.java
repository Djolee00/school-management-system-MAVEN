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

class StudentTest {
	private Student student;

	@BeforeEach
	public void setUp() throws Exception {
		student = new Student(1L, "username", "password", "John", "Doe", LocalDate.of(2000, 1, 1), LocalDate.now());
	}

	@AfterEach
	void tearDown() throws Exception {
		student = null;
	}

	@Test
	public void testGetFirstName() {
		assertEquals("John", student.getFirstName());
	}

	@Test
	public void testSetFirstName() {
		student.setFirstName("Jane");
		assertEquals("Jane", student.getFirstName());
	}

	@Test
	public void testSetFirstNameWithNull() {
		assertThrows(NullPointerException.class, () -> student.setFirstName(null));
	}


	@Test
	public void testGetLastName() {
		assertEquals("Doe", student.getLastName());
	}

	@Test
	public void testSetLastName() {
		student.setLastName("Smith");
		assertEquals("Smith", student.getLastName());
	}

	@Test
	public void testSetLastNameWithNull() {
		assertThrows(NullPointerException.class, () -> student.setLastName(null));
	}


	@Test
	public void testGetBirthdate() {
		assertEquals(LocalDate.of(2000, 1, 1), student.getBirthdate());
	}

	@Test
	public void testSetBirthdate() {
		LocalDate newBirthdate = LocalDate.of(1995, 5, 10);
		student.setBirthdate(newBirthdate);
		assertEquals(newBirthdate, student.getBirthdate());
	}

	@Test
	public void testSetBirthdateWithNull() {
		assertThrows(NullPointerException.class, () -> student.setBirthdate(null));
	}

	@Test
	public void testSetBirthdateWithFutureDate() {
		LocalDate futureDate = LocalDate.now().plusDays(1);
		assertThrows(IllegalArgumentException.class, () -> student.setBirthdate(futureDate));
	}

	@Test
	public void testGetCreationDate() {
		assertEquals(LocalDate.now(), student.getCreationDate());
	}

	@Test
	public void testSetCreationDate() {
		LocalDate newCreationDate = LocalDate.of(2021, 9, 1);
		student.setCreationDate(newCreationDate);
		assertEquals(newCreationDate, student.getCreationDate());
	}

	@Test
	public void testSetCreationDateWithNull() {
		assertThrows(NullPointerException.class, () -> student.setCreationDate(null));
	}

	@Test
	public void testGetCourseEnrollments() {
		assertNull(student.getCourseEnrollments());
	}

	@Test
	public void testSetCourseEnrollments() {
		List<CourseEnrollment> courseEnrollments = new ArrayList<>();
		student.setCourseEnrollments(courseEnrollments);
		assertEquals(courseEnrollments, student.getCourseEnrollments());
	}

	@Test
	public void testGetCourseGroups() {
		assertNull(student.getCourseGroups());
	}

	@Test
	public void testSetCourseGroups() {
		List<CourseGroup> courseGroups = new ArrayList<>();
		student.setCourseGroups(courseGroups);
		assertEquals(courseGroups, student.getCourseGroups());
	}

	@Test
	public void testEqualsWithSameStudent() {
		assertTrue(student.equals(student));
	}

	@Test
	public void testEqualsWithNull() {
		assertFalse(student.equals(null));
	}

	@Test
	public void testEqualsWithDifferentClass() {
		assertFalse(student.equals("John Doe"));
	}

	@Test
	public void testToString() {
		assertEquals("John Doe", student.toString());
	}

	@ParameterizedTest
	@CsvSource({ "1, username, password, John, Doe, 2000-01-01, true",
			"2, username, password, Jane, Smith, 1995-05-10, false",
			"3, username, password, John, Doe, 2000-01-01, false" })
	public void testEquals(long id, String username, String password, String firstName, String lastName,
			LocalDate birthdate, boolean expectedResult) {
		Student student1 = new Student(id, username, password, firstName, lastName, birthdate, LocalDate.now());
		Student student2 = new Student(1L, "username", "password", "John", "Doe", LocalDate.of(2000, 1, 1),
				LocalDate.now());

		assertEquals(expectedResult, student1.equals(student2));
	}
}
