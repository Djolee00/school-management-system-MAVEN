package schoolmanagement.communication;

import java.io.IOException;
import java.net.Socket;
import schoolmanagement.commonlib.communication.Receiver;
import schoolmanagement.commonlib.communication.Request;
import schoolmanagement.commonlib.communication.Response;
import schoolmanagement.commonlib.communication.Sender;

public class Communication {

	private final Sender sender;
	private final Receiver receiver;

	private static Communication instance;

	private Communication() throws IOException {
		Socket socket = new Socket("localhost", 9001);
		sender = new Sender(socket);
		receiver = new Receiver(socket);
	}

	public static Communication getInstance() throws IOException {
		if (instance == null) {
			instance = new Communication();
		}
		return instance;
	}

	public void send(Request request) throws IOException {
		sender.send(request);
	}

	public Response receive() throws IOException, ClassNotFoundException {
		return (Response) receiver.receive();
	}
}
