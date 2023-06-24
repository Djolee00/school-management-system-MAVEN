package schoolmanagement.service.mock;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import schoolmanagement.commonlib.model.Course;
import schoolmanagement.commonlib.model.CourseEnrollment;
import schoolmanagement.commonlib.model.Student;
import schoolmanagement.commonlib.model.User;
import schoolmanagement.persistence.dao.StudentDao;

public class MockStudentDao implements StudentDao {

	List<CourseEnrollment> courseEnrollments;
	List<Course> courses;
	List<Student> students;
	
	public MockStudentDao() {
		Student s1 = new Student(1l, "john", "password", "john", "bryant", null, null);
		Student s2 = new Student(2l, "michael", "password", "michael", "bryant", null, null);
		Student s3 = new Student(3l, "eric", "password", "eric", "bryant", null, null);
		
		Course c1 = new Course("English",null,null,2,null);
		c1.setId(1l);
		Course c2 = new Course("France",null,null,2,null);
		c2.setId(2l);
		Course c3 = new Course("German",null,null,2,null);
		c3.setId(3l);
		
		courses = new ArrayList<>();
		courses.add(c1);
		courses.add(c2);
		courses.add(c3);

		students = new ArrayList<>();
		students.add(s1);
		students.add(s2);
		students.add(s3);
		
		courseEnrollments = new ArrayList<>();
		courseEnrollments.add(new CourseEnrollment(s1,c1,null));
		courseEnrollments.add(new CourseEnrollment(s1,c2,null));
		courseEnrollments.add(new CourseEnrollment(s2,c1,null));
		courseEnrollments.add(new CourseEnrollment(s3,c3,null));
		courseEnrollments.add(new CourseEnrollment(s3,c1,null));
		
		
	}
	
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
		return courseEnrollments.stream().filter(ce -> ce.getStudent().getId() == id).toList();
	}

	@Override
	public List<Course> getStudentUnselecteCourses(Long id) throws SQLException {
		List<Course> unselectedCourses = new ArrayList<>();
		List<Course> selectedCourses = getStudentCourses(id).stream().map(ce->ce.getCourse()).toList();
		for (Course course : courses) {
			if(!selectedCourses.contains(course)) {
				unselectedCourses.add(course);
			}
		}
		
		return unselectedCourses;
		
	}

	@Override
	public boolean saveStudentSelectedCourses(List<CourseEnrollment> selectedCourses) throws SQLException {
		if(selectedCourses != null) {
			for (CourseEnrollment courseEnrollment : selectedCourses) {
				if(courseEnrollment == null)
					return false;
			}
			return true;
		}else {
			throw new SQLException();
		}
	}

	@Override
	public List<Student> getAllStudents() throws SQLException {
		return students;
	}

	@Override
	public boolean updateStudent(Student student) throws SQLException {
		if(student.getFirstName().equals("user"))
			return false;
		return true;
	}

}
