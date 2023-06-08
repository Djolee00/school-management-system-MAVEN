package schoolmanagement.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import schoolmanagement.commonlib.model.Course;
import schoolmanagement.commonlib.model.CourseGroup;
import schoolmanagement.commonlib.model.Student;

public interface CourseService {

	public List<Course> getAllCourses() throws IOException, SQLException;

	public boolean updateCourse(Course course) throws IOException, SQLException;

	public boolean deleteCourse(Course course) throws IOException, SQLException;

	public Long saveCourse(Course course) throws IOException, SQLException;

	public List<CourseGroup> getGroupOfCourse(Course temp) throws IOException, SQLException;

	public List<Student> getCourseStudents(Course temp) throws IOException, SQLException;

	public Long saveCourseGroup(CourseGroup courseGroup) throws IOException, SQLException;

	public boolean updateCourseGroup(CourseGroup courseGroup) throws IOException, SQLException;

}
