package schoolmanagement.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import schoolmanagement.commonlib.model.Course;
import schoolmanagement.commonlib.model.CourseGroup;
import schoolmanagement.commonlib.model.Student;

/**
 * The CourseService interface provides methods for managing courses and course
 * groups. It allows retrieving information about courses, updating their
 * details, deleting them, and performing operations related to course groups
 * and student enrollment.
 *
 * @see Course
 * @see CourseGroup
 * @see Student
 * @author Djordje Ivanovic
 */
public interface CourseService {

	/**
	 * Retrieves a list of all courses available in the system.
	 *
	 * @return the list of all courses
	 * @throws IOException  if an I/O error occurs while accessing the data source
	 * @throws SQLException if an SQL error occurs while accessing the data source
	 */
	public List<Course> getAllCourses() throws IOException, SQLException;

	/**
	 * Updates the details of a course in the system.
	 *
	 * @param course the course to update
	 * @return true if the course is successfully updated, false otherwise
	 * @throws IOException  if an I/O error occurs while accessing the data source
	 * @throws SQLException if an SQL error occurs while accessing the data source
	 */
	public boolean updateCourse(Course course) throws IOException, SQLException;

	/**
	 * Deletes a course from the system.
	 *
	 * @param course the course to delete
	 * @return true if the course is successfully deleted, false otherwise
	 * @throws IOException  if an I/O error occurs while accessing the data source
	 * @throws SQLException if an SQL error occurs while accessing the data source
	 */
	public boolean deleteCourse(Course course) throws IOException, SQLException;

	/**
	 * Saves a new course in the system.
	 *
	 * @param course the course to save
	 * @return the ID of the newly saved course
	 * @throws IOException  if an I/O error occurs while accessing the data source
	 * @throws SQLException if an SQL error occurs while accessing the data source
	 */
	public Long saveCourse(Course course) throws IOException, SQLException;

	/**
	 * Retrieves the course groups associated with a specific course. A course group
	 * represents a specific instance or section of a course, and may have its own
	 * schedule, instructor, and enrollment capacity.
	 *
	 * @param course the course for which to retrieve the associated groups
	 * @return the list of course groups associated with the specified course
	 * @throws IOException  if an I/O error occurs while accessing the data source
	 * @throws SQLException if an SQL error occurs while accessing the data source
	 */
	public List<CourseGroup> getGroupOfCourse(Course temp) throws IOException, SQLException;

	/**
	 * Retrieves the students enrolled in a specific course.
	 *
	 * @param course the course for which to retrieve the enrolled students
	 * @return the list of students enrolled in the specified course
	 * @throws IOException  if an I/O error occurs while accessing the data source
	 * @throws SQLException if an SQL error occurs while accessing the data source
	 */
	public List<Student> getCourseStudents(Course temp) throws IOException, SQLException;

	/**
	 * Saves a new course group in the system. A course group represents a specific
	 * instance or section of a course, and may have its own schedule, instructor,
	 * and enrollment capacity.
	 *
	 * @param courseGroup the course group to save
	 * @return the ID of the newly saved course group
	 * @throws IOException  if an I/O error occurs while accessing the data source
	 * @throws SQLException if an SQL error occurs while accessing the data source
	 */
	public Long saveCourseGroup(CourseGroup courseGroup) throws IOException, SQLException;

	/**
	 * Updates the details of a course group in the system.
	 *
	 * @param courseGroup the course group to update
	 * @return true if the course group is successfully updated, false otherwise
	 * @throws IOException  if an I/O error occurs while accessing the data source
	 * @throws SQLException if an SQL error occurs while accessing the data source
	 */
	public boolean updateCourseGroup(CourseGroup courseGroup) throws IOException, SQLException;

}
