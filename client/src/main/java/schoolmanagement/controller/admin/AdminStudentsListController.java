package schoolmanagement.controller.admin;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import com.fasterxml.jackson.core.type.TypeReference;

import schoolmanagement.commonlib.communication.Operation;
import schoolmanagement.commonlib.communication.Request;
import schoolmanagement.commonlib.communication.Response;
import schoolmanagement.commonlib.communication.ResponseType;
import schoolmanagement.commonlib.model.Course;
import schoolmanagement.commonlib.model.CourseEnrollment;
import schoolmanagement.commonlib.model.Language;
import schoolmanagement.commonlib.model.Student;
import schoolmanagement.commonlib.utils.JsonSerializationUtils;
import schoolmanagement.communication.Communication;
import schoolmanagement.validator.StudentValidatorBuilder;
import schoolmanagement.view.admin.AdminStudentsListView;
import schoolmanagement.view.component.table.tmodel.StudentsListTModel;
import validation.exception.ValidationException;
import validation.rule.result.ResultInfo;

public class AdminStudentsListController {

	private final AdminStudentsListView studentsView;
	private StudentsListTModel tableModel;
	private List<Student> students;
	private List<Student> backupStudents;
	private Student selectedStudent;

	public AdminStudentsListController() {
		studentsView = new AdminStudentsListView();
		initView();
		studentsView.setVisible(true);
	}

	private void initView() {
		initListeners();
		populateTable();
		initCourses();
		initLanguages();
	}

