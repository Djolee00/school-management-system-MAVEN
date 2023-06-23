package schoolmanagement.service.mock;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

import schoolmanagement.commonlib.model.Administrator;
import schoolmanagement.commonlib.model.User;
import schoolmanagement.persistence.dao.AdminDao;

public class MockAdminDao implements AdminDao {

	@Override
	public User getAdminByUser(User user) throws SQLException {
		if (user != null && user.getUsername().equals("michael") && user.getPassword().equals("password")) {
			return new Administrator(1l, "michael", "password", LocalDate.of(2023, 4, 19));
		}
		return null;
	}

	@Override
	public void setConnection(Connection connection) {
		// TODO Auto-generated method stub

	}

}
