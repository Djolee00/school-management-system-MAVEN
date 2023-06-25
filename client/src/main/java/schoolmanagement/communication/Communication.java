package schoolmanagement.communication;

import java.io.IOException;
import java.net.Socket;

import com.fasterxml.jackson.core.type.TypeReference;

import schoolmanagement.commonlib.communication.Receiver;
import schoolmanagement.commonlib.communication.Request;
import schoolmanagement.commonlib.communication.Response;
import schoolmanagement.commonlib.communication.Sender;
import schoolmanagement.commonlib.utils.JsonSerializationUtils;

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
		String jsonRequest = JsonSerializationUtils.serializeToJson(request,new TypeReference<Request>() {
		});
		sender.send(jsonRequest);
	}

	public Response receive() throws IOException, ClassNotFoundException {
		String jsonResponse = (String) receiver.receive();
		return JsonSerializationUtils.deserializeFromJson(jsonResponse, new TypeReference<Response>() {
		});
	}
}
