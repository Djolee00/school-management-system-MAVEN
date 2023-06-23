package schoolmanagement.service.mock;

import java.sql.SQLException;

import schoolmanagement.commonlib.model.Student;
import schoolmanagement.persistence.dao.UserDao;
import schoolmanagement.validator.student.StudentValidator;
import validation.exception.ValidationException;

public class MockStudentValidator implements StudentValidator{

	@Override
	public void validate(Student student, UserDao userDao) throws ValidationException, SQLException {
		
	}

}
