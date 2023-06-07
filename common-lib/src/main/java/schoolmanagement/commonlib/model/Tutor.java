package schoolmanagement.commonlib.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Tutor implements Serializable {

	private Long id;
	private String firstName;
	private String lastName;
	private List<Language> languages;

	public Tutor(String firstName, String lastName, List<Language> languages) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.languages = languages;
	}

	public Tutor() {
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if (firstName == null) {
			throw new NullPointerException("First name cannot be null");
		}
		if (firstName.length() < 3) {
			throw new IllegalArgumentException("First name cannot contain less then 3 char");
		}
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if (lastName == null) {
			throw new NullPointerException("First name cannot be null");
		}
		if (lastName.length() < 3) {
			throw new IllegalArgumentException("Lst name cannot contain less then 3 char");
		}
		this.lastName = lastName;
	}

	public List<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Language> languages) {
		if (languages == null) {
			throw new NullPointerException("Languages list cannot be null");
		}
		this.languages = languages;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName;
	}

	@Override
	public int hashCode() {
		int hash = 3;
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
		final Tutor other = (Tutor) obj;
		return Objects.equals(this.id, other.id);
	}

}
