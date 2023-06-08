package validation.rule;

public class MatchRegexRule extends Rule {

	private final Object property;
	private final String regex;

	public MatchRegexRule(Object property, String regex) {
		this.property = property;
		this.regex = regex;
	}

	@Override
	public String validate() {
		if (property != null) {
			if (property instanceof String temp) {

				if (!temp.matches(regex)) {
					if (this.getErrorMessage() != null && !this.getErrorMessage().isEmpty()) {
						return this.getErrorMessage();
					} else {
						return "Invalid string format";
					}

				}
			}
		}
		return null;
	}

}
