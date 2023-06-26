package schoolmanagement.server.handler;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

import schoolmanagement.commonlib.communication.Request;
import schoolmanagement.commonlib.communication.Response;
import schoolmanagement.commonlib.communication.ResponseType;
import schoolmanagement.commonlib.model.Course;
import schoolmanagement.commonlib.model.CourseEnrollment;
import schoolmanagement.commonlib.model.CourseGroup;
import schoolmanagement.commonlib.model.Language;
import schoolmanagement.commonlib.model.Student;
import schoolmanagement.commonlib.model.Tutor;
import schoolmanagement.commonlib.model.User;
import schoolmanagement.commonlib.utils.JsonSerializationUtils;
import schoolmanagement.service.CourseService;
import schoolmanagement.service.LanguageService;
import schoolmanagement.service.StudentService;
import schoolmanagement.service.UserService;
import schoolmanagement.service.provider.ServiceProvider;
import schoolmanagement.validator.student.SaveStudentValidator;
import schoolmanagement.validator.student.UpdateStudentValidator;
import validation.exception.ValidationException;

public class ClientHandlerController {

	public Response loginUser(Request request) throws IOException, SQLException {
		Response response = new Response();
		User temp = JsonSerializationUtils.convertValue(request.getObject(), new TypeReference<User>() {
		});
		User user = ((UserService) ServiceProvider.getInstance().getRequiredService(UserService.class))
				.login(temp.getUsername(), temp.getPassword());
		if (user == null) {
			response.setResponseType(ResponseType.FAILURE);
		} else {
			response.setResponseType(ResponseType.SUCCESS);
			response.setObject(user);
		}

		return response;
	}

	public Response getStudentCourses(Request request) throws IOException, SQLException {
		Response response = new Response();
		Student student = JsonSerializationUtils.convertValue(request.getObject(), new TypeReference<Student>() {
		});

		List<CourseEnrollment> courses = ((StudentService) ServiceProvider.getInstance()
				.getRequiredService(StudentService.class)).getStudentCourses(student.getId());
		if (courses == null) {
			response.setResponseType(ResponseType.FAILURE);
		} else {
			response.setResponseType(ResponseType.SUCCESS);
			response.setObject(courses);
		}

		return response;
	}

	public Response getStudentUnselectedCourses(Request request) throws IOException, SQLException {
		Response response = new Response();
		Student student = JsonSerializationUtils.convertValue(request.getObject(), new TypeReference<Student>() {
		});

		List<Course> courses = ((StudentService) ServiceProvider.getInstance().getRequiredService(StudentService.class))
				.getStudentUnselectedCourses(student.getId());
		if (courses == null) {
			response.setResponseType(ResponseType.FAILURE);
		} else {
			response.setResponseType(ResponseType.SUCCESS);
			response.setObject(courses);
		}

		return response;
	}

	public Response enrollStudentInCourses(Request request) throws IOException, SQLException {
		Response response = new Response();
		List<CourseEnrollment> selectedCourses = JsonSerializationUtils.convertValue(request.getObject(),new TypeReference<List<CourseEnrollment>>() {
		});

		boolean status = ((StudentService) ServiceProvider.getInstance().getRequiredService(StudentService.class))
				.enrollCourses(selectedCourses);
		if (status == false) {
			response.setResponseType(ResponseType.FAILURE);
		} else {
			response.setResponseType(ResponseType.SUCCESS);
		}

		return response;
	}

	public Response getAllStudents() throws IOException, SQLException {
		Response response = new Response();

		List<Student> students = ((StudentService) ServiceProvider.getInstance()
				.getRequiredService(StudentService.class)).getAllStudents();
		if (students == null) {
			response.setResponseType(ResponseType.FAILURE);
		} else {
			response.setResponseType(ResponseType.SUCCESS);
			response.setObject(students);
		}

		return response;
	}

	public Response getAllCourses() throws IOException, SQLException {
		Response response = new Response();

		List<Course> courses = ((CourseService) ServiceProvider.getInstance().getRequiredService(CourseService.class))
				.getAllCourses();
		if (courses == null) {
			response.setResponseType(ResponseType.FAILURE);
		} else {
			response.setResponseType(ResponseType.SUCCESS);
			response.setObject(courses);
		}

		return response;
	}

	public Response getAllLanguages() throws IOException, SQLException {
		Response response = new Response();

		List<Language> languages = ((LanguageService) ServiceProvider.getInstance()
				.getRequiredService(LanguageService.class)).getAllLanguages();
		if (languages == null) {
			response.setResponseType(ResponseType.FAILURE);
		} else {
			response.setResponseType(ResponseType.SUCCESS);
			response.setObject(languages);
		}

		return response;
	}

	public Response updateStudentPersonalInfo(Request request) throws IOException, SQLException, ValidationException {
		Response response = new Response();
		Student student = JsonSerializationUtils.convertValue(request.getObject(), new TypeReference<Student>() {
		});

		boolean status = ((StudentService) ServiceProvider.getInstance().getRequiredService(StudentService.class))
				.updateStudent(student, new UpdateStudentValidator());
		if (status == false) {
			response.setResponseType(ResponseType.FAILURE);
		} else {
			response.setResponseType(ResponseType.SUCCESS);
		}

		return response;
	}

