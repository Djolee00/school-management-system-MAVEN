package schoolmanagement.service.mock;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import schoolmanagement.commonlib.model.Course;
import schoolmanagement.commonlib.model.CourseEnrollment;
import schoolmanagement.commonlib.model.Student;
import schoolmanagement.commonlib.model.User;
import schoolmanagement.persistence.dao.StudentDao;

public class MockStudentDao implements StudentDao {

	@Override
	public Student getStudentByUser(User user) throws SQLException {
		if (user != null && user.getUsername().equals("john") && user.getPassword().equals("password")) {
			return new Student("john", "password");
		}
		return null;
	}

	@Override
	public void setConnection(Connection connection) {
		// TODO Auto-generated method stub
	}

	@Override
	public Student saveStudent(Student student) throws SQLException, IOException {
		return student;
	}

	@Override
	public List<CourseEnrollment> getStudentCourses(Long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> getStudentUnselecteCourses(Long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveStudentSelectedCourses(List<CourseEnrollment> selectedCourses) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Student> getAllStudents() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateStudent(Student student) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
