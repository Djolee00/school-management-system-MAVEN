package schoolmanagement.service;

import schoolmanagement.service.impl.LanguageServiceImpl;
import schoolmanagement.service.mock.MockLanguageDao;

public class LanguageServiceImplTest extends LanguageServiceTest{

	@Override
	protected LanguageService createLanguageService() {
		return new LanguageServiceImpl(new MockLanguageDao());
	}

}
