package schoolmanagement.commonlib.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Student extends User implements Serializable {

	private String firstName;
	private String lastName;
	private LocalDate birthdate;
	private LocalDate creationDate;
	private List<CourseEnrollment> courseEnrollments;
	private List<CourseGroup> courseGroups;

	public Student(Long id, String username, String password, String firstName, String lastName, LocalDate birthdate,
			LocalDate creationDate) {
		super(id, username, password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.creationDate = creationDate;
	}

	public Student(String username, String password) {
		super(username, password);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if (firstName == null) {
			throw new NullPointerException("First name cannot be null");
		}
		if (firstName.isBlank()) {
			throw new IllegalArgumentException("First name cannot be blank");
		}
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if (lastName == null) {
			throw new NullPointerException("Last name cannot be null");
		}
		if (lastName.isBlank()) {
			throw new IllegalArgumentException("Last name cannot be blank");
		}
		this.lastName = lastName;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		if (birthdate == null) {
			throw new NullPointerException("Birthdate cannot be null");
		}
		if (birthdate.isAfter(LocalDate.now())) {
			throw new IllegalArgumentException("Birthdate must be in the past");
		}
		this.birthdate = birthdate;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		if (creationDate == null) {
			throw new NullPointerException("Creation date cannot be null");
		}
		this.creationDate = creationDate;
	}

	public List<CourseEnrollment> getCoursesEnrollments() {
		return courseEnrollments;
	}

	public void setCourseEnrollments(List<CourseEnrollment> courseEnrollments) {
		if (courseEnrollments == null) {
			throw new NullPointerException("Course enrollments list cannot be null");
		}
		this.courseEnrollments = courseEnrollments;
	}

	public List<CourseGroup> getCourseGroups() {
		return courseGroups;
	}

	public void setCourseGroups(List<CourseGroup> courseGroups) {
		if (courseGroups == null) {
			throw new NullPointerException("Course groups list cannot be null");
		}
		this.courseGroups = courseGroups;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName;
	}

	@Override
	public int hashCode() {
		int hash = 5;
		return hash;
	}

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
