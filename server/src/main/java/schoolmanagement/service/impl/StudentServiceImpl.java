package schoolmanagement.service.impl;

import java.sql.Connection;
import java.io.IOException;
import java.util.List;
import schoolmanagement.commonlib.model.Student;
import schoolmanagement.persistence.dao.StudentDao;
import schoolmanagement.service.StudentService;
import validation.exception.ValidationException;
import java.sql.SQLException;
import schoolmanagement.commonlib.model.Course;
import schoolmanagement.commonlib.model.CourseEnrollment;
import schoolmanagement.persistence.dao.UserDao;
import schoolmanagement.persistence.pool.ConnectionPool;
import schoolmanagement.validator.student.StudentValidator;

/**
 * The {@code StudentServiceImpl} class is an implementation of the
 * {@link StudentService} interface. It provides functionality for managing
 * student-related operations such as saving, retrieving, enrolling in courses,
 * and updating student details. This implementation relies on the
 * {@link UserDao} and {@link StudentDao} objects for data access operations.
 *
 * <p>
 * Implementation note: This class assumes the usage of a connection pool for
 * efficient management of database connections. The connection pool can be
 * obtained through the {@link ConnectionPool#getInstance()} method.
 * </p>
 *
 *
 * @author Djordje Ivanovic
 * @see StudentService
 * @see UserDao
 * @see StudentDao
 * @see ConnectionPool
 */
public class StudentServiceImpl implements StudentService {

	/**
	 * Object for user-related data access operations
	 */
	private final UserDao userDao;
	/**
	 * Object for student-related data access operations
	 */
	private final StudentDao studentDao;

	/**
	 * Constructs a new {@code StudentServiceImpl} object with the specified UserDao
	 * and StudentDao objects.
	 *
	 * @param userDao    the UserDao object used for user-related data access
	 *                   operations
	 * @param studentDao the StudentDao object used for student-related data access
	 *                   operations
	 */
	public StudentServiceImpl(UserDao userDao, StudentDao studentDao) {
		this.studentDao = studentDao;
		this.userDao = userDao;
	}

	/**
	 * Saves a student to the data source after validating the student object.
	 *
	 * <p>
	 * This method saves the provided student object to the data source after
	 * performing validation using the provided validator object. The method
	 * retrieves a connection from the connection pool, sets it up for manual
	 * transaction management, and begins a transaction. If the validation fails, a
	 * {@link ValidationException} is thrown with details about the validation
	 * error. Otherwise, the student is saved as a user using the {@link UserDao},
	 * and the generated user ID is assigned to the student. The student is then
	 * saved using the {@link StudentDao}. Finally, the transaction is committed,
	 * and the connection is released back to the connection pool.
	 * </p>
	 *
	 * @param student   the student object to be saved
	 * @param validator the validator object used to validate the student
	 * @return the saved student object
	 * @throws ValidationException if the student fails validation
	 * @throws IOException         if an I/O error occurs while accessing the data
	 *                             source
	 * @throws SQLException        if an SQL error occurs while accessing the data
	 *                             source
	 */
	@Override
	public synchronized Student saveStudent(Student student, StudentValidator validator)
			throws ValidationException, IOException, SQLException {
		Connection connection = ConnectionPool.getInstance().getConnection();
		try {
			userDao.setConnection(connection);
			studentDao.setConnection(connection);

			connection.setAutoCommit(false);

			validator.validate(student, userDao);

			long userId = userDao.saveUser(student);
			student.setId(userId);
			student = studentDao.saveStudent(student);

			connection.commit();
			ConnectionPool.getInstance().releaseConnection(connection);

			return student;
		} catch (ValidationException | IOException | SQLException ex) {
			connection.rollback();
			ConnectionPool.getInstance().releaseConnection(connection);
			throw ex;
		}
	}

