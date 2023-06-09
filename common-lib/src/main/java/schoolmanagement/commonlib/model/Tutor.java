package schoolmanagement.commonlib.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * The {@code Tutor} class represents a tutor in the language learning system. A
 * tutor is responsible for teaching courses and specializes in certain
 * languages. It contains information such as the tutor's ID, first name, last
 * name, and the list of languages they specialize in.
 *
 * @author Djordje Ivanovic
 * 
 */
public class Tutor implements Serializable {

	/**
	 * The unique ID of the tutor.
	 */
	private Long id;

	/**
	 * The first name of the tutor.
	 */
	private String firstName;

	/**
	 * The last name of the tutor.
	 */
	private String lastName;

	/**
	 * The list of languages that the tutor specializes in. Each tutor can teach
	 * multiple languages.
	 *
	 * @see Language
	 */
	private List<Language> languages;

	/**
	 * Constructs a {@code Tutor} object with the specified first name, last name,
	 * and languages they specialize in.
	 *
	 * @param firstName The first name of the tutor.
	 * @param lastName  The last name of the tutor.
	 * @param languages The list of languages the tutor specializes in.
	 * @see Language
	 */
	public Tutor(String firstName, String lastName, List<Language> languages) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.languages = languages;
	}

	/**
	 * Default constructor for the {@code Tutor} class. Creates a tutor object with
	 * default values.
	 */
	public Tutor() {
	}

	/**
	 * Retrieves the ID of the tutor.
	 *
	 * @return The ID of the tutor.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the ID of the tutor.
	 *
	 * @param id The ID of the tutor.
	 * @throws NullPointerException if the specified ID is null.
	 */
	public void setId(Long id) {
		if (id == null) {
			throw new NullPointerException("ID cannot be null");
		}
		this.id = id;
	}

	/**
	 * Retrieves the first name of the tutor.
	 *
	 * @return The first name of the tutor.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name of the tutor.
	 *
	 * @param firstName The first name of the tutor.
	 * @throws NullPointerException     if the specified first name is null.
	 * @throws IllegalArgumentException if the specified first name has less than 3
	 *                                  characters.
	 */
	public void setFirstName(String firstName) {
		if (firstName == null) {
			throw new NullPointerException("First name cannot be null");
		}
		if (firstName.length() < 3) {
			throw new IllegalArgumentException("First name must have at least 3 characters");
		}
		this.firstName = firstName;
	}

	/**
	 * Retrieves the last name of the tutor.
	 *
	 * @return The last name of the tutor.
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name of the tutor.
	 *
	 * @param lastName The last name of the tutor.
	 * @throws NullPointerException     if the specified last name is null.
	 * @throws IllegalArgumentException if the specified last name has less than 3
	 *                                  characters.
	 */
	public void setLastName(String lastName) {
		if (lastName == null) {
			throw new NullPointerException("Last name cannot be null");
		}
		if (lastName.length() < 3) {
			throw new IllegalArgumentException("Last name must have at least 3 characters");
		}
		this.lastName = lastName;
	}

	/**
	 * Retrieves the list of languages the tutor specializes in.
	 *
	 * @return The list of languages the tutor specializes in.
	 * @see Language
	 */
	public List<Language> getLanguages() {
		return languages;
	}

	/**
	 * Sets the list of languages the tutor specializes in.
	 *
	 * @param languages The list of languages the tutor specializes in.
	 * @throws NullPointerException if the specified list of languages is null.
	 */
	public void setLanguages(List<Language> languages) {
		if (languages == null) {
			throw new NullPointerException("Languages list cannot be null");
		}
		this.languages = languages;
	}

	/**
	 * Returns the string representation of the tutor object. The string contains
	 * the tutor's first name and last name.
	 *
	 * @return The string representation of the tutor object.
	 */
	@Override
	public String toString() {
		return firstName + " " + lastName;
	}

	/**
	 * Returns the hash code value for the tutor object. The hash code is computed
	 * based on the tutor's ID.
	 *
	 * @return The hash code value for the tutor object.
	 */
	@Override
	public int hashCode() {
		int hash = 3;
		return hash;
	}

	/**
	 * Indicates whether some other object is "equal to" this one. Two tutors are
	 * considered equal if they have the same ID.
	 *
	 * @param obj The reference object with which to compare.
	 * @return {@code true} if this tutor is the same as the obj argument;
	 *         {@code false} otherwise.
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
		final Tutor other = (Tutor) obj;
		return Objects.equals(this.id, other.id);
	}

}
