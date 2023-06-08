package schoolmanagement.validator.student;

import java.sql.SQLException;
import schoolmanagement.commonlib.model.Student;
import schoolmanagement.persistence.dao.UserDao;
import validation.exception.ValidationException;

public interface StudentValidator {

	void validate(Student student, UserDao userDao) throws ValidationException, SQLException;
}
