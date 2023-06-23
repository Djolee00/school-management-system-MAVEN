package schoolmanagement.service;

import schoolmanagement.service.impl.StudentServiceImpl;
import schoolmanagement.service.mock.MockStudentDao;
import schoolmanagement.service.mock.MockUserDao;

public class StudentServiceImplTest extends StudentServiceTest{

	@Override
	protected StudentService createStudentService() {
		return new StudentServiceImpl(new MockUserDao(), new MockStudentDao());
	}

}
