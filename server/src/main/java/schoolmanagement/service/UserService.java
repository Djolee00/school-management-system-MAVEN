package schoolmanagement.service;

import java.io.IOException;
import java.sql.SQLException;
import schoolmanagement.commonlib.model.User;

public interface UserService {

	User login(String username, String password) throws IOException, SQLException;
}
