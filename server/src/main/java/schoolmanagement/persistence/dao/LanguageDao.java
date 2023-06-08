package schoolmanagement.persistence.dao;

import java.sql.SQLException;
import java.util.List;
import schoolmanagement.commonlib.model.Language;
import schoolmanagement.commonlib.model.Tutor;

public interface LanguageDao extends DaoInterface {

	public List<Language> getAllLanguages() throws SQLException;

	public List<Tutor> getAllTutors(Language language) throws SQLException;

}
