package schoolmanagement.service.mock;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import schoolmanagement.commonlib.model.User;
import schoolmanagement.persistence.dao.UserDao;

public class MockUserDao implements UserDao {

	@Override
	public User getUserByUsernameAndPassword(String username, String password) throws SQLException {
		if (username.equals("john") && password.equals("password")) {
			return new User("john", "password");
		}
		if (username.equals("michael") && password.equals("password")) {
			return new User("michael", "password");
		}
		return null;
	}

	public long saveUser(User user) throws SQLException, IOException {
		return 1;
	}

	public boolean isUsernameUnique(String username) {
		return true;
	}

	public boolean updateUser(User user) throws SQLException {
		if(user.getUsername().equals("user"))
			return false;
		return true;
	}

	@Override
	public void setConnection(Connection connection) {
	}
}
