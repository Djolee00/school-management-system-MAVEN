package schoolmanagement.persistence.dao;

import schoolmanagement.commonlib.model.User;
import java.sql.SQLException;

public interface AdminDao extends DaoInterface{

    public User getAdminByUser(User user) throws SQLException;
    
}
