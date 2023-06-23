package schoolmanagement.service;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import schoolmanagement.commonlib.model.Language;
import schoolmanagement.commonlib.model.Tutor;
import schoolmanagement.commonlib.model.enums.Level;

abstract class LanguageServiceTest {

	protected LanguageService languageService;

	protected abstract LanguageService createLanguageService();

	@BeforeEach
	void setUp() throws Exception {
		languageService = createLanguageService();
	}

	@SuppressWarnings("serial")
	@Test
	public void testGetAllTutors() throws IOException, SQLException {
		Tutor t1 = new Tutor("John", "Bryant", new ArrayList<>() {
			{
				add(new Language("English", Level.A1));
			}
		});
		Tutor t2 = new Tutor("Michael", "O'Neil", new ArrayList<>() {
			{
				add(new Language("English", Level.A1));
			}
		});

		List<Tutor> actualTutors = languageService.getAllTutors(new Language("English", Level.A1));

		assertTrue(actualTutors.size() == 2);
		assertTrue(actualTutors.contains(t1));
		assertTrue(actualTutors.contains(t2));
	}

	@Test
	public void testGetAllLanguages() throws IOException, SQLException {
		List<Language> expectedLanguages = new ArrayList<>();
		expectedLanguages.add(new Language("English",Level.A1));
		expectedLanguages.add(new Language("France",Level.A2));
		expectedLanguages.add(new Language("German",Level.B1));

		List<Language> actualLanguages = languageService.getAllLanguages();

		assertEquals(expectedLanguages, actualLanguages);
		assertTrue(actualLanguages.size()==3);
	}

}
