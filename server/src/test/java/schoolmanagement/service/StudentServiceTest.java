package schoolmanagement.service;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import schoolmanagement.commonlib.model.Student;
import schoolmanagement.service.mock.MockStudentValidator;
import schoolmanagement.validator.student.SaveStudentValidator;
import validation.exception.ValidationException;

abstract class StudentServiceTest {
	
	protected StudentService studentService;
	
	protected abstract StudentService createStudentService();
	
	@BeforeEach
	void setUp() throws Exception {
		studentService = createStudentService();
	}

	@AfterEach
	void tearDown() throws Exception {
		studentService = null;
	}

	@Test
	void saveStudentValidationException() {
		Student s = new Student("mike", "password");
		assertThrows(ValidationException.class,() -> studentService.saveStudent(s, new SaveStudentValidator()));
	}
	
	@Test
	void saveStudentSuccessfull() throws ValidationException, IOException, SQLException {
		Student s = new Student("mike12345", "Password12341.");
		s.setFirstName("Mike");
		s.setLastName("Jordan");
		s.setBirthdate(LocalDate.of(2000, 4, 19));
		s.setCreationDate(LocalDate.of(2022, 4, 19));

		Student saved = studentService.saveStudent(s, new MockStudentValidator());
		s.setId(1l);
		
		assertEquals(s, saved);
	}
}
