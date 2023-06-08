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

public class LanguageServiceImpl implements LanguageService {

	private final LanguageDao languageDao;

	public LanguageServiceImpl(LanguageDao languageDao) {
		this.languageDao = languageDao;
	}

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
