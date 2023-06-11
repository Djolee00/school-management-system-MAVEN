package schoolmanagement.commonlib.model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import schoolmanagement.commonlib.model.enums.Level;

class CourseEnrollmentTest {

	private CourseEnrollment courseEnrollment;
	private Student student;
	private Course course;
	private LocalDate enrollmentDate;

	@BeforeEach
	void setUp() throws Exception {
		student = new Student("Alice", "Smith");
		course = new Course("English", LocalDate.now(), LocalDate.now().plusMonths(3), 30,
				new Language("English", Level.A1));
		enrollmentDate = LocalDate.now();

		courseEnrollment = new CourseEnrollment(student, course, enrollmentDate);
	}

	@AfterEach
	void tearDown() throws Exception {
		courseEnrollment = null;
		student = null;
		course = null;
		enrollmentDate = null;
	}

	@Test
	public void testGetStudent() {
		assertEquals(student, courseEnrollment.getStudent());
	}

	@Test
	public void testSetStudent() {
		Student newStudent = new Student("Bob", "Johnson");
		courseEnrollment.setStudent(newStudent);
		assertEquals(newStudent, courseEnrollment.getStudent());
	}

	@Test
	public void testGetCourse() {
		assertEquals(course, courseEnrollment.getCourse());
	}

	@Test
	public void testSetCourse() {
		Course newCourse = new Course("Physics", LocalDate.now(), LocalDate.now().plusMonths(4), 25,
				new Language("English", Level.A1));
		courseEnrollment.setCourse(newCourse);
		assertEquals(newCourse, courseEnrollment.getCourse());
	}

	@Test
	public void testGetEnrollmentDate() {
		assertEquals(enrollmentDate, courseEnrollment.getEnrollmentDate());
	}

	@Test
	public void testSetEnrollmentDate() {
		LocalDate newEnrollmentDate = LocalDate.now().minusDays(1);
		courseEnrollment.setEnrollmentDate(newEnrollmentDate);
		assertEquals(newEnrollmentDate, courseEnrollment.getEnrollmentDate());
	}
}
