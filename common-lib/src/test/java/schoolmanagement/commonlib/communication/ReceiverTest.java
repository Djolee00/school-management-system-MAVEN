package schoolmanagement.commonlib.communication;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReceiverTest {

	private Receiver receiver;
	private ByteArrayInputStream mockInputStream;

	@BeforeEach
	void setUp() throws Exception {
		Object testObject = "Test object";

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
		objectOutputStream.writeObject(testObject);
		objectOutputStream.flush();

		mockInputStream = new ByteArrayInputStream(outputStream.toByteArray());

		Socket socket = new Socket() {
			public InputStream getInputStream() throws IOException {
				return mockInputStream;
			};
		};
		receiver = new Receiver(socket);
	}

	@AfterEach
	void tearDown() throws Exception {
		receiver = null;
		mockInputStream.close();
		mockInputStream = null;
	}

	@Test
	public void testReceive() throws IOException, ClassNotFoundException {
		Object expectedObject = "Test object";
		Object actualObject = receiver.receive();

		assertEquals(expectedObject, actualObject);
	}

	@Test
	public void testReceiveIOException() throws ClassNotFoundException {
		Socket socket = new Socket(); // Create a socket without connecting

		assertThrows(IOException.class, () -> {
			new Receiver(socket);
		});
	}

}
