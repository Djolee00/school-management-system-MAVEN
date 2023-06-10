package schoolmanagement.service.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import schoolmanagement.commonlib.model.Course;
import schoolmanagement.commonlib.model.CourseGroup;
import schoolmanagement.commonlib.model.Student;
import schoolmanagement.persistence.dao.CourseDao;
import schoolmanagement.persistence.pool.ConnectionPool;
import schoolmanagement.service.CourseService;

/**
 * The CourseServiceImpl class is an implementation of the CourseService
 * interface. It provides methods for managing courses and course groups by
 * interacting with the CourseDao.
 *
 * @see CourseService
 * @see CourseDao
 * @author Djordje Ivanovic
 */
public class CourseServiceImpl implements CourseService {

	/**
	 * Object for course-related data access operations
	 */
	private final CourseDao courseDao;

	/**
	 * Constructs a new CourseServiceImpl object with the specified CourseDao.
	 *
	 * @param courseDao the CourseDao implementation to use for data access
	 */
	public CourseServiceImpl(CourseDao courseDao) {
		this.courseDao = courseDao;
	}

	/**
	 * Retrieves all courses from the data source.
	 *
	 * <p>
	 * This method establishes a connection to the database using the connection
	 * pool and sets it up for manual transaction management. It calls the
	 * {@code getAllCourses()} method of the {@code CourseDao} to retrieve all
	 * courses from the data source. If the operation is successful, the transaction
	 * is committed, and the connection is released back to the connection pool. If
	 * an I/O or SQL error occurs during the operation, the transaction is rolled
	 * back, the connection is released, and the exception is rethrown.
	 * </p>
	 *
	 * @return a list of all courses retrieved from the data source
	 * @throws IOException  if an I/O error occurs while accessing the data source
	 * @throws SQLException if an SQL error occurs while accessing the data source
	 */
	@Override
	public List<Course> getAllCourses() throws IOException, SQLException {
		Connection connection = ConnectionPool.getInstance().getConnection();
		List<Course> courses;

		try {
			courseDao.setConnection(connection);

			connection.setAutoCommit(false);

			courses = courseDao.getAllCourses();

			connection.commit();
			ConnectionPool.getInstance().releaseConnection(connection);

			return courses;
		} catch (IOException | SQLException ex) {
			connection.rollback();
			ConnectionPool.getInstance().releaseConnection(connection);
			throw ex;
		}
	}

	/**
	 * Updates a course in the data source.
	 *
	 * <p>
	 * This method establishes a connection to the database using the connection
	 * pool and sets it up for manual transaction management. It calls the
	 * {@code updateCourse()} method of the {@code CourseDao} to update the course
	 * in the data source. If the operation is successful, the transaction is
	 * committed, and the connection is released back to the connection pool. If the
	 * update fails, the transaction is rolled back, the connection is released, and
	 * false is returned. If an I/O or SQL error occurs during the operation, the
	 * transaction is rolled back, the connection is released, and the exception is
	 * rethrown.
	 * </p>
	 *
	 * @param course the course to be updated
	 * @return true if the course is updated successfully, false otherwise
	 * @throws IOException  if an I/O error occurs while accessing the data source
	 * @throws SQLException if an SQL error occurs while accessing the data source
	 */
	@Override
	public synchronized boolean updateCourse(Course course) throws IOException, SQLException {
		Connection connection = ConnectionPool.getInstance().getConnection();

		try {
			courseDao.setConnection(connection);

			connection.setAutoCommit(false);

			boolean status = courseDao.updateCourse(course);
			if (status == false) {
				connection.rollback();
				ConnectionPool.getInstance().releaseConnection(connection);
				return false;
			}

			connection.commit();
			ConnectionPool.getInstance().releaseConnection(connection);

			return true;
		} catch (IOException | SQLException ex) {
			connection.rollback();
			ConnectionPool.getInstance().releaseConnection(connection);
			throw ex;
		}
	}