	/**
	 * Retrieves the list of courses enrolled by the student with the specified ID.
	 *
	 * <p>
	 * This method retrieves a connection from the connection pool, sets it up for
	 * manual transaction management, and begins a transaction. It calls the
	 * {@link StudentDao#getStudentCourses(Long)} method to fetch the list of
	 * courses enrolled by the student with the given ID. The transaction is
	 * committed, and the connection is released back to the connection pool upon
	 * successful execution. If an I/O or SQL error occurs during the operation, the
	 * transaction is rolled back, the connection is released, and the exception is
	 * rethrown.
	 * </p>
	 *
	 * @param id the ID of the student
	 * @return the list of course enrollments for the student
	 * @throws IOException  if an I/O error occurs while accessing the data source
	 * @throws SQLException if an SQL error occurs while accessing the data source
	 */
	@Override
	public List<CourseEnrollment> getStudentCourses(Long id) throws IOException, SQLException {
		Connection connection = ConnectionPool.getInstance().getConnection();
		List<CourseEnrollment> courses;

		try {
			studentDao.setConnection(connection);

			connection.setAutoCommit(false);

			courses = studentDao.getStudentCourses(id);

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
	 * Retrieves the list of unselected courses available for the student with the
	 * specified ID.
	 *
	 * <p>
	 * This method retrieves a connection from the connection pool, sets it up for
	 * manual transaction management, and begins a transaction. It calls the
	 * {@link StudentDao#getStudentUnselectedCourses(Long)} method to fetch the list
	 * of courses that the student with the given ID has not selected. The
	 * transaction is committed, and the connection is released back to the
	 * connection pool upon successful execution. If an I/O or SQL error occurs
	 * during the operation, the transaction is rolled back, the connection is
	 * released, and the exception is rethrown.
	 * </p>
	 *
	 * @param id the ID of the student
	 * @return the list of unselected courses for the student
	 * @throws IOException  if an I/O error occurs while accessing the data source
	 * @throws SQLException if an SQL error occurs while accessing the data source
	 */

	@Override
	public List<Course> getStudentUnselectedCourses(Long id) throws IOException, SQLException {
		Connection connection = ConnectionPool.getInstance().getConnection();
		List<Course> courses;

		try {
			studentDao.setConnection(connection);

			connection.setAutoCommit(false);

			courses = studentDao.getStudentUnselecteCourses(id);

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
	 * Enrolls the student in the selected courses.
	 *
	 * <p>
	 * This method retrieves a connection from the connection pool, sets it up for
	 * manual transaction management, and begins a transaction. It calls the
	 * {@link StudentDao#saveStudentSelectedCourses(List)} method to enroll the
	 * student in the selected courses. The transaction is committed, and the
	 * connection is released back to the connection pool upon successful execution.
	 * If an I/O or SQL error occurs during the operation, the transaction is rolled
	 * back, the connection is released, and the exception is rethrown.
	 * </p>
	 *
	 * @param selectedCourses the list of course enrollments to be saved
	 * @return {@code true} if the enrollment is successful, {@code false} otherwise
	 * @throws IOException  if an I/O error occurs while accessing the data source
	 * @throws SQLException if an SQL error occurs while accessing the data source
	 */
	@Override
	public synchronized boolean enrollCourses(List<CourseEnrollment> selectedCourses) throws IOException, SQLException {
		Connection connection = ConnectionPool.getInstance().getConnection();

		try {
			studentDao.setConnection(connection);

			connection.setAutoCommit(false);

			boolean status = studentDao.saveStudentSelectedCourses(selectedCourses);

			connection.commit();
			ConnectionPool.getInstance().releaseConnection(connection);

			return status;
		} catch (IOException | SQLException ex) {
			connection.rollback();
			ConnectionPool.getInstance().releaseConnection(connection);
			throw ex;
		}
	}

	/**
	 * Retrieves the list of all students.
	 *
	 * <p>
	 * This method retrieves a connection from the connection pool, sets it up for
	 * manual transaction management, and begins a transaction. It calls the
	 * {@link StudentDao#getAllStudents()} method to fetch the list of all students.
	 * The transaction is committed, and the connection is released back to the
	 * connection pool upon successful execution. If an I/O or SQL error occurs
	 * during the operation, the transaction is rolled back, the connection is
	 * released, and the exception is rethrown.
	 * </p>
	 *
	 * @return the list of all students
	 * @throws IOException  if an I/O error occurs while accessing the data source
	 * @throws SQLException if an SQL error occurs while accessing the data source
	 */
	@Override
	public List<Student> getAllStudents() throws IOException, SQLException {
		Connection connection = ConnectionPool.getInstance().getConnection();
		List<Student> students;

		try {
			studentDao.setConnection(connection);

			connection.setAutoCommit(false);

			students = studentDao.getAllStudents();

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
	 * Updates the details of a student after validating the student object.
	 *
	 * <p>
	 * This method retrieves a connection from the connection pool, sets it up for
	 * manual transaction management, and begins a transaction. It calls the
	 * {@link StudentValidator#validate(Student, UserDao)} method to validate the
	 * student object using the provided validator object. If the validation fails,
	 * a {@link ValidationException} is thrown with details about the validation
	 * error. Otherwise, the student details are updated using the {@link UserDao}
	 * and {@link StudentDao}. The transaction is committed, and the connection is
	 * released back to the connection pool upon successful execution. If an I/O or
	 * SQL error occurs during the operation, the transaction is rolled back, the
	 * connection is released, and the exception is rethrown.
	 * </p>
	 *
	 * @param student   the student object to be updated
	 * @param validator the validator object used to validate the student
	 * @return {@code true} if the update is successful, {@code false} otherwise
	 * @throws ValidationException if the student fails validation
	 * @throws IOException         if an I/O error occurs while accessing the data
	 *                             source
	 * @throws SQLException        if an SQL error occurs while accessing the data
	 *                             source
	 */
	@Override
	public synchronized boolean updateStudent(Student student, StudentValidator validator)
			throws ValidationException, IOException, SQLException {
		Connection connection = ConnectionPool.getInstance().getConnection();
		try {
			userDao.setConnection(connection);
			studentDao.setConnection(connection);

			connection.setAutoCommit(false);

			validator.validate(student, userDao);

			boolean statusUser = userDao.updateUser(student);
			boolean statusStudent = studentDao.updateStudent(student);

			if (statusStudent == false || statusUser == false) {
				connection.rollback();
				ConnectionPool.getInstance().releaseConnection(connection);
				return false;
			}

			connection.commit();
			ConnectionPool.getInstance().releaseConnection(connection);
			return true;
		} catch (ValidationException | IOException | SQLException ex) {
			connection.rollback();
			ConnectionPool.getInstance().releaseConnection(connection);
			throw ex;
		}
	}

}
