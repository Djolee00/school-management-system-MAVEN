package schoolmanagement.commonlib.model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import schoolmanagement.commonlib.model.enums.Level;

class CourseGroupTest {

	private CourseGroup courseGroup;
	private Course course;
	private List<Tutor> tutors;
	private List<Student> students;

	@BeforeEach
	public void setUp() {
		course = new Course("Math", LocalDate.now(), LocalDate.now().plusMonths(3), 30,
				new Language("English", Level.A1));

		tutors = new ArrayList<>();
		tutors.add(new Tutor("John", "Doe", List.of(new Language("English", Level.A1))));

		students = new ArrayList<>();
		students.add(new Student("Alice", "Smith"));

		courseGroup = new CourseGroup(course, "Group A", 20, tutors, students);
	}

	@AfterEach
	void tearDown() throws Exception {
		courseGroup = null;
		course = null;
		tutors = null;
		students = null;
	}

	@Test
	public void testGetCourse() {
		assertEquals(course, courseGroup.getCourse());
	}

	@Test
	public void testSetCourse() {
		Course newCourse = new Course("Physics", LocalDate.now(), LocalDate.now().plusMonths(4), 25,
				new Language("English", Level.A2));
		courseGroup.setCourse(newCourse);
		assertEquals(newCourse, courseGroup.getCourse());
	}

	@Test
	public void testGetName() {
		assertEquals("Group A", courseGroup.getName());
	}

	@Test
	public void testSetName() {
		courseGroup.setName("Group B");
		assertEquals("Group B", courseGroup.getName());
	}

	@Test
	public void testGetNumOfStudents() {
		assertEquals(20, courseGroup.getNumOfStudents());
	}

	@Test
	public void testSetNumOfStudents() {
		courseGroup.setNumOfStudents(30);
		assertEquals(30, courseGroup.getNumOfStudents());
	}

	@Test
	public void testGetTutors() {
		assertEquals(tutors, courseGroup.getTutors());
	}

	@Test
	public void testSetTutors() {
		List<Tutor> newTutors = new ArrayList<>();
		newTutors.add(new Tutor("Jane", "Smith", List.of(new Language("Spanish", Level.B1))));
		courseGroup.setTutors(newTutors);
		assertEquals(newTutors, courseGroup.getTutors());
	}

	@Test
	public void testGetStudents() {
		assertEquals(students, courseGroup.getStudents());
	}

	@Test
	public void testSetStudents() {
		List<Student> newStudents = new ArrayList<>();
		newStudents.add(new Student("Bob", "Johnson"));
		courseGroup.setStudents(newStudents);
		assertEquals(newStudents, courseGroup.getStudents());
	}

	@Test
	public void testToString() {
		String s = courseGroup.toString();
		assertTrue(s.contains("null"));
		assertTrue(s.contains("Math"));
		assertTrue(s.contains("Group A"));
		assertTrue(s.contains("20"));
	}
}
