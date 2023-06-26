package schoolmanagement.main;

import com.formdev.flatlaf.FlatLightLaf;
import schoolmanagement.controller.login.LoginController;

public class Main {

	public static void main(String[] args) {

		// to set FlatLaft Look and Feel for JFrames
		FlatLightLaf.setup();

		@SuppressWarnings("unused")
		LoginController loginController = new LoginController();
	}

}
