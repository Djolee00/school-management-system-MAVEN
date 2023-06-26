package schoolmanagement.commonlib.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * Represents a student in the educational system, extending the {@link User}
 * class and implementing {@link Serializable}. The Student class contains
 * information such as first name, last name, birthdate, creation date, course
 * enrollments, and course groups.
 * 
 * @author Djordje Ivanovic
 */
public class Student extends User implements Serializable {

	/**
	 * The first name of the student.
	 */
	private String firstName;

	/**
	 * The last name of the student.
	 */
	private String lastName;

	/**
	 * The birthdate of the student.
	 */
	private LocalDate birthdate;

	/**
	 * The creation date of the student's account.
	 */
	private LocalDate creationDate;

	/**
	 * The list of course enrollments of the student.
	 */
	private List<CourseEnrollment> courseEnrollments;

	/**
	 * The list of course groups the student is associated with.
	 */
	private List<CourseGroup> courseGroups;

	/**
	 * Constructs a Student object with the specified parameters.
	 *
	 * @param id           the unique identifier of the student
	 * @param username     the username of the student
	 * @param password     the password of the student
	 * @param firstName    the first name of the student
	 * @param lastName     the last name of the student
	 * @param birthdate    the birthdate of the student
	 * @param creationDate the creation date of the student
	 */
	public Student(Long id, String username, String password, String firstName, String lastName, LocalDate birthdate,
			LocalDate creationDate) {
		super(id, username, password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.creationDate = creationDate;
	}

	/**
	 * Constructs a Student object with the specified username and password.
	 *
	 * @param username the username of the student
	 * @param password the password of the student
	 */
	public Student(String username, String password) {
		super(username, password);
	}
	
	/**
	 * Default constructor
	 */
	public Student() {
		super();
	}

	/**
	 * Returns the first name of the student.
	 *
	 * @return the first name of the student
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name of the student.
	 *
	 * @param firstName the first name of the student
	 * @throws NullPointerException     if the specified first name is null
	 * @throws IllegalArgumentException if the specified first name is blank
	 */
	public void setFirstName(String firstName) {
		if (firstName == null) {
			throw new NullPointerException("First name cannot be null");
		}
		this.firstName = firstName;
	}

	/**
	 * Returns the last name of the student.
	 *
	 * @return the last name of the student
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name of the student.
	 *
	 * @param lastName the last name of the student
	 * @throws NullPointerException     if the specified last name is null
	 * @throws IllegalArgumentException if the specified last name is blank
	 */
	public void setLastName(String lastName) {
		if (lastName == null) {
			throw new NullPointerException("Last name cannot be null");
		}
		this.lastName = lastName;
	}

	/**
	 * Returns the birthdate of the student.
	 *
	 * @return the birthdate of the student
	 */
	public LocalDate getBirthdate() {
		return birthdate;
	}

	/**
	 * Sets the birthdate of the student.
	 *
	 * @param birthdate the birthdate of the student
	 * @throws NullPointerException     if the specified birthdate is null
	 * @throws IllegalArgumentException if the specified birthdate is in the future
	 */
	public void setBirthdate(LocalDate birthdate) {
		if (birthdate == null) {
			throw new NullPointerException("Birthdate cannot be null");
		}
		if (birthdate.isAfter(LocalDate.now())) {
			throw new IllegalArgumentException("Birthdate must be in the past");
		}
		this.birthdate = birthdate;
	}

	/**
	 * Returns the creation date of the student.
	 *
	 * @return the creation date of the student
	 */
	public LocalDate getCreationDate() {
		return creationDate;
	}

	/**
	 * Sets the creation date of the student.
	 *
	 * @param creationDate the creation date of the student
	 * @throws NullPointerException if the specified creation date is null
	 */
	public void setCreationDate(LocalDate creationDate) {
		if (creationDate == null) {
			throw new NullPointerException("Creation date cannot be null");
		}
		this.creationDate = creationDate;
	}

	/**
	 * Returns the list of course enrollments of the student.
	 *
	 * @return the list of course enrollments of the student
	 */
	public List<CourseEnrollment> getCourseEnrollments() {
		return courseEnrollments;
	}

	/**
	 * Sets the list of course enrollments of the student.
	 *
	 * @param courseEnrollments the list of course enrollments of the student
	 */
	public void setCourseEnrollments(List<CourseEnrollment> courseEnrollments) {
		this.courseEnrollments = courseEnrollments;
	}

	/**
	 * Returns the list of course groups the student is associated with.
	 *
	 * @return the list of course groups the student is associated with
	 */
	public List<CourseGroup> getCourseGroups() {
		return courseGroups;
	}

	/**
	 * Sets the list of course groups the student is associated with.
	 *
	 * @param courseGroups the list of course groups the student is associated with
	 */
	public void setCourseGroups(List<CourseGroup> courseGroups) {
		this.courseGroups = courseGroups;
	}

	/**
	 * Returns a string representation of the student.
	 *
	 * @return a string representation of the student
	 */
	@Override
	public String toString() {
		return firstName + " " + lastName;
	}

	/**
	 * Generates the hash code for the student.
	 *
	 * @return the hash code value for the student
	 */
	@Override
	public int hashCode() {
		int hash = 5;
		return hash;
	}

	/**
	 * Checks if the student is equal to another object.
	 *
	 * @param obj the object to compare with
	 * @return true if the student is equal to the other object, false otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Student other = (Student) obj;
		return Objects.equals(this.id, other.id);
	}
}
