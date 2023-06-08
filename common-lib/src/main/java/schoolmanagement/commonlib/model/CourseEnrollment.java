package schoolmanagement.commonlib.model;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * The {@code CourseEnrollment} class represents a student's enrollment in a
 * course, implementing the {@link Serializable} interface. It contains
 * information about the student, course, and enrollment date.
 * 
 * @author Djordje Ivanovic
 */
public class CourseEnrollment implements Serializable {

	/**
	 * The student enrolled in the course.
	 */
	private Student student;

	/**
	 * The course in which the student is enrolled.
	 */
	private Course course;

	/**
	 * The date of enrollment.
	 */
	private LocalDate enrollmentDate;

	/**
	 * Constructs a {@code CourseEnrollment} object with the specified student,
	 * course, and enrollment date.
	 *
	 * @param student        the student enrolled in the course
	 * @param course         the course in which the student is enrolled
	 * @param enrollmentDate the date of enrollment
	 */
	public CourseEnrollment(Student student, Course course, LocalDate enrollmentDate) {
		this.student = student;
		this.course = course;
		this.enrollmentDate = enrollmentDate;
	}

	/**
	 * Default constructor for the {@code CourseEnrollment} class.
	 */
	public CourseEnrollment() {
	}

	/**
	 * Retrieves the student enrolled in the course.
	 *
	 * @return the student enrolled in the course
	 */
	public Student getStudent() {
		return student;
	}

	/**
	 * Sets the student enrolled in the course.
	 *
	 * @param student the student enrolled in the course
	 */
	public void setStudent(Student student) {
		this.student = student;
	}

	/**
	 * Retrieves the course in which the student is enrolled.
	 *
	 * @return the course in which the student is enrolled
	 */
	public Course getCourse() {
		return course;
	}

	/**
	 * Sets the course in which the student is enrolled.
	 *
	 * @param course the course in which the student is enrolled
	 */
	public void setCourse(Course course) {
		this.course = course;
	}

	/**
	 * Retrieves the date of enrollment.
	 *
	 * @return the date of enrollment
	 */
	public LocalDate getEnrollmentDate() {
		return enrollmentDate;
	}

	/**
	 * Sets the date of enrollment.
	 *
	 * @param enrollmentDate the date of enrollment
	 */
	public void setEnrollmentDate(LocalDate enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}

}