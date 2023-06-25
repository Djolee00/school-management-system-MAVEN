package schoolmanagement.controller.login;

import java.io.IOException;
import javax.swing.JOptionPane;
import schoolmanagement.commonlib.communication.Operation;
import schoolmanagement.commonlib.communication.Request;
import schoolmanagement.commonlib.communication.Response;
import schoolmanagement.commonlib.communication.ResponseType;
import schoolmanagement.commonlib.model.Administrator;
import schoolmanagement.commonlib.model.User;
import schoolmanagement.commonlib.utils.JsonSerializationUtils;
import schoolmanagement.communication.Communication;
import schoolmanagement.controller.admin.AdminHomeController;
import schoolmanagement.controller.student.StudentHomeController;
import schoolmanagement.session.Session;
import schoolmanagement.view.login.LoginView;

public class LoginController {

	private LoginView loginView;

	public LoginController() {
		loginView = new LoginView();
		loginView.setVisible(true);
		try {
			connectToServer();
			initView();
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(loginView, "Error establishing connection with the client", "Error",
					JOptionPane.ERROR_MESSAGE);
			loginView.dispose();
		}
	}

	private void connectToServer() throws IOException {
		Communication.getInstance();
	}

	private void initView() {
		loginView.getBtnLogin().addActionListener(e -> new Thread(() -> {
			login();
		}).start());
	}

	private void login() {
		String username = loginView.getTxtUsername().getText().trim();
		String password = new String(loginView.getTxtPassword().getPassword());
		User user = new User(username, password);

		try {
			Communication.getInstance().send(new Request(Operation.LOGIN, user));
			Response response = (Response) Communication.getInstance().receive();

			if (response.getResponseType() == ResponseType.SUCCESS) {
				User loggedUser = JsonSerializationUtils.convertValue(response.getObject(), Administrator.class);
				Session.getInstance().add("user", loggedUser);

				if (loggedUser instanceof Administrator) {
					JOptionPane.showMessageDialog(loginView, "Successfully logged in!", "Success",
							JOptionPane.INFORMATION_MESSAGE);
					new AdminHomeController();
				} else {
					JOptionPane.showMessageDialog(loginView, "Successfully logged in!", "Success",
							JOptionPane.INFORMATION_MESSAGE);
					new StudentHomeController();
				}

				loginView.dispose();

			} else {
				JOptionPane.showMessageDialog(loginView,
						"User with those credentials doesn't exist.\nPlease try again.", "Try again",
						JOptionPane.WARNING_MESSAGE);
			}

		} catch (IOException | ClassNotFoundException ex) {
			JOptionPane.showMessageDialog(loginView, "Error in communication with server", "Error",
					JOptionPane.ERROR_MESSAGE);
			loginView.dispose();
		}

	}
}
