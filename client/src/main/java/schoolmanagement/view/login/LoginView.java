package schoolmanagement.view.login;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class LoginView extends javax.swing.JFrame {

	public LoginView() {
		initComponents();
		setLocationRelativeTo(null);

	}

	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		lblLogin = new javax.swing.JLabel();
		jSeparator1 = new javax.swing.JSeparator();
		lblUsernameIcon = new javax.swing.JLabel();
		lblPasswordPhoto = new javax.swing.JLabel();
		jSeparator2 = new javax.swing.JSeparator();
		lblPassword = new javax.swing.JLabel();
		lblUsername = new javax.swing.JLabel();
		txtPassword = new javax.swing.JPasswordField();
		txtUsername = new javax.swing.JTextField();
		btnLogin = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setMaximumSize(new java.awt.Dimension(600, 500));
		setMinimumSize(new java.awt.Dimension(600, 500));
		setPreferredSize(new java.awt.Dimension(600, 500));
		setResizable(false);

		jPanel1.setBackground(new java.awt.Color(45, 118, 232));

		lblLogin.setBackground(new java.awt.Color(45, 118, 232));
		lblLogin.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 36)); // NOI18N
		lblLogin.setForeground(new java.awt.Color(255, 255, 255));
		lblLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblLogin.setText("LOGIN");

		jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
		jSeparator1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

		lblUsernameIcon
				.setIcon(new javax.swing.ImageIcon(getClass().getResource("/schoolmanagement/images/username.png"))); // NOI18N
		lblUsernameIcon.setPreferredSize(new java.awt.Dimension(50, 50));

		lblPasswordPhoto
				.setIcon(new javax.swing.ImageIcon(getClass().getResource("/schoolmanagement/images/password.png"))); // NOI18N

		jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
		jSeparator2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

		lblPassword.setBackground(new java.awt.Color(45, 118, 232));
		lblPassword.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		lblPassword.setForeground(new java.awt.Color(255, 255, 255));
		lblPassword.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		lblPassword.setText("Password:");

		lblUsername.setBackground(new java.awt.Color(45, 118, 232));
		lblUsername.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		lblUsername.setForeground(new java.awt.Color(255, 255, 255));
		lblUsername.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblUsername.setText("Username:");

		txtPassword.setBackground(new java.awt.Color(45, 118, 232));
		txtPassword.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		txtPassword.setForeground(new java.awt.Color(255, 255, 255));
		txtPassword.setBorder(null);

		txtUsername.setBackground(new java.awt.Color(45, 118, 232));
		txtUsername.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		txtUsername.setForeground(new java.awt.Color(255, 255, 255));
		txtUsername.setBorder(null);

		btnLogin.setText("Log In");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup().addGap(155, 155, 155).addComponent(lblLogin,
								javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(jPanel1Layout.createSequentialGroup().addGap(205, 205, 205).addComponent(lblPassword,
								javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(jPanel1Layout.createSequentialGroup().addGap(165, 165, 165).addGroup(jPanel1Layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addComponent(lblPasswordPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(jPanel1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 210,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 210,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGroup(jPanel1Layout.createSequentialGroup()
												.addComponent(lblUsernameIcon, javax.swing.GroupLayout.PREFERRED_SIZE,
														38, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(2, 2, 2).addComponent(jSeparator1,
														javax.swing.GroupLayout.PREFERRED_SIZE, 210,
														javax.swing.GroupLayout.PREFERRED_SIZE)))))
						.addGroup(jPanel1Layout.createSequentialGroup().addGap(232, 232, 232).addComponent(btnLogin,
								javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(
								jPanel1Layout.createSequentialGroup().addGap(201, 201, 201).addComponent(lblUsername)))
						.addGap(182, 182, 182)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(31, 31, 31).addComponent(lblLogin)
						.addGap(72, 72, 72).addComponent(lblUsername)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(lblUsernameIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(4, 4, 4).addComponent(jSeparator1,
												javax.swing.GroupLayout.PREFERRED_SIZE, 6,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGap(18, 18, 18).addComponent(lblPassword).addGap(6, 6, 6)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(lblPasswordPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 20,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(5, 5, 5).addComponent(jSeparator2,
												javax.swing.GroupLayout.PREFERRED_SIZE, 6,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGap(48, 48, 48).addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 36,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(41, Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnLogin;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JSeparator jSeparator2;
	private javax.swing.JLabel lblLogin;
	private javax.swing.JLabel lblPassword;
	private javax.swing.JLabel lblPasswordPhoto;
	private javax.swing.JLabel lblUsername;
	private javax.swing.JLabel lblUsernameIcon;
	private javax.swing.JPasswordField txtPassword;
	private javax.swing.JTextField txtUsername;
	// End of variables declaration//GEN-END:variables

	public JButton getBtnLogin() {
		return btnLogin;
	}

	public JPasswordField getTxtPassword() {
		return txtPassword;
	}

	public JTextField getTxtUsername() {
		return txtUsername;
	}

}
