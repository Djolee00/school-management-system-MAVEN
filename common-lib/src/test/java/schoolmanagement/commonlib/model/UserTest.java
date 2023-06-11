package schoolmanagement.commonlib.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest {

	private User user;

	@BeforeEach
	public void setUp() {
		user = new User(1L, "john", "password123");
	}

	@AfterEach
	public void tearDown() {
		user = null;
	}

	@Test
	public void testGetId() {
		assertEquals(1L, user.getId());
	}

	@Test
	public void testSetId() {
		user.setId(2L);
		assertEquals(2L, user.getId());
	}

	@Test
	public void testSetIdWithNullId() {
		assertThrows(NullPointerException.class, () -> user.setId(null));
	}

	@Test
	public void testGetUsername() {
		assertEquals("john", user.getUsername());
	}

	@Test
	public void testSetUsername() {
		user.setUsername("jane");
		assertEquals("jane", user.getUsername());
	}

	@Test
	public void testSetUsernameWithNullUsername() {
		assertThrows(NullPointerException.class, () -> user.setUsername(null));
	}

	@Test
	public void testSetUsernameWithBlankUsername() {
		assertThrows(IllegalArgumentException.class, () -> user.setUsername(""));
	}

	@Test
	public void testGetPassword() {
		assertEquals("password123", user.getPassword());
	}

	@Test
	public void testSetPassword() {
		user.setPassword("newPassword");
		assertEquals("newPassword", user.getPassword());
	}

	@Test
	public void testSetPasswordWithNullPassword() {
		assertThrows(NullPointerException.class, () -> user.setPassword(null));
	}

	@Test
	public void testSetPasswordWithBlankPassword() {
		assertThrows(IllegalArgumentException.class, () -> user.setPassword(""));
	}
	
	@Test
	public void testToString() {
		String s = user.toString();
		s.contains("john");
		s.contains("1");
		s.contains("password123");
	}

}
