package schoolmanagement.view;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import schoolmanagement.server.Server;
import schoolmanagement.server.handler.ClientHandler;

@SuppressWarnings("serial")
public class MainForm extends javax.swing.JFrame {

	private Server serverThread;

	/**
	 * Creates new form MainForm
	 */
	public MainForm() {
		initComponents();
		setLocationRelativeTo(null);
		prepareTable();

		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				try {
					fillTable();
				} catch (Exception ex) {
					System.out.println(ex);
				}
			}
		}, 5000, 5000);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jScrollPane1 = new javax.swing.JScrollPane();
		tblUsers = new javax.swing.JTable();
		btnStartServer = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenuConfiguation = new javax.swing.JMenu();
		jMenuItemDatabase = new javax.swing.JMenuItem();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		tblUsers.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "Username:", "Login time:" }) {
			@SuppressWarnings("rawtypes")
			Class[] types = new Class[] { java.lang.String.class, java.lang.String.class };
			boolean[] canEdit = new boolean[] { false, false };

			@SuppressWarnings("rawtypes")
			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jScrollPane1.setViewportView(tblUsers);

		btnStartServer.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
		btnStartServer.setText("Start server");
		btnStartServer.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnStartServerActionPerformed(evt);
			}
		});

		jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel1.setText("Active users:");

		jMenuConfiguation.setText("Server");

		jMenuItemDatabase.setText("Configuration");
		jMenuItemDatabase.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItemDatabaseActionPerformed(evt);
			}
		});
		jMenuConfiguation.add(jMenuItemDatabase);

		jMenuBar1.add(jMenuConfiguation);

		setJMenuBar(jMenuBar1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addGap(48, 48, 48)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 605,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								layout.createSequentialGroup()
										.addComponent(btnStartServer, javax.swing.GroupLayout.PREFERRED_SIZE, 159,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(218, 218, 218)))
				.addContainerGap(50, Short.MAX_VALUE))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jLabel1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(283, 283, 283)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(16, 16, 16).addComponent(jLabel1)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(48, 48, 48).addComponent(btnStartServer, javax.swing.GroupLayout.PREFERRED_SIZE, 39,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(56, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void btnStartServerActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnStartServerActionPerformed
		try {
			serverThread = new Server();
			serverThread.start();
			JOptionPane.showMessageDialog(this, "Server is started!", "Success", JOptionPane.INFORMATION_MESSAGE);
			btnStartServer.setEnabled(false);
			jMenuConfiguation.setEnabled(false);
		} catch (IOException ex) {
			System.out.println(ex);
			JOptionPane.showMessageDialog(this, "Error starting server. Please try again!", "Erorr",
					JOptionPane.ERROR_MESSAGE);
			this.dispose();
			System.exit(0);
		}
	}// GEN-LAST:event_btnStartServerActionPerformed

	private void jMenuItemDatabaseActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItemDatabaseActionPerformed
		new ConfigurationForm(this, true).setVisible(true);
	}// GEN-LAST:event_jMenuItemDatabaseActionPerformed

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnStartServer;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JMenu jMenuConfiguation;
	private javax.swing.JMenuItem jMenuItemDatabase;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable tblUsers;
	// End of variables declaration//GEN-END:variables

	private void fillTable() {
		if (this.serverThread != null) {
			List<ClientHandler> clients = Server.loggedClients;
			DefaultTableModel dtm = (DefaultTableModel) this.tblUsers.getModel();
			int rows = dtm.getRowCount();
			if (rows >= 0) {
				for (int i = rows - 1; i >= 0; i--) {
					dtm.removeRow(i);
				}
			}

			SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
			for (ClientHandler ch : clients) {
				if (ch.getUser() != null) {
					String loginTime = sdf.format(ch.getLoginTime());
					dtm.addRow(new Object[] { ch.getUser().getUsername(), loginTime });
				}
			}
		}
	}

	private void prepareTable() {
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		tblUsers.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tblUsers.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
	}
}