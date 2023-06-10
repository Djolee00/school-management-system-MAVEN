package schoolmanagement.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import schoolmanagement.commonlib.model.Language;
import schoolmanagement.commonlib.model.Tutor;

/**
 * This interface provides methods for retrieving information about languages
 * and tutors.
 * 
 * @author Djordje Ivanovic
 */
public interface LanguageService {

	/**
	 * Retrieves a list of all languages.
	 *
	 * @return the list of all languages
	 * @throws IOException  if an I/O error occurs while accessing the data source
	 * @throws SQLException if an SQL error occurs while accessing the data source
	 */
	public List<Language> getAllLanguages() throws IOException, SQLException;

	/**
	 * Retrieves a list of tutors for the specified language.
	 *
	 * @param language the language for which to retrieve tutors
	 * @return the list of tutors for the specified language
	 * @throws IOException  if an I/O error occurs while accessing the data source
	 * @throws SQLException if an SQL error occurs while accessing the data source
	 */
	public List<Tutor> getAllTutors(Language language) throws IOException, SQLException;

}
