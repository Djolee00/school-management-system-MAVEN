package schoolmanagement.commonlib.communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * The Receiver class is responsible for receiving objects over a network
 * connection.
 *
 * <p>
 * It provides a mechanism to read objects from the input stream of a Socket.
 * </p>
 *
 * @author Djordje Ivanovic
 */
public class Receiver {

	/**
	 * The ObjectInputStream used for reading objects from the input stream.
	 */
	private final ObjectInputStream in;

	/**
	 * Constructs a Receiver object with the specified socket.
	 *
	 * @param socket The socket from which to receive objects.
	 * @throws IOException if an I/O error occurs while reading from the input
	 *                     stream. found.
	 */
	public Receiver(Socket socket) throws IOException {
		in = new ObjectInputStream(socket.getInputStream());
	}

	/**
	 * Receives an object from the input stream.
	 *
	 * @return The received object.
	 * @throws IOException            if an I/O error occurs while reading from the
	 *                                input stream.
	 * @throws ClassNotFoundException if the class of the object received is not
	 *                                found.
	 */
	public Object receive() throws IOException, ClassNotFoundException {
		return in.readObject();
	}
}
