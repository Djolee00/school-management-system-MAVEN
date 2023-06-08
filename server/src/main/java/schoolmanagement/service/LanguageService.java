package schoolmanagement.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import schoolmanagement.commonlib.model.Language;
import schoolmanagement.commonlib.model.Tutor;

public interface LanguageService {

	public List<Language> getAllLanguages() throws IOException, SQLException;

	public List<Tutor> getAllTutors(Language language) throws IOException, SQLException;

}
