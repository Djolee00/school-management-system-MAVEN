package schoolmanagement.service;

import java.io.IOException;
import java.util.List;
import schoolmanagement.commonlib.model.Student;
import validation.exception.ValidationException;
import java.sql.SQLException;
import schoolmanagement.commonlib.model.Course;
import schoolmanagement.commonlib.model.CourseEnrollment;
import schoolmanagement.validator.student.StudentValidator;

/**
 * The {@code StudentService} interface represents a service for managing
 * student-related operations. It provides methods for saving and retrieving
 * student information, enrolling in courses, and updating student details.
 *
 * <p>
 * This interface defines the contract for classes that implement student
 * management functionality. Implementing classes should provide an
 * implementation for the methods defined in this interface.
 * </p>
 *
 *
 * @author Djordje Ivanovic
 * @see Student
 * @see StudentValidator
 */
public interface StudentService {

	/**
	 * Saves a student to the data source after validating the student object.
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
	public Student saveStudent(Student student, StudentValidator validator)
			throws ValidationException, IOException, SQLException;

	/**
	 * Retrieves a list of course enrollments for the specified student.
	 *
	 * @param studentId the ID of the student
	 * @return a list of course enrollments for the student
	 * @throws IOException  if an I/O error occurs while accessing the data source
	 * @throws SQLException if an SQL error occurs while accessing the data source
	 */
	public List<CourseEnrollment> getStudentCourses(Long studentId) throws IOException, SQLException;

	/**
	 * Retrieves a list of unselected courses for the specified student.
	 *
	 * @param studentId the ID of the student
	 * @return a list of unselected courses for the student
	 * @throws IOException  if an I/O error occurs while accessing the data source
	 * @throws SQLException if an SQL error occurs while accessing the data source
	 */
	public List<Course> getStudentUnselectedCourses(Long studentId) throws IOException, SQLException;

	/**
	 * Enrolls the student in the specified courses.
	 *
	 * @param selectedCourses the list of courses to enroll in
	 * @return {@code true} if the enrollment is successful, {@code false} otherwise
	 * @throws IOException  if an I/O error occurs while accessing the data source
	 * @throws SQLException if an SQL error occurs while accessing the data source
	 */
	public boolean enrollCourses(List<CourseEnrollment> selectedCourses) throws IOException, SQLException;

	/**
	 * Retrieves a list of all students.
	 *
	 * @return a list of all students
	 * @throws IOException  if an I/O error occurs while accessing the data source
	 * @throws SQLException if an SQL error occurs while accessing the data source
	 */
	public List<Student> getAllStudents() throws IOException, SQLException;

	/**
	 * Updates the details of the specified student after validating the updated
	 * student object.
	 *
	 * @param student   the updated student object
	 * @param validator the validator object used to validate the student
	 * @return {@code true} if the update is successful, {@code false} otherwise
	 * @throws ValidationException if the student fails validation
	 * @throws IOException         if an I/O error occurs while accessing the data
	 *                             source
	 * @throws SQLException        if an SQL error occurs while accessing the data
	 *                             source
	 */
	public boolean updateStudent(Student student, StudentValidator validator)
			throws ValidationException, IOException, SQLException;
}
