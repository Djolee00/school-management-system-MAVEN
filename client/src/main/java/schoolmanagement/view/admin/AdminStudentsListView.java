package schoolmanagement.view.admin;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class AdminStudentsListView extends javax.swing.JFrame {

	public AdminStudentsListView() {
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
		jScrollPane1 = new javax.swing.JScrollPane();
		tblStudents = new javax.swing.JTable();
		panelSearch = new javax.swing.JPanel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		birthdateFrom = new com.toedter.calendar.JDateChooser();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		birthdateTo = new com.toedter.calendar.JDateChooser();
		btnSearch = new javax.swing.JButton();
		jSeparator2 = new javax.swing.JSeparator();
		jLabel7 = new javax.swing.JLabel();
		jcbCourses = new javax.swing.JComboBox<>();
		jLabel8 = new javax.swing.JLabel();
		jcbLanguages = new javax.swing.JComboBox<>();
		txtLastnameSearch = new javax.swing.JTextField();
		txtFirstnameSearch = new javax.swing.JTextField();
		btnReset = new javax.swing.JButton();
		panelSearch1 = new javax.swing.JPanel();
		jLabel9 = new javax.swing.JLabel();
		jLabel10 = new javax.swing.JLabel();
		birthDate = new com.toedter.calendar.JDateChooser();
		jLabel11 = new javax.swing.JLabel();
		btnUpdate = new javax.swing.JButton();
		jSeparator3 = new javax.swing.JSeparator();
		txtLastname = new javax.swing.JTextField();
		txtFirstname = new javax.swing.JTextField();
		jLabel15 = new javax.swing.JLabel();
		creationDate = new com.toedter.calendar.JDateChooser();
		jLabel12 = new javax.swing.JLabel();
		txtUsername = new javax.swing.JTextField();
		jLabel13 = new javax.swing.JLabel();
		txtPassword = new javax.swing.JPasswordField();
		btnAddEmptyStudent = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setMinimumSize(new java.awt.Dimension(900, 640));
		setResizable(false);

		panelMain.setBackground(new java.awt.Color(255, 255, 255));
		panelMain.setMaximumSize(new java.awt.Dimension(900, 660));
		panelMain.setMinimumSize(new java.awt.Dimension(900, 660));
		panelMain.setPreferredSize(new java.awt.Dimension(900, 660));

		panelHeader.setBackground(new java.awt.Color(45, 118, 232));

		lblUserText3.setBackground(new java.awt.Color(45, 118, 232));
		lblUserText3.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 36)); // NOI18N
		lblUserText3.setForeground(new java.awt.Color(255, 255, 255));
		lblUserText3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		lblUserText3.setText("STUDENTS");

		jLabel1.setIcon(
				new javax.swing.ImageIcon(getClass().getResource("/schoolmanagement/images/studentsWhite.png"))); // NOI18N

		lblHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/schoolmanagement/images/home.png"))); // NOI18N

		javax.swing.GroupLayout panelHeaderLayout = new javax.swing.GroupLayout(panelHeader);
		panelHeader.setLayout(panelHeaderLayout);
		panelHeaderLayout
				.setHorizontalGroup(panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(panelHeaderLayout.createSequentialGroup().addGap(60, 60, 60).addComponent(jLabel1)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(lblUserText3, javax.swing.GroupLayout.PREFERRED_SIZE, 286,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblHome).addGap(17, 17, 17)));
		panelHeaderLayout.setVerticalGroup(panelHeaderLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelHeaderLayout.createSequentialGroup().addGroup(panelHeaderLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(panelHeaderLayout.createSequentialGroup().addGap(21, 21, 21)
								.addGroup(panelHeaderLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(lblUserText3, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0,
												Short.MAX_VALUE)))
						.addGroup(panelHeaderLayout.createSequentialGroup().addContainerGap().addComponent(lblHome)))
						.addContainerGap(102, Short.MAX_VALUE)));

		tblStudents
				.setModel(
						new javax.swing.table.DefaultTableModel(
								new Object[][] { { null, null, null }, { null, null, null }, { null, null, null },
										{ null, null, null } },
								new String[] { "First name", "Last name", "Birthdate" }) {
							boolean[] canEdit = new boolean[] { false, false, false };

							public boolean isCellEditable(int rowIndex, int columnIndex) {
								return canEdit[columnIndex];
							}
						});
		tblStudents.setFocusable(false);
		tblStudents.setRowHeight(25);
		tblStudents.setSelectionBackground(new java.awt.Color(232, 57, 99));
		tblStudents.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tblStudents.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		tblStudents.setShowGrid(true);
		tblStudents.setShowVerticalLines(false);
		jScrollPane1.setViewportView(tblStudents);

		panelSearch.setBackground(new java.awt.Color(255, 255, 255));
		panelSearch.setBorder(javax.swing.BorderFactory.createTitledBorder("Search"));

		jLabel3.setText("First name:");

		jLabel4.setText("Last name:");

		jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabel5.setText("Birthdate from:");

		jLabel6.setText("Birthdate to:");

		btnSearch.setText("Search");

		jLabel7.setText("Course:");

		jcbCourses.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

		jLabel8.setText("Language:");

		jcbLanguages.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

		btnReset.setText("Reset");

		javax.swing.GroupLayout panelSearchLayout = new javax.swing.GroupLayout(panelSearch);
		panelSearch.setLayout(panelSearchLayout);
		panelSearchLayout.setHorizontalGroup(panelSearchLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelSearchLayout.createSequentialGroup().addGap(23, 23, 23).addGroup(panelSearchLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(panelSearchLayout.createSequentialGroup().addComponent(btnSearch)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnReset))
						.addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								panelSearchLayout.createSequentialGroup().addGroup(panelSearchLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(panelSearchLayout.createSequentialGroup().addGroup(panelSearchLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 63,
														javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGap(18, 18, 18)
												.addGroup(panelSearchLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(txtLastnameSearch,
																javax.swing.GroupLayout.DEFAULT_SIZE, 113,
																Short.MAX_VALUE)
														.addComponent(txtFirstnameSearch)))
										.addGroup(panelSearchLayout.createSequentialGroup()
												.addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 63,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(18, 18, 18).addComponent(jcbCourses,
														javax.swing.GroupLayout.PREFERRED_SIZE, 113,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(panelSearchLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGap(18, 18, 18)
										.addGroup(panelSearchLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(birthdateFrom, javax.swing.GroupLayout.DEFAULT_SIZE, 102,
														Short.MAX_VALUE)
												.addComponent(birthdateTo, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(jcbLanguages, 0, javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE))))
						.addGap(55, 55, 55)));
		panelSearchLayout.setVerticalGroup(panelSearchLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelSearchLayout.createSequentialGroup().addContainerGap().addGroup(panelSearchLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(birthdateFrom, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel5)
						.addGroup(panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel3).addComponent(txtFirstnameSearch,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(birthdateTo, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(panelSearchLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addGroup(panelSearchLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(txtLastnameSearch, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel6))
										.addComponent(jLabel4)))
						.addGap(23, 23, 23)
						.addGroup(panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel7)
								.addComponent(jcbCourses, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel8).addComponent(jcbLanguages,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
						.addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btnSearch).addComponent(btnReset))
						.addContainerGap()));

		panelSearch1.setBorder(javax.swing.BorderFactory.createTitledBorder("Student"));

		jLabel9.setText("First name:");

		jLabel10.setText("Last name:");

		jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		jLabel11.setText("Birthdate ");

		btnUpdate.setText("Update");

		jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabel15.setText("Creation date:");

		creationDate.setToolTipText("");
		creationDate.setEnabled(false);

		jLabel12.setText("Username:");

		txtUsername.setEditable(false);

		jLabel13.setText("Password:");

		javax.swing.GroupLayout panelSearch1Layout = new javax.swing.GroupLayout(panelSearch1);
		panelSearch1.setLayout(panelSearch1Layout);
		panelSearch1Layout.setHorizontalGroup(panelSearch1Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSearch1Layout.createSequentialGroup()
						.addGroup(panelSearch1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(panelSearch1Layout.createSequentialGroup().addGap(27, 27, 27)
										.addComponent(btnUpdate).addGap(0, 0, Short.MAX_VALUE))
								.addGroup(panelSearch1Layout.createSequentialGroup().addGap(23, 23, 23)
										.addGroup(panelSearch1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
												.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSearch1Layout
														.createSequentialGroup()
														.addGroup(panelSearch1Layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																.addGroup(panelSearch1Layout.createSequentialGroup()
																		.addGroup(panelSearch1Layout
																				.createParallelGroup(
																						javax.swing.GroupLayout.Alignment.LEADING,
																						false)
																				.addComponent(jLabel10,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)
																				.addComponent(jLabel9,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						63,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addGap(18, 18, 18)
																		.addGroup(panelSearch1Layout
																				.createParallelGroup(
																						javax.swing.GroupLayout.Alignment.LEADING,
																						false)
																				.addComponent(txtLastname,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						113, Short.MAX_VALUE)
																				.addComponent(txtFirstname)))
																.addGroup(panelSearch1Layout.createSequentialGroup()
																		.addComponent(jLabel12,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				63,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(18, 18, 18).addComponent(txtUsername,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				113,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32,
																Short.MAX_VALUE)
														.addGroup(panelSearch1Layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING,
																		false)
																.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
																		panelSearch1Layout.createSequentialGroup()
																				.addComponent(jLabel11,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						66,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addPreferredGap(
																						javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)
																				.addComponent(birthDate,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						102,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
																		panelSearch1Layout.createSequentialGroup()
																				.addGroup(panelSearch1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								panelSearch1Layout
																										.createSequentialGroup()
																										.addComponent(
																												jLabel15)
																										.addGap(18, 18,
																												18))
																						.addGroup(panelSearch1Layout
																								.createSequentialGroup()
																								.addComponent(jLabel13,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										63,
																										javax.swing.GroupLayout.PREFERRED_SIZE)
																								.addGap(29, 29, 29)))
																				.addGroup(panelSearch1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING,
																								false)
																						.addComponent(creationDate,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								102, Short.MAX_VALUE)
																						.addComponent(
																								txtPassword))))))))
						.addGap(55, 55, 55)));
		panelSearch1Layout.setVerticalGroup(panelSearch1Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelSearch1Layout.createSequentialGroup().addContainerGap().addGroup(panelSearch1Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(birthDate, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGroup(panelSearch1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel9)
								.addComponent(txtFirstname, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel11)))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(panelSearch1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(panelSearch1Layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addComponent(txtLastname, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel10))
								.addComponent(creationDate, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel15))
						.addGap(18, 18, 18)
						.addGroup(panelSearch1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(panelSearch1Layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel13).addComponent(txtPassword,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(panelSearch1Layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel12).addComponent(txtUsername,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
						.addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(btnUpdate)
						.addContainerGap()));

		btnAddEmptyStudent.setText("Add student");

		javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
		panelMain.setLayout(panelMainLayout);
		panelMainLayout.setHorizontalGroup(panelMainLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(panelHeader, javax.swing.GroupLayout.Alignment.TRAILING,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMainLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btnAddEmptyStudent))
						.addGap(18, 18, 18)
						.addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(panelSearch1, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panelSearch, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(36, 36, 36)));
		panelMainLayout.setVerticalGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelMainLayout.createSequentialGroup()
						.addComponent(panelHeader, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(panelMainLayout.createSequentialGroup()
										.addComponent(panelSearch1, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(15, 15, 15).addComponent(panelSearch,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(panelMainLayout.createSequentialGroup()
										.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 406,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18).addComponent(btnAddEmptyStudent)))
						.addContainerGap(28, Short.MAX_VALUE)));

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
	private com.toedter.calendar.JDateChooser birthDate;
	private com.toedter.calendar.JDateChooser birthdateFrom;
	private com.toedter.calendar.JDateChooser birthdateTo;
	private javax.swing.JButton btnAddEmptyStudent;
	private javax.swing.JButton btnReset;
	private javax.swing.JButton btnSearch;
	private javax.swing.JButton btnUpdate;
	private com.toedter.calendar.JDateChooser creationDate;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel15;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JSeparator jSeparator2;
	private javax.swing.JSeparator jSeparator3;
	private javax.swing.JComboBox<String> jcbCourses;
	private javax.swing.JComboBox<String> jcbLanguages;
	private javax.swing.JLabel lblHome;
	private javax.swing.JLabel lblUserText3;
	private javax.swing.JPanel panelHeader;
	private javax.swing.JPanel panelMain;
	private javax.swing.JPanel panelSearch;
	private javax.swing.JPanel panelSearch1;
	private javax.swing.JTable tblStudents;
	private javax.swing.JTextField txtFirstname;
	private javax.swing.JTextField txtFirstnameSearch;
	private javax.swing.JTextField txtLastname;
	private javax.swing.JTextField txtLastnameSearch;
	private javax.swing.JPasswordField txtPassword;
	private javax.swing.JTextField txtUsername;
	// End of variables declaration//GEN-END:variables

	private void designTable() {
		tblStudents.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 15));
		tblStudents.getTableHeader().setOpaque(false);
		tblStudents.getTableHeader().setBackground(new Color(32, 136, 203));
		tblStudents.getTableHeader().setForeground(new Color(255, 255, 255));
		tblStudents.setRowHeight(25);
	}

	public JLabel getLblHome() {
		return lblHome;
	}

	public JButton getBtnUpdate() {
		return btnUpdate;
	}

	public JButton getBtnSearch() {
		return btnSearch;
	}

	public JTable getTblStudents() {
		return tblStudents;
	}

	public JComboBox<String> getJcbCourses() {
		return jcbCourses;
	}

	public JComboBox<String> getJcbLanguages() {
		return jcbLanguages;
	}

	public JTextField getTxtFirstnameSearch() {
		return txtFirstnameSearch;
	}

	public JTextField getTxtLastnameSearch() {
		return txtLastnameSearch;
	}

	public JDateChooser getBirthdateFrom() {
		return birthdateFrom;
	}

	public JDateChooser getBirthdateTo() {
		return birthdateTo;
	}

	public JButton getBtnReset() {
		return btnReset;
	}

	public JTextField getTxtFirstname() {
		return txtFirstname;
	}

	public JTextField getTxtLastname() {
		return txtLastname;
	}

	public JTextField getTxtPassword() {
		return txtPassword;
	}

	public JTextField getTxtUsername() {
		return txtUsername;
	}

	public JDateChooser getBirthDate() {
		return birthDate;
	}

	public JDateChooser getCreationDate() {
		return creationDate;
	}

	public JButton getBtnAddEmptyStudent() {
		return btnAddEmptyStudent;
	}

}
