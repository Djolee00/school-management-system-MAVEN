package schoolmanagement.commonlib.communication;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Sender {

	private final ObjectOutputStream out;

	public Sender(Socket socket) throws IOException {
		out = new ObjectOutputStream(socket.getOutputStream());
	}

	public void send(Object object) throws IOException {
		out.writeObject(object);
		out.flush();
		out.reset();
	}
}
