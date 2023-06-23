package schoolmanagement.service.mock;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import schoolmanagement.commonlib.model.Language;
import schoolmanagement.commonlib.model.Tutor;
import schoolmanagement.commonlib.model.enums.Level;
import schoolmanagement.persistence.dao.LanguageDao;

public class MockLanguageDao implements LanguageDao{

	@Override
	public void setConnection(Connection connection) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("serial")
	@Override
	public List<Language> getAllLanguages() throws SQLException {
		return new ArrayList<Language>() {{
			add(new Language("English",Level.A1));
			add(new Language("France",Level.A2));
			add(new Language("German",Level.B1));
		}};
	}

	@SuppressWarnings("serial")
	@Override
	public List<Tutor> getAllTutors(Language language) throws SQLException {
		List<Tutor> tutors = new ArrayList<>() {{
			add(new Tutor("John", "Bryant", new ArrayList<>() {{add(new Language("English",Level.A1));}}));
			add(new Tutor("Michael", "O'Neil", new ArrayList<>() {{add(new Language("English",Level.A1));}}));
			add(new Tutor("Kobe", "Hill", new ArrayList<>() {{add(new Language("France",Level.A1));}}));

		}};
		
		return tutors.stream().filter(t->t.getLanguages().contains(language)).toList();
	}

}
