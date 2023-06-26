/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package schoolmanagement.view.student;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author ivano
 */
@SuppressWarnings("serial")
public class StudentHomeView extends javax.swing.JFrame {

	public StudentHomeView() {
		initComponents();
		setLocationRelativeTo(null);
	}

	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		panelMain = new javax.swing.JPanel();
		panelHeader = new javax.swing.JPanel();
		lblUser = new javax.swing.JLabel();
		lblUserText3 = new javax.swing.JLabel();
		jLabel1 = new javax.swing.JLabel();
		panelProfileItem = new javax.swing.JPanel();
		lblUserText = new javax.swing.JLabel();
		lblUserPhoto = new javax.swing.JLabel();
		panelCourseItem = new javax.swing.JPanel();
		lblCoursesText = new javax.swing.JLabel();
		lblCoursesPhoto = new javax.swing.JLabel();
		panelLogoutItem = new javax.swing.JPanel();
		lblLogoutText = new javax.swing.JLabel();
		lblLogoutPhozo = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setMaximumSize(new java.awt.Dimension(900, 550));
		setMinimumSize(new java.awt.Dimension(900, 550));
		setPreferredSize(new java.awt.Dimension(900, 550));
		setResizable(false);

		panelMain.setBackground(new java.awt.Color(255, 255, 255));
		panelMain.setMaximumSize(new java.awt.Dimension(900, 550));
		panelMain.setMinimumSize(new java.awt.Dimension(900, 550));
		panelMain.setPreferredSize(new java.awt.Dimension(900, 550));

		panelHeader.setBackground(new java.awt.Color(45, 118, 232));

		lblUser.setBackground(new java.awt.Color(45, 118, 232));
		lblUser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		lblUser.setForeground(new java.awt.Color(255, 255, 255));
		lblUser.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

