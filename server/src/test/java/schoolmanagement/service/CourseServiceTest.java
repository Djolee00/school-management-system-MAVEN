package schoolmanagement.service;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import schoolmanagement.commonlib.model.Course;
import schoolmanagement.commonlib.model.CourseGroup;
import schoolmanagement.commonlib.model.Student;
import schoolmanagement.persistence.dao.CourseDao;
import schoolmanagement.service.mock.MockCourseDao;

abstract class CourseServiceTest {

	protected CourseService courseService;
	protected CourseDao courseDao;

	protected abstract CourseService createCourseService();

	@BeforeEach
	void setUp() throws Exception {
		courseService = createCourseService();
	}

	@AfterEach
	void tearDown() throws Exception {
		courseService = null;
	}

	@Test
	void testGetAllCoursesSuccess() throws IOException, SQLException {
		List<Course> expected = new ArrayList<>();
		Course c1 = new Course("English", null, null, 5, null);
		c1.setId(1l);
		Course c2 = new Course("France", null, null, 5, null);
		c2.setId(2l);
		Course c3 = new Course("German", null, null, 5, null);
		c3.setId(3l);

		expected.add(c1);
		expected.add(c2);
		expected.add(c3);

		// Assert the result
		assertTrue(courseService.getAllCourses().size() == 3);
		assertEquals(expected, courseService.getAllCourses());
	}

	@Test
	void testDeleteCourseFailureGroupsExist() throws IOException, SQLException {
		Course c1 = new Course("English", null, null, 5, null);
		c1.setId(1l);

		boolean status = courseService.deleteCourse(c1);
		assertFalse(status);
	}

	@Test
	void testDeleteCourseSuccess() throws IOException, SQLException {
		Course c2 = new Course("France", null, null, 5, null);
		c2.setId(2l);

		boolean status = courseService.deleteCourse(c2);
		assertTrue(status);
		assertTrue(!((MockCourseDao) courseDao).getAllCourses().contains(c2));
	}

	@Test
	void testUpdateCourseFailureError() throws IOException, SQLException {
		Course c1 = new Course("ENGLISH UPDATE", null, null, 5, null);
		c1.setId(1l);

		((MockCourseDao) courseDao).setFailure(true);
		assertFalse(courseService.updateCourse(c1));
		assertTrue(((MockCourseDao) courseDao).getAllCourses().get(0).getName().equals("English"));
	}

	@Test
	void testUpdateCourseFailureDoesntExist() throws IOException, SQLException {
		Course c1 = new Course("ENGLISH UPDATE", null, null, 5, null);
		c1.setId(5l);

		((MockCourseDao) courseDao).setFailure(true);
		assertFalse(courseService.updateCourse(c1));
	}

	@Test
	void testUpdateCourseSuccess() throws IOException, SQLException {
		Course c1 = new Course("ENGLISH UPDATE", null, null, 5, null);
		c1.setId(1l);

		assertTrue(courseService.updateCourse(c1));
		assertTrue(((MockCourseDao) courseDao).getAllCourses().get(0).getName().equals("ENGLISH UPDATE"));
		assertTrue(((MockCourseDao) courseDao).getAllCourses().size() == 3);
	}

	@Test
	void testSaveCourseSuccessfull() throws SQLException, IOException {
		Course c5 = new Course("Serbian", null, null, 5, null);

		long generatedId = courseService.saveCourse(c5);
		assertEquals(5l, generatedId);
		assertTrue(((MockCourseDao) courseDao).getAllCourses().size() == 4);
		assertTrue(((MockCourseDao) courseDao).getAllCourses().contains(c5));
	}

	@Test
	void testSaveCourseUnsuccessfull() throws SQLException {
		Course c5 = new Course("Serbian", null, null, 5, null);
		((MockCourseDao) courseDao).setFailure(true);
		assertThrows(SQLException.class, () -> courseService.saveCourse(c5));
	}

	@Test
	void testGetCourseGroup() throws SQLException, IOException {
		Course c1 = new Course("English", null, null, 5, null);
		c1.setId(1l);

		List<CourseGroup> actual = courseService.getGroupOfCourse(c1);
		assertEquals(1, actual.size());
		assertTrue(actual.get(0).getName().equals("Group1"));
	}

	@Test
	void testGetCourseStudents() throws SQLException, IOException {
		Course c1 = new Course("English", null, null, 5, null);
		c1.setId(1l);

		Student s1 = new Student("s1", "s1");
		s1.setId(1l);
		Student s2 = new Student("s2", "s2");
		s2.setId(2l);

		List<Student> actual = courseService.getCourseStudents(c1);
		assertEquals(2, actual.size());
		assertEquals(s1, actual.get(0));
		assertEquals(s2, actual.get(1));
	}

	@Test
	void testSaveCourseGroup() throws SQLException, IOException {
		Course c1 = new Course("English", null, null, 5, null);
		c1.setId(1l);
		
		Student s1 = new Student("s1", "s1");
		s1.setId(1l);
		Student s2 = new Student("s2", "s2");
		s2.setId(2l);
		
		@SuppressWarnings("serial")
		CourseGroup cg = new CourseGroup(c1, "Group2", 5, null, new ArrayList<>() {{
			add(s1);
			add(s2);
		}});
		
		long id = courseService.saveCourseGroup(cg);
		assertEquals(2l, id);
		assertTrue(((MockCourseDao) courseDao).getAllCourses().get(0).getCourseGroups().size()==2);
		assertTrue(((MockCourseDao) courseDao).getAllCourses().get(0).getCourseGroups().get(1).equals(cg));

	}
}
