package schoolmanagement.commonlib.model;

import java.io.Serializable;
import java.util.List;

/**
 * The {@code CourseGroup} class represents a group within a course,
 * implementing the {@link Serializable} interface. It contains information
 * about the course, group name, number of students, tutors, and students.
 * 
 * @author Djordje Ivanovic
 */
public class CourseGroup implements Serializable {

	/**
	 * The unique identifier of the course group.
	 */
	private Long id;

	/**
	 * The course to which the group belongs.
	 */
	private Course course;

	/**
	 * The name of the group.
	 */
	private String name;

	/**
	 * The number of students in the group.
	 */
	private Integer numOfStudents;

	/**
	 * The list of tutors assigned to the group.
	 */
	private List<Tutor> tutors;

	/**
	 * The list of students in the group.
	 */
	private List<Student> students;

	/**
	 * Constructs a {@code CourseGroup} object with the specified course, group
	 * name, number of students, tutors, and students.
	 *
	 * @param course        the course to which the group belongs
	 * @param name          the name of the group
	 * @param numOfStudents the number of students in the group
	 * @param tutors        the list of tutors assigned to the group
	 * @param students      the list of students in the group
	 */
	public CourseGroup(Course course, String name, Integer numOfStudents, List<Tutor> tutors, List<Student> students) {
		this.course = course;
		this.name = name;
		this.numOfStudents = numOfStudents;
		this.tutors = tutors;
		this.students = students;
	}

	/**
	 * Default constructor for the {@code CourseGroup} class.
	 */
	public CourseGroup() {
	}

	/**
	 * Retrieves the unique identifier of the course group.
	 *
	 * @return the unique identifier of the course group
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the unique identifier of the course group.
	 *
	 * @param id the unique identifier of the course group
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Retrieves the course to which the group belongs.
	 *
	 * @return the course to which the group belongs
	 */
	public Course getCourse() {
		return course;
	}

	/**
	 * Sets the course to which the group belongs.
	 *
	 * @param course the course to which the group belongs
	 */
	public void setCourse(Course course) {
		this.course = course;
	}

	/**
	 * Retrieves the name of the group.
	 *
	 * @return the name of the group
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the group.
	 *
	 * @param name the name of the group
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Retrieves the number of students in the group.
	 *
	 * @return the number of students in the group
	 */
	public Integer getNumOfStudents() {
		return numOfStudents;
	}

	/**
	 * Sets the number of students in the group.
	 *
	 * @param numOfStudents the number of students in the group
	 */
	public void setNumOfStudents(Integer numOfStudents) {
		this.numOfStudents = numOfStudents;
	}

	/**
	 * Retrieves the list of tutors assigned to the group.
	 *
	 * @return the list of tutors assigned to the group
	 */
	public List<Tutor> getTutors() {
		return tutors;
	}

	/**
	 * Sets the list of tutors assigned to the group.
	 *
	 * @param tutors the list of tutors assigned to the group
	 */
	public void setTutors(List<Tutor> tutors) {
		this.tutors = tutors;
	}

	/**
	 * Retrieves the list of students in the group.
	 *
	 * @return the list of students in the group
	 */
	public List<Student> getStudents() {
		return students;
	}

	/**
	 * Sets the list of students in the group.
	 *
	 * @param students the list of students in the group
	 */
	public void setStudents(List<Student> students) {
		this.students = students;
	}

	/**
	 * Returns a string representation of the {@code CourseGroup} object.
	 * Representation contains id of group, course, name of group and number of
	 * students.
	 *
	 * @return a string representation of the {@code CourseGroup} object
	 */
	@Override
	public String toString() {
		return "CourseGroup{" + "id=" + id + ", course=" + course + ", name='" + name + '\'' + ", numOfStudents="
				+ numOfStudents + '}';
	}
}
