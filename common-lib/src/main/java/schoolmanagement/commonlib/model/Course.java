package schoolmanagement.commonlib.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * The {@code Course} class represents a course, implementing the
 * {@link Serializable} interface. It contains information about the course,
 * such as its name, start and end dates, group capacity, language, course
 * enrollments, and course groups.
 * 
 * @author Djordje Ivanovic
 */
public class Course implements Serializable {

	/**
	 * The unique identifier of the course.
	 */
	private Long id;

	/**
	 * The name of the course.
	 */
	private String name;

	/**
	 * The start date of the course.
	 */
	private LocalDate startDate;

	/**
	 * The end date of the course.
	 */
	private LocalDate endDate;

	/**
	 * The capacity of each course group.
	 */
	private Integer groupCapacity;

	/**
	 * The language which is being learned in the course.
	 */
	private Language language;

	/**
	 * The list of course enrollments for this course.
	 */
	private List<CourseEnrollment> courseEnrollments;

	/**
	 * The list of course groups for this course.
	 */
	private List<CourseGroup> courseGroups;

	/**
	 * Constructs a {@code Course} object with the specified name, start date, end
	 * date, group capacity, and language.
	 *
	 * @param name          the name of the course
	 * @param startDate     the start date of the course
	 * @param endDate       the end date of the course
	 * @param groupCapacity the capacity of each course group
	 * @param language      the language of the course
	 */
	public Course(String name, LocalDate startDate, LocalDate endDate, Integer groupCapacity, Language language) {
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.groupCapacity = groupCapacity;
		this.language = language;
	}

	/**
	 * Default constructor for the {@code Course} class.
	 */
	public Course() {
	}

	/**
	 * Retrieves the ID of the course.
	 *
	 * @return the ID of the course
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the ID of the course.
	 *
	 * @param id the ID of the course
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Retrieves the name of the course.
	 *
	 * @return the name of the course
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the course.
	 *
	 * @param name the name of the course
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Retrieves the start date of the course.
	 *
	 * @return the start date of the course
	 */
	public LocalDate getStartDate() {
		return startDate;
	}

	/**
	 * Sets the start date of the course.
	 *
	 * @param startDate the start date of the course
	 */
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	/**
	 * Retrieves the end date of the course.
	 *
	 * @return the end date of the course
	 */
	public LocalDate getEndDate() {
		return endDate;
	}

	/**
	 * Sets the end date of the course.
	 *
	 * @param endDate the end date of the course
	 */
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	/**
	 * Retrieves the group capacity of the course.
	 *
	 * @return the group capacity of the course
	 */
	public Integer getGroupCapacity() {
		return groupCapacity;
	}

	/**
	 * Sets the group capacity of the course.
	 *
	 * @param groupCapacity the group capacity of the course
	 */
	public void setGroupCapacity(Integer groupCapacity) {
		this.groupCapacity = groupCapacity;
	}

	/**
	 * Retrieves the language of the course.
	 *
	 * @return the language of the course
	 */
	public Language getLanguage() {
		return language;
	}

	/**
	 * Sets the language of the course.
	 *
	 * @param language the language of the course
	 */
	public void setLanguage(Language language) {
		this.language = language;
	}

	/**
	 * Retrieves the list of course enrollments.
	 *
	 * @return the list of course enrollments
	 */
	public List<CourseEnrollment> getCourseEnrollments() {
		return courseEnrollments;
	}

	/**
	 * Sets the list of course enrollments.
	 *
	 * @param courseEnrollments the list of course enrollments
	 */
	public void setCourseEnrollments(List<CourseEnrollment> courseEnrollments) {
		this.courseEnrollments = courseEnrollments;
	}

	/**
	 * Retrieves the list of course groups.
	 *
	 * @return the list of course groups
	 */
	public List<CourseGroup> getCourseGroups() {
		return courseGroups;
	}

	/**
	 * Sets the list of course groups.
	 *
	 * @param courseGroups the list of course groups
	 */
	public void setCourseGroups(List<CourseGroup> courseGroups) {
		this.courseGroups = courseGroups;
	}

	/**
	 * Returns a string representation of the {@code Course} object.
	 *
	 * @return a string representation of the {@code Course} object
	 */
	@Override
	public String toString() {
		return name;
	}

	/**
	 * Generates a hash code for the {@code Course} object.
	 *
	 * @return the hash code for the {@code Course} object
	 */
	@Override
	public int hashCode() {
		int hash = 7;
		return hash;
	}

	/**
	 * Checks whether the {@code Course} object is equal to another object.
	 *
	 * @param obj the object to compare
	 * @return
	 *         <ul>
	 *         <li>{@code true} - when same instance is passed or when id's of
	 *         courses are same</li>
	 *         <li>{@code false} - otherwise</li>
	 *         </ul>
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
		final Course other = (Course) obj;
		return Objects.equals(this.id, other.id);
	}
}
