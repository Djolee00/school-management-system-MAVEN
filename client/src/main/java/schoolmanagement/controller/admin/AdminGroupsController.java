package schoolmanagement.controller.admin;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
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
import schoolmanagement.commonlib.model.CourseGroup;
import schoolmanagement.commonlib.model.Student;
import schoolmanagement.commonlib.model.Tutor;
import schoolmanagement.commonlib.utils.JsonSerializationUtils;
import schoolmanagement.communication.Communication;
import schoolmanagement.session.Session;
import schoolmanagement.view.admin.AdminGroupsView;
import schoolmanagement.view.component.table.tmodel.AdminGroupsSelectionTModel;

public class AdminGroupsController {

	private final AdminGroupsView groupsView;
	private final Course selectedCourse;
	private final AdminGroupsSelectionTModel tableModel;
	private List<CourseGroup> courseGroups;
	private List<Tutor> languageTutors;
	private List<Student> courseStudents;
	private CourseGroup selectedGroup;

	public AdminGroupsController() {
		selectedCourse = (Course) Session.getInstance().get("course");
		groupsView = new AdminGroupsView();
		groupsView.setVisible(true);
		initView();
		tableModel = (AdminGroupsSelectionTModel) groupsView.getTblGroups().getModel();
	}

	private void initView() {
		initListeners();
		initLists();
		populateTableOfGroups();
		languageTutors = getCourseLanguageTutors();
		courseStudents = getCourseStudents();
		groupsView.getLblCourseName().setText(selectedCourse.getName());
	}

