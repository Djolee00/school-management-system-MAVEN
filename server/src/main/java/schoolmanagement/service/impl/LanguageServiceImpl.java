package schoolmanagement.service.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import schoolmanagement.commonlib.model.Language;
import schoolmanagement.commonlib.model.Tutor;
import schoolmanagement.persistence.dao.LanguageDao;
import schoolmanagement.persistence.pool.ConnectionPool;
import schoolmanagement.service.LanguageService;

/**
 * This class implements the {@link LanguageService} interface and provides
 * methods for retrieving information about languages and tutors.
 * 
 * @author Djordje Ivanovic
 */
public class LanguageServiceImpl implements LanguageService {
	
	/**
	 * Object for language-related data access operations
	 */
	private final LanguageDao languageDao;

	/**
	 * Constructs a new {@code LanguageServiceImpl} object with the specified
	 * {@link LanguageDao}.
	 *
	 * @param languageDao the data access object for languages
	 */
	public LanguageServiceImpl(LanguageDao languageDao) {
		this.languageDao = languageDao;
	}

	/**
	 * Retrieves a list of all languages.
	 *
	 * <p>
	 * This method retrieves a database connection from the connection pool and sets
	 * it up for manual transaction management. It invokes the
	 * {@code getAllLanguages} method of the {@link LanguageDao} to fetch all
	 * languages from the data source. The transaction is committed, and the
	 * connection is released back to the connection pool upon successful execution.
	 * If an I/O or SQL error occurs during the operation, the transaction is rolled
	 * back, the connection is released, and the exception is rethrown.
	 * </p>
	 *
	 * @return the list of all languages
	 * @throws IOException  if an I/O error occurs while accessing the data source
	 * @throws SQLException if an SQL error occurs while accessing the data source
	 */
	@Override
	public List<Language> getAllLanguages() throws IOException, SQLException {

		Connection connection = ConnectionPool.getInstance().getConnection();
		List<Language> languages;

		try {
			languageDao.setConnection(connection);
			connection.setAutoCommit(false);
			languages = languageDao.getAllLanguages();

			connection.commit();
			ConnectionPool.getInstance().releaseConnection(connection);

			return languages;
		} catch (IOException | SQLException ex) {
			connection.rollback();
			ConnectionPool.getInstance().releaseConnection(connection);
			throw ex;
		}
	}

	/**
	 * Retrieves a list of tutors for the specified language.
	 *
	 * <p>
	 * This method retrieves a database connection from the connection pool and sets
	 * it up for manual transaction management. It invokes the {@code getAllTutors}
	 * method of the {@link LanguageDao} to fetch all tutors for the specified
	 * language from the data source. The transaction is committed, and the
	 * connection is released back to the connection pool upon successful execution.
	 * If an I/O or SQL error occurs during the operation, the transaction is rolled
	 * back, the connection is released, and the exception is rethrown.
	 * </p>
	 *
	 * @param language the language for which to retrieve tutors
	 * @return the list of tutors for the specified language
	 * @throws IOException  if an I/O error occurs while accessing the data source
	 * @throws SQLException if an SQL error occurs while accessing the data source
	 */
	@Override
	public List<Tutor> getAllTutors(Language language) throws IOException, SQLException {
		Connection connection = ConnectionPool.getInstance().getConnection();
		List<Tutor> tutors;

		try {
			languageDao.setConnection(connection);
			connection.setAutoCommit(false);
			tutors = languageDao.getAllTutors(language);

			connection.commit();
			ConnectionPool.getInstance().releaseConnection(connection);

			return tutors;
		} catch (IOException | SQLException ex) {
			connection.rollback();
			ConnectionPool.getInstance().releaseConnection(connection);
			throw ex;
		}
	}

}
