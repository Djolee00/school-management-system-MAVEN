package validation.rule;

public class NotEmptyRule extends Rule {

	private final Object property;

	public NotEmptyRule(Object property) {
		this.property = property;
	}

	@Override
	public String validate() {
		if (property == null || (property instanceof String && ((String) property).isBlank())) {
			if (this.getErrorMessage() != null && !this.getErrorMessage().isEmpty())
				return this.getErrorMessage();
			else
				return "String can't be empty!";
		}
		return null;
	}
}
