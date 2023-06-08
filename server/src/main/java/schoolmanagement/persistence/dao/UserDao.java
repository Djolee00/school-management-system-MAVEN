package schoolmanagement.persistence.dao;

import java.io.IOException;
import java.sql.SQLException;
import schoolmanagement.commonlib.model.User;

public interface UserDao extends DaoInterface {

	// needs to return generated id
	public long saveUser(User user) throws SQLException, IOException;

	public boolean isUsernameUnique(String username) throws SQLException;

	public User getUserByUsernameAndPassword(String username, String password) throws SQLException;

	public boolean updateUser(User user) throws SQLException;
}
