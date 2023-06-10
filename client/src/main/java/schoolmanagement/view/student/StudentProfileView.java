package schoolmanagement.view.student;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class StudentProfileView extends javax.swing.JFrame {

	public StudentProfileView() {
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
		jTabbedPane1 = new javax.swing.JTabbedPane();
		panelData = new javax.swing.JPanel();
		lblUsername = new javax.swing.JLabel();
		lblCreationDate = new javax.swing.JLabel();
		lblPassword = new javax.swing.JLabel();
		lblFirstname = new javax.swing.JLabel();
		lblLastname = new javax.swing.JLabel();
		lblBirthdate = new javax.swing.JLabel();
		txtLastname = new javax.swing.JTextField();
		txtFirstname = new javax.swing.JTextField();
		txtBirthDate = new javax.swing.JFormattedTextField();
		txtCreationDate = new javax.swing.JFormattedTextField();
		txtPassword = new javax.swing.JTextField();
		txtUsername = new javax.swing.JTextField();
		panelCourses = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		tblCourses = new javax.swing.JTable();
		panelGroup = new javax.swing.JPanel();
		lblNumOfStudents = new javax.swing.JLabel();
		txtNumOfStudents = new javax.swing.JTextField();
		lblName = new javax.swing.JLabel();
		txtName = new javax.swing.JTextField();
		lblMessage = new javax.swing.JLabel();
		jScrollPane2 = new javax.swing.JScrollPane();
		txtTutors = new javax.swing.JTextArea();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setMaximumSize(new java.awt.Dimension(900, 640));
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
		lblUserText3.setText("MY PROFILE");

		jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/schoolmanagement/images/profile.png"))); // NOI18N

		lblHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/schoolmanagement/images/home.png"))); // NOI18N

		javax.swing.GroupLayout panelHeaderLayout = new javax.swing.GroupLayout(panelHeader);
		panelHeader.setLayout(panelHeaderLayout);
		panelHeaderLayout
				.setHorizontalGroup(panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(panelHeaderLayout.createSequentialGroup().addGap(60, 60, 60).addComponent(jLabel1)
								.addGap(18, 18, 18)
								.addComponent(lblUserText3, javax.swing.GroupLayout.PREFERRED_SIZE, 250,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblHome).addGap(21, 21, 21)));
		panelHeaderLayout.setVerticalGroup(panelHeaderLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelHeaderLayout.createSequentialGroup()
						.addGroup(panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(javax.swing.GroupLayout.Alignment.LEADING,
										panelHeaderLayout.createSequentialGroup().addGap(29, 29, 29)
												.addGroup(panelHeaderLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(lblUserText3).addComponent(lblHome))))
						.addContainerGap(86, Short.MAX_VALUE)));

		jTabbedPane1.setToolTipText("");

		lblUsername.setBackground(new java.awt.Color(45, 118, 232));
		lblUsername.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		lblUsername.setForeground(new java.awt.Color(45, 118, 232));
		lblUsername.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblUsername.setText("Username:");

		lblCreationDate.setBackground(new java.awt.Color(45, 118, 232));
		lblCreationDate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		lblCreationDate.setForeground(new java.awt.Color(45, 118, 232));
		lblCreationDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblCreationDate.setText("Creation date:");

		lblPassword.setBackground(new java.awt.Color(45, 118, 232));
		lblPassword.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		lblPassword.setForeground(new java.awt.Color(45, 118, 232));
		lblPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblPassword.setText("Password:");

		lblFirstname.setBackground(new java.awt.Color(45, 118, 232));
		lblFirstname.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		lblFirstname.setForeground(new java.awt.Color(45, 118, 232));
		lblFirstname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblFirstname.setText("First name:");

		lblLastname.setBackground(new java.awt.Color(45, 118, 232));
		lblLastname.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		lblLastname.setForeground(new java.awt.Color(45, 118, 232));
		lblLastname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblLastname.setText("Last name:");

		lblBirthdate.setBackground(new java.awt.Color(45, 118, 232));
		lblBirthdate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		lblBirthdate.setForeground(new java.awt.Color(45, 118, 232));
		lblBirthdate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblBirthdate.setText("Birthdate:");

		txtLastname.setEditable(false);
		txtLastname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		txtLastname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		txtLastname.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null,
				new java.awt.Color(45, 118, 232), null, new java.awt.Color(45, 118, 232)));

		txtFirstname.setEditable(false);
		txtFirstname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		txtFirstname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		txtFirstname.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null,
				new java.awt.Color(45, 118, 232), null, new java.awt.Color(45, 118, 232)));

		txtBirthDate.setEditable(false);
		txtBirthDate.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null,
				new java.awt.Color(45, 118, 232), null, new java.awt.Color(45, 118, 232)));
		txtBirthDate.setFormatterFactory(
				new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
		txtBirthDate.setHorizontalAlignment(javax.swing.JTextField.CENTER);

		txtCreationDate.setEditable(false);
		txtCreationDate.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED,
				null, new java.awt.Color(45, 118, 232), null, new java.awt.Color(45, 118, 232)));
		txtCreationDate.setFormatterFactory(
				new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
		txtCreationDate.setHorizontalAlignment(javax.swing.JTextField.CENTER);

		txtPassword.setEditable(false);
		txtPassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		txtPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		txtPassword.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null,
				new java.awt.Color(45, 118, 232), null, new java.awt.Color(45, 118, 232)));

		txtUsername.setEditable(false);
		txtUsername.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		txtUsername.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		txtUsername.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null,
				new java.awt.Color(45, 118, 232), null, new java.awt.Color(45, 118, 232)));

		javax.swing.GroupLayout panelDataLayout = new javax.swing.GroupLayout(panelData);
		panelData.setLayout(panelDataLayout);
		panelDataLayout.setHorizontalGroup(panelDataLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelDataLayout.createSequentialGroup().addGap(91, 91, 91)
						.addGroup(panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
								.addComponent(lblCreationDate, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txtCreationDate)
								.addComponent(txtBirthDate, javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lblBirthdate, javax.swing.GroupLayout.Alignment.LEADING,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(txtLastname, javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lblLastname, javax.swing.GroupLayout.Alignment.LEADING,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(txtFirstname, javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lblFirstname, javax.swing.GroupLayout.Alignment.LEADING,
										javax.swing.GroupLayout.PREFERRED_SIZE, 159,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 329, Short.MAX_VALUE)
						.addGroup(panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(lblUsername, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txtPassword).addComponent(txtUsername).addComponent(lblPassword,
										javax.swing.GroupLayout.PREFERRED_SIZE, 159,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(106, 106, 106)));
		panelDataLayout.setVerticalGroup(panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelDataLayout.createSequentialGroup().addGap(21, 21, 21)
						.addGroup(panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(panelDataLayout.createSequentialGroup().addComponent(lblFirstname)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(txtFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, 39,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(lblLastname)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(txtLastname, javax.swing.GroupLayout.PREFERRED_SIZE, 39,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(panelDataLayout.createSequentialGroup().addComponent(lblUsername)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 39,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(lblPassword)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 39,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGap(18, 18, 18).addComponent(lblBirthdate)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(txtBirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, 37,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18).addComponent(lblCreationDate)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(txtCreationDate, javax.swing.GroupLayout.PREFERRED_SIZE, 37,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(93, Short.MAX_VALUE)));

		jTabbedPane1.addTab("Personal data", panelData);

		tblCourses.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null } },
				new String[] { "Name", "Begin date", "End date", "Capacity", "Language", "Level" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		tblCourses.setFocusable(false);
		tblCourses.setRowHeight(25);
		tblCourses.setSelectionBackground(new java.awt.Color(255, 255, 255));
		tblCourses.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		tblCourses.setShowHorizontalLines(true);
		jScrollPane1.setViewportView(tblCourses);

		panelGroup.setBackground(new java.awt.Color(255, 255, 255));
		panelGroup.setBorder(javax.swing.BorderFactory.createTitledBorder("Course group"));

		lblNumOfStudents.setBackground(new java.awt.Color(45, 118, 232));
		lblNumOfStudents.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		lblNumOfStudents.setForeground(new java.awt.Color(45, 118, 232));
		lblNumOfStudents.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		lblNumOfStudents.setText("Number of students:");

		txtNumOfStudents.setEditable(false);
		txtNumOfStudents.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		txtNumOfStudents.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		txtNumOfStudents.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED,
				null, new java.awt.Color(45, 118, 232), null, new java.awt.Color(45, 118, 232)));

		lblName.setBackground(new java.awt.Color(45, 118, 232));
		lblName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		lblName.setForeground(new java.awt.Color(45, 118, 232));
		lblName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		lblName.setText("Name:");

		txtName.setEditable(false);
		txtName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		txtName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		txtName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null,
				new java.awt.Color(45, 118, 232), null, new java.awt.Color(45, 118, 232)));

		lblMessage.setBackground(new java.awt.Color(45, 118, 232));
		lblMessage.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		lblMessage.setForeground(new java.awt.Color(232, 57, 99));
		lblMessage.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		lblMessage.setText("You are not added to any group for this course");

		jScrollPane2.setBorder(null);

		txtTutors.setEditable(false);
		txtTutors.setColumns(20);
		txtTutors.setRows(5);
		txtTutors.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createTitledBorder(null, "",
						javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
						javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12),
						new java.awt.Color(255, 255, 255)),
				"Tutors", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14),
				new java.awt.Color(45, 118, 232))); // NOI18N
		txtTutors.setMaximumSize(new java.awt.Dimension(2147483647, 100));
		jScrollPane2.setViewportView(txtTutors);

		javax.swing.GroupLayout panelGroupLayout = new javax.swing.GroupLayout(panelGroup);
		panelGroup.setLayout(panelGroupLayout);
		panelGroupLayout.setHorizontalGroup(panelGroupLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelGroupLayout.createSequentialGroup().addContainerGap().addGroup(panelGroupLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(panelGroupLayout.createSequentialGroup()
								.addGroup(panelGroupLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addComponent(lblNumOfStudents).addComponent(lblName,
												javax.swing.GroupLayout.PREFERRED_SIZE, 102,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addGroup(panelGroupLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(txtNumOfStudents, javax.swing.GroupLayout.DEFAULT_SIZE, 130,
												Short.MAX_VALUE)
										.addComponent(txtName)))
						.addComponent(lblMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 356,
								javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 244,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(29, 29, 29)));
		panelGroupLayout.setVerticalGroup(panelGroupLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGroupLayout.createSequentialGroup()
						.addGap(8, 8, 8)
						.addGroup(panelGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 24,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(panelGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lblNumOfStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 24,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(txtNumOfStudents, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
						.addComponent(lblMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 20,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(32, 32, 32))
				.addGroup(panelGroupLayout.createSequentialGroup().addComponent(jScrollPane2,
						javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE)));

		javax.swing.GroupLayout panelCoursesLayout = new javax.swing.GroupLayout(panelCourses);
		panelCourses.setLayout(panelCoursesLayout);
		panelCoursesLayout.setHorizontalGroup(panelCoursesLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelCoursesLayout.createSequentialGroup().addContainerGap()
						.addGroup(panelCoursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 832, Short.MAX_VALUE)
								.addComponent(panelGroup, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap()));
		panelCoursesLayout
				.setVerticalGroup(panelCoursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(panelCoursesLayout.createSequentialGroup().addContainerGap()
								.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(panelGroup, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		jTabbedPane1.addTab("My courses", panelCourses);

		javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
		panelMain.setLayout(panelMainLayout);
		panelMainLayout.setHorizontalGroup(panelMainLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(panelHeader, javax.swing.GroupLayout.Alignment.TRAILING,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(panelMainLayout
						.createSequentialGroup().addGap(37, 37, 37).addComponent(jTabbedPane1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 844, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(19, Short.MAX_VALUE)));
		panelMainLayout.setVerticalGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelMainLayout.createSequentialGroup()
						.addComponent(panelHeader, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jTabbedPane1)
						.addContainerGap()));

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
	private javax.swing.JLabel jLabel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTabbedPane jTabbedPane1;
	private javax.swing.JLabel lblBirthdate;
	private javax.swing.JLabel lblCreationDate;
	private javax.swing.JLabel lblFirstname;
	private javax.swing.JLabel lblHome;
	private javax.swing.JLabel lblLastname;
	private javax.swing.JLabel lblMessage;
	private javax.swing.JLabel lblName;
	private javax.swing.JLabel lblNumOfStudents;
	private javax.swing.JLabel lblPassword;
	private javax.swing.JLabel lblUserText3;
	private javax.swing.JLabel lblUsername;
	private javax.swing.JPanel panelCourses;
	private javax.swing.JPanel panelData;
	private javax.swing.JPanel panelGroup;
	private javax.swing.JPanel panelHeader;
	private javax.swing.JPanel panelMain;
	private javax.swing.JTable tblCourses;
	private javax.swing.JFormattedTextField txtBirthDate;
	private javax.swing.JFormattedTextField txtCreationDate;
	private javax.swing.JTextField txtFirstname;
	private javax.swing.JTextField txtLastname;
	private javax.swing.JTextField txtName;
	private javax.swing.JTextField txtNumOfStudents;
	private javax.swing.JTextField txtPassword;
	private javax.swing.JTextArea txtTutors;
	private javax.swing.JTextField txtUsername;
	// End of variables declaration//GEN-END:variables

	private void designTable() {
		tblCourses.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 15));
		tblCourses.getTableHeader().setOpaque(false);
		tblCourses.getTableHeader().setBackground(new Color(32, 136, 203));
		tblCourses.getTableHeader().setForeground(new Color(255, 255, 255));
		tblCourses.setRowHeight(25);
	}

	public void setRowGreen() {
		tblCourses.setSelectionBackground(new Color(0, 250, 154));
	}

	public void setRowRed() {
		tblCourses.setSelectionBackground(new Color(232, 57, 99));
	}

	public JFormattedTextField getTxtBirthDate() {
		return txtBirthDate;
	}

	public JFormattedTextField getTxtCreationDate() {
		return txtCreationDate;
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

	public JLabel getLblHome() {
		return lblHome;
	}

	public JTable getTblCourses() {
		return tblCourses;
	}

	public JTextArea getTxtTutors() {
		return txtTutors;
	}

	public JTextField getTxtNumOfStudents() {
		return txtNumOfStudents;
	}

	public JTextField getTxtName() {
		return txtName;
	}

	public JLabel getLblMessage() {
		return lblMessage;
	}

	public JLabel getLblName() {
		return lblName;
	}

	public JLabel getLblNumOfStudents() {
		return lblNumOfStudents;
	}

}
