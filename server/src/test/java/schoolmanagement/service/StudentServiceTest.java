package schoolmanagement.service;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import schoolmanagement.commonlib.model.Course;
import schoolmanagement.commonlib.model.CourseEnrollment;
import schoolmanagement.commonlib.model.Student;
import schoolmanagement.service.mock.MockStudentValidator;
import schoolmanagement.validator.student.SaveStudentValidator;
import schoolmanagement.validator.student.UpdateStudentValidator;
import validation.exception.ValidationException;

abstract class StudentServiceTest {

	protected StudentService studentService;

	protected abstract StudentService createStudentService();

	@BeforeEach
	void setUp() throws Exception {
		studentService = createStudentService();
	}

	@AfterEach
	void tearDown() throws Exception {
		studentService = null;
	}

	@Test
	void saveStudentValidationException() {
		Student s = new Student("mike", "password");
		assertThrows(ValidationException.class, () -> studentService.saveStudent(s, new SaveStudentValidator()));
	}

	@Test
	void saveStudentSuccessfull() throws ValidationException, IOException, SQLException {
		Student s = new Student("mike12345", "Password12341.");
		s.setFirstName("Mike");
		s.setLastName("Jordan");
		s.setBirthdate(LocalDate.of(2000, 4, 19));
		s.setCreationDate(LocalDate.of(2022, 4, 19));

		Student saved = studentService.saveStudent(s, new MockStudentValidator());
		s.setId(1l);

		assertEquals(s, saved);
	}

	@SuppressWarnings("serial")
	@Test
	void getStudentCoursesSuccessfull() throws IOException, SQLException {
		Student s1 = new Student(1l, "john", "password", "john", "bryant", null, null);
		Course c1 = new Course("English", null, null, 2, null);
		c1.setId(1l);
		Course c2 = new Course("France", null, null, 2, null);
		c2.setId(2l);

		List<CourseEnrollment> courseEnrollments = new ArrayList<>() {
			{
				add(new CourseEnrollment(s1, c1, null));
				add(new CourseEnrollment(s1, c2, null));
			}
		};

		List<CourseEnrollment> actual = studentService.getStudentCourses(1l);
		assertTrue(actual.size() == 2);
		for (int i = 0; i < actual.size(); i++) {
			assertEquals(courseEnrollments.get(i).getCourse(), actual.get(i).getCourse());
			assertEquals(courseEnrollments.get(i).getStudent(), actual.get(i).getStudent());
		}
	}

	@Test
	void getStudentUnselectedCoursesSuccessfull() throws IOException, SQLException {
		Course c3 = new Course("German", null, null, 2, null);
		c3.setId(3l);

		List<Course> actual = studentService.getStudentUnselectedCourses(1l);
		assertTrue(actual.size() == 1);
		assertEquals(c3, actual.get(0));
	}

	@Test
	void enrollCoursesSQLException() {
		assertThrows(SQLException.class, () -> studentService.enrollCourses(null));
	}

	@SuppressWarnings("serial")
	@Test
	void enrollCoursesSuccessfull() throws IOException, SQLException {
		assertTrue(studentService.enrollCourses(new ArrayList<>() {
			{
				add(new CourseEnrollment());
			}
		}));
	}

	@SuppressWarnings("serial")
	@Test
	void enrollCoursesUnsuccessfull() throws IOException, SQLException {
		assertFalse(studentService.enrollCourses(new ArrayList<>() {
			{
				add(new CourseEnrollment());
				add(null);
			}
		}));
	}

	@Test
	void getAllStudentsSuccessfull() throws IOException, SQLException {
		List<Student> students = new ArrayList<>();
		Student s1 = new Student(1l, "john", "password", "john", "bryant", null, null);
		Student s2 = new Student(2l, "michael", "password", "michael", "bryant", null, null);
		Student s3 = new Student(3l, "eric", "password", "eric", "bryant", null, null);
		students.add(s1);
		students.add(s2);
		students.add(s3);

		List<Student> actual = studentService.getAllStudents();
		assertTrue(actual.size() == 3);
		for (int i = 0; i < actual.size(); i++) {
			assertEquals(actual.get(i), students.get(i));
		}
	}

	@Test
	void updateStudentValidationException() {
		Student s1 = new Student(1l, "john", "password", "john", "bryant", null, null);
		s1.setUsername("student");
		assertThrows(ValidationException.class, () -> studentService.updateStudent(s1, new UpdateStudentValidator()));
	}

	@Test
	void updateStudentUnsuccessfullStudent() throws ValidationException, IOException, SQLException {
		Student s1 = new Student(1l, "john", "password", "john", "bryant", null, null);
		s1.setFirstName("user");
		assertFalse(studentService.updateStudent(s1, new MockStudentValidator()));
	}

	@Test
	void updateStudentUnsuccessfullUser() throws ValidationException, IOException, SQLException {
		Student s1 = new Student(1l, "john", "password", "john", "bryant", null, null);
		s1.setUsername("user");
		assertFalse(studentService.updateStudent(s1, new MockStudentValidator()));
	}

	@Test
	void updateStudentSuccessfull() throws ValidationException, IOException, SQLException {
		Student s1 = new Student(1l, "john", "password", "john", "bryant", null, null);
		s1.setUsername("john123");
		s1.setFirstName("michael");
		assertTrue(studentService.updateStudent(s1, new MockStudentValidator()));
	}
}