	private void initListeners() {
		groupsView.getLblHome().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Session.getInstance().remove("course");
				new AdminCoursesController();
				groupsView.dispose();
			}
		});

		groupsView.getBtnAddGroup().addActionListener(e -> addEmptyGroup());
		groupsView.getBtnAddStudentToGroup().addActionListener(e -> addStudentInGroup());
		groupsView.getBtnRemoveStudentFromGroup().addActionListener(e -> removeStudentFromGroup());
		groupsView.getBtnAddTutorToGroup().addActionListener(e -> addTutorToGroup());
		groupsView.getBtnRemoveTutorFromGroup().addActionListener(e -> removeTutorFromGroup());
		groupsView.getBtnUpdateGroupInfo().addActionListener(e -> saveOrUpdateGroup());

		groupsView.getTblGroups().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				groupSelection();
			}
		});
	}

	private void addEmptyGroup() {
		CourseGroup temp = makeDummyCourseGroup();
		courseGroups.add(temp);
		tableModel.fireTableDataChanged();
	}

	private void addStudentInGroup() {
		int groupRow = groupsView.getTblGroups().getSelectedRow();
		if (groupRow == -1) {
			return;
		}

		List<Student> selectedStudents = groupsView.getListAvailableStudents().getSelectedValuesList();
		if (selectedStudents.size() + selectedGroup.getNumOfStudents() > selectedCourse.getGroupCapacity()) {
			JOptionPane.showMessageDialog(groupsView,
					"Maximum number of students in group is " + selectedCourse.getGroupCapacity(), "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		selectedGroup.getStudents().addAll(selectedStudents);
		selectedGroup.setNumOfStudents(selectedGroup.getNumOfStudents() + selectedStudents.size());
		groupSelection();
		tableModel.fireTableDataChanged();
		groupsView.getTblGroups().setRowSelectionInterval(groupRow, groupRow);
	}

	private void removeStudentFromGroup() {
		int groupRow = groupsView.getTblGroups().getSelectedRow();
		if (groupRow == -1) {
			return;
		}

		List<Student> selectedStudents = groupsView.getListAttendingStudents().getSelectedValuesList();
		selectedGroup.getStudents().removeAll(selectedStudents);
		selectedGroup.setNumOfStudents(selectedGroup.getStudents().size());
		groupSelection();
		tableModel.fireTableDataChanged();
		groupsView.getTblGroups().setRowSelectionInterval(groupRow, groupRow);
	}

	private void removeTutorFromGroup() {
		int groupRow = groupsView.getTblGroups().getSelectedRow();
		if (groupRow == -1) {
			return;
		}

		List<Tutor> selectedTutors = groupsView.getListDelegatedTutors().getSelectedValuesList();
		selectedGroup.getTutors().removeAll(selectedTutors);
		groupSelection();
	}

	private void addTutorToGroup() {
		int groupRow = groupsView.getTblGroups().getSelectedRow();
		if (groupRow == -1) {
			return;
		}

		List<Tutor> selectedTutors = groupsView.getListAvailableTutors().getSelectedValuesList();
		selectedGroup.getTutors().addAll(selectedTutors);
		groupSelection();
	}

	private void saveOrUpdateGroup() {
		if (groupsView.getTblGroups().getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(groupsView, "Please select group you want to save/update", "Warning",
					JOptionPane.WARNING_MESSAGE);
			return;
		}

		if (JOptionPane.showConfirmDialog(groupsView, "Are you sure you want to update this group?", "Confirmation",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			CourseGroup temp = (CourseGroup) tableModel.getCourseGroup(groupsView.getTblGroups().getSelectedRow());
			if (temp.getName().equals("")) {
				JOptionPane.showMessageDialog(groupsView, "Please fill in the name of course group", "Warning",
						JOptionPane.WARNING_MESSAGE);
				return;
			}

			if (temp.getId() != null) {
				sendUpdateRequest(temp);
				JOptionPane.showMessageDialog(groupsView, "Group's data successfully updated", "Success",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				Long generatedId = sendSaveRequest(temp);
				temp.setId(generatedId);
				JOptionPane.showMessageDialog(groupsView, "Group's data successfully saved", "Success",
						JOptionPane.INFORMATION_MESSAGE);
			}

		}
	}

	private void populateTableOfGroups() {
		courseGroups = getGroupsOfCourse();
		groupsView.getTblGroups().setModel(new AdminGroupsSelectionTModel(courseGroups));
	}

	private List<CourseGroup> getGroupsOfCourse() {
		List<CourseGroup> temp = null;

		try {
			Communication.getInstance().send(new Request(Operation.GET_COURSE_GROUPS, selectedCourse));

			Response response = Communication.getInstance().receive();

			if (response.getResponseType() == ResponseType.FAILURE) {
				throw new IOException("Error getting groups' data");
			} else {
				temp = JsonSerializationUtils.convertValue(response.getObject(), new TypeReference<List<CourseGroup>>() {
				});
			}

		} catch (ClassNotFoundException | IOException ex) {
			JOptionPane.showMessageDialog(groupsView, "Error getting groups' data. Try again later!", "Error",
					JOptionPane.ERROR_MESSAGE);
			groupsView.dispose();
			System.exit(0);
		}

		return temp;
	}

	private List<Tutor> getCourseLanguageTutors() {
		List<Tutor> tempTutors = null;

		try {
			Communication.getInstance().send(new Request(Operation.GET_LANGUAGE_TUTORS, selectedCourse.getLanguage()));

			Response response = Communication.getInstance().receive();

			if (response.getResponseType() == ResponseType.FAILURE) {
				throw new IOException("Error getting languages' data");
			} else {
				tempTutors = JsonSerializationUtils.convertValue(response.getObject(), new TypeReference<List<Tutor>>() {
				});
			}

		} catch (ClassNotFoundException | IOException ex) {
			JOptionPane.showMessageDialog(groupsView, "Error getting language' data. Try again later!", "Error",
					JOptionPane.ERROR_MESSAGE);
			groupsView.dispose();
			System.exit(0);
		}

		return tempTutors;
	}

	private List<Student> getCourseStudents() {
		List<Student> tempStudents = null;

		try {
			Communication.getInstance().send(new Request(Operation.GET_COURSE_STUDENTS, selectedCourse));

			Response response = Communication.getInstance().receive();

			if (response.getResponseType() == ResponseType.FAILURE) {
				throw new IOException("Error getting students data");
			} else {
				tempStudents = JsonSerializationUtils.convertValue(response.getObject(), new TypeReference<List<Student>>() {
				});
			}

		} catch (ClassNotFoundException | IOException ex) {
			JOptionPane.showMessageDialog(groupsView, "Error getting students data. Try again later!", "Error",
					JOptionPane.ERROR_MESSAGE);
			groupsView.dispose();
			System.exit(0);
		}

		return tempStudents;
	}

	private void groupSelection() {
		int rowIndex = groupsView.getTblGroups().getSelectedRow();
		selectedGroup = tableModel.getCourseGroup(rowIndex);
		List<Tutor> availableTutors = languageTutors.stream().filter(lt -> !selectedGroup.getTutors().contains(lt))
				.collect(Collectors.toList());
		List<Student> availableStudents = getAvailableStudentsForCourseGroup();

		groupsView.getListAttendingStudents().setListData(selectedGroup.getStudents().toArray(new Student[0]));
		groupsView.getListDelegatedTutors().setListData(selectedGroup.getTutors().toArray(new Tutor[0]));
		groupsView.getListAvailableTutors().setListData(availableTutors.toArray(new Tutor[0]));
		groupsView.getListAvailableStudents().setListData(availableStudents.toArray(new Student[0]));

		groupsView.getListAvailableStudents().updateUI();
		groupsView.getListAvailableTutors().updateUI();
		groupsView.getListAttendingStudents().updateUI();
		groupsView.getListDelegatedTutors().updateUI();
	}

	private void initLists() {
		groupsView.getListAvailableStudents().setModel(new DefaultComboBoxModel<>());
		groupsView.getListAvailableTutors().setModel(new DefaultComboBoxModel<>());
		groupsView.getListAttendingStudents().setModel(new DefaultComboBoxModel<>());
		groupsView.getListDelegatedTutors().setModel(new DefaultComboBoxModel<>());
	}

	private List<Student> getAvailableStudentsForCourseGroup() {
		List<Student> students = new ArrayList<>();
		for (Student student : courseStudents) {
			boolean status = true;
			for (CourseGroup courseGroup : courseGroups) {
				if (courseGroup.getStudents().contains(student)) {
					status = false;
					break;
				}
			}
			if (status == true) {
				students.add(student);
			}
		}
		return students;
	}

	private CourseGroup makeDummyCourseGroup() {
		CourseGroup temp = new CourseGroup();
		temp.setId(null);
		temp.setCourse(selectedCourse);
		temp.setName("");
		temp.setNumOfStudents(0);
		temp.setStudents(new ArrayList<>());
		temp.setTutors(new ArrayList<>());
		return temp;
	}

	private Long sendSaveRequest(CourseGroup temp) {
		try {
			Communication.getInstance().send(new Request(Operation.ADD_COURSE_GROUP, temp));

			Response response = Communication.getInstance().receive();

			if (response.getResponseType() == ResponseType.FAILURE) {
				throw new IOException("Course group couldn't be saved");
			}

			return JsonSerializationUtils.convertValue(response.getObject(), new TypeReference<Long>() {
			});
		} catch (ClassNotFoundException | IOException ex) {
			JOptionPane.showMessageDialog(groupsView, "Error adding group's data. Try again later!", "Error",
					JOptionPane.ERROR_MESSAGE);
			groupsView.dispose();
			System.exit(0);
			return null;
		}
	}

	private void sendUpdateRequest(CourseGroup temp) {
		try {
			Communication.getInstance().send(new Request(Operation.UPDATE_COURSE_GROUP, temp));

			Response response = Communication.getInstance().receive();

			if (response.getResponseType() == ResponseType.FAILURE) {
				throw new IOException("Group update failed");
			}

		} catch (ClassNotFoundException | IOException ex) {
			JOptionPane.showMessageDialog(groupsView, "Error updating course's data. Try again later!", "Error",
					JOptionPane.ERROR_MESSAGE);
			groupsView.dispose();
			System.exit(0);
		}
	}

}
