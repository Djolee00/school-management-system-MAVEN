package schoolmanagement.view.component.table.tmodel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import schoolmanagement.commonlib.model.CourseGroup;

public class AdminGroupsSelectionTModel extends AbstractTableModel {

	private final List<CourseGroup> groups;
	private final String[] header = { "Name", "Number of students" };

	public AdminGroupsSelectionTModel(List<CourseGroup> groups) {
		this.groups = groups;
	}

	@Override
	public int getRowCount() {
		return groups.size();
	}

	@Override
	public int getColumnCount() {
		return header.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		CourseGroup temp = groups.get(rowIndex);
		return switch (columnIndex) {
		case 0 -> temp.getName();
		case 1 -> temp.getNumOfStudents();
		default -> "N/A";
		};
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex != 1;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		CourseGroup temp = groups.get(rowIndex);
		switch (columnIndex) {
		case 0 -> temp.setName((String) aValue);
		}
	}

	@Override
	public String getColumnName(int column) {
		return header[column];
	}

	public CourseGroup getCourseGroup(int index) {
		return groups.get(index);
	}

}
