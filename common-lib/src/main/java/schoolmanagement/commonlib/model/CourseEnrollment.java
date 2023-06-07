package schoolmanagement.commonlib.model;

import java.io.Serializable;
import java.time.LocalDate;

public class CourseEnrollment implements Serializable {

	private Student student;
	private Course course;
	private LocalDate enrollmentDate;

	public CourseEnrollment(Student student, Course course, LocalDate enrollmentDate) {
		this.student = student;
		this.course = course;
		this.enrollmentDate = enrollmentDate;
	}

	public CourseEnrollment() {
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public LocalDate getEnrollmentDate() {
		return enrollmentDate;
	}

	public void setEnrollmentDate(LocalDate enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}

}
