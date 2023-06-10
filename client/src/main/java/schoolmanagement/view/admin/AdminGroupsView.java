package schoolmanagement.view.admin;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;
import schoolmanagement.commonlib.model.Student;
import schoolmanagement.commonlib.model.Tutor;

public class AdminGroupsView extends javax.swing.JFrame {

	public AdminGroupsView() {

		initComponents();
		setLocationRelativeTo(null);
		designTable();
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		panelMain = new javax.swing.JPanel();
		panelHeader = new javax.swing.JPanel();
		lblUserText3 = new javax.swing.JLabel();
		jLabel1 = new javax.swing.JLabel();
		lblHome = new javax.swing.JLabel();
		lblCourseName = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		tblGroups = new javax.swing.JTable();
		panelSearch1 = new javax.swing.JPanel();
		jSeparator3 = new javax.swing.JSeparator();
		jScrollPane2 = new javax.swing.JScrollPane();
		listAvailableStudents = new javax.swing.JList<>();
		btnAddStudentToGroup = new javax.swing.JButton();
		btnRemoveStudentFromGroup = new javax.swing.JButton();
		jScrollPane3 = new javax.swing.JScrollPane();
		listAttendingStudents = new javax.swing.JList<>();
		btnUpdateGroupInfo = new javax.swing.JButton();
		btnAddGroup = new javax.swing.JButton();
		panelSearch2 = new javax.swing.JPanel();
		jSeparator4 = new javax.swing.JSeparator();
		jScrollPane4 = new javax.swing.JScrollPane();
		listAvailableTutors = new javax.swing.JList<>();
		btnAddTutorToGroup = new javax.swing.JButton();
		btnRemoveTutorFromGroup = new javax.swing.JButton();
		jScrollPane5 = new javax.swing.JScrollPane();
		listDeleagatedTutors = new javax.swing.JList<>();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setMinimumSize(new java.awt.Dimension(900, 640));
		setResizable(false);

		panelMain.setBackground(new java.awt.Color(255, 255, 255));
		panelMain.setMaximumSize(new java.awt.Dimension(900, 640));
		panelMain.setMinimumSize(new java.awt.Dimension(900, 640));
		panelMain.setPreferredSize(new java.awt.Dimension(900, 640));

		panelHeader.setBackground(new java.awt.Color(45, 118, 232));

		lblUserText3.setBackground(new java.awt.Color(45, 118, 232));
		lblUserText3.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 36)); // NOI18N
		lblUserText3.setForeground(new java.awt.Color(255, 255, 255));
		lblUserText3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		lblUserText3.setText("GROUPS");

		jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/schoolmanagement/images/groups.png"))); // NOI18N

		lblHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/schoolmanagement/images/home.png"))); // NOI18N

		lblCourseName.setBackground(new java.awt.Color(45, 118, 232));
		lblCourseName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		lblCourseName.setForeground(new java.awt.Color(255, 255, 255));
		lblCourseName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		lblCourseName.setText("Course name");

		javax.swing.GroupLayout panelHeaderLayout = new javax.swing.GroupLayout(panelHeader);
		panelHeader.setLayout(panelHeaderLayout);
		panelHeaderLayout.setHorizontalGroup(panelHeaderLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelHeaderLayout.createSequentialGroup().addGap(60, 60, 60).addComponent(jLabel1)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(panelHeaderLayout.createSequentialGroup().addComponent(lblCourseName)
										.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(panelHeaderLayout.createSequentialGroup()
										.addComponent(lblUserText3, javax.swing.GroupLayout.PREFERRED_SIZE, 286,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 425,
												Short.MAX_VALUE)
										.addComponent(lblHome).addGap(17, 17, 17)))));
		panelHeaderLayout.setVerticalGroup(panelHeaderLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelHeaderLayout.createSequentialGroup()
						.addGroup(panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(panelHeaderLayout.createSequentialGroup()
										.addGroup(panelHeaderLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(panelHeaderLayout.createSequentialGroup().addGap(21, 21, 21)
														.addComponent(lblUserText3))
												.addGroup(panelHeaderLayout.createSequentialGroup().addContainerGap()
														.addComponent(lblHome)))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(lblCourseName)))
						.addContainerGap(79, Short.MAX_VALUE)));

		tblGroups.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null }, { null, null }, { null, null }, { null, null } },
				new String[] { "Name", "Number of students" }));
		tblGroups.setFocusable(false);
		tblGroups.setRowHeight(25);
		tblGroups.setSelectionBackground(new java.awt.Color(232, 57, 99));
		tblGroups.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		tblGroups.setShowGrid(true);
		tblGroups.setShowVerticalLines(false);
		jScrollPane1.setViewportView(tblGroups);

		panelSearch1.setBorder(javax.swing.BorderFactory.createTitledBorder("Students"));

		listAvailableStudents.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Available",
				javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
		listAvailableStudents.setFocusable(false);
		jScrollPane2.setViewportView(listAvailableStudents);

		btnAddStudentToGroup
				.setIcon(new javax.swing.ImageIcon(getClass().getResource("/schoolmanagement/images/rightArrow.png"))); // NOI18N

		btnRemoveStudentFromGroup
				.setIcon(new javax.swing.ImageIcon(getClass().getResource("/schoolmanagement/images/leftArrow.png"))); // NOI18N

		listAttendingStudents.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Attending",
				javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
		listAttendingStudents.setFocusable(false);
		jScrollPane3.setViewportView(listAttendingStudents);

		javax.swing.GroupLayout panelSearch1Layout = new javax.swing.GroupLayout(panelSearch1);
		panelSearch1.setLayout(panelSearch1Layout);
		panelSearch1Layout.setHorizontalGroup(panelSearch1Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelSearch1Layout.createSequentialGroup().addGap(23, 23, 23).addGroup(panelSearch1Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								panelSearch1Layout.createSequentialGroup().addComponent(jSeparator3).addGap(55, 55, 55))
						.addGroup(panelSearch1Layout.createSequentialGroup()
								.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 136,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(36, 36, 36)
								.addGroup(panelSearch1Layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(btnAddStudentToGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 61,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(btnRemoveStudentFromGroup, javax.swing.GroupLayout.PREFERRED_SIZE,
												61, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(39, 39, 39)
								.addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 151,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(74, Short.MAX_VALUE)))));
		panelSearch1Layout.setVerticalGroup(panelSearch1Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelSearch1Layout.createSequentialGroup().addGroup(panelSearch1Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								panelSearch1Layout.createSequentialGroup()
										.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(panelSearch1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGroup(panelSearch1Layout.createSequentialGroup().addGap(19, 19, 19)
								.addComponent(btnAddStudentToGroup)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnRemoveStudentFromGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(8, 8, 8)))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jSeparator3,
								javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(35, 35, 35)));

		btnUpdateGroupInfo.setText("Save/Update group");

		btnAddGroup.setText("Add group");

		panelSearch2.setBorder(javax.swing.BorderFactory.createTitledBorder("Tutors"));

		listAvailableTutors.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Available",
				javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
		listAvailableTutors.setFocusable(false);
		jScrollPane4.setViewportView(listAvailableTutors);

		btnAddTutorToGroup
				.setIcon(new javax.swing.ImageIcon(getClass().getResource("/schoolmanagement/images/rightArrow.png"))); // NOI18N

		btnRemoveTutorFromGroup
				.setIcon(new javax.swing.ImageIcon(getClass().getResource("/schoolmanagement/images/leftArrow.png"))); // NOI18N

		listDeleagatedTutors.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Delegated",
				javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
		listDeleagatedTutors.setFocusable(false);
		jScrollPane5.setViewportView(listDeleagatedTutors);

		javax.swing.GroupLayout panelSearch2Layout = new javax.swing.GroupLayout(panelSearch2);
		panelSearch2.setLayout(panelSearch2Layout);
		panelSearch2Layout.setHorizontalGroup(panelSearch2Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelSearch2Layout.createSequentialGroup().addGap(23, 23, 23).addGroup(panelSearch2Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								panelSearch2Layout.createSequentialGroup().addComponent(jSeparator4).addGap(55, 55, 55))
						.addGroup(panelSearch2Layout.createSequentialGroup()
								.addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 138,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(33, 33, 33)
								.addGroup(panelSearch2Layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addComponent(btnAddTutorToGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 60,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(btnRemoveTutorFromGroup, javax.swing.GroupLayout.PREFERRED_SIZE,
												60, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(41, 41, 41)
								.addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 146,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(79, Short.MAX_VALUE)))));
		panelSearch2Layout.setVerticalGroup(panelSearch2Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelSearch2Layout.createSequentialGroup()
						.addGroup(panelSearch2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(panelSearch2Layout.createSequentialGroup()
										.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(panelSearch2Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGroup(panelSearch2Layout.createSequentialGroup().addGap(19, 19, 19)
										.addComponent(btnAddTutorToGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnRemoveTutorFromGroup, javax.swing.GroupLayout.PREFERRED_SIZE,
												35, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(8, 8, 8)))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jSeparator4,
								javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(35, 35, 35)));

		javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
		panelMain.setLayout(panelMainLayout);
		panelMainLayout.setHorizontalGroup(panelMainLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(panelHeader, javax.swing.GroupLayout.Alignment.TRAILING,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(panelMainLayout.createSequentialGroup().addContainerGap()
						.addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(panelMainLayout.createSequentialGroup()
										.addComponent(btnAddGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 97,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnUpdateGroupInfo))
								.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(panelSearch1, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panelSearch2, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(36, 36, 36)));
		panelMainLayout.setVerticalGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelMainLayout.createSequentialGroup()
						.addComponent(panelHeader, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(12, 12, 12)
						.addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addGroup(panelMainLayout.createSequentialGroup()
										.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 378,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(26, 26, 26)
										.addGroup(panelMainLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(btnUpdateGroupInfo,
														javax.swing.GroupLayout.PREFERRED_SIZE, 33,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(btnAddGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGroup(panelMainLayout.createSequentialGroup()
										.addComponent(panelSearch1, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(panelSearch2, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addContainerGap(26, Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				panelMain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.PREFERRED_SIZE));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void setColor(JPanel panel) {
		panel.setBackground(new Color(197, 197, 197));
	}

	private void resetColor(JPanel panel) {
		panel.setBackground(new Color(240, 240, 240));
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnAddGroup;
	private javax.swing.JButton btnAddStudentToGroup;
	private javax.swing.JButton btnAddTutorToGroup;
	private javax.swing.JButton btnRemoveStudentFromGroup;
	private javax.swing.JButton btnRemoveTutorFromGroup;
	private javax.swing.JButton btnUpdateGroupInfo;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JScrollPane jScrollPane4;
	private javax.swing.JScrollPane jScrollPane5;
	private javax.swing.JSeparator jSeparator3;
	private javax.swing.JSeparator jSeparator4;
	private javax.swing.JLabel lblCourseName;
	private javax.swing.JLabel lblHome;
	private javax.swing.JLabel lblUserText3;
	private javax.swing.JList<Student> listAttendingStudents;
	private javax.swing.JList<Student> listAvailableStudents;
	private javax.swing.JList<Tutor> listAvailableTutors;
	private javax.swing.JList<Tutor> listDeleagatedTutors;
	private javax.swing.JPanel panelHeader;
	private javax.swing.JPanel panelMain;
	private javax.swing.JPanel panelSearch1;
	private javax.swing.JPanel panelSearch2;
	private javax.swing.JTable tblGroups;
	// End of variables declaration//GEN-END:variables

	private void designTable() {
		tblGroups.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 15));
		tblGroups.getTableHeader().setOpaque(false);
		tblGroups.getTableHeader().setBackground(new Color(32, 136, 203));
		tblGroups.getTableHeader().setForeground(new Color(255, 255, 255));
		tblGroups.setRowHeight(25);
	}

	public JTable getTblGroups() {
		return tblGroups;
	}

	public JButton getBtnUpdateGroupInfo() {
		return btnUpdateGroupInfo;
	}

	public JButton getBtnAddGroup() {
		return btnAddGroup;
	}

	public JButton getBtnAddStudentToGroup() {
		return btnAddStudentToGroup;
	}

	public JButton getBtnRemoveStudentFromGroup() {
		return btnRemoveStudentFromGroup;
	}

	public JButton getBtnAddTutorToGroup() {
		return btnAddTutorToGroup;
	}

	public JButton getBtnRemoveTutorFromGroup() {
		return btnRemoveTutorFromGroup;
	}

	public JLabel getLblHome() {
		return lblHome;
	}

	public JList<Student> getListAttendingStudents() {
		return listAttendingStudents;
	}

	public JList<Tutor> getListDelegatedTutors() {
		return listDeleagatedTutors;
	}

	public JList<Student> getListAvailableStudents() {
		return listAvailableStudents;
	}

	public JList<Tutor> getListAvailableTutors() {
		return listAvailableTutors;
	}

	public JLabel getLblCourseName() {
		return lblCourseName;
	}

}
