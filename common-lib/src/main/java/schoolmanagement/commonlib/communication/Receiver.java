package schoolmanagement.commonlib.communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class Receiver {

	private final ObjectInputStream in;

	public Receiver(Socket socket) throws IOException {
		in = new ObjectInputStream(socket.getInputStream());
	}

	public Object receive() throws IOException, ClassNotFoundException {
		return in.readObject();
	}

}
