package schoolmanagement.commonlib.communication;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * The Sender class represents a sender, responsible for sending objects over a
 * socket connection.
 *
 * <p>
 * It uses an ObjectOutputStream to write objects to the output stream of the
 * socket.
 * </p>
 *
 * @see Socket
 * @author Djordje Ivanovic
 */
public class Sender {

	/**
	 * The ObjectOutputStream used for writing objects to the output stream.
	 */
	private final ObjectOutputStream out;

	/**
	 * Constructs a Sender object with the specified socket.
	 *
	 * @param socket The socket to be used for sending objects.
	 * @throws IOException if an I/O error occurs when creating the
	 *                     ObjectOutputStream.
	 */
	public Sender(Socket socket) throws IOException {
		out = new ObjectOutputStream(socket.getOutputStream());
	}

	/**
	 * Sends the specified object over the socket connection.
	 *
	 * @param object The object to be sent.
	 * @throws IOException if an I/O error occurs when writing the object to the
	 *                     output stream.
	 */
	public void send(Object object) throws IOException {
		out.writeObject(object);
		out.flush();
		out.reset();
	}
}
