package validation.exception;

import java.util.List;

@SuppressWarnings("serial")
public class ValidationException extends Exception {

	public ValidationException(List<String> errors) {
		super(String.join("\n", errors));
	}

	public ValidationException(String error) {
		super(error);
	}

}
