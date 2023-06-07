package schoolmanagement.commonlib.model;

import java.io.Serializable;

/**
 * The User class represents a user in the system. It provides basic
 * functionality for storing and retrieving user information.
 * 
 * @author Djordje Ivanovic
 */
public class User implements Serializable {

	/**
	 * The ID of the user.
	 */
	protected Long id;

	/**
	 * The username of the user.
	 */
	protected String username;

	/**
	 * The password of the user.
	 */
	protected String password;

	/**
	 * Constructs a User object with the specified ID, username, and password.
	 *
	 * @param id       The ID of the user.
	 * @param username The username of the user.
	 * @param password The password of the user.
	 */
	public User(Long id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}

	/**
	 * Constructs a User object with the specified username and password.
	 *
	 * @param username The username of the user.
	 * @param password The password of the user.
	 */
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	/**
	 * Returns the ID of the user.
	 *
	 * @return The ID of the user.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the ID of the user.
	 *
	 * @param id The ID of the user.
	 */
	public void setId(Long id) {
		if (id == null) {
			throw new NullPointerException("ID cannot be null");
		}
		this.id = id;
	}

	/**
	 * Returns the username of the user.
	 *
	 * @return The username of the user.
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the username of the user.
	 *
	 * @param username The username of the user.
	 */
	public void setUsername(String username) {
		if (username == null) {
			throw new NullPointerException("Username cannot be null");
		}
		if (username.isBlank()) {
			throw new IllegalArgumentException("Username cannot be blank");
		}
		this.username = username;
	}

	/**
	 * Returns the password of the user.
	 *
	 * @return The password of the user.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password of the user.
	 *
	 * @param password The password of the user.
	 */
	public void setPassword(String password) {
		if (password == null) {
            throw new NullPointerException("Password cannot be null");
        }
        if (password.isBlank()) {
            throw new IllegalArgumentException("Password cannot be blank");
        }
		this.password = password;
	}

	/**
     * Returns a string representation of the User object.
     *
     * @return A string representation of the User object.
     */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}