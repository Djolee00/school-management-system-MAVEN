package schoolmanagement.commonlib.model;

import java.io.Serializable;

public class User implements Serializable {

	protected Long id;
	protected String username;
	protected String password;

	public User(Long id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		if (id == null) {
			throw new NullPointerException("ID cannot be null");
		}
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		if (username == null) {
			throw new NullPointerException("Username cannot be null");
		}
		if (username.isBlank()) {
			throw new IllegalArgumentException("Username cannot be blank");
		}
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if (password == null) {
            throw new NullPointerException("Password cannot be null");
        }
        if (password.isBlank()) {
            throw new IllegalArgumentException("Password cannot be blank");
        }
		this.password = password;
	}

	@Override
	public String toString() {
		return "User{" + "id=" + id + ", username=" + username + ", password=" + password + '}';
	}

}
