package validation.builder;

public interface RuleBuilder {

	RuleBuilder maxLength(int maxLength);

	RuleBuilder minLength(int minLength);

	RuleBuilder notEmpty();

	RuleBuilder matchesRegex(String regex);

	RuleBuilder withMessage(String message);
}
