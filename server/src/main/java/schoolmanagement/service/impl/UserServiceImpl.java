package schoolmanagement.service.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import schoolmanagement.commonlib.model.User;
import schoolmanagement.persistence.dao.AdminDao;
import schoolmanagement.persistence.dao.StudentDao;
import schoolmanagement.persistence.dao.UserDao;
import schoolmanagement.persistence.pool.ConnectionPool;
import schoolmanagement.service.UserService;

/**
 * The {@code UserServiceImpl} class is an implementation of the
 * {@link UserService} interface. It provides user authentication functionality
 * by interacting with the data source. This implementation relies on the
 * UserDao, StudentDao, and AdminDao objects for data access operations.
 * 
 * <p>
 * Implementation note: This class assumes the usage of a connection pool for
 * efficient management of database connections. The connection pool can be
 * obtained through the ConnectionPool.getInstance() method.
 * </p>
 * 
 * 
 * @author Djordje Ivanovic
 * @see UserService
 * @see UserDao
 * @see StudentDao
 * @see AdminDao
 * @see ConnectionPool
 */
public class UserServiceImpl implements UserService {

	/**
	 * Object for user-related data access operations
	 */
	private UserDao userDao;
	/**
	 * Object for student-related data access operations
	 */
	private StudentDao studentDao;
	/**
	 * Object for admin-related data access operations
	 */
	private AdminDao adminDao;

	/**
	 * Constructs a new {@code UserServiceImpl} object. Initializes the UserDao,
	 * StudentDao, and AdminDao objects.
	 */
	public UserServiceImpl(UserDao userDao, StudentDao studentDao, AdminDao adminDao) {
		this.userDao = userDao;
		this.studentDao = studentDao;
		this.adminDao = adminDao;
	}

	/**
	 * Logs in a user with the provided username and password.
	 *
	 * <p>
	 * This method retrieves a database connection from the connection pool and sets
	 * it up for manual transaction management. It attempts to fetch a user from the
	 * data source using the provided username and password. If a user is found, it
	 * checks if the user is a student or an admin. The transaction is committed,
	 * and the connection is released back to the connection pool upon successful
	 * execution. If an I/O or SQL error occurs during the operation, the
	 * transaction is rolled back, the connection is released, and the exception is
	 * rethrown.
	 * </p>
	 *
	 * @param username the username of the user
	 * @param password the password of the user
	 * @return the logged-in user, or null if the login is unsuccessful
	 * @throws IOException  if an I/O error occurs while accessing the data source
	 * @throws SQLException if an SQL error occurs while accessing the data source
	 */
	@Override
	public User login(String username, String password) throws IOException, SQLException {
		Connection connection = ConnectionPool.getInstance().getConnection();

		try {
			userDao.setConnection(connection);
			studentDao.setConnection(connection);
			adminDao.setConnection(connection);

			connection.setAutoCommit(false);

			User user = userDao.getUserByUsernameAndPassword(username, password);
			User temp = null;

			if (user != null) {
				temp = studentDao.getStudentByUser(user);

				if (temp == null) {
					temp = adminDao.getAdminByUser(user);
				}
			}

			connection.commit();
			ConnectionPool.getInstance().releaseConnection(connection);

			return temp;

		} catch (IOException | SQLException ex) {
			connection.rollback();
			ConnectionPool.getInstance().releaseConnection(connection);
			throw ex;
		}

	}

}
