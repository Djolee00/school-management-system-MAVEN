package schoolmanagement.commonlib.communication;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

import org.junit.jupiter.api.Test;

class SenderTest {
	@Test
	public void testSend() throws IOException {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

		Socket socket = new Socket() {
			@Override
			public OutputStream getOutputStream() throws IOException {
				return byteArrayOutputStream;
			}
		};

		Sender sender = new Sender(socket);

		Object object = "Test object";

		sender.send(object);

		byte[] sentData = byteArrayOutputStream.toByteArray();

		assertNotNull(sentData);
		assertTrue(sentData.length > 0);
	}

	@Test
	public void testSendIOException() {
		Socket socket = new Socket() {
			@Override
			public OutputStream getOutputStream() throws IOException {
				throw new IOException("Mocked IOException");
			}
		};

		Sender sender = null;
		try {
			sender = new Sender(socket);
			fail("Expected IOException to be thrown");
		} catch (IOException e) {
			assertEquals("Mocked IOException", e.getMessage());
		}

		assertNull(sender);
	}
}
