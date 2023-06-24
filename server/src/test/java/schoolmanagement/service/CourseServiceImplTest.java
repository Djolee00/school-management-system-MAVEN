package schoolmanagement.service;

import schoolmanagement.service.impl.CourseServiceImpl;
import schoolmanagement.service.mock.MockCourseDao;

public class CourseServiceImplTest extends CourseServiceTest{

	@Override
	protected CourseService createCourseService() {
		courseDao = new MockCourseDao();
		return new CourseServiceImpl(courseDao);
	}

}
