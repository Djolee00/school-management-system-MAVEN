package validation.rule;

public abstract class Rule {

	private String errorMessage;

	public abstract String validate();

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
