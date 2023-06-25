package schoolmanagement.server.handler;

import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Date;

import com.fasterxml.jackson.core.type.TypeReference;

import schoolmanagement.commonlib.communication.Sender;
import schoolmanagement.commonlib.communication.Receiver;
import schoolmanagement.commonlib.communication.Request;
import schoolmanagement.commonlib.communication.Response;
import schoolmanagement.commonlib.communication.ResponseType;
import schoolmanagement.commonlib.model.User;
import schoolmanagement.commonlib.utils.JsonSerializationUtils;
import schoolmanagement.server.Server;
import validation.exception.ValidationException;

public class ClientHandler extends Thread {

	private final Sender sender;
	private final Receiver receiver;
	private final ClientHandlerController controller;
	private User user;
	private Date loginTime;

	public ClientHandler(Socket socket) throws IOException {
		sender = new Sender(socket);
		receiver = new Receiver(socket);
		controller = new ClientHandlerController();
	}

	@Override
	public void run() {
		try {
			while (true) {

				String jsonRequest = (String) receiver.receive();
				Request request = JsonSerializationUtils.deserializeFromJson(jsonRequest, new TypeReference<Request>() {
				});
				handleRequest(request);

			}
		} catch (IOException | ClassNotFoundException ex) {
			System.out.println("One client disconnected");
			Server.loggedClients.remove(this);
		}
	}

	private void handleRequest(Request request) throws IOException {
		Response response = new Response();

		try {
			switch (request.getOperation()) {
			case LOGIN -> {
				response = controller.loginUser(request);
				addActiveClient(response);
			}
			case GET_STUDENT_COURSES -> {
				response = controller.getStudentCourses(request);
			}
			case GET_STUDENT_UNSELECTED_COURSES -> {
				response = controller.getStudentUnselectedCourses(request);
			}
			case ENROLL_STUDENT_IN_COURSES -> {
				response = controller.enrollStudentInCourses(request);
			}
			case GET_ALL_STUDENTS -> {
				response = controller.getAllStudents();
			}
			case GET_ALL_COURSES -> {
				response = controller.getAllCourses();
			}
			case GET_ALL_LANGUAGES -> {
				response = controller.getAllLanguages();
			}
			case UPDATE_STUDENT_PERSONAL_INFO -> {
				response = controller.updateStudentPersonalInfo(request);
			}
			case ADD_NEW_STUDENT -> {
				response = controller.addStudent(request);
			}
			case UPDATE_COURSE -> {
				response = controller.updateCourseData(request);
			}
			case DELETE_COURSE -> {
				response = controller.deleteCourse(request);
			}
			case ADD_COURSE -> {
				response = controller.addCourse(request);
			}
			case GET_COURSE_GROUPS -> {
				response = controller.getGroupsOfCourse(request);
			}
			case GET_LANGUAGE_TUTORS -> {
				response = controller.getLanguageTutors(request);
			}
			case GET_COURSE_STUDENTS -> {
				response = controller.getCourseStudents(request);
			}
			case ADD_COURSE_GROUP -> {
				response = controller.addCourseGroup(request);
			}
			case UPDATE_COURSE_GROUP -> {
				response = controller.updateCourseGroup(request);
			}
			case LOG_OUT -> {
				Server.loggedClients.remove(this);
			}
			}
			String jsonResponse = JsonSerializationUtils.serializeToJson(response, new TypeReference<Response>() {
			});
			sender.send(jsonResponse);
		} catch (SQLException | ValidationException ex) {
			String jsonResponse = JsonSerializationUtils.serializeToJson(new Response(ex.getMessage(), ResponseType.FAILURE), new TypeReference<Response>() {
			});
			sender.send(jsonResponse);
		}
	}

	private void addActiveClient(Response response) {
		if (response.getResponseType() == ResponseType.FAILURE) {
			return;
		}
		user = (User) response.getObject();
		loginTime = new Date();
		Server.loggedClients.add(this);
	}

	public User getUser() {
		return user;
	}

	public Date getLoginTime() {
		return loginTime;
	}

}
