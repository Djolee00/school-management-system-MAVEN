package schoolmanagement.commonlib.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import schoolmanagement.commonlib.model.enums.Level;

/**
 * The {@code Language} class represents a language with its name, proficiency
 * level, tutors, and available courses. It implements the {@link Serializable}
 * interface to support object serialization.
 * 
 * @author Djordje Ivanovic
 */
public class Language implements Serializable {

	/**
	 * The ID of the language.
	 */
	private Long id;

	/**
	 * The name of the language.
	 */
	private String name;

	/**
	 * The level of proficiency for the language.
	 */
	private Level level;

	/**
	 * The list of tutors who specialize in this language.
	 */
	private List<Tutor> tutors;

	/**
	 * The list of courses offered in this language.
	 */
	private List<Course> courses;

	/**
	 * Constructs a new {@code Language} object with the specified name and level.
	 *
	 * @param name  the name of the language
	 * @param level the proficiency level of the language
	 */
	public Language(String name, Level level) {
		this.name = name;
		this.level = level;
	}

	/**
	 * Default constructor for the {@code Language} class.
	 */
	public Language() {
	}

	/**
	 * Retrieves the unique identifier of the language.
	 *
	 * @return the unique identifier of the language
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the unique identifier of the language.
	 *
	 * @param id the unique identifier of the language
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Retrieves the name of the language.
	 *
	 * @return the name of the language
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the language.
	 *
	 * @param name the name of the language
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Retrieves the proficiency level of the language.
	 *
	 * @return the proficiency level of the language
	 */
	public Level getLevel() {
		return level;
	}

	/**
	 * Retrieves the list of tutors for the language.
	 *
	 * @return the list of tutors for the language
	 */
	public List<Tutor> getTutors() {
		return tutors;
	}

	/**
	 * Sets the list of tutors for the language.
	 *
	 * @param tutors the list of tutors for the language
	 */
	public void setTutors(List<Tutor> tutors) {
		this.tutors = tutors;
	}

	/**
	 * Retrieves the list of courses available in the language.
	 *
	 * @return the list of courses available in the language
	 */
	public List<Course> getCourses() {
		return courses;
	}

	/**
	 * Sets the list of courses available in the language.
	 *
	 * @param courses the list of courses available in the language
	 */
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	/**
	 * Sets the proficiency level of the language.
	 *
	 * @param level the proficiency level of the language
	 */
	public void setLevel(Level level) {
		this.level = level;
	}

	/**
	 * Returns a string representation of the {@code Language} object. The string
	 * representation consists of the language name followed by the proficiency
	 * level.
	 *
	 * @return a string representation of the {@code Language} object
	 */
	@Override
	public String toString() {
		return name + " " + level;
	}

	/**
	 * Returns the hash code value for the {@code Language} object. The hash code is
	 * generated based on the name and level of the language.
	 *
	 * @return the hash code value for the {@code Language} object
	 */
	@Override
	public int hashCode() {
		int hash = 7;
		return hash;
	}

	/**
	 * Indicates whether some other object is "equal to" this one. Two
	 * {@code Language} objects are considered equal if they have the same name and
	 * proficiency level.
	 *
	 * @param obj the reference object with which to compare
	 * @return {@code true} if this {@code Language} object is equal to the
	 *         {@code obj} argument; {@code false} otherwise
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
		final Language other = (Language) obj;
		if (!Objects.equals(this.name, other.name)) {
			return false;
		}
		return this.level == other.level;
	}
}
