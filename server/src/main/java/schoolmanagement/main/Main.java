package schoolmanagement.main;

import com.formdev.flatlaf.FlatLightLaf;
import schoolmanagement.view.MainForm;

public class Main {

	public static void main(String[] args) {
		FlatLightLaf.setup();
		(new MainForm()).setVisible(true);
	}

}