	/**
	 * Deletes a course from the data source.
	 *
	 * <p>
	 * This method establishes a connection to the database using the connection
	 * pool and sets it up for manual transaction management. It calls the
	 * {@code checkIfCourseGroupsExist()} method of the {@code CourseDao} to check
	 * if there are any course groups associated with the course. If there are
	 * course groups, the transaction is rolled back, the connection is released,
	 * and false is returned. Otherwise, it calls the
	 * {@code deleteCourseEnrollments()} method of the {@code CourseDao} to delete
	 * any course enrollments associated with the course, and then calls the
	 * {@code deleteCourse()} method to delete the course itself. If the deletion is
	 * successful, the transaction is committed, and the connection is released back
	 * to the connection pool. If the deletion fails or an I/O or SQL error occurs
	 * during the operation, the transaction is rolled back, the connection is
	 * released, and the exception is rethrown.
	 * </p>
	 *
	 * @param course the course to be deleted
	 * @return true if the course is deleted successfully, false if there are course
	 *         groups associated with the course
	 * @throws IOException  if an I/O error occurs while accessing the data source
	 * @throws SQLException if an SQL error occurs while accessing the data source
	 */
	@Override
	public synchronized boolean deleteCourse(Course course) throws IOException, SQLException {
		Connection connection = ConnectionPool.getInstance().getConnection();

		try {
			courseDao.setConnection(connection);

			connection.setAutoCommit(false);

			boolean hasCourseGroups = courseDao.checkIfCourseGroupsExist(course);
			if (hasCourseGroups == true) {
				connection.rollback();
				ConnectionPool.getInstance().releaseConnection(connection);
				return false;
			}

			courseDao.deleteCourseEnrollments(course);
			courseDao.deleteCourse(course);

			connection.commit();
			ConnectionPool.getInstance().releaseConnection(connection);

			return true;
		} catch (IOException | SQLException ex) {
			connection.rollback();
			ConnectionPool.getInstance().releaseConnection(connection);
			throw ex;
		}
	}

	/**
	 * Saves a course to the data source and returns the generated ID.
	 *
	 * <p>
	 * This method establishes a connection to the database using the connection
	 * pool and sets it up for manual transaction management. It calls the
	 * {@code saveCourse()} method of the {@code CourseDao} to save the course and
	 * obtain the generated ID. If the saving is successful, the transaction is
	 * committed, and the connection is released back to the connection pool. If the
	 * saving fails or an I/O or SQL error occurs during the operation, the
	 * transaction is rolled back, the connection is released, and the exception is
	 * rethrown.
	 * </p>
	 *
	 * @param course the course to be saved
	 * @return the generated ID of the saved course
	 * @throws IOException  if an I/O error occurs while accessing the data source
	 * @throws SQLException if an SQL error occurs while accessing the data source
	 */
	@Override
	public synchronized Long saveCourse(Course course) throws IOException, SQLException {
		Connection connection = ConnectionPool.getInstance().getConnection();
		Long generatedId;

		try {
			courseDao.setConnection(connection);

			connection.setAutoCommit(false);

			generatedId = courseDao.saveCourse(course);

			connection.commit();
			ConnectionPool.getInstance().releaseConnection(connection);

			return generatedId;
		} catch (IOException | SQLException ex) {
			connection.rollback();
			ConnectionPool.getInstance().releaseConnection(connection);
			throw ex;
		}
	}

	/**
	 * Retrieves the course groups associated with a specific course.
	 *
	 * <p>
	 * This method establishes a connection to the database using the connection
	 * pool and sets it up for manual transaction management. It calls the
	 * {@code getGroupsOfCourse()} method of the {@code CourseDao} to retrieve the
	 * course groups associated with the given course. If the retrieval is
	 * successful, the transaction is committed, and the connection is released back
	 * to the connection pool. If the retrieval fails or an I/O or SQL error occurs
	 * during the operation, the transaction is rolled back, the connection is
	 * released, and the exception is rethrown.
	 * </p>
	 *
	 * @param temp the course for which to retrieve the associated course groups
	 * @return a list of course groups associated with the given course
	 * @throws IOException  if an I/O error occurs while accessing the data source
	 * @throws SQLException if an SQL error occurs while accessing the data source
	 */
	@Override
	public List<CourseGroup> getGroupOfCourse(Course temp) throws IOException, SQLException {
		Connection connection = ConnectionPool.getInstance().getConnection();
		List<CourseGroup> courseGroups;

		try {
			courseDao.setConnection(connection);

			connection.setAutoCommit(false);

			courseGroups = courseDao.getGroupsOfCourse(temp);

			connection.commit();
			ConnectionPool.getInstance().releaseConnection(connection);

			return courseGroups;
		} catch (IOException | SQLException ex) {
			connection.rollback();
			ConnectionPool.getInstance().releaseConnection(connection);
			throw ex;
		}
	}

