package schoolmanagement.commonlib.model;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The {@code Administrator} class represents an administrator user, extending
 * the {@link User} class and implementing the {@link Serializable} interface.
 * It contains additional information about the employment date of the
 * administrator.
 * 
 * @author Djordje Ivanovic
 */
public class Administrator extends User implements Serializable {

	/**
	 * Represents specific date of employment of administrator
	 */
	private LocalDate employmentDate;

	/**
	 * Constructs an {@code Administrator} object with the specified id, username,
	 * password, and employment date.
	 *
	 * @param id             the ID of the administrator
	 * @param username       the username of the administrator
	 * @param password       the password of the administrator
	 * @param employmentDate the date when the administrator was employed
	 */
	public Administrator(Long id, String username, String password, LocalDate employmentDate) {
		super(id, username, password);
		this.employmentDate = employmentDate;
	}
	
	/**
	 * Default constructor
	 */
	public Administrator() {
		super();
	}	

	/**
	 * Retrieves the employment date of the administrator.
	 *
	 * @return the employment date of the administrator
	 */
	public LocalDate getEmploymentDate() {
		return employmentDate;
	}


	/**
	 * Sets the employment date of the administrator.
	 *
	 * @param employmentDate the employment date of the administrator
	 */
	public void setEmploymentDate(LocalDate employmentDate) {
		this.employmentDate = employmentDate;
	}

	/**
	 * Returns a string representation of the {@code Administrator} object. String
	 * representation contains id, username, password and date of employment of
	 * administrator
	 * 
	 * @return a string representation of the {@code Administrator} object
	 */
	@Override
	public String toString() {
		return "Administrator{id=" + super.getId() + " username=" + super.getUsername() + " password="
				+ super.getPassword() + " employmentDate=" + employmentDate + '}';
	}
}
