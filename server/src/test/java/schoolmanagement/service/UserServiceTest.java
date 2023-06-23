package schoolmanagement.service;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import schoolmanagement.commonlib.model.Administrator;
import schoolmanagement.commonlib.model.Student;
import schoolmanagement.commonlib.model.User;

abstract class UserServiceTest {

	protected UserService userService;

	protected abstract UserService createUserService();

	@BeforeEach
	void setUp() throws Exception {
		userService = createUserService();
	}

	@AfterEach
	void tearDown() throws Exception {
		userService = null;
	}

	@Test
	public void testLoginSuccessfulStudent() throws IOException, SQLException {
		String username = "john";
		String password = "password";

		Student expectedUser = new Student(username, password);
		User actualUser = userService.login(username, password);

		assertEquals(expectedUser, actualUser);
	}

	@Test
	public void testLoginSuccessfulAdministrator() throws IOException, SQLException {
		String username = "michael";
		String password = "password";

		Administrator expectedUser = new Administrator(1l, username, password, LocalDate.of(2023, 4, 19));

		User actualUser = userService.login(username, password);

		assertEquals(expectedUser.getId(), actualUser.getId());
		assertEquals(expectedUser.getUsername(), actualUser.getUsername());
		assertEquals(expectedUser.getPassword(), actualUser.getPassword());
		assertEquals(expectedUser.getEmploymentDate(), ((Administrator) actualUser).getEmploymentDate());
	}

	@Test
	public void testLoginUnsuccessful() throws IOException, SQLException {
		String username = "jane";
		String password = "invalid";

		User user = userService.login(username, password);

		assertNull(user);
	}
}