	/**
	 * Retrieves the students enrolled in a specific course.
	 *
	 * <p>
	 * This method establishes a connection to the database using the connection
	 * pool and sets it up for manual transaction management. It calls the
	 * {@code getStudentsOfCourse()} method of the {@code CourseDao} to retrieve the
	 * students enrolled in the given course. If the retrieval is successful, the
	 * transaction is committed, and the connection is released back to the
	 * connection pool. If the retrieval fails or an I/O or SQL error occurs during
	 * the operation, the transaction is rolled back, the connection is released,
	 * and the exception is rethrown.
	 * </p>
	 *
	 * @param temp the course for which to retrieve the enrolled students
	 * @return a list of students enrolled in the given course
	 * @throws IOException  if an I/O error occurs while accessing the data source
	 * @throws SQLException if an SQL error occurs while accessing the data source
	 */
	@Override
	public List<Student> getCourseStudents(Course temp) throws IOException, SQLException {
		Connection connection = ConnectionPool.getInstance().getConnection();
		List<Student> students;

		try {
			courseDao.setConnection(connection);

			connection.setAutoCommit(false);

			students = courseDao.getStudentsOfCourse(temp);

			connection.commit();
			ConnectionPool.getInstance().releaseConnection(connection);

			return students;
		} catch (IOException | SQLException ex) {
			connection.rollback();
			ConnectionPool.getInstance().releaseConnection(connection);
			throw ex;
		}
	}

	/**
	 * Saves a course group to the database.
	 *
	 * <p>
	 * This method establishes a connection to the database using the connection
	 * pool and sets it up for manual transaction management. It calls the
	 * {@code saveCourseGroup()} method of the {@code CourseDao} to save the course
	 * group. If the save operation is successful, the generated ID is retrieved and
	 * assigned to the course group. The method then adds students and tutors to the
	 * course group using the {@code addStudentsInGroup()} and
	 * {@code addTutorsInGroup()} methods of the {@code CourseDao}. If any I/O or
	 * SQL error occurs during the operation, the transaction is rolled back, the
	 * connection is released, and the exception is rethrown.
	 * </p>
	 *
	 * @param courseGroup the course group to be saved
	 * @return the generated ID of the saved course group
	 * @throws IOException  if an I/O error occurs while accessing the data source
	 * @throws SQLException if an SQL error occurs while accessing the data source
	 */
	@Override
	public synchronized Long saveCourseGroup(CourseGroup courseGroup) throws IOException, SQLException {
		Connection connection = ConnectionPool.getInstance().getConnection();
		Long generatedId;

		try {
			courseDao.setConnection(connection);

			connection.setAutoCommit(false);

			generatedId = courseDao.saveCourseGroup(courseGroup);

			courseGroup.setId(generatedId);
//            courseDao.deleteTutorsFromGroup(courseGroup);
//            courseDao.deleteStudentsFromGroup(courseGroup);
			courseDao.addStudentsInGroup(courseGroup);
			courseDao.addTutorsInGroup(courseGroup);

			connection.commit();
			ConnectionPool.getInstance().releaseConnection(connection);

			return generatedId;
		} catch (IOException | SQLException ex) {
			connection.rollback();
			ConnectionPool.getInstance().releaseConnection(connection);
			throw ex;
		}
	}

	/**
	 * Updates a course group in the database.
	 *
	 * <p>
	 * This method establishes a connection to the database using the connection
	 * pool and sets it up for manual transaction management. It calls the
	 * {@code updateCourseGroupData()} method of the {@code CourseDao} to update the
	 * course group data. If the update operation is successful, the method deletes
	 * existing tutors and students from the course group using the
	 * {@code deleteTutorsFromGroup()} and {@code deleteStudentsFromGroup()} methods
	 * of the {@code CourseDao}, and then adds the updated tutors and students using
	 * the {@code addStudentsInGroup()} and {@code addTutorsInGroup()} methods. If
	 * any I/O or SQL error occurs during the operation, the transaction is rolled
	 * back, the connection is released, and the exception is rethrown.
	 * </p>
	 *
	 * @param courseGroup the course group to be updated
	 * @return {@code true} if the update operation is successful, {@code false}
	 *         otherwise
	 * @throws IOException  if an I/O error occurs while accessing the data source
	 * @throws SQLException if an SQL error occurs while accessing the data source
	 */
	@Override
	public synchronized boolean updateCourseGroup(CourseGroup courseGroup) throws IOException, SQLException {
		Connection connection = ConnectionPool.getInstance().getConnection();

		try {
			courseDao.setConnection(connection);

			connection.setAutoCommit(false);

			boolean status = courseDao.updateCourseGroupData(courseGroup);
			if (status == false) {
				connection.rollback();
				ConnectionPool.getInstance().releaseConnection(connection);
				return false;
			}
			courseDao.deleteTutorsFromGroup(courseGroup);
			courseDao.deleteStudentsFromGroup(courseGroup);
			courseDao.addStudentsInGroup(courseGroup);
			courseDao.addTutorsInGroup(courseGroup);

			connection.commit();
			ConnectionPool.getInstance().releaseConnection(connection);
			return true;
		} catch (IOException | SQLException ex) {
			connection.rollback();
			ConnectionPool.getInstance().releaseConnection(connection);
			throw ex;
		}
	}

}
