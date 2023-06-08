package validation.rule;

public class MinLengthRule extends Rule {

	private final int minLength;
	private final Object property;

	public MinLengthRule(int maxLength, Object property) {
		this.minLength = maxLength;
		this.property = property;
	}

	@Override
	public String validate() {
		if (property != null) {
			if (property instanceof String temp) {

				if (temp.length() < minLength) {
					if (this.getErrorMessage() != null && !this.getErrorMessage().isEmpty()) {
						return this.getErrorMessage();
					} else {
						return "String can't be shorter than " + minLength + " characters!";
					}

				}
			}
		}
		return null;
	}
}
