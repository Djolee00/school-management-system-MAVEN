package schoolmanagement.service.mock;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import schoolmanagement.commonlib.model.Course;
import schoolmanagement.commonlib.model.CourseEnrollment;
import schoolmanagement.commonlib.model.CourseGroup;
import schoolmanagement.commonlib.model.Student;
import schoolmanagement.persistence.dao.CourseDao;

public class MockCourseDao implements CourseDao {

	private List<Course> courses;
	private boolean failure;

	@SuppressWarnings("serial")
	public MockCourseDao() {
		Course c1 = new Course("English", null, null, 5, null);
		c1.setCourseGroups(new ArrayList<>() {{add(new CourseGroup(c1,"Group1",5,null,null));}});
		c1.setId(1l);
		Course c2 = new Course("France", null, null, 5, null);
		c2.setId(2l);
		Course c3 = new Course("German", null, null, 5, null);
		c3.setId(3l);
		
		courses = new ArrayList<>();
		courses.add(c1);
		courses.add(c2);
		courses.add(c3);
	}

	@Override
	public List<Course> getAllCourses() throws SQLException {
		return courses;
	}

	@Override
	public boolean updateCourse(Course course) throws SQLException {
		if(failure) {
			return false;
		}
		for (Course temp : courses) {
			if(temp.equals(course)) {
				courses.set(courses.indexOf(temp), course);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean checkIfCourseGroupsExist(Course course) throws SQLException {
		for (Course temp : courses) {
			if(temp.equals(course)) {
				if(temp.getCourseGroups()!=null && temp.getCourseGroups().size()>0)
					return true;
			}
		}
		return false;
	}

	@Override
	public void deleteCourseEnrollments(Course course) throws SQLException {
		for (Course temp : courses) {
			if(temp.equals(course)) {
				temp.setCourseEnrollments(null);
			}
		}
	}

	@Override
	public void deleteCourse(Course course) throws SQLException {
		for (Course temp : courses) {
			if(temp.equals(course)) {
				courses.remove(courses.indexOf(temp));
			}
		}
	}

	@Override
	public Long saveCourse(Course course) throws SQLException {
		if(failure == true) {
			throw new SQLException("Could not save course");
		}
		course.setId(5l);
		courses.add(course);
		return course.getId();
	}

	@Override
	public List<CourseGroup> getGroupsOfCourse(Course temp) throws SQLException {
		for (Course course : courses) {
			if(course.equals(temp))
				return course.getCourseGroups();
		}
		return null;
	}

	@Override
	public List<Student> getStudentsOfCourse(Course temp) throws SQLException {
		Student s1 = new Student("s1", "s1");
		s1.setId(1l);
		
		Student s2 = new Student("s2", "s2");
		s2.setId(2l);
		Student s3 = new Student("s3", "s3");
		s3.setId(3l);
		
		List<CourseEnrollment> courseEnrollments = new ArrayList<>();
		courseEnrollments.add(new CourseEnrollment(s1,courses.get(0),null));
		courseEnrollments.add(new CourseEnrollment(s2,courses.get(0),null));

		courseEnrollments.add(new CourseEnrollment(s2,courses.get(1),null));
		courseEnrollments.add(new CourseEnrollment(s3,courses.get(1),null));

		
		return courseEnrollments.stream().filter(ce->ce.getCourse().equals(temp)).map(
				ce->ce.getStudent()).toList();
	}

	@Override
	public Long saveCourseGroup(CourseGroup courseGroup) throws SQLException {
		courseGroup.setId(2l);
		for (Course course : courses) {
			if(course.equals(courseGroup.getCourse())) {
				course.getCourseGroups().add(courseGroup);
				return 2l;
			}
		}
		return 0l;
	}

	@Override
	public boolean updateCourseGroupData(CourseGroup courseGroup) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void deleteTutorsFromGroup(CourseGroup courseGroup) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteStudentsFromGroup(CourseGroup courseGroup) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void addStudentsInGroup(CourseGroup courseGroup) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void addTutorsInGroup(CourseGroup courseGroup) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setConnection(Connection connection) {
		// TODO Auto-generated method stub

	}
	
	public List<Course> getCourses() {
		return courses;
	}

	public void setFailure(boolean failure) {
		this.failure = failure;
	}
}
