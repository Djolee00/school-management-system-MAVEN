package schoolmanagement.service;

import java.io.IOException;
import java.sql.SQLException;
import schoolmanagement.commonlib.model.User;

/**
 * The {@code UserService} interface represents a user service in the system. It
 * provides methods for user authentication and related operations.
 *
 * <p>
 * This interface defines the contract for classes that implement user
 * authentication functionality. Implementing classes should provide an
 * implementation for the {@link #login(String, String)} method.
 * </p>
 *
 * <p>
 * Implementation note: The authentication process may involve accessing a data
 * source to validate the user credentials.
 * </p>
 *
 *
 * @author Djordje Ivanovic
 * @see User
 */
public interface UserService {

	/**
	 * Logs in a user with the provided username and password.
	 *
	 * @param username the username of the user
	 * @param password the password of the user
	 * @return the logged-in {@link User} object, or {@code null} if the login is
	 *         unsuccessful
	 * @throws IOException  if an I/O error occurs while accessing the data source
	 * @throws SQLException if an SQL error occurs while accessing the data source
	 */
	User login(String username, String password) throws IOException, SQLException;
}