	private void initListeners() {
		studentsView.getLblHome().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new AdminHomeController();
				studentsView.dispose();
			}
		});

		studentsView.getBtnSearch().addActionListener(e -> searchStudents());
		studentsView.getBtnUpdate().addActionListener(e -> updateStudent());
		studentsView.getBtnReset().addActionListener(e -> resetSearch());
		studentsView.getTblStudents().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				studentSelection();
			}
		});
		studentsView.getBtnAddEmptyStudent().addActionListener(e -> insertEmptyStudent());
	}

	private void populateTable() {
		students = getAllStudents();
		backupStudents = students;
		studentsView.getTblStudents().setModel(new StudentsListTModel(students));
		tableModel = (StudentsListTModel) studentsView.getTblStudents().getModel();
	}

	private void initCourses() {
		List<Course> courses = getAllCourses();
		studentsView.getJcbCourses().setModel(new DefaultComboBoxModel(courses.toArray()));
		studentsView.getJcbCourses().setSelectedIndex(-1);
	}

	private void initLanguages() {
		List<Language> languages = getAllLanguages();
		studentsView.getJcbLanguages().setModel(new DefaultComboBoxModel(languages.toArray()));
		studentsView.getJcbLanguages().setSelectedIndex(-1);
	}

	private void searchStudents() {
		List<Student> temp = this.backupStudents;
		String firstName = studentsView.getTxtFirstnameSearch().getText().trim();
		String lastName = studentsView.getTxtLastnameSearch().getText().trim();

		temp = temp.stream().filter(s -> s.getFirstName().startsWith(firstName) && s.getLastName().startsWith(lastName))
				.collect(Collectors.toList());
		if (studentsView.getBirthdateFrom().getDate() != null) {
			LocalDate birthdateFrom = studentsView.getBirthdateFrom().getDate().toInstant()
					.atZone(ZoneId.systemDefault()).toLocalDate();
			temp = temp.stream()
					.filter(s -> s.getBirthdate().isAfter(birthdateFrom) || s.getBirthdate().isEqual(birthdateFrom))
					.collect(Collectors.toList());
		}
		if (studentsView.getBirthdateTo().getDate() != null) {
			LocalDate birthdateTo = studentsView.getBirthdateTo().getDate().toInstant().atZone(ZoneId.systemDefault())
					.toLocalDate();
			temp = temp.stream()
					.filter(s -> s.getBirthdate().isBefore(birthdateTo) || s.getBirthdate().isEqual(birthdateTo))
					.collect(Collectors.toList());
		}
		if (studentsView.getJcbCourses().getSelectedIndex() != -1) {
			Course course = (Course) studentsView.getJcbCourses().getSelectedItem();
			temp = getStudentsForSelectedCourse(temp, course);
		}
		if (studentsView.getJcbLanguages().getSelectedIndex() != -1) {
			Language language = (Language) studentsView.getJcbLanguages().getSelectedItem();
			temp = getStudentsForSelectedLanguages(temp, language);
		}

		students = temp;
		tableModel.setStudents(temp);

		if (students.isEmpty()) {
			JOptionPane.showMessageDialog(studentsView, "There are no students with these values", "Info",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private void updateStudent() {
		if (studentsView.getTblStudents().getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(studentsView, "Please, first select student", "Message",
					JOptionPane.WARNING_MESSAGE);
			return;
		}

		if (JOptionPane.showConfirmDialog(studentsView, "Are you sure you want to update this student?", "Confirmation",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			Student temp = populateSelectedStudent();

			try {
				validateStudentData(temp);

				boolean status = sendSaveOrUpdateRequest(temp);
				if (status == true) {
					selectedStudent.setFirstName(temp.getFirstName());
					selectedStudent.setLastName(temp.getLastName());
					selectedStudent.setBirthdate(temp.getBirthdate());
					selectedStudent.setPassword(temp.getPassword());
					selectedStudent.setUsername(temp.getUsername());

					tableModel.fireTableDataChanged();
					resetUpdateSection();
					JOptionPane.showMessageDialog(studentsView, "Student information has been successfully updated",
							"Success", JOptionPane.INFORMATION_MESSAGE);
				}

			} catch (ValidationException ex) {
				JOptionPane.showMessageDialog(studentsView, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}

	}

	private List<Student> getAllStudents() {
		List<Student> tempStudents = null;

		try {
			Communication.getInstance().send(new Request(Operation.GET_ALL_STUDENTS, null));

			Response response = Communication.getInstance().receive();

			if (response.getResponseType() == ResponseType.SUCCESS) {
				tempStudents = JsonSerializationUtils.convertValue(response.getObject(),
						new TypeReference<List<Student>>() {
						});
			} else {
				JOptionPane.showMessageDialog(studentsView, "Error getting students' data. Try again later!", "Error",
						JOptionPane.ERROR_MESSAGE);
				studentsView.dispose();
				System.exit(0);
			}

		} catch (ClassNotFoundException | IOException ex) {
			JOptionPane.showMessageDialog(studentsView, "Error getting students' data. Try again later!", "Error",
					JOptionPane.ERROR_MESSAGE);
			studentsView.dispose();
			System.exit(0);
		}

		return tempStudents;
	}

	private List<Course> getAllCourses() {
		List<Course> tempCourses = null;

		try {
			Communication.getInstance().send(new Request(Operation.GET_ALL_COURSES, null));

			Response response = Communication.getInstance().receive();

			if (response.getResponseType() == ResponseType.SUCCESS) {
				tempCourses = JsonSerializationUtils.convertValue(response.getObject(),
						new TypeReference<List<Course>>() {
						});
			} else {
				JOptionPane.showMessageDialog(studentsView, "Error getting courses' data. Try again later!", "Error",
						JOptionPane.ERROR_MESSAGE);
				studentsView.dispose();
				System.exit(0);
			}

		} catch (ClassNotFoundException | IOException ex) {
			JOptionPane.showMessageDialog(studentsView, "Error getting courses' data. Try again later!", "Error",
					JOptionPane.ERROR_MESSAGE);
			studentsView.dispose();
			System.exit(0);
		}

		return tempCourses;
	}

	private List<Language> getAllLanguages() {
		List<Language> tempLanguages = null;

		try {
			Communication.getInstance().send(new Request(Operation.GET_ALL_LANGUAGES, null));

			Response response = Communication.getInstance().receive();

			if (response.getResponseType() == ResponseType.SUCCESS) {
				tempLanguages = JsonSerializationUtils.convertValue(response.getObject(),
						new TypeReference<List<Language>>() {
						});
			} else {
				throw new IOException("Error getting languages' data");
			}

		} catch (ClassNotFoundException | IOException ex) {
			JOptionPane.showMessageDialog(studentsView, "Error getting languages' data. Try again later!", "Error",
					JOptionPane.ERROR_MESSAGE);
			studentsView.dispose();
			System.exit(0);
		}

		return tempLanguages;
	}

	private List<Student> getStudentsForSelectedCourse(List<Student> temp, Course course) {
		List<Student> courseStudents = new ArrayList<>();
		for (Student student : temp) {
			for (CourseEnrollment coursesEnrollment : student.getCourseEnrollments()) {
				if (coursesEnrollment.getCourse().equals(course)) {
					courseStudents.add(student);
					break;
				}
			}
		}

		return courseStudents;
	}

	private List<Student> getStudentsForSelectedLanguages(List<Student> temp, Language language) {
		List<Student> languageStudents = new ArrayList<>();
		for (Student student : temp) {
			for (CourseEnrollment coursesEnrollment : student.getCourseEnrollments()) {
				if (coursesEnrollment.getCourse().getLanguage().equals(language)) {
					languageStudents.add(student);
					break;
				}
			}
		}

		return languageStudents;
	}

	private void studentSelection() {
		int rowIndex = studentsView.getTblStudents().getSelectedRow();
		selectedStudent = tableModel.getStudent(rowIndex);

		studentsView.getTxtFirstname().setText(selectedStudent.getFirstName());
		studentsView.getTxtLastname().setText(selectedStudent.getLastName());
		studentsView.getTxtUsername().setText(selectedStudent.getUsername());
		studentsView.getTxtPassword().setText(selectedStudent.getPassword());
		studentsView.getBirthDate()
				.setDate(Date.from(selectedStudent.getBirthdate().atStartOfDay(ZoneId.systemDefault()).toInstant()));
		studentsView.getCreationDate()
				.setDate(Date.from(selectedStudent.getCreationDate().atStartOfDay(ZoneId.systemDefault()).toInstant()));

		if (selectedStudent.getId() == null) {
			studentsView.getTxtUsername().setEditable(true);
		} else {
			studentsView.getTxtUsername().setEditable(false);
		}
	}

	private void validateStudentData(Student student) throws ValidationException {
		ResultInfo result = new StudentValidatorBuilder(student).validate();
		if (!result.isValid()) {
			throw new ValidationException(result.getErrors());
		}
	}

	private Student populateSelectedStudent() {
		// making deep copy, because maybe input will fail validation
		Student temp = new Student(selectedStudent.getId(), selectedStudent.getUsername(),
				selectedStudent.getPassword(), selectedStudent.getFirstName(), selectedStudent.getLastName(),
				selectedStudent.getBirthdate(), selectedStudent.getCreationDate());
		temp.setCourseEnrollments(selectedStudent.getCourseEnrollments());
		temp.setCourseGroups(selectedStudent.getCourseGroups());

		temp.setFirstName(studentsView.getTxtFirstname().getText().trim());
		temp.setLastName(studentsView.getTxtLastname().getText().trim());
		temp.setBirthdate(
				studentsView.getBirthDate().getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
		temp.setPassword(studentsView.getTxtPassword().getText().trim());
		temp.setUsername(studentsView.getTxtUsername().getText().trim());

		return temp;
	}

	private boolean sendSaveOrUpdateRequest(Student temp) {
		try {
			if (selectedStudent.getId() != null) {
				Communication.getInstance().send(new Request(Operation.UPDATE_STUDENT_PERSONAL_INFO, temp));
			} else {
				Communication.getInstance().send(new Request(Operation.ADD_NEW_STUDENT, temp));
			}

			Response response = Communication.getInstance().receive();

			if (selectedStudent.getId() != null && response.getResponseType() == ResponseType.FAILURE) {
				JOptionPane.showMessageDialog(studentsView, "Error updating student's data. Try again later!", "Error",
						JOptionPane.ERROR_MESSAGE);
				studentsView.dispose();
				System.exit(0);
			}

			if (selectedStudent.getId() == null && response.getResponseType() == ResponseType.FAILURE) {
				JOptionPane.showMessageDialog(studentsView,
						JsonSerializationUtils.convertValue(response.getObject(), new TypeReference<String>() {
						}), "Error", JOptionPane.ERROR_MESSAGE);
				return false;
			}

			if (selectedStudent.getId() == null && response.getResponseType() == ResponseType.SUCCESS) {
				selectedStudent
						.setId((JsonSerializationUtils.convertValue(response.getObject(), new TypeReference<Student>() {
						})).getId());
				return true;
			}

		} catch (ClassNotFoundException | IOException ex) {
			JOptionPane.showMessageDialog(studentsView, "Error updating student's data. Try again later!", "Error",
					JOptionPane.ERROR_MESSAGE);
			studentsView.dispose();
			System.exit(0);
		}

		return true;
	}

	private void insertEmptyStudent() {
		resetSearch();
		// creating dummy student
		Student temp = new Student("", "");
		temp.setFirstName("");
		temp.setLastName("");
		temp.setCreationDate(LocalDate.now());
		temp.setBirthdate(LocalDate.now());
		temp.setCourseEnrollments(new ArrayList<>());
		temp.setCourseGroups(new ArrayList<>());
		temp.setId(null);

		backupStudents.add(temp);
		tableModel.setStudents(students);
	}

	private void resetUpdateSection() {
		studentsView.getTxtFirstname().setText("");
		studentsView.getTxtLastname().setText("");
		studentsView.getTxtUsername().setText("");
		studentsView.getTxtPassword().setText("");
		studentsView.getBirthDate().setDate(null);
		studentsView.getCreationDate().setDate(null);
	}

	private void resetSearch() {
		studentsView.getJcbLanguages().setSelectedIndex(-1);
		studentsView.getJcbCourses().setSelectedIndex(-1);
		studentsView.getBirthdateFrom().setDate(null);
		studentsView.getBirthdateTo().setDate(null);
		studentsView.getTxtFirstnameSearch().setText("");
		studentsView.getTxtLastnameSearch().setText("");
		students = backupStudents;
		tableModel.setStudents(backupStudents);
	}
}
