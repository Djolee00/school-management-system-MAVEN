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
		assertTrue(((MockCourseDao)courseDao).getAllCourses().get(0).getName().equals("English"));
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
		assertTrue(((MockCourseDao)courseDao).getAllCourses().get(0).getName().equals("ENGLISH UPDATE"));
		assertTrue(((MockCourseDao)courseDao).getAllCourses().size() == 3);

	}
}
