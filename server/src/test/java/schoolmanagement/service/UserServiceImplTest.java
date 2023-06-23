package schoolmanagement.service;

import schoolmanagement.service.impl.UserServiceImpl;
import schoolmanagement.service.mock.MockAdminDao;
import schoolmanagement.service.mock.MockStudentDao;
import schoolmanagement.service.mock.MockUserDao;

class UserServiceImplTest extends UserServiceTest{

	@Override
	protected UserService createUserService() {
		return new UserServiceImpl(new MockUserDao(), new MockStudentDao(), new MockAdminDao());
	}
	
}