	public Response addStudent(Request request) throws ValidationException, IOException, SQLException {
		Response response = new Response();
		Student student = JsonSerializationUtils.convertValue(request, new TypeReference<Student>() {
		});

		Student newStudent = ((StudentService) ServiceProvider.getInstance().getRequiredService(StudentService.class))
				.saveStudent(student, new SaveStudentValidator());
		if (newStudent == null) {
			response.setResponseType(ResponseType.FAILURE);
		} else {
			response.setResponseType(ResponseType.SUCCESS);
			response.setObject(student);
		}

		return response;
	}

	public Response updateCourseData(Request request) throws IOException, SQLException {
		Response response = new Response();
		Course course = JsonSerializationUtils.convertValue(request.getObject(),new TypeReference<Course>() {
		});

		boolean status = ((CourseService) ServiceProvider.getInstance().getRequiredService(CourseService.class))
				.updateCourse(course);
		if (status == false) {
			response.setResponseType(ResponseType.FAILURE);
		} else {
			response.setResponseType(ResponseType.SUCCESS);
		}

		return response;
	}

	public Response deleteCourse(Request request) throws IOException, SQLException {
		Response response = new Response();
		Course course = JsonSerializationUtils.convertValue(request.getObject(),new TypeReference<Course>() {
		});

		boolean status = ((CourseService) ServiceProvider.getInstance().getRequiredService(CourseService.class))
				.deleteCourse(course);
		if (status == false) {
			response.setResponseType(ResponseType.FAILURE);
		} else {
			response.setResponseType(ResponseType.SUCCESS);
		}

		return response;
	}

	public Response addCourse(Request request) throws IOException, SQLException {
		Response response = new Response();
		Course course = JsonSerializationUtils.convertValue(request.getObject(), new TypeReference<Course>() {
		});

		Long generatedId = ((CourseService) ServiceProvider.getInstance().getRequiredService(CourseService.class))
				.saveCourse(course);
		if (generatedId == null) {
			response.setResponseType(ResponseType.FAILURE);
		} else {
			response.setResponseType(ResponseType.SUCCESS);
			response.setObject(generatedId);
		}

		return response;
	}

	public Response getGroupsOfCourse(Request request) throws IOException, SQLException {
		Response response = new Response();
		Course temp = JsonSerializationUtils.convertValue(request.getObject(), new TypeReference<Course>() {
		});

		List<CourseGroup> courseGroups = ((CourseService) ServiceProvider.getInstance()
				.getRequiredService(CourseService.class)).getGroupOfCourse(temp);
		if (courseGroups == null) {
			response.setResponseType(ResponseType.FAILURE);
		} else {
			response.setResponseType(ResponseType.SUCCESS);
			response.setObject(courseGroups);
		}

		return response;
	}

	public Response getLanguageTutors(Request request) throws IOException, SQLException {
		Response response = new Response();
		Language tempLanguage = JsonSerializationUtils.convertValue(request.getObject(),new TypeReference<Language>() {
		});

		List<Tutor> tutors = ((LanguageService) ServiceProvider.getInstance().getRequiredService(LanguageService.class))
				.getAllTutors(tempLanguage);
		if (tutors == null) {
			response.setResponseType(ResponseType.FAILURE);
		} else {
			response.setResponseType(ResponseType.SUCCESS);
			response.setObject(tutors);
		}

		return response;
	}

	public Response getCourseStudents(Request request) throws IOException, SQLException {
		Response response = new Response();
		Course temp = JsonSerializationUtils.convertValue(request.getObject(), new TypeReference<Course>() {
		});

		List<Student> students = ((CourseService) ServiceProvider.getInstance().getRequiredService(CourseService.class))
				.getCourseStudents(temp);
		if (students == null) {
			response.setResponseType(ResponseType.FAILURE);
		} else {
			response.setResponseType(ResponseType.SUCCESS);
			response.setObject(students);
		}

		return response;
	}

	public Response addCourseGroup(Request request) throws IOException, SQLException {
		Response response = new Response();
		CourseGroup courseGroup = JsonSerializationUtils.convertValue(request.getObject(),new TypeReference<CourseGroup>() {
		});

		Long generatedId = ((CourseService) ServiceProvider.getInstance().getRequiredService(CourseService.class))
				.saveCourseGroup(courseGroup);
		if (generatedId == null) {
			response.setResponseType(ResponseType.FAILURE);
		} else {
			response.setResponseType(ResponseType.SUCCESS);
			response.setObject(generatedId);
		}

		return response;
	}

	public Response updateCourseGroup(Request request) throws IOException, SQLException {
		Response response = new Response();
		CourseGroup courseGroup = JsonSerializationUtils.convertValue(request.getObject(),new TypeReference<CourseGroup>() {
		});

		boolean status = ((CourseService) ServiceProvider.getInstance().getRequiredService(CourseService.class))
				.updateCourseGroup(courseGroup);
		if (status == false) {
			response.setResponseType(ResponseType.FAILURE);
		} else {
			response.setResponseType(ResponseType.SUCCESS);
		}

		return response;
	}

}