		lblUserText3.setBackground(new java.awt.Color(45, 118, 232));
		lblUserText3.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 36)); // NOI18N
		lblUserText3.setForeground(new java.awt.Color(255, 255, 255));
		lblUserText3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		lblUserText3.setText("Welcome");

		jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/schoolmanagement/images/school.png"))); // NOI18N

		javax.swing.GroupLayout panelHeaderLayout = new javax.swing.GroupLayout(panelHeader);
		panelHeader.setLayout(panelHeaderLayout);
		panelHeaderLayout.setHorizontalGroup(panelHeaderLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelHeaderLayout.createSequentialGroup().addGap(60, 60, 60).addComponent(jLabel1)
						.addGap(18, 18, 18)
						.addGroup(panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lblUserText3, javax.swing.GroupLayout.PREFERRED_SIZE, 250,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lblUser))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panelHeaderLayout
				.setVerticalGroup(panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(panelHeaderLayout.createSequentialGroup().addGap(21, 21, 21)
								.addGroup(panelHeaderLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(panelHeaderLayout.createSequentialGroup().addComponent(lblUserText3)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(lblUser)))
								.addContainerGap(79, Short.MAX_VALUE)));

		panelProfileItem.setBackground(new java.awt.Color(240, 240, 240));
		panelProfileItem.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				panelProfileItemMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				panelProfileItemMouseExited(evt);
			}
		});

		lblUserText.setBackground(new java.awt.Color(45, 118, 232));
		lblUserText.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		lblUserText.setForeground(new java.awt.Color(45, 118, 232));
		lblUserText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblUserText.setText("My Profile");

		lblUserPhoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/schoolmanagement/images/user.png"))); // NOI18N
		lblUserPhoto.setText("jLabel1");
		lblUserPhoto.setMaximumSize(new java.awt.Dimension(48, 48));
		lblUserPhoto.setMinimumSize(new java.awt.Dimension(48, 48));
		lblUserPhoto.setPreferredSize(new java.awt.Dimension(48, 48));

		javax.swing.GroupLayout panelProfileItemLayout = new javax.swing.GroupLayout(panelProfileItem);
		panelProfileItem.setLayout(panelProfileItemLayout);
		panelProfileItemLayout.setHorizontalGroup(panelProfileItemLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelProfileItemLayout.createSequentialGroup().addGroup(panelProfileItemLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(panelProfileItemLayout.createSequentialGroup().addGap(50, 50, 50).addComponent(
								lblUserPhoto, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(panelProfileItemLayout.createSequentialGroup().addGap(40, 40, 40).addComponent(
								lblUserText, javax.swing.GroupLayout.PREFERRED_SIZE, 67,
								javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(40, Short.MAX_VALUE)));
		panelProfileItemLayout
				.setVerticalGroup(panelProfileItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(panelProfileItemLayout.createSequentialGroup().addGap(10, 10, 10)
								.addComponent(lblUserPhoto, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(12, 12, 12).addComponent(lblUserText)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		panelCourseItem.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				panelCourseItemMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				panelCourseItemMouseExited(evt);
			}
		});

		lblCoursesText.setBackground(new java.awt.Color(45, 118, 232));
		lblCoursesText.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		lblCoursesText.setForeground(new java.awt.Color(45, 118, 232));
		lblCoursesText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblCoursesText.setText("Courses");

		lblCoursesPhoto
				.setIcon(new javax.swing.ImageIcon(getClass().getResource("/schoolmanagement/images/courses.png"))); // NOI18N
		lblCoursesPhoto.setText("jLabel1");
		lblCoursesPhoto.setMaximumSize(new java.awt.Dimension(48, 48));
		lblCoursesPhoto.setMinimumSize(new java.awt.Dimension(48, 48));
		lblCoursesPhoto.setPreferredSize(new java.awt.Dimension(48, 48));

		javax.swing.GroupLayout panelCourseItemLayout = new javax.swing.GroupLayout(panelCourseItem);
		panelCourseItem.setLayout(panelCourseItemLayout);
		panelCourseItemLayout.setHorizontalGroup(panelCourseItemLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelCourseItemLayout.createSequentialGroup()
						.addGroup(panelCourseItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(panelCourseItemLayout.createSequentialGroup().addGap(50, 50, 50).addComponent(
										lblCoursesPhoto, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(panelCourseItemLayout.createSequentialGroup().addGap(40, 40, 40).addComponent(
										lblCoursesText, javax.swing.GroupLayout.PREFERRED_SIZE, 67,
										javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(40, Short.MAX_VALUE)));
		panelCourseItemLayout
				.setVerticalGroup(panelCourseItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(panelCourseItemLayout.createSequentialGroup().addGap(10, 10, 10)
								.addComponent(lblCoursesPhoto, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(12, 12, 12).addComponent(lblCoursesText)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		panelLogoutItem.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				panelLogoutItemMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				panelLogoutItemMouseExited(evt);
			}
		});

		lblLogoutText.setBackground(new java.awt.Color(45, 118, 232));
		lblLogoutText.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		lblLogoutText.setForeground(new java.awt.Color(45, 118, 232));
		lblLogoutText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblLogoutText.setText("Log Out");

		lblLogoutPhozo
				.setIcon(new javax.swing.ImageIcon(getClass().getResource("/schoolmanagement/images/logout.png"))); // NOI18N
		lblLogoutPhozo.setText("jLabel1");
		lblLogoutPhozo.setMaximumSize(new java.awt.Dimension(48, 48));
		lblLogoutPhozo.setMinimumSize(new java.awt.Dimension(48, 48));
		lblLogoutPhozo.setPreferredSize(new java.awt.Dimension(48, 48));

		javax.swing.GroupLayout panelLogoutItemLayout = new javax.swing.GroupLayout(panelLogoutItem);
		panelLogoutItem.setLayout(panelLogoutItemLayout);
		panelLogoutItemLayout.setHorizontalGroup(panelLogoutItemLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelLogoutItemLayout.createSequentialGroup()
						.addGroup(panelLogoutItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(panelLogoutItemLayout.createSequentialGroup().addGap(50, 50, 50).addComponent(
										lblLogoutPhozo, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(panelLogoutItemLayout.createSequentialGroup().addGap(40, 40, 40).addComponent(
										lblLogoutText, javax.swing.GroupLayout.PREFERRED_SIZE, 67,
										javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(40, Short.MAX_VALUE)));
		panelLogoutItemLayout
				.setVerticalGroup(panelLogoutItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(panelLogoutItemLayout.createSequentialGroup().addGap(10, 10, 10)
								.addComponent(lblLogoutPhozo, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(12, 12, 12).addComponent(lblLogoutText).addContainerGap(49, Short.MAX_VALUE)));

		javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
		panelMain.setLayout(panelMainLayout);
		panelMainLayout.setHorizontalGroup(panelMainLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(panelHeader, javax.swing.GroupLayout.Alignment.TRAILING,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						panelMainLayout.createSequentialGroup().addContainerGap(169, Short.MAX_VALUE)
								.addComponent(panelProfileItem, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(67, 67, 67)
								.addComponent(panelCourseItem, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(57, 57, 57)
								.addComponent(panelLogoutItem, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(166, 166, 166)));
		panelMainLayout.setVerticalGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelMainLayout.createSequentialGroup()
						.addComponent(panelHeader, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(34, 34, 34)
						.addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(panelProfileItem, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panelCourseItem, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panelLogoutItem, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(0, 322, Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				panelMain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(panelMain, 640, 640, javax.swing.GroupLayout.PREFERRED_SIZE));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void panelProfileItemMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_panelProfileItemMouseEntered
		setColor(panelProfileItem);
	}// GEN-LAST:event_panelProfileItemMouseEntered

	private void panelProfileItemMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_panelProfileItemMouseExited
		resetColor(panelProfileItem);
	}// GEN-LAST:event_panelProfileItemMouseExited

	private void panelCourseItemMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_panelCourseItemMouseEntered
		setColor(panelCourseItem);
	}// GEN-LAST:event_panelCourseItemMouseEntered

	private void panelCourseItemMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_panelCourseItemMouseExited
		resetColor(panelCourseItem);
	}// GEN-LAST:event_panelCourseItemMouseExited

	private void panelLogoutItemMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_panelLogoutItemMouseEntered
		setColor(panelLogoutItem);
	}// GEN-LAST:event_panelLogoutItemMouseEntered

	private void panelLogoutItemMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_panelLogoutItemMouseExited
		resetColor(panelLogoutItem);
	}// GEN-LAST:event_panelLogoutItemMouseExited

	private void setColor(JPanel panel) {
		panel.setBackground(new Color(197, 197, 197));
	}

	private void resetColor(JPanel panel) {
		panel.setBackground(new Color(240, 240, 240));
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel lblCoursesPhoto;
	private javax.swing.JLabel lblCoursesText;
	private javax.swing.JLabel lblLogoutPhozo;
	private javax.swing.JLabel lblLogoutText;
	private javax.swing.JLabel lblUser;
	private javax.swing.JLabel lblUserPhoto;
	private javax.swing.JLabel lblUserText;
	private javax.swing.JLabel lblUserText3;
	private javax.swing.JPanel panelCourseItem;
	private javax.swing.JPanel panelHeader;
	private javax.swing.JPanel panelLogoutItem;
	private javax.swing.JPanel panelMain;
	private javax.swing.JPanel panelProfileItem;
	// End of variables declaration//GEN-END:variables

	public JPanel getPanelCourseItem() {
		return panelCourseItem;
	}

	public JPanel getPanelLogoutItem() {
		return panelLogoutItem;
	}

	public JPanel getPanelProfileItem() {
		return panelProfileItem;
	}

	public JLabel getLblUser() {
		return lblUser;
	}

}
