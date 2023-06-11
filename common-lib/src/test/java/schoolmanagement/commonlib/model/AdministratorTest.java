package schoolmanagement.commonlib.model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AdministratorTest {

	private Administrator administrator;
	private LocalDate employmentDate;

	@BeforeEach
	public void setup() throws Exception {
		employmentDate = LocalDate.now();
		administrator = new Administrator(1L, "admin", "password", employmentDate);
	}

	@AfterEach
	public void tearDown() throws Exception {
		employmentDate = null;
		administrator = null;
	}

	@Test
	public void testGetEmploymentDate() {
		LocalDate employmentDate = administrator.getEmploymentDate();
		assertNotNull(employmentDate);
	}

	@Test
	public void testSetEmploymentDate() {
		LocalDate newEmploymentDate = LocalDate.of(2022, 2, 2);
		administrator.setEmploymentDate(newEmploymentDate);
		assertEquals(newEmploymentDate, administrator.getEmploymentDate());
	}

	@Test
	public void testToString() {
		String s = administrator.toString();

		assertTrue(s.contains("1"));
		assertTrue(s.contains("admin"));
		assertTrue(s.contains("password"));
		assertTrue(s.contains(employmentDate.toString()));
	}

}
