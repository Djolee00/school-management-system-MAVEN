package schoolmanagement.view.student;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import schoolmanagement.commonlib.model.Language;
import schoolmanagement.commonlib.model.enums.Level;

@SuppressWarnings("serial")
public class StudentCoursesView extends javax.swing.JFrame {

	public StudentCoursesView() {
		initComponents();
		setLocationRelativeTo(null);
		designTable();

	}

	private void initComponents() {

		buttonGroup1 = new javax.swing.ButtonGroup();
		panelMain = new javax.swing.JPanel();
		panelHeader = new javax.swing.JPanel();
		lblUserText3 = new javax.swing.JLabel();
		jLabel1 = new javax.swing.JLabel();
		lblHome = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		tblCourses = new javax.swing.JTable();
		panelSort = new javax.swing.JPanel();
		jSeparator1 = new javax.swing.JSeparator();
		btnSort = new javax.swing.JButton();
		jrbStartDate = new javax.swing.JRadioButton();
		jrbLanguage = new javax.swing.JRadioButton();
		jrbLevel = new javax.swing.JRadioButton();
		jrbEndDate = new javax.swing.JRadioButton();
		panelSearch = new javax.swing.JPanel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		dateBegin = new com.toedter.calendar.JDateChooser();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		dateEnd = new com.toedter.calendar.JDateChooser();
		btnSearch = new javax.swing.JButton();
		jSeparator2 = new javax.swing.JSeparator();
		jComboBoxLevel = new javax.swing.JComboBox<>();
		jComboBoxLanguage = new javax.swing.JComboBox<>();
		btnReset = new javax.swing.JButton();
		btnChoose = new javax.swing.JButton();

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
		lblUserText3.setText(" COURSES");

		jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/schoolmanagement/images/coursesList.png"))); // NOI18N

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

		tblCourses.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null } },
				new String[] { "Name", "Begin date ", "End date ", "Capacity", "Language", "Level" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		tblCourses.setFocusable(false);
		tblCourses.setRowHeight(25);
		tblCourses.setSelectionBackground(new java.awt.Color(232, 57, 99));
		tblCourses.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tblCourses.setShowGrid(true);
		tblCourses.setShowVerticalLines(false);
		jScrollPane1.setViewportView(tblCourses);

		panelSort.setBackground(new java.awt.Color(255, 255, 255));
		panelSort.setBorder(javax.swing.BorderFactory.createTitledBorder("Sort"));

		btnSort.setText("Sort");

		buttonGroup1.add(jrbStartDate);
		jrbStartDate.setText("Start date");

		buttonGroup1.add(jrbLanguage);
		jrbLanguage.setText("Language");

		buttonGroup1.add(jrbLevel);
		jrbLevel.setText("Level");

		buttonGroup1.add(jrbEndDate);
		jrbEndDate.setText("End date");

		javax.swing.GroupLayout panelSortLayout = new javax.swing.GroupLayout(panelSort);
		panelSort.setLayout(panelSortLayout);
		panelSortLayout.setHorizontalGroup(panelSortLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelSortLayout.createSequentialGroup().addContainerGap().addGroup(panelSortLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(btnSort)
						.addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 214,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGroup(panelSortLayout.createSequentialGroup()
								.addGroup(panelSortLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jrbLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 98,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jrbLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, 98,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(38, 38, 38)
								.addGroup(panelSortLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jrbEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 98,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jrbStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 98,
												javax.swing.GroupLayout.PREFERRED_SIZE))))
						.addContainerGap(145, Short.MAX_VALUE)));
		panelSortLayout.setVerticalGroup(panelSortLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelSortLayout.createSequentialGroup().addGap(12, 12, 12)
						.addGroup(panelSortLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jrbStartDate).addComponent(jrbLevel))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(panelSortLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jrbLanguage).addComponent(jrbEndDate))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(btnSort)
						.addContainerGap()));

		panelSearch.setBackground(new java.awt.Color(255, 255, 255));
		panelSearch.setBorder(javax.swing.BorderFactory.createTitledBorder("Search"));

		jLabel3.setText("Level:");

		jLabel4.setText("Language:");

		jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabel5.setText("Begin date:");

		jLabel6.setText(" End date:");

		btnSearch.setText("Filter");

		btnReset.setText("Reset");

		javax.swing.GroupLayout panelSearchLayout = new javax.swing.GroupLayout(panelSearch);
		panelSearch.setLayout(panelSearchLayout);
		panelSearchLayout.setHorizontalGroup(panelSearchLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelSearchLayout.createSequentialGroup().addContainerGap().addGroup(panelSearchLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(panelSearchLayout.createSequentialGroup().addComponent(btnSearch)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnReset))
						.addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								panelSearchLayout.createSequentialGroup().addGroup(panelSearchLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addGroup(panelSearchLayout.createSequentialGroup()
												.addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 63,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jComboBoxLanguage, javax.swing.GroupLayout.PREFERRED_SIZE,
														116, javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(panelSearchLayout.createSequentialGroup()
												.addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(35, 35, 35)
												.addComponent(jComboBoxLevel, javax.swing.GroupLayout.PREFERRED_SIZE,
														115, javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addGap(45, 45, 45)
										.addGroup(panelSearchLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 62,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31,
												Short.MAX_VALUE)
										.addGroup(panelSearchLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(dateBegin, javax.swing.GroupLayout.PREFERRED_SIZE, 102,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(dateEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 102,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(9, 9, 9)))
						.addGap(31, 31, 31)));
		panelSearchLayout.setVerticalGroup(panelSearchLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelSearchLayout.createSequentialGroup().addContainerGap().addGroup(panelSearchLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(dateBegin, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel5)
						.addGroup(panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel3).addComponent(jComboBoxLevel,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(dateEnd, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(panelSearchLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel4).addComponent(jLabel6).addComponent(jComboBoxLanguage,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
						.addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btnSearch).addComponent(btnReset))
						.addContainerGap()));

		btnChoose.setText("Choose courses");

		javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
		panelMain.setLayout(panelMainLayout);
		panelMainLayout.setHorizontalGroup(panelMainLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(panelHeader, javax.swing.GroupLayout.Alignment.TRAILING,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(panelMainLayout.createSequentialGroup().addContainerGap().addGroup(panelMainLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(panelMainLayout.createSequentialGroup()
								.addComponent(panelSort, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(panelSearch, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(panelMainLayout.createSequentialGroup()
								.addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 885,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(btnChoose, javax.swing.GroupLayout.PREFERRED_SIZE, 131,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(0, 3, Short.MAX_VALUE)))
						.addContainerGap()));
		panelMainLayout.setVerticalGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelMainLayout.createSequentialGroup()
						.addComponent(panelHeader, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(panelSearch, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panelSort, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(18, 18, 18).addComponent(btnChoose, javax.swing.GroupLayout.PREFERRED_SIZE, 43,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 8, Short.MAX_VALUE)));

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

	@SuppressWarnings("unused")
	private void setColor(JPanel panel) {
		panel.setBackground(new Color(197, 197, 197));
	}

	@SuppressWarnings("unused")
	private void resetColor(JPanel panel) {
		panel.setBackground(new Color(240, 240, 240));
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnChoose;
	private javax.swing.JButton btnReset;
	private javax.swing.JButton btnSearch;
	private javax.swing.JButton btnSort;
	private javax.swing.ButtonGroup buttonGroup1;
	private com.toedter.calendar.JDateChooser dateBegin;
	private com.toedter.calendar.JDateChooser dateEnd;
	private javax.swing.JComboBox<Language> jComboBoxLanguage;
	private javax.swing.JComboBox<Level> jComboBoxLevel;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JSeparator jSeparator2;
	private javax.swing.JRadioButton jrbEndDate;
	private javax.swing.JRadioButton jrbLanguage;
	private javax.swing.JRadioButton jrbLevel;
	private javax.swing.JRadioButton jrbStartDate;
	private javax.swing.JLabel lblHome;
	private javax.swing.JLabel lblUserText3;
	private javax.swing.JPanel panelHeader;
	private javax.swing.JPanel panelMain;
	private javax.swing.JPanel panelSearch;
	private javax.swing.JPanel panelSort;
	private javax.swing.JTable tblCourses;
	// End of variables declaration//GEN-END:variables

	private void designTable() {
		tblCourses.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 15));
		tblCourses.getTableHeader().setOpaque(false);
		tblCourses.getTableHeader().setBackground(new Color(32, 136, 203));
		tblCourses.getTableHeader().setForeground(new Color(255, 255, 255));
		tblCourses.setRowHeight(25);
	}

	public JTable getTblCourses() {
		return tblCourses;
	}

	public JLabel getLblHome() {
		return lblHome;
	}

	public JButton getBtnSort() {
		return btnSort;
	}

	public JButton getBtnChoose() {
		return btnChoose;
	}

	public JButton getBtnSearch() {
		return btnSearch;
	}

	public JRadioButton getJrbStartDate() {
		return jrbStartDate;
	}

	public JRadioButton getJrbEndDate() {
		return jrbEndDate;
	}

	public JRadioButton getJrbLanguage() {
		return jrbLanguage;
	}

	public JRadioButton getJrbLevel() {
		return jrbLevel;
	}

	public JComboBox<Level> getjComboBoxLevel() {
		return jComboBoxLevel;
	}

	public JComboBox<Language> getjComboBoxLanguage() {
		return jComboBoxLanguage;
	}

	public JButton getBtnReset() {
		return btnReset;
	}

	public JDateChooser getDateBegin() {
		return dateBegin;
	}

	public JDateChooser getDateEnd() {
		return dateEnd;
	}

}
